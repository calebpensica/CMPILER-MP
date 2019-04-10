package tors;

import gen.PascaletBaseVisitor;
import gen.PascaletParser;
import variablemanager.VariableModel;
import variablemanager.VariableTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascaletImpl extends PascaletBaseVisitor<Double> {

    // "stack" of scopes for all variables
    List<VariableTable> scopes = new ArrayList<>();



    // Evaluate function call
    @Override
    public Double visitProcedureStatement(gen.PascaletParser.ProcedureStatementContext ctx) {
        // If built in function, execute
        String procedureName = ctx.identifier().IDENT().toString();

        // readln()
        if (procedureName.equalsIgnoreCase("readln")) {
            readln(ctx);
        }

        // writeln()
        else if (procedureName.equalsIgnoreCase("writeln")) {
            writeln(ctx);
        }

        return super.visitProcedureStatement(ctx);
    }




    /*
    *
    *   HELPER METHODS
    *
    * */

    // writeln() logic
    private void writeln(PascaletParser.ProcedureStatementContext ctx) {
        // TODO: do visit expression before this
    }

    // readln() logic
    private void readln(gen.PascaletParser.ProcedureStatementContext ctx) {
        // always add a new scope for function call parameters
        scopes.add(new VariableTable());

        Scanner in = new Scanner(System.in);

        // DEBUG (store sample var)
        // addNewVar("somevar", "69", "int");

        // iterate through the parameters and scan per parameter
        List<PascaletParser.ActualParameterContext> parameters = ctx.parameterList().actualParameter();
        for (int i = 0; i < parameters.size(); i++) {
            String parameterName = parameters.get(i).getText();

            // get last table where var was mentioned
            VariableTable lastVarTable = queryLastVariableInstance(parameterName);

            // TODO: handle this error
            // if null, variable not mentioned before
            if (lastVarTable == null) {
                // handle error here
                System.out.println("Variable " + parameterName + " does not exist.");
                return;
            }

            // print parameters to console
            VariableModel variableModel = lastVarTable.get(parameterName);
            lastVarTable.add(parameterName, in.nextLine(), variableModel.getType());
        }
    }

    // Get the last table where a certain var is mentioned
    private VariableTable queryLastVariableInstance(String variableName) {
        for (int i = scopes.size()-1; i >= 0; i--) {
            if (scopes.get(i).contains(variableName))
                return scopes.get(i);
        }
        // return null if var not found
        return null;
    }

    // add a new variable in the TOP symbol table
    private void addNewVar(String name, String value, String type) {
        scopes.get(scopes.size()-1).add(name, value, type);
    }
}

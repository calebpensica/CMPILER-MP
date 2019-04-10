import gen.APascaletParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Integer> {

    private HashMap<String, Object> globalVariables = new HashMap<>();
    private Stack<HashMap<String, Object>> localVariables = new Stack<>();

    private Object getVariable(String key){

        if(localVariables.peek().containsKey(key))
            return localVariables.peek().get(key);
        else if(globalVariables.containsKey(key))
            return globalVariables.get(key);
        return null;
    }

    @Override
    public Integer visitProgram(APascaletParser.ProgramContext ctx) {

        Object tempObject = null;

//        Setting global variables
        for(APascaletParser.VariableDeclarationPartContext varBlock : ctx.block().variableDeclarationPart()){
            System.out.println(varBlock.getText());

            for(int j = 0; j < varBlock.variableDeclaration().size(); j++) {
                APascaletParser.VariableDeclarationContext varBlockDeclarations = varBlock.variableDeclaration(j);

                for(APascaletParser.IdentifierContext ident : varBlockDeclarations.identifierList().identifier()) {
//                    varNames.add(ident.getText());
//                    System.out.println(ident.getText());
                    switch (varBlockDeclarations.type().getText()) {
                        case "integer":
                            globalVariables.put(ident.getText(), 0);
                            break;
                        case "String":
                            globalVariables.put(ident.getText(), "");
                            break;
                        case "boolean":
                            globalVariables.put(ident.getText(), Boolean.FALSE);
                            break;
                        default:
//                            TODO add other kinds of data type
                    }
                }

            }

        }
        return super.visitProgram(ctx);
    }

    @Override
    public Integer visitProcedureStatement(APascaletParser.ProcedureStatementContext ctx) {

        List<APascaletParser.ActualParameterContext> tempParam = ctx.parameterList().actualParameter();
        String[] param = new String[tempParam.size()];
        for(int i = 0; i < tempParam.size(); i++)
            param[i] = tempParam.get(i).getText();

//        System.out.println(ctx.parameterList().getText());
        if (ctx.identifier().getText().equalsIgnoreCase("writeln") ||
                ctx.identifier().getText().equalsIgnoreCase("write")){
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < param.length; i++) {
                for (int j = 0; j < param[i].length(); j++) {
                    if (param[i].charAt(j) == '\'') {
                        do {
                            j++;

                            if (param[i].charAt(j) != '\'')
                                temp.append(param[i].charAt(j));

                        } while (param[i].charAt(j) != '\'');

                        // System.out.println(param[i].charAt(j) + " " + j + " " + param[i].length());
                        if (j != param[i].length() - 1 && param[i].charAt(j) != '+')
                            error("Syntax error | Line number - " + ctx.getStart().getLine());
                    } else {
                        //  todo add expressionParser
//                        int expression = evaluateExpression(ctx.parameterList().actualParameter(i).expression());
//                        temp.append(expression);
                    }
                }
            }
            if(ctx.identifier().getText().equalsIgnoreCase("writeln"))
                System.out.println(temp);
            else
                System.out.print(temp);
        } else {
            System.out.println(ctx.identifier().getText());
            //todo add other procedure statements (procedure function calls)
        }
        return super.visitProcedureStatement(ctx);
    }

    private int evaluateExpression(APascaletParser.ExpressionContext expression){
        int result = 0;
        String exp = expression.getText();

        return result;
    }

    private void error(String msg){
        System.out.println("Error: " + msg);
        System.exit(-1);
    }

    @Override
    public Integer visitVariableDeclaration(APascaletParser.VariableDeclarationContext ctx) {
        List<APascaletParser.IdentifierContext> tempParam = ctx.identifierList().identifier();
        String [] param = new String[tempParam.size()];
        for(int i = 0; i < tempParam.size(); i++)
        {
            param[i] = tempParam.get(i).getText();
            System.out.println("variable name: " + param[i]);
        }
        if(ctx.type().simpleType() != null)
        {
            if(ctx.type().simpleType().typeIdentifier().INTEGER() != null)
            {
                System.out.println("type Integer");
            }
            if(ctx.type().simpleType().typeIdentifier().STRING() != null)
            {
                System.out.println("type String");
            }
            if(ctx.type().simpleType().typeIdentifier().BOOLEAN() != null)
            {
                System.out.println("type Boolean");
            }
            if(ctx.type().simpleType().typeIdentifier().CHAR() != null)
            {
                System.out.println("type Char");
            }
        }
        else{
            System.out.println("Not a basic data type");
        }
        //todo make use of the stacks for the scope
        return super.visitVariableDeclaration(ctx);
    }
    @Override
    public Integer visitForStatement(APascaletParser.ForStatementContext ctx) {
        int startingValue, endingValue;

        return super.visitForStatement(ctx);
    }

    public boolean evaluateRelationalOperators(String operator, Object firstObject, Object secondObject)
    {
        boolean relBool = true;
        switch (operator){
            case "EQUAL":
                if(firstObject != secondObject)
                    relBool = false;
                break;
            case "NOT_EQUAL":
                if(firstObject == secondObject)
                    relBool = false;
            case "LT":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    if((Integer) firstObject > (Integer) secondObject)
                        relBool = false;
                break;
            case "GT":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    if((Integer) firstObject < (Integer) secondObject)
                        relBool = false;
                break;
            case "GE":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    if(!((Integer) firstObject >= (Integer) secondObject))
                        relBool = false;
                break;
            case "LE":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    if(!((Integer) firstObject <= (Integer) secondObject))
                        relBool = false;
                break;
            default:
                System.out.println("No Relational Operator");
        }
        return relBool;
    }
}

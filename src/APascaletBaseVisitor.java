import gen.APascaletParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Integer> {
    private HashMap<String, contextParameters> functionList = new HashMap<>();
    private HashMap<String, Object> globalVariables = new HashMap<>();
    private Stack<HashMap<String, Object>> localVariables = new Stack<>();

    private Object getVariable(String key) {

        if (!localVariables.empty() && localVariables.peek().containsKey(key))
            return localVariables.peek().get(key);
        else if (globalVariables.containsKey(key))
            return globalVariables.get(key);
        return null;
    }

    private boolean replaceVariableValue(String key, Object newValue){

        if (!localVariables.empty() && localVariables.peek().containsKey(key)){
           localVariables.peek().put(key,newValue); //unsure
            return true;
        }
        else if (globalVariables.containsKey(key)){
            globalVariables.put(key,newValue);
            return true;
        }


        return false;
    }

    @Override
    public Integer visitProcedureDeclaration(APascaletParser.ProcedureDeclarationContext ctx) {
        contextParameters cp = new contextParameters();
        String parameterList [];
        //add to list
        if(ctx.formalParameterList() != null)
        {
            parameterList = new String[ctx.formalParameterList().formalParameterSection().size()];
            for(int i = 0; i < ctx.formalParameterList().formalParameterSection().size(); i++)
            {
                parameterList[i] = ctx.formalParameterList().formalParameterSection(i).getText();
            }
            cp.setParameters(parameterList);
        }
        cp.setCurrentContext(ctx.block());
        functionList.put(ctx.identifier().getText(), cp);
        return super.visitProcedureDeclaration(ctx);
    }

    @Override
    public Integer visitFunctionDeclaration(APascaletParser.FunctionDeclarationContext ctx) {
        contextParameters cp = new contextParameters();
        String parameterList [];
        //add to list
        if(ctx.formalParameterList() != null)
        {
            parameterList = new String[ctx.formalParameterList().formalParameterSection().size()];
            for(int i = 0; i < ctx.formalParameterList().formalParameterSection().size(); i++)
            {
                parameterList[i] = ctx.formalParameterList().formalParameterSection(i).getText();
            }
            cp.setParameters(parameterList);
        }
        cp.setCurrentContext(ctx.block());
        functionList.put(ctx.identifier().getText(), cp);
        return super.visitFunctionDeclaration(ctx);
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
                    setVariableDataType(varBlockDeclarations.type().getText(), ident);
                }

            }

        }
        return super.visitProgram(ctx);
    }

    public void setVariableDataType(String dataType, APascaletParser.IdentifierContext ident){
        switch (dataType) {
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




    public void variableDeclaration(APascaletParser.VariableDeclarationContext ctx,  HashMap<String, Object> variables) {
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
                for(int x = 0; x < tempParam.size(); x++)
                {
                    variables.put(param[x], new Integer(0));
                }

            }
            if(ctx.type().simpleType().typeIdentifier().STRING() != null)
            {
                System.out.println("type String");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    variables.put(param[x], "");
                }
            }
            if(ctx.type().simpleType().typeIdentifier().BOOLEAN() != null)
            {
                System.out.println("type Boolean");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    variables.put(param[x], false);
                }
            }
            if(ctx.type().simpleType().typeIdentifier().CHAR() != null)
            {
                System.out.println("type Char");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    variables.put(param[x], new Character(' '));
                }
            }
        }
        else{
            System.out.println("Not a basic data type");
        }
        //todo make use of the stacks for the scope
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
        }
        else if(functionList.containsKey(ctx.identifier().getText()))
        {
            executeFunction(functionList.get(ctx.identifier().getText()));
        }
        else {
            System.out.println(ctx.identifier().getText());
            //todo add other procedure statements (procedure function calls)
        }
        return super.visitProcedureStatement(ctx);
    }
    public void executeFunction(contextParameters currentContextParameter)
    {
        HashMap<String, Object> variables = new HashMap<>();
        System.out.println(currentContextParameter.getCurrentContext().getText());
        if(currentContextParameter.getCurrentContext().variableDeclarationPart() != null)
        {
            List<APascaletParser.VariableDeclarationPartContext> varDecPart = currentContextParameter.getCurrentContext().variableDeclarationPart();
            for(int i = 0; i < varDecPart.size(); i++)
            {
                for(int x = 0; x < varDecPart.get(i).variableDeclaration().size(); x++)
                {
                    variableDeclaration(varDecPart.get(i).variableDeclaration().get(x), variables);
                }
            }
            localVariables.push(variables);
            visit(currentContextParameter.getCurrentContext().compoundStatement());
            localVariables.pop();
        }
    }
   // @Override public T visitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx) { return visitChildren(ctx); }
    @Override
    public Integer visitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx){
        //  variable ASSIGN expession
//        ctx.expression().
        Object var = getVariable(ctx.variable().identifier().get(0).getText());
//        System.out.println("Val: " + getVariable(ctx.variable().identifier().get(0).getText()) + " | " + 2);
        if(var instanceof String){
            //String result = evaluateExpression(ctx.expression());
        }
        else if(var instanceof Integer){
//            result = evaluateExpression(ctx.expression());
//            var = new Integer(2);
        }
        else if(var instanceof Boolean){
            //    Boolean result = evaluateExpression(ctx.expression());

        }
        else if(var instanceof Character){
            //Character result =

        }
        replaceVariableValue(ctx.variable().identifier().get(0).getText(),var);

//        System.out.println("new Val: " + getVariable(ctx.variable().identifier().get(0).getText()) + " | Var: " + var);
        return visitChildren(ctx);
    }

    private int evaluateExpression(APascaletParser.ExpressionContext expression){
        int result = 0;
        String exp = expression.getText();
        expression.addChild( expression);
        return result;
    }

    private void error(String msg){
        System.out.println("Error: " + msg);
        System.exit(-1);
    }

    @Override
    public Integer visitForStatement(APascaletParser.ForStatementContext ctx) {
        int startingValue, endingValue;
        return super.visitForStatement(ctx);
    }

    public boolean evaluateLogicalOperators(String operator, Boolean firstObject, Boolean secondObject){
        if(operator.equalsIgnoreCase("AND"))
            return firstObject&&secondObject;
        else if(operator.equalsIgnoreCase("OR"))
            return firstObject||secondObject;
        else if(operator.equalsIgnoreCase("NOT"))
            return !firstObject;
    }

    public boolean evaluateRelationalOperators(String operator, Object firstObject, Object secondObject)
    {

        boolean relBool = true;
        switch (operator){
            case "=":
                if(!firstObject.equals(secondObject))
                    relBool = false;
                break;
            case "<>":
                if(firstObject == secondObject)
                    relBool = false;
            case "<":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if ((Integer) firstObject > (Integer) secondObject)
                        relBool = false;
                }
                else {
                    //error("Syntax error | Line number - " + ctx.getStart().getLine());
                }
                break;
            case ">":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if ((Integer) firstObject < (Integer) secondObject)
                        relBool = false;
                }
                else {
                    //error("Syntax error | Line number - " + ctx.getStart().getLine());
                }
                break;
            case ">=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if (!((Integer) firstObject >= (Integer) secondObject))
                        relBool = false;
                }
                else {
                    //error("Syntax error | Line number - " + ctx.getStart().getLine());
                }
                break;
            case "<=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if (!((Integer) firstObject <= (Integer) secondObject))
                        relBool = false;
                }
                else {
                    //error("Syntax error | Line number - " + ctx.getStart().getLine());
                }
                break;
            default:
                System.out.println("No Relational Operator");
        }
        return relBool;
    }
}

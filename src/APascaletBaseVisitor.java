import gen.APascaletParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Object> {
    private HashMap<String, contextParameters> functionList = new HashMap<>();
    private HashMap<String, Object> globalVariables = new HashMap<>();
    private Stack<HashMap<String, Object>> localVariables = new Stack<>();

    private Object getVariable(String key) {

        key = key.toLowerCase();
        if (!localVariables.empty() && localVariables.peek().containsKey(key))
            return localVariables.peek().get(key);
        else if (globalVariables.containsKey(key))
            return globalVariables.get(key);
        return null;
    }

    private boolean replaceVariableValue(String key, Object newValue){

        if (!localVariables.empty() && localVariables.peek().containsKey(key)){
            localVariables.peek().put(key.toLowerCase(),newValue); //unsure
            return true;
        }
        else if (globalVariables.containsKey(key)){
            globalVariables.put(key.toLowerCase(), newValue);
            return true;
        }


        return false;
    }

    @Override
    public Object visitProcedureDeclaration(APascaletParser.ProcedureDeclarationContext ctx) {
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
        functionList.put(ctx.identifier().getText().toLowerCase(), cp);
        return super.visitProcedureDeclaration(ctx);
    }

    @Override
    public Object visitFunctionDeclaration(APascaletParser.FunctionDeclarationContext ctx) {
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
        functionList.put(ctx.identifier().getText().toLowerCase(), cp);
        return super.visitFunctionDeclaration(ctx);
    }
    @Override
    public Object visitProgram(APascaletParser.ProgramContext ctx) {

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
                globalVariables.put(ident.getText().toLowerCase(), 0);
                break;
            case "String":
                globalVariables.put(ident.getText().toLowerCase(), "");
                break;
            case "boolean":
                globalVariables.put(ident.getText().toLowerCase(), Boolean.FALSE);
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
    public Object visitProcedureStatement(APascaletParser.ProcedureStatementContext ctx) {

        List<APascaletParser.ActualParameterContext> tempParam = ctx.parameterList().actualParameter();
        String[] param = new String[tempParam.size()];
        for(int i = 0; i < tempParam.size(); i++)
            param[i] = tempParam.get(i).getText();

//        System.out.println(ctx.parameterList().getText());
        if (ctx.identifier().getText().equalsIgnoreCase("writeln") ||
                ctx.identifier().getText().equalsIgnoreCase("write")){
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < param.length; i++) {
                if (param[i].charAt(0) == '\'') {
                    for (int j = 0; j < param[i].length(); j++) {
                        do {
                            j++;

                            if (param[i].charAt(j) != '\'')
                                temp.append(param[i].charAt(j));

                        } while (param[i].charAt(j) != '\'');

                        // System.out.println(param[i].charAt(j) + " " + j + " " + param[i].length());
                        if (j != param[i].length() - 1 && param[i].charAt(j) != '+')
                            error("Syntax error", ctx);
                    }
                } else {
//                          todo add expressionParser
//                        int expression = evaluateExpression(ctx.parameterList().actualParameter(i).expression());
                    temp.append(visitExpression(tempParam.get(i).expression()));
                }
            }
            if(ctx.identifier().getText().equalsIgnoreCase("writeln"))
                System.out.println(temp);
            else
                System.out.print(temp);
        }

        else if(functionList.containsKey(ctx.identifier().getText().toLowerCase()))
        {
            executeFunction(functionList.get(ctx.identifier().getText().toLowerCase()));
        }
        else {
            System.out.println(ctx.identifier().getText());
            //todo add other procedure statements (procedure function calls)
        }
        return super.visitProcedureStatement(ctx);
    }

    public void executeFunction(contextParameters currentContextParameter) {
        HashMap<String, Object> variables = new HashMap<>();
        System.out.println(currentContextParameter.getCurrentContext().getText());
        if (currentContextParameter.getCurrentContext().variableDeclarationPart() != null) {
            List<APascaletParser.VariableDeclarationPartContext> varDecPart = currentContextParameter.getCurrentContext().variableDeclarationPart();
            for (int i = 0; i < varDecPart.size(); i++) {
                for (int x = 0; x < varDecPart.get(i).variableDeclaration().size(); x++) {
                    variableDeclaration(varDecPart.get(i).variableDeclaration().get(x), variables);
                }
            }
            localVariables.push(variables);
            visit(currentContextParameter.getCurrentContext().compoundStatement());
            localVariables.pop();
        }
    }

    @Override
    public Object visitExpression(APascaletParser.ExpressionContext ctx) {


        if(ctx.relationaloperator() != null && visit(ctx.expression()) == null) // todo @caleb with relation op but 2nd var is not valid
            error("", ctx);

        if(ctx.relationaloperator() != null)
            return evaluateRelationalOperators(ctx.relationaloperator().getText(),
                    visit(ctx.simpleExpression()),
                    visit(ctx.expression()));

        else return visit(ctx.simpleExpression());
    }


    @Override
    public Object visitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx){
        //  variable ASSIGN expression
        if(getVariable(ctx.variable().identifier().getText()) == null)
            error("", ctx);

        /*if(var instanceof Character){
            //Character result =

        }*/
        replaceVariableValue(ctx.variable().identifier().getText(), visitExpression(ctx.expression()));

//        System.out.println("new Val: " + getVariable(ctx.variable().identifier().get(0).getText()) + " | Var: " + var);
        return visitChildren(ctx);
    }


    public boolean evaluateLogicalOperators(String operator, Boolean firstObject, Boolean secondObject){
        if(operator.equalsIgnoreCase("AND"))
            return firstObject&&secondObject;
        else if(operator.equalsIgnoreCase("OR"))
            return firstObject||secondObject;
        else // if(operator.equalsIgnoreCase("NOT"))
            return !firstObject;
    }

    private int evaluateExpression(APascaletParser.ExpressionContext expression){
        int result = 0;
        String exp = expression.getText();
        expression.addChild( expression);
        return result;
    }

    @Override
    public Object visitFactor(APascaletParser.FactorContext ctx) {
        return super.visitFactor(ctx);
    }

    private void error(String msg, ParserRuleContext ctx){
        System.out.println("Error: " + msg + " | Line number - " + ctx.getStart().getLine());
        System.exit(-1);
    }

    @Override
    public Object visitForStatement(APascaletParser.ForStatementContext ctx) {
        int startingValue, endingValue;
        return super.visitForStatement(ctx);
    }

    public boolean evaluateRelationalOperators(String operator, Object firstObject, Object secondObject)
    {

        boolean relBool = true;
        switch (operator){
            case "=":
                if(firstObject.equals(secondObject))
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
                    //error
                }
                break;
            case ">":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if ((Integer) firstObject < (Integer) secondObject)
                        relBool = false;
                }
                else {
                    //error
                }
                break;
            case ">=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if (!((Integer) firstObject >= (Integer) secondObject))
                        relBool = false;
                }
                else {
                    //error
                }
                break;
            case "<=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer)) {
                    if (!((Integer) firstObject <= (Integer) secondObject))
                        relBool = false;
                }
                else {
                    //error
                }
                break;
            default:
                System.out.println("No Relational Operator");
        }
        return relBool;
    }

    @Override
    public Object visitSimpleExpression(APascaletParser.SimpleExpressionContext ctx) {


        if(ctx.additiveoperator()!=null){
            evaluateAdditiveExpression(ctx.additiveoperator().getText(), ctx.term(),ctx.simpleExpression());
        }

        return visitChildren(ctx);
    }
    
    private Object evaluateAdditiveExpression(String operator, Object firstObject, Object secondObject){
        Integer result = 0;
        String stringResult = "";
        switch(operator){
            case "+":
                if(firstObject instanceof Integer && secondObject instanceof Integer)
                    result += (Integer)firstObject + (Integer)secondObject;
                else if(firstObject instanceof String && secondObject instanceof String) {
                    stringResult += (String)firstObject + secondObject;
                    return stringResult;
                }
                break;
            case "-":
                result += (Integer)firstObject - (Integer)secondObject;
                break;

        }

        return result;
    }

    @Override
    public Object visitTerm(APascaletParser.TermContext ctx) {
        if(ctx.multiplicativeoperator()!=null){
            evaluateMultiplicativeOperator(ctx.multiplicativeoperator().getText(), ctx.signedFactor(), ctx.term());
        }
        return visitChildren(ctx);
    }


    private int evaluateMultiplicativeOperator(String operator, Object firstObject, Object secondObject){
        int result = 0;
        switch(operator){
            case "*":
                result += (Integer)firstObject * (Integer)secondObject;
                break;
            case "/":
                result += (Integer)firstObject / (Integer)secondObject;
                break;
            case "%":
                result += (Integer)firstObject % (Integer)secondObject;
                break;

        }
        return result;
    }
    @Override
    public Object visitUnsignedNumber(APascaletParser.UnsignedNumberContext ctx) {
        return new Integer(ctx.getText());
    }

    @Override
    public Object visitString(APascaletParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override
    public Object visitVariable(APascaletParser.VariableContext ctx) {
        return getVariable(ctx.identifier().getText());
    }

}

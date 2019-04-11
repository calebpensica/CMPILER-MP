import gen.APascaletParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Stack;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Object> {
    private HashMap<String, contextParameters> functionList = new HashMap<>();
    private HashMap<String, Object> globalVariables = new HashMap<>();
    private Stack<HashMap<String, Object>> localVariables = new Stack<>();

    private Boolean containsVariable(String key){

        key = key.toLowerCase();
        if (!localVariables.empty() && localVariables.peek().containsKey(key))
             return true;
        else if (globalVariables.containsKey(key))
             return true;
        else return false;
    }
    private Object getVariable(String key) {

        key = key.toLowerCase();
//        System.out.print(key + " | " );
//        for(String x: globalVariables.keySet())
//            System.out.print(x);
//        System.out.println();
        if (!localVariables.empty() && localVariables.peek().containsKey(key))
            return localVariables.peek().get(key);
        else if (globalVariables.containsKey(key))
            return globalVariables.get(key);
        return null;
    }

    private boolean replaceVariableValue(String key, Object newValue, ParserRuleContext ctx){

        if(getVariable(key).getClass()!=newValue.getClass())
            error("Datatype Mismatch.", ctx);
        if (!localVariables.empty() && localVariables.peek().containsKey(key)){

            localVariables.peek().put(key,newValue); //unsure
            return true;
        }
        else if (globalVariables.containsKey(key)){
            globalVariables.put(key, newValue);
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
        if(!checkHashTables(ctx.identifier().getText().toLowerCase()))
            functionList.put(ctx.identifier().getText().toLowerCase(), cp);
        else
            error("Identifier already in use", ctx);
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
        cp.setFunctionContext(ctx);
        if (!checkHashTables(ctx.identifier().getText().toLowerCase()))
            functionList.put(ctx.identifier().getText().toLowerCase(), cp);
        else
            error("Identifier already in use", ctx);
        return super.visitFunctionDeclaration(ctx);
    }
    @Override
    public Object visitProgram(APascaletParser.ProgramContext ctx) {

        Object tempObject = null;

//        typeDefinition
//        : identifier EQUAL (type | functionType | procedureType)

        for(APascaletParser.TypeDefinitionPartContext typeBlock : ctx.block().typeDefinitionPart()){
            for(int i = 0; i < typeBlock.typeDefinition().size(); i++){
                APascaletParser.TypeDefinitionContext typeBlockDeclarations = typeBlock.typeDefinition(i);
                initializeArray(typeBlock.typeDefinition(i));
//                todo Array type definitions
            }
        }

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
    public void initializeArray(APascaletParser.TypeDefinitionContext typeDefinitionContext){

//        type
//                temperature = array [-10 .. 50] of real;
//        var
//        day_temp, night_temp: temperature;

//        typeDefinition
//        : identifier EQUAL (type | functionType | procedureType)

        String arrayName = typeDefinitionContext.identifier().getText();
        if(!typeDefinitionContext.type().getText().equalsIgnoreCase("array")){

        }
    }

    public void setVariableDataType(String dataType, APascaletParser.IdentifierContext ident){
        dataType = dataType.toLowerCase();
        switch (dataType) {
            case "integer":
                if(!checkHashTables(ident.getText().toLowerCase()))
                {
                    globalVariables.put(ident.getText().toLowerCase(), 0);
                }
                else
                    error("Identifier already in use", ident);

                break;
            case "string":
                if(!checkHashTables(ident.getText().toLowerCase())) {
                    globalVariables.put(ident.getText().toLowerCase(), "");
                }
                else
                    error("Identifier already in use", ident);
                break;
            case "char":
                if(!checkHashTables(ident.getText().toLowerCase())) {
                    globalVariables.put(ident.getText().toLowerCase(), '\0');
                }
                else
                    error("Identifier already in use", ident);
                break;
            case "boolean":
                if(!checkHashTables(ident.getText().toLowerCase())) {
                    globalVariables.put(ident.getText().toLowerCase(), Boolean.FALSE);
                }
                else
                    error("Identifier already in use", ident);

                break;
            default:
//                            TODO add other kinds of data type
        }
    }


    public void detectConstantDataType(APascaletParser.ConstantDefinitionContext ctx){
        if(ctx.constant().sign() != null || ctx.constant().unsignedNumber() != null)
        {
            if(!checkHashTables(ctx.identifier().getText().toLowerCase()))
            {
                final int x = Integer.parseInt(ctx.constant().getText());
                globalVariables.put(ctx.identifier().getText().toLowerCase(), x);
            }
            else
                error("Identifier already in use", ctx);

        }

        else if(ctx.constant().string() != null && !checkHashTables(ctx.identifier().getText().toLowerCase()))
        {
            if(!checkHashTables(ctx.identifier().getText().toLowerCase())) {
                final String x = ctx.constant().getText();
                globalVariables.put(ctx.identifier().getText().toLowerCase(), x);
            }
            else
                error("Identifier already in use", ctx);
        }


    }

    public void variableDeclaration(APascaletParser.VariableDeclarationContext ctx,  HashMap<String, Object> variables) {
        List<APascaletParser.IdentifierContext> tempParam = ctx.identifierList().identifier();
        String [] param = new String[tempParam.size()];
        for(int i = 0; i < tempParam.size(); i++)
        {
            param[i] = tempParam.get(i).getText().toLowerCase();
            System.out.println("variable name: " + param[i]);
        }
        if(ctx.type().simpleType() != null)
        {
            if(ctx.type().simpleType().typeIdentifier().INTEGER() != null)
            {
                System.out.println("type Integer");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    if(!checkHashTables(param[x].toLowerCase()))
                        variables.put(param[x].toLowerCase(), 0);
                    else{
                        error("Variable assignment error", ctx);
                        return;
                    }
                }
            }
            if(ctx.type().simpleType().typeIdentifier().STRING() != null)
            {
                System.out.println("type String");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    if(!checkHashTables(param[x].toLowerCase()))
                        variables.put(param[x].toLowerCase(), "");
                    else{
                        error("Variable assignment error", ctx);
                        return;
                    }
                }
            }
            if(ctx.type().simpleType().typeIdentifier().BOOLEAN() != null)
            {
                System.out.println("type Boolean");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    if(!checkHashTables(param[x].toLowerCase()))
                        variables.put(param[x].toLowerCase(), false);
                    else{
                        error("Variable assignment error", ctx);
                        return;
                    }
                }
            }
            if(ctx.type().simpleType().typeIdentifier().CHAR() != null)
            {
                System.out.println("type Char");
                for(int x = 0; x < tempParam.size(); x++)
                {
                    if(!checkHashTables(param[x].toLowerCase()))
                        variables.put(param[x].toLowerCase(), ' ');
                    else{
                        error("Variable assignment error", ctx);
                        return;
                    }
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

        if (ctx.identifier().getText().equalsIgnoreCase("writeln") ||
                ctx.identifier().getText().equalsIgnoreCase("write")){

            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < tempParam.size(); i++)
                temp.append(visitExpression(tempParam.get(i).expression()));

            System.out.println(temp + (ctx.identifier().getText().equalsIgnoreCase("writeln") ? "\n" : ""));

        } else if(functionList.containsKey(ctx.identifier().getText().toLowerCase())){
            executeFunction(functionList.get(ctx.identifier().getText().toLowerCase()));
        }  else if(ctx.identifier().getText().equalsIgnoreCase("readln")) {
            Scanner sc = new Scanner(System.in);
            String input;
            for (int i = 0; i < ctx.parameterList().actualParameter().size(); i++) {
                System.out.println("Enter input:");
                input = sc.nextLine();
                System.out.println("Input: " + input);
                Object x = getVariable(ctx.parameterList().actualParameter().get(i).getText());
                if (x != null) {
                    if (x instanceof Integer) {
                        Integer intInput = 0;
                        try {
                            intInput = Integer.parseInt(input); //todo check for error
                        } catch (Exception e) {
                            error("Input mismatch. ", ctx);
                        }
                        replaceVariableValue(ctx.parameterList().actualParameter().get(i).getText(), intInput, ctx);
                    } else if (x instanceof String) {
                        replaceVariableValue(ctx.parameterList().actualParameter().get(i).getText(), input, ctx);
                    } else if (x instanceof Character) {
                        Character charInput = input.toCharArray()[0];
                        replaceVariableValue(ctx.parameterList().actualParameter().get(i).getText(), charInput, ctx);
                    } else {
                        error("Variable does not exist.", ctx);
                    }
                }
            }
        }
        else {
            System.out.println(ctx.identifier().getText());
            error("Invalid identifier.",ctx);
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
            //push variable name check if ctx is current context then pwede ipush
            if(currentContextParameter.getFunctionContext() != null)
            {
                if(!checkHashTables(currentContextParameter.getFunctionContext().identifier().getText()))
                    variables.put(currentContextParameter.getFunctionContext().identifier().getText().toLowerCase(),
                            currentContextParameter.getFunctionContext().resultType().typeIdentifier().getText());
                else
                    error("Identifier already in use", currentContextParameter.getCurrentContext());
            }
            localVariables.push(variables);
            visit(currentContextParameter.getCurrentContext().compoundStatement());
            localVariables.pop();
        }
    }

    public boolean checkHashTables(String checkName)
    {
        System.out.println("Check this String " + checkName);
        if(functionList.containsKey(checkName) || globalVariables.containsKey(checkName))
        {
            System.out.println("Meron naman eh: Return True");
            return true;
        }

        for(HashMap<String, Object> obj: localVariables)
        {
            if(obj.containsKey(checkName))
            {
                System.out.println("Meron naman eh: Return True");
                return true;
            }

        }
        System.out.println("Wala naman eh: Return False");
        return false;

    }

    @Override
    public Object visitExpression(APascaletParser.ExpressionContext ctx) {


        if(ctx.relationaloperator() != null && visit(ctx.expression()) == null) // todo @caleb with relation op but 2nd var is not valid
            error("Invalid operator", ctx);

        if(ctx.relationaloperator() != null)
            return evaluateRelationalOperators(ctx.relationaloperator().getText(),
                                                visit(ctx.simpleExpression()),
                                                visit(ctx.expression()),
                                                ctx);

        else return visit(ctx.simpleExpression());
    }


    @Override
    public Object visitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx){
        //  variable ASSIGN expression
        if(getVariable(ctx.variable().identifier().getText()) == null)
            error("Variable does not exist", ctx);


        replaceVariableValue(ctx.variable().identifier().getText().toLowerCase(), visit(ctx.expression()), ctx);

        return null;
    }

    @Override
    public Object visitSignedFactor(APascaletParser.SignedFactorContext ctx) {
        if(ctx.MINUS() != null || ctx.PLUS() != null)
            if(visit(ctx.factor()) instanceof Integer){
                if(ctx.MINUS() != null)
                    return -(Integer)visit(ctx.factor());
                else if(ctx.PLUS() != null)
                    return +(Integer)visit(ctx.factor());
                else System.out.println((ctx.MINUS() != null || ctx.PLUS() != null) + " sasad " +
                            (visit(ctx.factor()) instanceof Integer));
            } else error("Expecting integer in minus unary operator", ctx);


        if(ctx.factor() != null)
            return visit(ctx.factor());
        else
            return "";
    }

    @Override
    public Object visitFactor(APascaletParser.FactorContext ctx) {
        if(ctx.NOT() != null)
            if(visit(ctx.expression()) instanceof Boolean)
                return !(Boolean)visit(ctx.expression());
            else error("Expecting a boolean in NOT expression", ctx);

        if(ctx.LPAREN() != null && ctx.RPAREN() != null)
            return visit(ctx.expression());

        return super.visitFactor(ctx);
    }

    private void error(String msg, ParserRuleContext ctx){
        System.out.println("Error: " + msg + " | Line number - " + ctx.getStart().getLine());
        System.exit(-1);
    }


    @Override
    public Object visitForStatement(APascaletParser.ForStatementContext ctx) {
        if(!(visit(ctx.forList().initialValue()) instanceof Integer &&
                visit(ctx.forList().finalValue()) instanceof Integer))
            error("Initial and final values must be an integer for FOR statements", ctx);

        int initVal  = (Integer)visit(ctx.forList().initialValue()),
                finalVal = (Integer)visit(ctx.forList().finalValue());
        boolean ascending = ctx.forList().DOWNTO() == null;
        String  key       = visit(ctx.identifier()).toString().toLowerCase();
        System.out.println(visit(ctx.identifier()) + " | " + visit(ctx.identifier()).toString() + " || " + getVariable(key));
        if(!containsVariable(key))
            error("Variable \"" + key + "\" is not declared", ctx);

        replaceVariableValue(key, initVal, ctx);
        finalVal += (ascending ? 1 : -1);
        while((Integer)getVariable(key)!= finalVal){
            visit(ctx.statement());
            replaceVariableValue(key, (Integer)getVariable(key) + (ascending ? 1 : -1), ctx);
        }

        return null;
//        return super.visitForStatement(ctx);
    }

    public Object evaluateRelationalOperators(String operator, Object firstObject,
                                              Object secondObject, APascaletParser.ExpressionContext ctx){


        switch (operator.toLowerCase()){
            case "=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return ((Integer) firstObject).equals((Integer) secondObject);
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) == 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) == 0;
                else if((firstObject instanceof Boolean) && (secondObject instanceof Boolean))
                    return ((Boolean) firstObject) == ((Boolean) secondObject);
                break;
            case "<>":

                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return !((Integer) firstObject).equals((Integer) secondObject);
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) != 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) != 0;
                else if((firstObject instanceof Boolean) && (secondObject instanceof Boolean))
                    return ((Boolean) firstObject) == ((Boolean) secondObject);
                break;
            case "<":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return (Integer) firstObject < (Integer) secondObject;
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) < 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) < 0;
                break;
            case ">":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return (Integer) firstObject > (Integer) secondObject;
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) > 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) > 0;
                break;
            case ">=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return (Integer) firstObject >= (Integer) secondObject;
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) >= 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) >= 0;
                break;
            case "<=":
                if((firstObject instanceof Integer) && (secondObject instanceof  Integer))
                    return (Integer) firstObject <= (Integer) secondObject;
                else if((firstObject instanceof String) && (secondObject instanceof  String))
                    return ((String) firstObject).compareTo((String) secondObject) <= 0;
                else if((firstObject instanceof Character) && (secondObject instanceof Character))
                    return ((Character) firstObject).compareTo((Character) secondObject) <= 0;
                break;
        }
        error("Relational expression error", ctx);
        return null;
    }

    @Override
    public Object visitSimpleExpression(APascaletParser.SimpleExpressionContext ctx) {


        if(ctx.additiveoperator()!=null){
            return evaluateAdditiveExpression(ctx.additiveoperator().getText(), visit(ctx.term()),
                    visit(ctx.simpleExpression()), ctx);
        }

        return visitChildren(ctx);
    }

    private Object evaluateAdditiveExpression(String operator, Object firstObject, Object secondObject, ParserRuleContext ctx){
        operator = operator.toLowerCase();
        switch(operator){
            case "+":
                if(firstObject instanceof Integer && secondObject instanceof Integer)
                    return (Integer)firstObject + (Integer)secondObject;
                else if(firstObject instanceof String && secondObject instanceof String)
                    return (String)firstObject + secondObject;
                break;
            case "-":
                if(firstObject instanceof  Integer && secondObject instanceof  Integer)
                    return (Integer)firstObject - (Integer)secondObject;
                break;

            case "or":
                if(firstObject instanceof  Boolean && secondObject instanceof  Boolean)
                    return (Boolean)firstObject || (Boolean)secondObject;
                break;

        }
        error("Additive expression error", ctx);
        return null;
    }

    @Override
    public Object visitTerm(APascaletParser.TermContext ctx) {
        if(ctx.multiplicativeoperator()!=null){
            return evaluateMultiplicativeOperator(ctx.multiplicativeoperator().getText(),
                    visit(ctx.signedFactor()), visit(ctx.term()), ctx);
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitConstantDefinition(APascaletParser.ConstantDefinitionContext ctx) {
        //check up to three letters
        if(ctx.identifier().getText().length() <= 3)
        {
            HashMap<String, Object> localConstant = new HashMap<>();

            if(ctx.constant().sign() != null || ctx.constant().unsignedNumber() != null)
            {
                if(!checkHashTables(ctx.identifier().getText().toLowerCase()))
                {
                    final int x = Integer.parseInt(ctx.constant().getText());
                    localConstant.put(ctx.identifier().getText().toLowerCase(), x);
                    localVariables.push(localConstant);
                }
                else
                    error("Identifier already in use", ctx);
            }

            else if(ctx.constant().string() != null)
            {
                if(!checkHashTables(ctx.identifier().getText().toLowerCase()))
                {
                    final String x = ctx.constant().getText();
                    localConstant.put(ctx.identifier().getText().toLowerCase(), x);
                    localVariables.push(localConstant);
                }
                else
                    error("Identifier already in use", ctx);
            }
            else
                error("Error incompatible type", ctx);
        }
        else
            error("Error constant identifier exceeded", ctx);
        //prepend ng final sa isang datatype
        //check whether global or local
        return super.visitConstantDefinition(ctx);
    }

    private Object evaluateMultiplicativeOperator(String operator, Object firstObject, Object secondObject,
                                                  APascaletParser.TermContext ctx){

        //        todo typechecking
        operator = operator.toLowerCase();
        switch(operator){
            case "*":
                if(firstObject instanceof Integer && secondObject instanceof Integer)
                    return (Integer)firstObject * (Integer)secondObject;
                break;
            case "/":
                if(firstObject instanceof Integer && secondObject instanceof Integer)
                    return (Integer)firstObject / (Integer)secondObject;
                break;
            case "%":
                if(firstObject instanceof  Integer && secondObject instanceof  Integer)
                    return (Integer)firstObject % (Integer)secondObject;
                break;

            case "and":
                if(firstObject instanceof  Boolean && secondObject instanceof  Boolean)
                    return (Boolean)firstObject && (Boolean)secondObject;
                break;

        }

        error("Multiplicative expression error", ctx);
        return null;
    }

    @Override
    public Object visitUnsignedNumber(APascaletParser.UnsignedNumberContext ctx) {
        return new Integer(ctx.getText());
    }

    @Override
    public Object visitString(APascaletParser.StringContext ctx) {
        if(ctx.getText().charAt(0) != '\'' || ctx.getText().charAt(ctx.getText().length() - 1) != '\'')
            error("Expecting a single quote at the start and end of the string", ctx);
        return ctx.getText().replaceAll("\'", "");
    }

    @Override
    public Object visitVariable(APascaletParser.VariableContext ctx) {
        return getVariable(ctx.identifier().getText());
    }

    @Override
    public Object visitBool(APascaletParser.BoolContext ctx) {
        return new Boolean(ctx.getText());
    }

    @Override
    public Object visitIdentifier(APascaletParser.IdentifierContext ctx) {
        return ctx.getText();
    }

    @Override
    public Object visitIfStatement(APascaletParser.IfStatementContext ctx) {
        System.out.println((Boolean)visit(ctx.expression()));
        if(visit(ctx.expression()) instanceof Boolean) {
            if ((Boolean)visit(ctx.expression()))
                visit(ctx.statement(0));
            else if (ctx.ELSE() != null && visit(ctx.statement(1)) != null)
                visit(ctx.statement(1));
        } else error("Expecting an expression in IF ELSE statement ", ctx);

        return null;
    }
}

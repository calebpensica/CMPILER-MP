import com.sun.org.apache.xpath.internal.operations.Bool;
import gen.APascaletParser;
import org.antlr.v4.runtime.CharStream;
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

    private boolean replaceVariableValue(String key, Object newValue){

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
        cp.setFunctionContext(ctx);
        functionList.put(ctx.identifier().getText().toLowerCase(), cp);
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
                globalVariables.put(ident.getText().toLowerCase(), 0);
                break;
            case "string":
                globalVariables.put(ident.getText().toLowerCase(), "");
                break;
            case "char":
                globalVariables.put(ident.getText().toLowerCase(), '\0');
                break;
            case "boolean":
                globalVariables.put(ident.getText().toLowerCase(), Boolean.FALSE);
                break;
            default:
//                            TODO add other kinds of data type
        }
    }


    public void detectConstantDataType(APascaletParser.ConstantDefinitionContext ctx){
        if(ctx.constant().sign() != null || ctx.constant().unsignedNumber() != null)
        {
            final int x = Integer.parseInt(ctx.constant().getText());
            globalVariables.put(ctx.identifier().getText().toLowerCase(), x);
        }

        else if(ctx.constant().string() != null)
        {
            final String x = ctx.constant().getText();
            globalVariables.put(ctx.identifier().getText().toLowerCase(), x);
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
                    if(!variables.containsKey(param[x]))
                        variables.put(param[x], 0);
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
                    variables.put(param[x], ' ');
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
        } else {
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
            //push variable name check if ctx is current context then pwede ipush
            if(currentContextParameter.getFunctionContext() != null)
            {
                variables.put(currentContextParameter.getFunctionContext().identifier().getText().toLowerCase(),
                        currentContextParameter.getFunctionContext().resultType().typeIdentifier().getText());
            }
            localVariables.push(variables);
            visit(currentContextParameter.getCurrentContext().compoundStatement());
            localVariables.pop();
        }
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

        replaceVariableValue(ctx.variable().identifier().getText().toLowerCase(), visit(ctx.expression()));

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
        int startingValue, endingValue;
        return super.visitForStatement(ctx);
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
                    return (Integer) firstObject != (Integer) secondObject;
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
                final int x = Integer.parseInt(ctx.constant().getText());
                localConstant.put(ctx.identifier().getText(), x);
                localVariables.push(localConstant);
            }

            else if(ctx.constant().string() != null)
            {
                final String x = ctx.constant().getText();
                localConstant.put(ctx.identifier().getText(), x);
                localVariables.push(localConstant);
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
    public Object visitIfStatement(APascaletParser.IfStatementContext ctx) {
        boolean condition;
        if(visit(ctx.expression()) instanceof Boolean)
        {
            condition = (Boolean) visit(ctx.expression());
            if(condition){
                visit(ctx.statement(0));
                return null;
            }
            else if(ctx.ELSE() != null && !condition){
                visit(ctx.statement(1));
                return null;
            }
        }
        else
            error("Not a valid expression error", ctx);
        return super.visitIfStatement(ctx);
    }
}

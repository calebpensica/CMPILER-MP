import gen.APascaletParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APascaletBaseVisitor extends gen.APascaletBaseVisitor<Integer> {

    private HashMap<String, Object> globalVariables;

    private List<HashMap<String, Object>> localVariables = new ArrayList<>();

    private boolean popStack = false;
//    procedureStatement -> IDENT   ( PARAMLIST )
//    Case 1                writeln ( '123123'  )
//    Case 1                writeln ( '231' + 2 )

//
//    public String getParameterType(char temp){
//        switch(temp){
//            case '\'': return "string";
//                       break;
//            case ''
//        }
//    }

    @Override
    public Integer visitProcedureStatement(APascaletParser.ProcedureStatementContext ctx) {

//        System.out.println(ctx.identifier().getText());
//        ArrayList<Object> parameters = evaluateParameterList(ctx.parameterList());


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
    private ArrayList<Object> evaluateParameterList(APascaletParser.ParameterListContext parameterList) {

        ArrayList<Object> temp = new ArrayList<>();

        int i = 0;
        do{
            temp.add(evaluateActualParameter(parameterList.actualParameter(i)));
            i++;
        }while(parameterList.COMMA(i) != null);

        return temp;
    }

    private Object evaluateActualParameter(APascaletParser.ActualParameterContext actualParameter) {


        System.out.println("oooooooooooo: " + actualParameter.getText() + " " + visit(actualParameter));
        return null;
    }

    private void error(String msg){
        System.out.println("Error: " + msg);
        System.exit(-1);
    }

}

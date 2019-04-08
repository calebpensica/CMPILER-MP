package Calc;

import Calc.gen.Calc.CalcLexer;
import Calc.gen.Calc.CalcParser;
import gen.APascaletLexer;
import gen.APascaletParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CalcMain {

    public static void main(String[] args) {
        CharStream input = null;

        String fileName = "src\\Calc\\input.txt";
        File file = new File(fileName);
        FileInputStream fis = null;

        //noinspection Duplicates
        try {

            fis = new FileInputStream(file);
            input = CharStreams.fromStream(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
        CalcLexer lexer = new CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.input();

        CalcBaseVisitor calcVisitor = new CalcBaseVisitor();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
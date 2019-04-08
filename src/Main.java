
import gen.APascaletLexer;
import gen.APascaletParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        CharStream input = null;

        String fileName = "src\\input.txt";
        File file = new File(fileName);
        FileInputStream fis = null;

        try {
            // Open the input file stream
            fis = new FileInputStream(file);

//            input = CharStreams.fromStream(System.in);
            input = CharStreams.fromStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        APascaletLexer lexer = new APascaletLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        APascaletParser parser = new APascaletParser(tokens);
        ParseTree tree = parser.program();

        APascaletBaseVisitor calcVisitor = new APascaletBaseVisitor();
        Double result = calcVisitor.visit(tree);
        System.out.println("Result: " + result);
    }
}
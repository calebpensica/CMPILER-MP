package gen;// Generated from C:/Users/Kevin/IdeaProjects/CMPILER_MP/src\APascalet.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link APascaletParser}.
 */
public interface APascaletListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(APascaletParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(APascaletParser.AddContext ctx);
}
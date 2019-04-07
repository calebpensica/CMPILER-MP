package gen;// Generated from C:/Users/Kevin/IdeaProjects/CMPILER_MP/src\APascalet.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link APascaletParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface APascaletVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(APascaletParser.AddContext ctx);
}
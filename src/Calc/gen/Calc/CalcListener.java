// Generated from C:/Users/Kevin/IdeaProjects/CMPILER-MP/src/Calc\Calc.g4 by ANTLR 4.7.2
package Calc.gen.Calc;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void enterToSetVar(CalcParser.ToSetVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToSetVar}
	 * labeled alternative in {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void exitToSetVar(CalcParser.ToSetVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void enterCalculate(CalcParser.CalculateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Calculate}
	 * labeled alternative in {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void exitCalculate(CalcParser.CalculateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link CalcParser#setVar}.
	 * @param ctx the parse tree
	 */
	void enterSetVariable(CalcParser.SetVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetVariable}
	 * labeled alternative in {@link CalcParser#setVar}.
	 * @param ctx the parse tree
	 */
	void exitSetVariable(CalcParser.SetVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterToMultOrDiv(CalcParser.ToMultOrDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToMultOrDiv}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitToMultOrDiv(CalcParser.ToMultOrDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterPlus(CalcParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitPlus(CalcParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void enterMinus(CalcParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link CalcParser#plusOrMinus}.
	 * @param ctx the parse tree
	 */
	void exitMinus(CalcParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(CalcParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterDivision(CalcParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitDivision(CalcParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void enterToPow(CalcParser.ToPowContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToPow}
	 * labeled alternative in {@link CalcParser#multOrDiv}.
	 * @param ctx the parse tree
	 */
	void exitToPow(CalcParser.ToPowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalcParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPower(CalcParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Power}
	 * labeled alternative in {@link CalcParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPower(CalcParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CalcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterChangeSign(CalcParser.ChangeSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ChangeSign}
	 * labeled alternative in {@link CalcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitChangeSign(CalcParser.ChangeSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CalcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void enterToAtom(CalcParser.ToAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link CalcParser#unaryMinus}.
	 * @param ctx the parse tree
	 */
	void exitToAtom(CalcParser.ToAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantPI(CalcParser.ConstantPIContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantPI}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantPI(CalcParser.ConstantPIContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterConstantE(CalcParser.ConstantEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstantE}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitConstantE(CalcParser.ConstantEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Double}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterDouble(CalcParser.DoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Double}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitDouble(CalcParser.DoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInt(CalcParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInt(CalcParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterVariable(CalcParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitVariable(CalcParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterBraces(CalcParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Braces}
	 * labeled alternative in {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitBraces(CalcParser.BracesContext ctx);
}
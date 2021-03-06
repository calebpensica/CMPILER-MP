package gen;// Generated from C:/Users/Kevin/IdeaProjects/CMPILER-MP/src\APascalet.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by {@link APascaletParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(APascaletParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#programHeading}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramHeading(APascaletParser.ProgramHeadingContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinitionPart(APascaletParser.TypeDefinitionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(APascaletParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(APascaletParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureType(APascaletParser.ProcedureTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#resultType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultType(APascaletParser.ResultTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#componentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentType(APascaletParser.ComponentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#labelDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelDeclarationPart(APascaletParser.LabelDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(APascaletParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinitionPart(APascaletParser.ConstantDefinitionPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#constantDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantDefinition(APascaletParser.ConstantDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(APascaletParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#structuredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredType(APascaletParser.StructuredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(APascaletParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(APascaletParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#scalarType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarType(APascaletParser.ScalarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#subrangeType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubrangeType(APascaletParser.SubrangeTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(APascaletParser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationPart(APascaletParser.VariableDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(APascaletParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureAndFunctionDeclarationPart(APascaletParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureOrFunctionDeclaration(APascaletParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(APascaletParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(APascaletParser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#formalParameterSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterSection(APascaletParser.FormalParameterSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#parameterGroup}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterGroup(APascaletParser.ParameterGroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(APascaletParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#constList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstList(APascaletParser.ConstListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(APascaletParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(APascaletParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(APascaletParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unpackedStructuredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpackedStructuredType(APascaletParser.UnpackedStructuredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(APascaletParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureStatement(APascaletParser.ProcedureStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(APascaletParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#forList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForList(APascaletParser.ForListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#initialValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitialValue(APascaletParser.InitialValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#finalValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalValue(APascaletParser.FinalValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(APascaletParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(APascaletParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#structuredStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredStatement(APascaletParser.StructuredStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(APascaletParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(APascaletParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#conditionalStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalStatement(APascaletParser.ConditionalStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(APascaletParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#repetetiveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetetiveStatement(APascaletParser.RepetetiveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(APascaletParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnlabelledStatement(APascaletParser.UnlabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(APascaletParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedInteger(APascaletParser.UnsignedIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#sign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSign(APascaletParser.SignContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(APascaletParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(APascaletParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedConstant(APascaletParser.UnsignedConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(APascaletParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#actualParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualParameter(APascaletParser.ActualParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#parameterwidth}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterwidth(APascaletParser.ParameterwidthContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#functionDesignator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDesignator(APascaletParser.FunctionDesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(APascaletParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(APascaletParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(APascaletParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(APascaletParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#relationaloperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationaloperator(APascaletParser.RelationaloperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(APascaletParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#additiveoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveoperator(APascaletParser.AdditiveoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(APascaletParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeoperator(APascaletParser.MultiplicativeoperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#signedFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedFactor(APascaletParser.SignedFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(APascaletParser.FactorContext ctx);
}
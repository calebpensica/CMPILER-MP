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
	 * Visit a parse tree produced by {@link APascaletParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(APascaletParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(APascaletParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#usesUnitsPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsesUnitsPart(APascaletParser.UsesUnitsPartContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#constantChr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantChr(APascaletParser.ConstantChrContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(APascaletParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedNumber(APascaletParser.UnsignedNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedInteger(APascaletParser.UnsignedIntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedReal(APascaletParser.UnsignedRealContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#structuredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructuredType(APascaletParser.StructuredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unpackedStructuredType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnpackedStructuredType(APascaletParser.UnpackedStructuredTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#stringtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringtype(APascaletParser.StringtypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(APascaletParser.ArrayTypeContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#componentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentType(APascaletParser.ComponentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#recordType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordType(APascaletParser.RecordTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#fieldList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldList(APascaletParser.FieldListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#fixedPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFixedPart(APascaletParser.FixedPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#recordSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordSection(APascaletParser.RecordSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#variantPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariantPart(APascaletParser.VariantPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(APascaletParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#variant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariant(APascaletParser.VariantContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#setType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(APascaletParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#baseType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseType(APascaletParser.BaseTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#fileType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFileType(APascaletParser.FileTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#pointerType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerType(APascaletParser.PointerTypeContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#resultType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResultType(APascaletParser.ResultTypeContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link APascaletParser#unsignedConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnsignedConstant(APascaletParser.UnsignedConstantContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#set}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(APascaletParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(APascaletParser.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(APascaletParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#procedureStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureStatement(APascaletParser.ProcedureStatementContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#gotoStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoStatement(APascaletParser.GotoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(APascaletParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(APascaletParser.EmptyContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#caseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseStatement(APascaletParser.CaseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#caseListElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseListElement(APascaletParser.CaseListElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#repetetiveStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetetiveStatement(APascaletParser.RepetetiveStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(APascaletParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#repeatStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeatStatement(APascaletParser.RepeatStatementContext ctx);
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
	 * Visit a parse tree produced by {@link APascaletParser#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(APascaletParser.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link APascaletParser#recordVariableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRecordVariableList(APascaletParser.RecordVariableListContext ctx);
}
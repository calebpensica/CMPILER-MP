package gen;// Generated from C:/Users/Kevin/IdeaProjects/CMPILER-MP/src\APascalet.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link APascaletParser}.
 */
public interface APascaletListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link APascaletParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(APascaletParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(APascaletParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void enterProgramHeading(APascaletParser.ProgramHeadingContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#programHeading}.
	 * @param ctx the parse tree
	 */
	void exitProgramHeading(APascaletParser.ProgramHeadingContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(APascaletParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(APascaletParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(APascaletParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(APascaletParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#usesUnitsPart}.
	 * @param ctx the parse tree
	 */
	void enterUsesUnitsPart(APascaletParser.UsesUnitsPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#usesUnitsPart}.
	 * @param ctx the parse tree
	 */
	void exitUsesUnitsPart(APascaletParser.UsesUnitsPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#labelDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterLabelDeclarationPart(APascaletParser.LabelDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#labelDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitLabelDeclarationPart(APascaletParser.LabelDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(APascaletParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(APascaletParser.LabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinitionPart(APascaletParser.ConstantDefinitionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#constantDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinitionPart(APascaletParser.ConstantDefinitionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefinition(APascaletParser.ConstantDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#constantDefinition}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefinition(APascaletParser.ConstantDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#constantChr}.
	 * @param ctx the parse tree
	 */
	void enterConstantChr(APascaletParser.ConstantChrContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#constantChr}.
	 * @param ctx the parse tree
	 */
	void exitConstantChr(APascaletParser.ConstantChrContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(APascaletParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(APascaletParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedNumber(APascaletParser.UnsignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#unsignedNumber}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedNumber(APascaletParser.UnsignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedInteger(APascaletParser.UnsignedIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#unsignedInteger}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedInteger(APascaletParser.UnsignedIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterSign(APascaletParser.SignContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitSign(APascaletParser.SignContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(APascaletParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(APascaletParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(APascaletParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(APascaletParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinitionPart(APascaletParser.TypeDefinitionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#typeDefinitionPart}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinitionPart(APascaletParser.TypeDefinitionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(APascaletParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(APascaletParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#functionType}.
	 * @param ctx the parse tree
	 */
	void enterFunctionType(APascaletParser.FunctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#functionType}.
	 * @param ctx the parse tree
	 */
	void exitFunctionType(APascaletParser.FunctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#procedureType}.
	 * @param ctx the parse tree
	 */
	void enterProcedureType(APascaletParser.ProcedureTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#procedureType}.
	 * @param ctx the parse tree
	 */
	void exitProcedureType(APascaletParser.ProcedureTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(APascaletParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(APascaletParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(APascaletParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(APascaletParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#scalarType}.
	 * @param ctx the parse tree
	 */
	void enterScalarType(APascaletParser.ScalarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#scalarType}.
	 * @param ctx the parse tree
	 */
	void exitScalarType(APascaletParser.ScalarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void enterSubrangeType(APascaletParser.SubrangeTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#subrangeType}.
	 * @param ctx the parse tree
	 */
	void exitSubrangeType(APascaletParser.SubrangeTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(APascaletParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(APascaletParser.TypeIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#structuredType}.
	 * @param ctx the parse tree
	 */
	void enterStructuredType(APascaletParser.StructuredTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#structuredType}.
	 * @param ctx the parse tree
	 */
	void exitStructuredType(APascaletParser.StructuredTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#unpackedStructuredType}.
	 * @param ctx the parse tree
	 */
	void enterUnpackedStructuredType(APascaletParser.UnpackedStructuredTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#unpackedStructuredType}.
	 * @param ctx the parse tree
	 */
	void exitUnpackedStructuredType(APascaletParser.UnpackedStructuredTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void enterStringtype(APascaletParser.StringtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void exitStringtype(APascaletParser.StringtypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(APascaletParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(APascaletParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(APascaletParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(APascaletParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(APascaletParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(APascaletParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#componentType}.
	 * @param ctx the parse tree
	 */
	void enterComponentType(APascaletParser.ComponentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#componentType}.
	 * @param ctx the parse tree
	 */
	void exitComponentType(APascaletParser.ComponentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#recordType}.
	 * @param ctx the parse tree
	 */
	void enterRecordType(APascaletParser.RecordTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#recordType}.
	 * @param ctx the parse tree
	 */
	void exitRecordType(APascaletParser.RecordTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void enterFieldList(APascaletParser.FieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#fieldList}.
	 * @param ctx the parse tree
	 */
	void exitFieldList(APascaletParser.FieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#fixedPart}.
	 * @param ctx the parse tree
	 */
	void enterFixedPart(APascaletParser.FixedPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#fixedPart}.
	 * @param ctx the parse tree
	 */
	void exitFixedPart(APascaletParser.FixedPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#recordSection}.
	 * @param ctx the parse tree
	 */
	void enterRecordSection(APascaletParser.RecordSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#recordSection}.
	 * @param ctx the parse tree
	 */
	void exitRecordSection(APascaletParser.RecordSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#variantPart}.
	 * @param ctx the parse tree
	 */
	void enterVariantPart(APascaletParser.VariantPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#variantPart}.
	 * @param ctx the parse tree
	 */
	void exitVariantPart(APascaletParser.VariantPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(APascaletParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(APascaletParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#variant}.
	 * @param ctx the parse tree
	 */
	void enterVariant(APascaletParser.VariantContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#variant}.
	 * @param ctx the parse tree
	 */
	void exitVariant(APascaletParser.VariantContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#setType}.
	 * @param ctx the parse tree
	 */
	void enterSetType(APascaletParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#setType}.
	 * @param ctx the parse tree
	 */
	void exitSetType(APascaletParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#baseType}.
	 * @param ctx the parse tree
	 */
	void enterBaseType(APascaletParser.BaseTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#baseType}.
	 * @param ctx the parse tree
	 */
	void exitBaseType(APascaletParser.BaseTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#fileType}.
	 * @param ctx the parse tree
	 */
	void enterFileType(APascaletParser.FileTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#fileType}.
	 * @param ctx the parse tree
	 */
	void exitFileType(APascaletParser.FileTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void enterPointerType(APascaletParser.PointerTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void exitPointerType(APascaletParser.PointerTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationPart(APascaletParser.VariableDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#variableDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationPart(APascaletParser.VariableDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(APascaletParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(APascaletParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void enterProcedureAndFunctionDeclarationPart(APascaletParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#procedureAndFunctionDeclarationPart}.
	 * @param ctx the parse tree
	 */
	void exitProcedureAndFunctionDeclarationPart(APascaletParser.ProcedureAndFunctionDeclarationPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureOrFunctionDeclaration(APascaletParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#procedureOrFunctionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureOrFunctionDeclaration(APascaletParser.ProcedureOrFunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(APascaletParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(APascaletParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(APascaletParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(APascaletParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#formalParameterSection}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterSection(APascaletParser.FormalParameterSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#formalParameterSection}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterSection(APascaletParser.FormalParameterSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void enterParameterGroup(APascaletParser.ParameterGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#parameterGroup}.
	 * @param ctx the parse tree
	 */
	void exitParameterGroup(APascaletParser.ParameterGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(APascaletParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(APascaletParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#constList}.
	 * @param ctx the parse tree
	 */
	void enterConstList(APascaletParser.ConstListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#constList}.
	 * @param ctx the parse tree
	 */
	void exitConstList(APascaletParser.ConstListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(APascaletParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(APascaletParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#resultType}.
	 * @param ctx the parse tree
	 */
	void enterResultType(APascaletParser.ResultTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#resultType}.
	 * @param ctx the parse tree
	 */
	void exitResultType(APascaletParser.ResultTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(APascaletParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(APascaletParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterUnlabelledStatement(APascaletParser.UnlabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#unlabelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitUnlabelledStatement(APascaletParser.UnlabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(APascaletParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(APascaletParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(APascaletParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(APascaletParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(APascaletParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(APascaletParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(APascaletParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(APascaletParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void enterRelationaloperator(APascaletParser.RelationaloperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#relationaloperator}.
	 * @param ctx the parse tree
	 */
	void exitRelationaloperator(APascaletParser.RelationaloperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(APascaletParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(APascaletParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#additiveoperator}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveoperator(APascaletParser.AdditiveoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#additiveoperator}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveoperator(APascaletParser.AdditiveoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(APascaletParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(APascaletParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeoperator(APascaletParser.MultiplicativeoperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#multiplicativeoperator}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeoperator(APascaletParser.MultiplicativeoperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void enterSignedFactor(APascaletParser.SignedFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#signedFactor}.
	 * @param ctx the parse tree
	 */
	void exitSignedFactor(APascaletParser.SignedFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(APascaletParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(APascaletParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void enterUnsignedConstant(APascaletParser.UnsignedConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#unsignedConstant}.
	 * @param ctx the parse tree
	 */
	void exitUnsignedConstant(APascaletParser.UnsignedConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDesignator(APascaletParser.FunctionDesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#functionDesignator}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDesignator(APascaletParser.FunctionDesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(APascaletParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(APascaletParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#set}.
	 * @param ctx the parse tree
	 */
	void enterSet(APascaletParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#set}.
	 * @param ctx the parse tree
	 */
	void exitSet(APascaletParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(APascaletParser.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(APascaletParser.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(APascaletParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(APascaletParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void enterProcedureStatement(APascaletParser.ProcedureStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#procedureStatement}.
	 * @param ctx the parse tree
	 */
	void exitProcedureStatement(APascaletParser.ProcedureStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void enterActualParameter(APascaletParser.ActualParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#actualParameter}.
	 * @param ctx the parse tree
	 */
	void exitActualParameter(APascaletParser.ActualParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#parameterwidth}.
	 * @param ctx the parse tree
	 */
	void enterParameterwidth(APascaletParser.ParameterwidthContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#parameterwidth}.
	 * @param ctx the parse tree
	 */
	void exitParameterwidth(APascaletParser.ParameterwidthContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void enterGotoStatement(APascaletParser.GotoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#gotoStatement}.
	 * @param ctx the parse tree
	 */
	void exitGotoStatement(APascaletParser.GotoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(APascaletParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(APascaletParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#empty}.
	 * @param ctx the parse tree
	 */
	void enterEmpty(APascaletParser.EmptyContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#empty}.
	 * @param ctx the parse tree
	 */
	void exitEmpty(APascaletParser.EmptyContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void enterStructuredStatement(APascaletParser.StructuredStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#structuredStatement}.
	 * @param ctx the parse tree
	 */
	void exitStructuredStatement(APascaletParser.StructuredStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(APascaletParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(APascaletParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(APascaletParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(APascaletParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionalStatement(APascaletParser.ConditionalStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#conditionalStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionalStatement(APascaletParser.ConditionalStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(APascaletParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(APascaletParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void enterCaseStatement(APascaletParser.CaseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#caseStatement}.
	 * @param ctx the parse tree
	 */
	void exitCaseStatement(APascaletParser.CaseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#caseListElement}.
	 * @param ctx the parse tree
	 */
	void enterCaseListElement(APascaletParser.CaseListElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#caseListElement}.
	 * @param ctx the parse tree
	 */
	void exitCaseListElement(APascaletParser.CaseListElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#repetetiveStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepetetiveStatement(APascaletParser.RepetetiveStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#repetetiveStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepetetiveStatement(APascaletParser.RepetetiveStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(APascaletParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(APascaletParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void enterRepeatStatement(APascaletParser.RepeatStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#repeatStatement}.
	 * @param ctx the parse tree
	 */
	void exitRepeatStatement(APascaletParser.RepeatStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(APascaletParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(APascaletParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#forList}.
	 * @param ctx the parse tree
	 */
	void enterForList(APascaletParser.ForListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#forList}.
	 * @param ctx the parse tree
	 */
	void exitForList(APascaletParser.ForListContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void enterInitialValue(APascaletParser.InitialValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#initialValue}.
	 * @param ctx the parse tree
	 */
	void exitInitialValue(APascaletParser.InitialValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void enterFinalValue(APascaletParser.FinalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#finalValue}.
	 * @param ctx the parse tree
	 */
	void exitFinalValue(APascaletParser.FinalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(APascaletParser.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(APascaletParser.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link APascaletParser#recordVariableList}.
	 * @param ctx the parse tree
	 */
	void enterRecordVariableList(APascaletParser.RecordVariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link APascaletParser#recordVariableList}.
	 * @param ctx the parse tree
	 */
	void exitRecordVariableList(APascaletParser.RecordVariableListContext ctx);
}
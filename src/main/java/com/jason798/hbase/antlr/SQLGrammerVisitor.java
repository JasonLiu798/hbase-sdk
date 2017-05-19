// Generated from r\SQLGrammer.g4 by ANTLR 4.5.3
package com.jason798.hbase.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SQLGrammerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SQLGrammerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code selectSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSqlStmt(SQLGrammerParser.SelectSqlStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code deleteSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteSqlStmt(SQLGrammerParser.DeleteSqlStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code updateSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSqlStmt(SQLGrammerParser.UpdateSqlStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#selectSql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectSql(SQLGrammerParser.SelectSqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#deleteSql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteSql(SQLGrammerParser.DeleteSqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#updateSql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateSql(SQLGrammerParser.UpdateSqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#assignList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignList(SQLGrammerParser.AssignListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#wherec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWherec(SQLGrammerParser.WherecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotequalvar(SQLGrammerParser.NotequalvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessequalvar(SQLGrammerParser.LessequalvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notmatchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotmatchvar(SQLGrammerParser.NotmatchvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notbetweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotbetweenvar(SQLGrammerParser.NotbetweenvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ismissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsmissingc(SQLGrammerParser.IsmissingcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndcondition(SQLGrammerParser.AndconditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterequalconstant(SQLGrammerParser.GreaterequalconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notmatchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotmatchconstant(SQLGrammerParser.NotmatchconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualvar(SQLGrammerParser.EqualvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterconstant(SQLGrammerParser.GreaterconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenvar(SQLGrammerParser.BetweenvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code betweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenconstant(SQLGrammerParser.BetweenconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isnotnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsnotnullc(SQLGrammerParser.IsnotnullcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInconstantlist(SQLGrammerParser.InconstantlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notbetweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotbetweenconstant(SQLGrammerParser.NotbetweenconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isnotmissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsnotmissingc(SQLGrammerParser.IsnotmissingcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notinconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotinconstantlist(SQLGrammerParser.NotinconstantlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrcondition(SQLGrammerParser.OrconditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsnullc(SQLGrammerParser.IsnullcContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualconstant(SQLGrammerParser.EqualconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterequalvar(SQLGrammerParser.GreaterequalvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessvar(SQLGrammerParser.LessvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotequalconstant(SQLGrammerParser.NotequalconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchvar(SQLGrammerParser.MatchvarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code invarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvarlist(SQLGrammerParser.InvarlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessconstant(SQLGrammerParser.LessconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionwrapper}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionwrapper(SQLGrammerParser.ConditionwrapperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notinvarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotinvarlist(SQLGrammerParser.NotinvarlistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessequalconstant(SQLGrammerParser.LessequalconstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greatervar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatervar(SQLGrammerParser.GreatervarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code matchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchconstant(SQLGrammerParser.MatchconstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#specrowkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecrowkey(SQLGrammerParser.SpecrowkeyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowkeyrangeSE}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyrangeSE(SQLGrammerParser.RowkeyrangeSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowkeyrangeStart}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyrangeStart(SQLGrammerParser.RowkeyrangeStartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowkeyrangeEnd}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyrangeEnd(SQLGrammerParser.RowkeyrangeEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowkeyrangeOne}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyrangeOne(SQLGrammerParser.RowkeyrangeOneContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rowkeyrangeSpec}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyrangeSpec(SQLGrammerParser.RowkeyrangeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#rowkeyexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRowkeyexp(SQLGrammerParser.RowkeyexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tsrange_startAndEnd}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsrange_startAndEnd(SQLGrammerParser.Tsrange_startAndEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tsrange_start}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsrange_start(SQLGrammerParser.Tsrange_startContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tsrange_end}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsrange_end(SQLGrammerParser.Tsrange_endContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#tsexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTsexp(SQLGrammerParser.TsexpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnListExt}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnListExt(SQLGrammerParser.ColumnListExtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnListAll}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnListAll(SQLGrammerParser.ColumnListAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code columnListOne}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnListOne(SQLGrammerParser.ColumnListOneContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(SQLGrammerParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#constantList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantList(SQLGrammerParser.ConstantListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#constant2List}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant2List(SQLGrammerParser.Constant2ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant2_NotNull}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant2_NotNull(SQLGrammerParser.Constant2_NotNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constant2_Null}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant2_Null(SQLGrammerParser.Constant2_NullContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#maxversionexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxversionexp(SQLGrammerParser.MaxversionexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#limitexp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLimitexp(SQLGrammerParser.LimitexpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#maxversion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaxversion(SQLGrammerParser.MaxversionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(SQLGrammerParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SQLGrammerParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#table_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_name(SQLGrammerParser.Table_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SQLGrammerParser#column_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn_name(SQLGrammerParser.Column_nameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code values}
	 * labeled alternative in {@link SQLGrammerParser#progprogprogconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncrowkeyrangerowkeyrangerowkeyrangerowkeyrangerowkeyrangetsrangetsrangetsrangecolumnListcolumnListcolumnListconstant2constant2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(SQLGrammerParser.ValuesContext ctx);
}
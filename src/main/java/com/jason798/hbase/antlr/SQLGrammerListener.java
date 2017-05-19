// Generated from r\SQLGrammer.g4 by ANTLR 4.5.3
package com.jason798.hbase.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLGrammerParser}.
 */
public interface SQLGrammerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code selectSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterSelectSqlStmt(SQLGrammerParser.SelectSqlStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selectSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitSelectSqlStmt(SQLGrammerParser.SelectSqlStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code deleteSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterDeleteSqlStmt(SQLGrammerParser.DeleteSqlStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code deleteSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitDeleteSqlStmt(SQLGrammerParser.DeleteSqlStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code updateSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterUpdateSqlStmt(SQLGrammerParser.UpdateSqlStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code updateSqlStmt}
	 * labeled alternative in {@link SQLGrammerParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitUpdateSqlStmt(SQLGrammerParser.UpdateSqlStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#selectSql}.
	 * @param ctx the parse tree
	 */
	void enterSelectSql(SQLGrammerParser.SelectSqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#selectSql}.
	 * @param ctx the parse tree
	 */
	void exitSelectSql(SQLGrammerParser.SelectSqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#deleteSql}.
	 * @param ctx the parse tree
	 */
	void enterDeleteSql(SQLGrammerParser.DeleteSqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#deleteSql}.
	 * @param ctx the parse tree
	 */
	void exitDeleteSql(SQLGrammerParser.DeleteSqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#updateSql}.
	 * @param ctx the parse tree
	 */
	void enterUpdateSql(SQLGrammerParser.UpdateSqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#updateSql}.
	 * @param ctx the parse tree
	 */
	void exitUpdateSql(SQLGrammerParser.UpdateSqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#assignList}.
	 * @param ctx the parse tree
	 */
	void enterAssignList(SQLGrammerParser.AssignListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#assignList}.
	 * @param ctx the parse tree
	 */
	void exitAssignList(SQLGrammerParser.AssignListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#wherec}.
	 * @param ctx the parse tree
	 */
	void enterWherec(SQLGrammerParser.WherecContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#wherec}.
	 * @param ctx the parse tree
	 */
	void exitWherec(SQLGrammerParser.WherecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotequalvar(SQLGrammerParser.NotequalvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotequalvar(SQLGrammerParser.NotequalvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterLessequalvar(SQLGrammerParser.LessequalvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitLessequalvar(SQLGrammerParser.LessequalvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notmatchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotmatchvar(SQLGrammerParser.NotmatchvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notmatchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotmatchvar(SQLGrammerParser.NotmatchvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notbetweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotbetweenvar(SQLGrammerParser.NotbetweenvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notbetweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotbetweenvar(SQLGrammerParser.NotbetweenvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ismissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterIsmissingc(SQLGrammerParser.IsmissingcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ismissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitIsmissingc(SQLGrammerParser.IsmissingcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterAndcondition(SQLGrammerParser.AndconditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitAndcondition(SQLGrammerParser.AndconditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterGreaterequalconstant(SQLGrammerParser.GreaterequalconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitGreaterequalconstant(SQLGrammerParser.GreaterequalconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notmatchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotmatchconstant(SQLGrammerParser.NotmatchconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notmatchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotmatchconstant(SQLGrammerParser.NotmatchconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterEqualvar(SQLGrammerParser.EqualvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitEqualvar(SQLGrammerParser.EqualvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterGreaterconstant(SQLGrammerParser.GreaterconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitGreaterconstant(SQLGrammerParser.GreaterconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code betweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterBetweenvar(SQLGrammerParser.BetweenvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code betweenvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitBetweenvar(SQLGrammerParser.BetweenvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code betweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterBetweenconstant(SQLGrammerParser.BetweenconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code betweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitBetweenconstant(SQLGrammerParser.BetweenconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isnotnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterIsnotnullc(SQLGrammerParser.IsnotnullcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isnotnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitIsnotnullc(SQLGrammerParser.IsnotnullcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterInconstantlist(SQLGrammerParser.InconstantlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitInconstantlist(SQLGrammerParser.InconstantlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notbetweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotbetweenconstant(SQLGrammerParser.NotbetweenconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notbetweenconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotbetweenconstant(SQLGrammerParser.NotbetweenconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isnotmissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterIsnotmissingc(SQLGrammerParser.IsnotmissingcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isnotmissingc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitIsnotmissingc(SQLGrammerParser.IsnotmissingcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notinconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotinconstantlist(SQLGrammerParser.NotinconstantlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notinconstantlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotinconstantlist(SQLGrammerParser.NotinconstantlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterOrcondition(SQLGrammerParser.OrconditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orcondition}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitOrcondition(SQLGrammerParser.OrconditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterIsnullc(SQLGrammerParser.IsnullcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isnullc}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitIsnullc(SQLGrammerParser.IsnullcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterEqualconstant(SQLGrammerParser.EqualconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitEqualconstant(SQLGrammerParser.EqualconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterGreaterequalvar(SQLGrammerParser.GreaterequalvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterequalvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitGreaterequalvar(SQLGrammerParser.GreaterequalvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterLessvar(SQLGrammerParser.LessvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitLessvar(SQLGrammerParser.LessvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotequalconstant(SQLGrammerParser.NotequalconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotequalconstant(SQLGrammerParser.NotequalconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterMatchvar(SQLGrammerParser.MatchvarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchvar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitMatchvar(SQLGrammerParser.MatchvarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code invarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterInvarlist(SQLGrammerParser.InvarlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code invarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitInvarlist(SQLGrammerParser.InvarlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterLessconstant(SQLGrammerParser.LessconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitLessconstant(SQLGrammerParser.LessconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionwrapper}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterConditionwrapper(SQLGrammerParser.ConditionwrapperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionwrapper}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitConditionwrapper(SQLGrammerParser.ConditionwrapperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notinvarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterNotinvarlist(SQLGrammerParser.NotinvarlistContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notinvarlist}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitNotinvarlist(SQLGrammerParser.NotinvarlistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterLessequalconstant(SQLGrammerParser.LessequalconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessequalconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitLessequalconstant(SQLGrammerParser.LessequalconstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greatervar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterGreatervar(SQLGrammerParser.GreatervarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greatervar}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitGreatervar(SQLGrammerParser.GreatervarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code matchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void enterMatchconstant(SQLGrammerParser.MatchconstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code matchconstant}
	 * labeled alternative in {@link SQLGrammerParser#conditionc}.
	 * @param ctx the parse tree
	 */
	void exitMatchconstant(SQLGrammerParser.MatchconstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#specrowkey}.
	 * @param ctx the parse tree
	 */
	void enterSpecrowkey(SQLGrammerParser.SpecrowkeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#specrowkey}.
	 * @param ctx the parse tree
	 */
	void exitSpecrowkey(SQLGrammerParser.SpecrowkeyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowkeyrangeSE}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyrangeSE(SQLGrammerParser.RowkeyrangeSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowkeyrangeSE}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyrangeSE(SQLGrammerParser.RowkeyrangeSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowkeyrangeStart}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyrangeStart(SQLGrammerParser.RowkeyrangeStartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowkeyrangeStart}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyrangeStart(SQLGrammerParser.RowkeyrangeStartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowkeyrangeEnd}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyrangeEnd(SQLGrammerParser.RowkeyrangeEndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowkeyrangeEnd}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyrangeEnd(SQLGrammerParser.RowkeyrangeEndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowkeyrangeOne}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyrangeOne(SQLGrammerParser.RowkeyrangeOneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowkeyrangeOne}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyrangeOne(SQLGrammerParser.RowkeyrangeOneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowkeyrangeSpec}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyrangeSpec(SQLGrammerParser.RowkeyrangeSpecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowkeyrangeSpec}
	 * labeled alternative in {@link SQLGrammerParser#rowkeyrange}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyrangeSpec(SQLGrammerParser.RowkeyrangeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#rowkeyexp}.
	 * @param ctx the parse tree
	 */
	void enterRowkeyexp(SQLGrammerParser.RowkeyexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#rowkeyexp}.
	 * @param ctx the parse tree
	 */
	void exitRowkeyexp(SQLGrammerParser.RowkeyexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tsrange_startAndEnd}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void enterTsrange_startAndEnd(SQLGrammerParser.Tsrange_startAndEndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tsrange_startAndEnd}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void exitTsrange_startAndEnd(SQLGrammerParser.Tsrange_startAndEndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tsrange_start}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void enterTsrange_start(SQLGrammerParser.Tsrange_startContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tsrange_start}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void exitTsrange_start(SQLGrammerParser.Tsrange_startContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tsrange_end}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void enterTsrange_end(SQLGrammerParser.Tsrange_endContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tsrange_end}
	 * labeled alternative in {@link SQLGrammerParser#tsrange}.
	 * @param ctx the parse tree
	 */
	void exitTsrange_end(SQLGrammerParser.Tsrange_endContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#tsexp}.
	 * @param ctx the parse tree
	 */
	void enterTsexp(SQLGrammerParser.TsexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#tsexp}.
	 * @param ctx the parse tree
	 */
	void exitTsexp(SQLGrammerParser.TsexpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnListExt}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnListExt(SQLGrammerParser.ColumnListExtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnListExt}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnListExt(SQLGrammerParser.ColumnListExtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnListAll}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnListAll(SQLGrammerParser.ColumnListAllContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnListAll}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnListAll(SQLGrammerParser.ColumnListAllContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnListOne}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnListOne(SQLGrammerParser.ColumnListOneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnListOne}
	 * labeled alternative in {@link SQLGrammerParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnListOne(SQLGrammerParser.ColumnListOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(SQLGrammerParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(SQLGrammerParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(SQLGrammerParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(SQLGrammerParser.ConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#constant2List}.
	 * @param ctx the parse tree
	 */
	void enterConstant2List(SQLGrammerParser.Constant2ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#constant2List}.
	 * @param ctx the parse tree
	 */
	void exitConstant2List(SQLGrammerParser.Constant2ListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant2_NotNull}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 */
	void enterConstant2_NotNull(SQLGrammerParser.Constant2_NotNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant2_NotNull}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 */
	void exitConstant2_NotNull(SQLGrammerParser.Constant2_NotNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constant2_Null}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 */
	void enterConstant2_Null(SQLGrammerParser.Constant2_NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constant2_Null}
	 * labeled alternative in {@link SQLGrammerParser#constant2}.
	 * @param ctx the parse tree
	 */
	void exitConstant2_Null(SQLGrammerParser.Constant2_NullContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#maxversionexp}.
	 * @param ctx the parse tree
	 */
	void enterMaxversionexp(SQLGrammerParser.MaxversionexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#maxversionexp}.
	 * @param ctx the parse tree
	 */
	void exitMaxversionexp(SQLGrammerParser.MaxversionexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#limitexp}.
	 * @param ctx the parse tree
	 */
	void enterLimitexp(SQLGrammerParser.LimitexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#limitexp}.
	 * @param ctx the parse tree
	 */
	void exitLimitexp(SQLGrammerParser.LimitexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#maxversion}.
	 * @param ctx the parse tree
	 */
	void enterMaxversion(SQLGrammerParser.MaxversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#maxversion}.
	 * @param ctx the parse tree
	 */
	void exitMaxversion(SQLGrammerParser.MaxversionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(SQLGrammerParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(SQLGrammerParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(SQLGrammerParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(SQLGrammerParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(SQLGrammerParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(SQLGrammerParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLGrammerParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(SQLGrammerParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLGrammerParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(SQLGrammerParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code values}
	 * labeled alternative in {@link SQLGrammerParser#progprogprogconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncrowkeyrangerowkeyrangerowkeyrangerowkeyrangerowkeyrangetsrangetsrangetsrangecolumnListcolumnListcolumnListconstant2constant2}.
	 * @param ctx the parse tree
	 */
	void enterValues(SQLGrammerParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code values}
	 * labeled alternative in {@link SQLGrammerParser#progprogprogconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncconditioncrowkeyrangerowkeyrangerowkeyrangerowkeyrangerowkeyrangetsrangetsrangetsrangecolumnListcolumnListcolumnListconstant2constant2}.
	 * @param ctx the parse tree
	 */
	void exitValues(SQLGrammerParser.ValuesContext ctx);
}
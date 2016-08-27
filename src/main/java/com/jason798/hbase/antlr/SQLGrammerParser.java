package com.jason798.hbase.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLGrammerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, SELECT=3, UPDATE=4, DELETE=5, FROM=6, WHERE=7, STAR=8, 
		LB=9, RB=10, SET=11, ROWKEY=12, STARTKEY=13, ENDKEY=14, MAXVERSION=15, 
		LIMIT=16, TS=17, STARTTS=18, ENDTS=19, IS=20, NULL=21, NOT=22, AND=23, 
		OR=24, EQ=25, LESSEQUAL=26, LESS=27, GREATEREQUAL=28, GREATER=29, NOTEQUAL=30, 
		EQUAL=31, NOTMATCH=32, MATCH=33, IN=34, NOTIN=35, BETWEEN=36, NOTBETWEEN=37, 
		ISNULL=38, ISNOTNULL=39, ISMISSING=40, ISNOTMISSING=41, Double_Quote=42, 
		Quote=43, Underscore=44, Period=45, POSITIVE=46, NATURAL=47, Regular_Identifier=48, 
		Data_Value=49, WS=50;
	public static final int
		RULE_prog = 0, RULE_selectSql = 1, RULE_deleteSql = 2, RULE_updateSql = 3, 
		RULE_assignList = 4, RULE_wherec = 5, RULE_conditionc = 6, RULE_specrowkey = 7, 
		RULE_rowkeyrange = 8, RULE_rowkeyexp = 9, RULE_tsrange = 10, RULE_tsexp = 11, 
		RULE_columnList = 12, RULE_funcname = 13, RULE_constantList = 14, RULE_constant2List = 15, 
		RULE_constant2 = 16, RULE_maxversionexp = 17, RULE_limitexp = 18, RULE_maxversion = 19, 
		RULE_constant = 20, RULE_var = 21, RULE_table_name = 22, RULE_column_name = 23, 
		RULE_values = 24;
	public static final String[] ruleNames = {
		"prog", "selectSql", "deleteSql", "updateSql", "assignList", "wherec", 
		"conditionc", "specrowkey", "rowkeyrange", "rowkeyexp", "tsrange", "tsexp", 
		"columnList", "funcname", "constantList", "constant2List", "constant2", 
		"maxversionexp", "limitexp", "maxversion", "constant", "var", "table_name", 
		"column_name", "values"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'#'", null, null, null, null, null, "'*'", "'('", "')'", 
		null, null, null, null, "'maxversion'", null, null, null, null, null, 
		null, null, null, null, "'='", "'lessequal'", "'less'", "'greaterequal'", 
		"'greater'", "'notequal'", "'equal'", "'notmatch'", "'match'", "'in'", 
		"'notin'", "'between'", "'notbetween'", "'isnull'", "'isnotnull'", "'ismissing'", 
		"'isnotmissing'", "'\"'", "'''", "'_'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "SELECT", "UPDATE", "DELETE", "FROM", "WHERE", "STAR", 
		"LB", "RB", "SET", "ROWKEY", "STARTKEY", "ENDKEY", "MAXVERSION", "LIMIT", 
		"TS", "STARTTS", "ENDTS", "IS", "NULL", "NOT", "AND", "OR", "EQ", "LESSEQUAL", 
		"LESS", "GREATEREQUAL", "GREATER", "NOTEQUAL", "EQUAL", "NOTMATCH", "MATCH", 
		"IN", "NOTIN", "BETWEEN", "NOTBETWEEN", "ISNULL", "ISNOTNULL", "ISMISSING", 
		"ISNOTMISSING", "Double_Quote", "Quote", "Underscore", "Period", "POSITIVE", 
		"NATURAL", "Regular_Identifier", "Data_Value", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SQLGrammer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLGrammerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectSqlStmtContext extends ProgContext {
		public SelectSqlContext selectSql() {
			return getRuleContext(SelectSqlContext.class,0);
		}
		public SelectSqlStmtContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterSelectSqlStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitSelectSqlStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitSelectSqlStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UpdateSqlStmtContext extends ProgContext {
		public UpdateSqlContext updateSql() {
			return getRuleContext(UpdateSqlContext.class,0);
		}
		public UpdateSqlStmtContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterUpdateSqlStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitUpdateSqlStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitUpdateSqlStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeleteSqlStmtContext extends ProgContext {
		public DeleteSqlContext deleteSql() {
			return getRuleContext(DeleteSqlContext.class,0);
		}
		public DeleteSqlStmtContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterDeleteSqlStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitDeleteSqlStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitDeleteSqlStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(53);
			switch (_input.LA(1)) {
			case SELECT:
				_localctx = new SelectSqlStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				selectSql();
				}
				break;
			case DELETE:
				_localctx = new DeleteSqlStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				deleteSql();
				}
				break;
			case UPDATE:
				_localctx = new UpdateSqlStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				updateSql();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectSqlContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(SQLGrammerParser.SELECT, 0); }
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLGrammerParser.FROM, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public MaxversionexpContext maxversionexp() {
			return getRuleContext(MaxversionexpContext.class,0);
		}
		public TsrangeContext tsrange() {
			return getRuleContext(TsrangeContext.class,0);
		}
		public LimitexpContext limitexp() {
			return getRuleContext(LimitexpContext.class,0);
		}
		public SelectSqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectSql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterSelectSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitSelectSql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitSelectSql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectSqlContext selectSql() throws RecognitionException {
		SelectSqlContext _localctx = new SelectSqlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectSql);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(SELECT);
			setState(56);
			columnList();
			setState(57);
			match(FROM);
			setState(58);
			table_name();
			setState(60);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(59);
				wherec();
				}
			}

			setState(62);
			rowkeyrange();
			setState(64);
			_la = _input.LA(1);
			if (_la==MAXVERSION) {
				{
				setState(63);
				maxversionexp();
				}
			}

			setState(67);
			_la = _input.LA(1);
			if (_la==STARTTS || _la==ENDTS) {
				{
				setState(66);
				tsrange();
				}
			}

			setState(70);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(69);
				limitexp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteSqlContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(SQLGrammerParser.DELETE, 0); }
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode FROM() { return getToken(SQLGrammerParser.FROM, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public RowkeyrangeContext rowkeyrange() {
			return getRuleContext(RowkeyrangeContext.class,0);
		}
		public WherecContext wherec() {
			return getRuleContext(WherecContext.class,0);
		}
		public TerminalNode TS() { return getToken(SQLGrammerParser.TS, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public DeleteSqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteSql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterDeleteSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitDeleteSql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitDeleteSql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteSqlContext deleteSql() throws RecognitionException {
		DeleteSqlContext _localctx = new DeleteSqlContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_deleteSql);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(DELETE);
			setState(73);
			columnList();
			setState(74);
			match(FROM);
			setState(75);
			table_name();
			setState(77);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(76);
				wherec();
				}
			}

			setState(79);
			rowkeyrange();
			setState(83);
			_la = _input.LA(1);
			if (_la==TS) {
				{
				setState(80);
				match(TS);
				setState(81);
				match(IS);
				setState(82);
				tsexp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateSqlContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(SQLGrammerParser.UPDATE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public TerminalNode SET() { return getToken(SQLGrammerParser.SET, 0); }
		public AssignListContext assignList() {
			return getRuleContext(AssignListContext.class,0);
		}
		public SpecrowkeyContext specrowkey() {
			return getRuleContext(SpecrowkeyContext.class,0);
		}
		public UpdateSqlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateSql; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterUpdateSql(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitUpdateSql(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitUpdateSql(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateSqlContext updateSql() throws RecognitionException {
		UpdateSqlContext _localctx = new UpdateSqlContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_updateSql);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(UPDATE);
			setState(86);
			table_name();
			setState(87);
			match(SET);
			setState(88);
			assignList();
			setState(89);
			specrowkey();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignListContext extends ParserRuleContext {
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(SQLGrammerParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(SQLGrammerParser.EQ, i);
		}
		public List<ValuesContext> values() {
			return getRuleContexts(ValuesContext.class);
		}
		public ValuesContext values(int i) {
			return getRuleContext(ValuesContext.class,i);
		}
		public AssignListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterAssignList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitAssignList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitAssignList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignListContext assignList() throws RecognitionException {
		AssignListContext _localctx = new AssignListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			column_name();
			setState(92);
			match(EQ);
			setState(93);
			values();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(94);
				match(T__0);
				setState(95);
				column_name();
				setState(96);
				match(EQ);
				setState(97);
				values();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WherecContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(SQLGrammerParser.WHERE, 0); }
		public ConditioncContext conditionc() {
			return getRuleContext(ConditioncContext.class,0);
		}
		public WherecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterWherec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitWherec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitWherec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WherecContext wherec() throws RecognitionException {
		WherecContext _localctx = new WherecContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_wherec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(WHERE);
			setState(105);
			conditionc(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditioncContext extends ParserRuleContext {
		public ConditioncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionc; }
	 
		public ConditioncContext() { }
		public void copyFrom(ConditioncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NotequalvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(SQLGrammerParser.NOTEQUAL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NotequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotequalvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotequalvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotequalvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessequalvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode LESSEQUAL() { return getToken(SQLGrammerParser.LESSEQUAL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public LessequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterLessequalvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitLessequalvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitLessequalvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotmatchvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTMATCH() { return getToken(SQLGrammerParser.NOTMATCH, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NotmatchvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotmatchvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotmatchvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotmatchvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotbetweenvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTBETWEEN() { return getToken(SQLGrammerParser.NOTBETWEEN, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLGrammerParser.AND, 0); }
		public NotbetweenvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotbetweenvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotbetweenvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotbetweenvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsmissingcContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode ISMISSING() { return getToken(SQLGrammerParser.ISMISSING, 0); }
		public IsmissingcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterIsmissingc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitIsmissingc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitIsmissingc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndconditionContext extends ConditioncContext {
		public List<ConditioncContext> conditionc() {
			return getRuleContexts(ConditioncContext.class);
		}
		public ConditioncContext conditionc(int i) {
			return getRuleContext(ConditioncContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLGrammerParser.AND, 0); }
		public AndconditionContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterAndcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitAndcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitAndcondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterequalconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode GREATEREQUAL() { return getToken(SQLGrammerParser.GREATEREQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public GreaterequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterGreaterequalconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitGreaterequalconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitGreaterequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotmatchconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTMATCH() { return getToken(SQLGrammerParser.NOTMATCH, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public NotmatchconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotmatchconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotmatchconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotmatchconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLGrammerParser.EQUAL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public EqualvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterEqualvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitEqualvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitEqualvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(SQLGrammerParser.GREATER, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public GreaterconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterGreaterconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitGreaterconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitGreaterconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(SQLGrammerParser.BETWEEN, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLGrammerParser.AND, 0); }
		public BetweenvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterBetweenvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitBetweenvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitBetweenvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BetweenconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode BETWEEN() { return getToken(SQLGrammerParser.BETWEEN, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLGrammerParser.AND, 0); }
		public BetweenconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterBetweenconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitBetweenconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitBetweenconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnotnullcContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode ISNOTNULL() { return getToken(SQLGrammerParser.ISNOTNULL, 0); }
		public IsnotnullcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterIsnotnullc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitIsnotnullc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitIsnotnullc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InconstantlistContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode IN() { return getToken(SQLGrammerParser.IN, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public InconstantlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterInconstantlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitInconstantlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitInconstantlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotbetweenconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTBETWEEN() { return getToken(SQLGrammerParser.NOTBETWEEN, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode AND() { return getToken(SQLGrammerParser.AND, 0); }
		public NotbetweenconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotbetweenconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotbetweenconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotbetweenconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnotmissingcContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode ISNOTMISSING() { return getToken(SQLGrammerParser.ISNOTMISSING, 0); }
		public IsnotmissingcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterIsnotmissingc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitIsnotmissingc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitIsnotmissingc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotinconstantlistContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTIN() { return getToken(SQLGrammerParser.NOTIN, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public NotinconstantlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotinconstantlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotinconstantlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotinconstantlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrconditionContext extends ConditioncContext {
		public List<ConditioncContext> conditionc() {
			return getRuleContexts(ConditioncContext.class);
		}
		public ConditioncContext conditionc(int i) {
			return getRuleContext(ConditioncContext.class,i);
		}
		public TerminalNode OR() { return getToken(SQLGrammerParser.OR, 0); }
		public OrconditionContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterOrcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitOrcondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitOrcondition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsnullcContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode ISNULL() { return getToken(SQLGrammerParser.ISNULL, 0); }
		public IsnullcContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterIsnullc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitIsnullc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitIsnullc(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(SQLGrammerParser.EQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public EqualconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterEqualconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitEqualconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitEqualconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterequalvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode GREATEREQUAL() { return getToken(SQLGrammerParser.GREATEREQUAL, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public GreaterequalvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterGreaterequalvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitGreaterequalvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitGreaterequalvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode LESS() { return getToken(SQLGrammerParser.LESS, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public LessvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterLessvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitLessvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitLessvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotequalconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(SQLGrammerParser.NOTEQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public NotequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotequalconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotequalconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchvarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode MATCH() { return getToken(SQLGrammerParser.MATCH, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public MatchvarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterMatchvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitMatchvar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitMatchvar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InvarlistContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode IN() { return getToken(SQLGrammerParser.IN, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public InvarlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterInvarlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitInvarlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitInvarlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode LESS() { return getToken(SQLGrammerParser.LESS, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public LessconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterLessconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitLessconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitLessconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionwrapperContext extends ConditioncContext {
		public TerminalNode LB() { return getToken(SQLGrammerParser.LB, 0); }
		public ConditioncContext conditionc() {
			return getRuleContext(ConditioncContext.class,0);
		}
		public TerminalNode RB() { return getToken(SQLGrammerParser.RB, 0); }
		public ConditionwrapperContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConditionwrapper(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConditionwrapper(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConditionwrapper(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotinvarlistContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode NOTIN() { return getToken(SQLGrammerParser.NOTIN, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NotinvarlistContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterNotinvarlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitNotinvarlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitNotinvarlist(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessequalconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode LESSEQUAL() { return getToken(SQLGrammerParser.LESSEQUAL, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public LessequalconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterLessequalconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitLessequalconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitLessequalconstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreatervarContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode GREATER() { return getToken(SQLGrammerParser.GREATER, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public GreatervarContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterGreatervar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitGreatervar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitGreatervar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MatchconstantContext extends ConditioncContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public TerminalNode MATCH() { return getToken(SQLGrammerParser.MATCH, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public MatchconstantContext(ConditioncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterMatchconstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitMatchconstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitMatchconstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditioncContext conditionc() throws RecognitionException {
		return conditionc(0);
	}

	private ConditioncContext conditionc(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditioncContext _localctx = new ConditioncContext(_ctx, _parentState);
		ConditioncContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_conditionc, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionwrapperContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(108);
				match(LB);
				setState(109);
				conditionc(0);
				setState(110);
				match(RB);
				}
				break;
			case 2:
				{
				_localctx = new EqualconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112);
				column_name();
				setState(113);
				match(EQUAL);
				setState(114);
				constant();
				}
				break;
			case 3:
				{
				_localctx = new EqualvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				column_name();
				setState(117);
				match(EQUAL);
				setState(118);
				var();
				}
				break;
			case 4:
				{
				_localctx = new LessconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				column_name();
				setState(121);
				match(LESS);
				setState(122);
				constant();
				}
				break;
			case 5:
				{
				_localctx = new LessvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				column_name();
				setState(125);
				match(LESS);
				setState(126);
				var();
				}
				break;
			case 6:
				{
				_localctx = new GreaterconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				column_name();
				setState(129);
				match(GREATER);
				setState(130);
				constant();
				}
				break;
			case 7:
				{
				_localctx = new GreatervarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				column_name();
				setState(133);
				match(GREATER);
				setState(134);
				var();
				}
				break;
			case 8:
				{
				_localctx = new LessequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				column_name();
				setState(137);
				match(LESSEQUAL);
				setState(138);
				constant();
				}
				break;
			case 9:
				{
				_localctx = new LessequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140);
				column_name();
				setState(141);
				match(LESSEQUAL);
				setState(142);
				var();
				}
				break;
			case 10:
				{
				_localctx = new GreaterequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				column_name();
				setState(145);
				match(GREATEREQUAL);
				setState(146);
				constant();
				}
				break;
			case 11:
				{
				_localctx = new GreaterequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				column_name();
				setState(149);
				match(GREATEREQUAL);
				setState(150);
				var();
				}
				break;
			case 12:
				{
				_localctx = new NotequalconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152);
				column_name();
				setState(153);
				match(NOTEQUAL);
				setState(154);
				constant();
				}
				break;
			case 13:
				{
				_localctx = new NotequalvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				column_name();
				setState(157);
				match(NOTEQUAL);
				setState(158);
				var();
				}
				break;
			case 14:
				{
				_localctx = new NotmatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				column_name();
				setState(161);
				match(NOTMATCH);
				setState(162);
				constant();
				}
				break;
			case 15:
				{
				_localctx = new NotmatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				column_name();
				setState(165);
				match(NOTMATCH);
				setState(166);
				var();
				}
				break;
			case 16:
				{
				_localctx = new MatchconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				column_name();
				setState(169);
				match(MATCH);
				setState(170);
				constant();
				}
				break;
			case 17:
				{
				_localctx = new MatchvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				column_name();
				setState(173);
				match(MATCH);
				setState(174);
				var();
				}
				break;
			case 18:
				{
				_localctx = new InconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				column_name();
				setState(177);
				match(IN);
				setState(178);
				constantList();
				}
				break;
			case 19:
				{
				_localctx = new InvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				column_name();
				setState(181);
				match(IN);
				setState(182);
				var();
				}
				break;
			case 20:
				{
				_localctx = new NotinconstantlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				column_name();
				setState(185);
				match(NOTIN);
				setState(186);
				constantList();
				}
				break;
			case 21:
				{
				_localctx = new NotinvarlistContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				column_name();
				setState(189);
				match(NOTIN);
				setState(190);
				var();
				}
				break;
			case 22:
				{
				_localctx = new BetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				column_name();
				setState(193);
				match(BETWEEN);
				setState(194);
				constant();
				setState(195);
				match(AND);
				setState(196);
				constant();
				}
				break;
			case 23:
				{
				_localctx = new BetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				column_name();
				setState(199);
				match(BETWEEN);
				setState(200);
				var();
				setState(201);
				match(AND);
				setState(202);
				var();
				}
				break;
			case 24:
				{
				_localctx = new NotbetweenconstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				column_name();
				setState(205);
				match(NOTBETWEEN);
				setState(206);
				constant();
				setState(207);
				match(AND);
				setState(208);
				constant();
				}
				break;
			case 25:
				{
				_localctx = new NotbetweenvarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				column_name();
				setState(211);
				match(NOTBETWEEN);
				setState(212);
				var();
				setState(213);
				match(AND);
				setState(214);
				var();
				}
				break;
			case 26:
				{
				_localctx = new IsnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				column_name();
				setState(217);
				match(ISNULL);
				}
				break;
			case 27:
				{
				_localctx = new IsnotnullcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(219);
				column_name();
				setState(220);
				match(ISNOTNULL);
				}
				break;
			case 28:
				{
				_localctx = new IsmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				column_name();
				setState(223);
				match(ISMISSING);
				}
				break;
			case 29:
				{
				_localctx = new IsnotmissingcContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				column_name();
				setState(226);
				match(ISNOTMISSING);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(236);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new AndconditionContext(new ConditioncContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(230);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(231);
						match(AND);
						setState(232);
						conditionc(31);
						}
						break;
					case 2:
						{
						_localctx = new OrconditionContext(new ConditioncContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionc);
						setState(233);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(234);
						match(OR);
						setState(235);
						conditionc(30);
						}
						break;
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SpecrowkeyContext extends ParserRuleContext {
		public TerminalNode ROWKEY() { return getToken(SQLGrammerParser.ROWKEY, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public SpecrowkeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specrowkey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterSpecrowkey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitSpecrowkey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitSpecrowkey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecrowkeyContext specrowkey() throws RecognitionException {
		SpecrowkeyContext _localctx = new SpecrowkeyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_specrowkey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(ROWKEY);
			setState(242);
			match(IS);
			setState(243);
			rowkeyexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowkeyrangeContext extends ParserRuleContext {
		public RowkeyrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowkeyrange; }
	 
		public RowkeyrangeContext() { }
		public void copyFrom(RowkeyrangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowkeyrangeEndContext extends RowkeyrangeContext {
		public TerminalNode ENDKEY() { return getToken(SQLGrammerParser.ENDKEY, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public RowkeyrangeEndContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyrangeEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyrangeEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyrangeEnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowkeyrangeSEContext extends RowkeyrangeContext {
		public TerminalNode STARTKEY() { return getToken(SQLGrammerParser.STARTKEY, 0); }
		public List<TerminalNode> IS() { return getTokens(SQLGrammerParser.IS); }
		public TerminalNode IS(int i) {
			return getToken(SQLGrammerParser.IS, i);
		}
		public List<RowkeyexpContext> rowkeyexp() {
			return getRuleContexts(RowkeyexpContext.class);
		}
		public RowkeyexpContext rowkeyexp(int i) {
			return getRuleContext(RowkeyexpContext.class,i);
		}
		public TerminalNode ENDKEY() { return getToken(SQLGrammerParser.ENDKEY, 0); }
		public RowkeyrangeSEContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyrangeSE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyrangeSE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyrangeSE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowkeyrangeStartContext extends RowkeyrangeContext {
		public TerminalNode STARTKEY() { return getToken(SQLGrammerParser.STARTKEY, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public RowkeyexpContext rowkeyexp() {
			return getRuleContext(RowkeyexpContext.class,0);
		}
		public RowkeyrangeStartContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyrangeStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyrangeStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyrangeStart(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowkeyrangeSpecContext extends RowkeyrangeContext {
		public TerminalNode ROWKEY() { return getToken(SQLGrammerParser.ROWKEY, 0); }
		public TerminalNode IN() { return getToken(SQLGrammerParser.IN, 0); }
		public TerminalNode LB() { return getToken(SQLGrammerParser.LB, 0); }
		public List<RowkeyexpContext> rowkeyexp() {
			return getRuleContexts(RowkeyexpContext.class);
		}
		public RowkeyexpContext rowkeyexp(int i) {
			return getRuleContext(RowkeyexpContext.class,i);
		}
		public TerminalNode RB() { return getToken(SQLGrammerParser.RB, 0); }
		public RowkeyrangeSpecContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyrangeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyrangeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyrangeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowkeyrangeOneContext extends RowkeyrangeContext {
		public SpecrowkeyContext specrowkey() {
			return getRuleContext(SpecrowkeyContext.class,0);
		}
		public RowkeyrangeOneContext(RowkeyrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyrangeOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyrangeOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyrangeOne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyrangeContext rowkeyrange() throws RecognitionException {
		RowkeyrangeContext _localctx = new RowkeyrangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rowkeyrange);
		int _la;
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new RowkeyrangeSEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(STARTKEY);
				setState(246);
				match(IS);
				setState(247);
				rowkeyexp();
				setState(248);
				match(T__0);
				setState(249);
				match(ENDKEY);
				setState(250);
				match(IS);
				setState(251);
				rowkeyexp();
				}
				break;
			case 2:
				_localctx = new RowkeyrangeStartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(STARTKEY);
				setState(254);
				match(IS);
				setState(255);
				rowkeyexp();
				}
				break;
			case 3:
				_localctx = new RowkeyrangeEndContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(ENDKEY);
				setState(257);
				match(IS);
				setState(258);
				rowkeyexp();
				}
				break;
			case 4:
				_localctx = new RowkeyrangeOneContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				specrowkey();
				}
				break;
			case 5:
				_localctx = new RowkeyrangeSpecContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				match(ROWKEY);
				setState(261);
				match(IN);
				setState(262);
				match(LB);
				setState(263);
				rowkeyexp();
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(264);
					match(T__0);
					setState(265);
					rowkeyexp();
					}
					}
					setState(270);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(271);
				match(RB);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowkeyexpContext extends ParserRuleContext {
		public TerminalNode Data_Value() { return getToken(SQLGrammerParser.Data_Value, 0); }
		public RowkeyexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowkeyexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterRowkeyexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitRowkeyexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitRowkeyexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowkeyexpContext rowkeyexp() throws RecognitionException {
		RowkeyexpContext _localctx = new RowkeyexpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rowkeyexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(Data_Value);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TsrangeContext extends ParserRuleContext {
		public TsrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsrange; }
	 
		public TsrangeContext() { }
		public void copyFrom(TsrangeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Tsrange_startContext extends TsrangeContext {
		public TerminalNode STARTTS() { return getToken(SQLGrammerParser.STARTTS, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public Tsrange_startContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterTsrange_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitTsrange_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitTsrange_start(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tsrange_endContext extends TsrangeContext {
		public TerminalNode ENDTS() { return getToken(SQLGrammerParser.ENDTS, 0); }
		public TerminalNode IS() { return getToken(SQLGrammerParser.IS, 0); }
		public TsexpContext tsexp() {
			return getRuleContext(TsexpContext.class,0);
		}
		public Tsrange_endContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterTsrange_end(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitTsrange_end(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitTsrange_end(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Tsrange_startAndEndContext extends TsrangeContext {
		public TerminalNode STARTTS() { return getToken(SQLGrammerParser.STARTTS, 0); }
		public List<TerminalNode> IS() { return getTokens(SQLGrammerParser.IS); }
		public TerminalNode IS(int i) {
			return getToken(SQLGrammerParser.IS, i);
		}
		public List<TsexpContext> tsexp() {
			return getRuleContexts(TsexpContext.class);
		}
		public TsexpContext tsexp(int i) {
			return getRuleContext(TsexpContext.class,i);
		}
		public TerminalNode ENDTS() { return getToken(SQLGrammerParser.ENDTS, 0); }
		public Tsrange_startAndEndContext(TsrangeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterTsrange_startAndEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitTsrange_startAndEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitTsrange_startAndEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsrangeContext tsrange() throws RecognitionException {
		TsrangeContext _localctx = new TsrangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tsrange);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Tsrange_startAndEndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(STARTTS);
				setState(278);
				match(IS);
				setState(279);
				tsexp();
				setState(280);
				match(T__0);
				setState(281);
				match(ENDTS);
				setState(282);
				match(IS);
				setState(283);
				tsexp();
				}
				break;
			case 2:
				_localctx = new Tsrange_startContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(STARTTS);
				setState(286);
				match(IS);
				setState(287);
				tsexp();
				}
				break;
			case 3:
				_localctx = new Tsrange_endContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				match(ENDTS);
				setState(289);
				match(IS);
				setState(290);
				tsexp();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TsexpContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TsexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tsexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterTsexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitTsexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitTsexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TsexpContext tsexp() throws RecognitionException {
		TsexpContext _localctx = new TsexpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tsexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnListContext extends ParserRuleContext {
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
	 
		public ColumnListContext() { }
		public void copyFrom(ColumnListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColumnListOneContext extends ColumnListContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public ColumnListOneContext(ColumnListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterColumnListOne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitColumnListOne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitColumnListOne(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnListExtContext extends ColumnListContext {
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public ColumnListExtContext(ColumnListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterColumnListExt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitColumnListExt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitColumnListExt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnListAllContext extends ColumnListContext {
		public TerminalNode STAR() { return getToken(SQLGrammerParser.STAR, 0); }
		public ColumnListAllContext(ColumnListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterColumnListAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitColumnListAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitColumnListAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_columnList);
		int _la;
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new ColumnListExtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				column_name();
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(296);
					match(T__0);
					setState(297);
					column_name();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new ColumnListAllContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(STAR);
				}
				break;
			case 3:
				_localctx = new ColumnListOneContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				column_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitFuncname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			column_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantListContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(SQLGrammerParser.LB, 0); }
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public TerminalNode RB() { return getToken(SQLGrammerParser.RB, 0); }
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(LB);
			setState(310);
			constant();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(311);
				match(T__0);
				setState(312);
				constant();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant2ListContext extends ParserRuleContext {
		public TerminalNode LB() { return getToken(SQLGrammerParser.LB, 0); }
		public List<Constant2Context> constant2() {
			return getRuleContexts(Constant2Context.class);
		}
		public Constant2Context constant2(int i) {
			return getRuleContext(Constant2Context.class,i);
		}
		public TerminalNode RB() { return getToken(SQLGrammerParser.RB, 0); }
		public Constant2ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant2List; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConstant2List(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConstant2List(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConstant2List(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant2ListContext constant2List() throws RecognitionException {
		Constant2ListContext _localctx = new Constant2ListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant2List);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(LB);
			setState(321);
			constant2();
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(322);
				match(T__0);
				setState(323);
				constant2();
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
			match(RB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constant2Context extends ParserRuleContext {
		public Constant2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant2; }
	 
		public Constant2Context() { }
		public void copyFrom(Constant2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Constant2_NotNullContext extends Constant2Context {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Constant2_NotNullContext(Constant2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConstant2_NotNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConstant2_NotNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConstant2_NotNull(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Constant2_NullContext extends Constant2Context {
		public TerminalNode NULL() { return getToken(SQLGrammerParser.NULL, 0); }
		public Constant2_NullContext(Constant2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConstant2_Null(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConstant2_Null(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConstant2_Null(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant2Context constant2() throws RecognitionException {
		Constant2Context _localctx = new Constant2Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_constant2);
		try {
			setState(333);
			switch (_input.LA(1)) {
			case Double_Quote:
				_localctx = new Constant2_NotNullContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				constant();
				}
				break;
			case NULL:
				_localctx = new Constant2_NullContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaxversionexpContext extends ParserRuleContext {
		public TerminalNode MAXVERSION() { return getToken(SQLGrammerParser.MAXVERSION, 0); }
		public MaxversionContext maxversion() {
			return getRuleContext(MaxversionContext.class,0);
		}
		public MaxversionexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxversionexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterMaxversionexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitMaxversionexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitMaxversionexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxversionexpContext maxversionexp() throws RecognitionException {
		MaxversionexpContext _localctx = new MaxversionexpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_maxversionexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(MAXVERSION);
			setState(336);
			maxversion();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LimitexpContext extends ParserRuleContext {
		public TerminalNode LIMIT() { return getToken(SQLGrammerParser.LIMIT, 0); }
		public TerminalNode POSITIVE() { return getToken(SQLGrammerParser.POSITIVE, 0); }
		public LimitexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limitexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterLimitexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitLimitexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitLimitexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LimitexpContext limitexp() throws RecognitionException {
		LimitexpContext _localctx = new LimitexpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_limitexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(LIMIT);
			setState(339);
			match(POSITIVE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MaxversionContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public MaxversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterMaxversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitMaxversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitMaxversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MaxversionContext maxversion() throws RecognitionException {
		MaxversionContext _localctx = new MaxversionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_maxversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			column_name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(Double_Quote);
			setState(344);
			column_name();
			setState(345);
			match(Double_Quote);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(T__1);
			setState(348);
			column_name();
			setState(349);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_nameContext extends ParserRuleContext {
		public TerminalNode Regular_Identifier() { return getToken(SQLGrammerParser.Regular_Identifier, 0); }
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitTable_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitTable_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(Regular_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Column_nameContext extends ParserRuleContext {
		public TerminalNode Regular_Identifier() { return getToken(SQLGrammerParser.Regular_Identifier, 0); }
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitColumn_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitColumn_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(Regular_Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValuesContext extends ParserRuleContext {
		public TerminalNode Data_Value() { return getToken(SQLGrammerParser.Data_Value, 0); }
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLGrammerListener ) ((SQLGrammerListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SQLGrammerVisitor ) return ((SQLGrammerVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_values);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(Data_Value);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return conditionc_sempred((ConditioncContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean conditionc_sempred(ConditioncContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 30);
		case 1:
			return precpred(_ctx, 29);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\64\u0168\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\5\28\n\2\3\3\3\3\3\3\3\3\3\3\5\3?\n\3\3\3\3\3\5"+
		"\3C\n\3\3\3\5\3F\n\3\3\3\5\3I\n\3\3\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4\3\4"+
		"\3\4\3\4\5\4V\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6f\n\6\f\6\16\6i\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00e7\n\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\7\b\u00ef\n\b\f\b\16\b\u00f2\13\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u010d\n\n\f\n\16\n\u0110\13\n\3\n\3\n\5\n\u0114\n\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0126\n\f\3\r\3\r"+
		"\3\16\3\16\3\16\7\16\u012d\n\16\f\16\16\16\u0130\13\16\3\16\3\16\5\16"+
		"\u0134\n\16\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u013c\n\20\f\20\16\20\u013f"+
		"\13\20\3\20\3\20\3\21\3\21\3\21\3\21\7\21\u0147\n\21\f\21\16\21\u014a"+
		"\13\21\3\21\3\21\3\22\3\22\5\22\u0150\n\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\32\2\3\16\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\2\2\u0182\2\67\3\2\2\2\49\3\2\2\2\6J\3\2\2\2\bW\3\2\2\2\n"+
		"]\3\2\2\2\fj\3\2\2\2\16\u00e6\3\2\2\2\20\u00f3\3\2\2\2\22\u0113\3\2\2"+
		"\2\24\u0115\3\2\2\2\26\u0125\3\2\2\2\30\u0127\3\2\2\2\32\u0133\3\2\2\2"+
		"\34\u0135\3\2\2\2\36\u0137\3\2\2\2 \u0142\3\2\2\2\"\u014f\3\2\2\2$\u0151"+
		"\3\2\2\2&\u0154\3\2\2\2(\u0157\3\2\2\2*\u0159\3\2\2\2,\u015d\3\2\2\2."+
		"\u0161\3\2\2\2\60\u0163\3\2\2\2\62\u0165\3\2\2\2\648\5\4\3\2\658\5\6\4"+
		"\2\668\5\b\5\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\28\3\3\2\2\29:"+
		"\7\5\2\2:;\5\32\16\2;<\7\b\2\2<>\5.\30\2=?\5\f\7\2>=\3\2\2\2>?\3\2\2\2"+
		"?@\3\2\2\2@B\5\22\n\2AC\5$\23\2BA\3\2\2\2BC\3\2\2\2CE\3\2\2\2DF\5\26\f"+
		"\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2GI\5&\24\2HG\3\2\2\2HI\3\2\2\2I\5\3\2"+
		"\2\2JK\7\7\2\2KL\5\32\16\2LM\7\b\2\2MO\5.\30\2NP\5\f\7\2ON\3\2\2\2OP\3"+
		"\2\2\2PQ\3\2\2\2QU\5\22\n\2RS\7\23\2\2ST\7\26\2\2TV\5\30\r\2UR\3\2\2\2"+
		"UV\3\2\2\2V\7\3\2\2\2WX\7\6\2\2XY\5.\30\2YZ\7\r\2\2Z[\5\n\6\2[\\\5\20"+
		"\t\2\\\t\3\2\2\2]^\5\60\31\2^_\7\33\2\2_g\5\62\32\2`a\7\3\2\2ab\5\60\31"+
		"\2bc\7\33\2\2cd\5\62\32\2df\3\2\2\2e`\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3"+
		"\2\2\2h\13\3\2\2\2ig\3\2\2\2jk\7\t\2\2kl\5\16\b\2l\r\3\2\2\2mn\b\b\1\2"+
		"no\7\13\2\2op\5\16\b\2pq\7\f\2\2q\u00e7\3\2\2\2rs\5\60\31\2st\7!\2\2t"+
		"u\5*\26\2u\u00e7\3\2\2\2vw\5\60\31\2wx\7!\2\2xy\5,\27\2y\u00e7\3\2\2\2"+
		"z{\5\60\31\2{|\7\35\2\2|}\5*\26\2}\u00e7\3\2\2\2~\177\5\60\31\2\177\u0080"+
		"\7\35\2\2\u0080\u0081\5,\27\2\u0081\u00e7\3\2\2\2\u0082\u0083\5\60\31"+
		"\2\u0083\u0084\7\37\2\2\u0084\u0085\5*\26\2\u0085\u00e7\3\2\2\2\u0086"+
		"\u0087\5\60\31\2\u0087\u0088\7\37\2\2\u0088\u0089\5,\27\2\u0089\u00e7"+
		"\3\2\2\2\u008a\u008b\5\60\31\2\u008b\u008c\7\34\2\2\u008c\u008d\5*\26"+
		"\2\u008d\u00e7\3\2\2\2\u008e\u008f\5\60\31\2\u008f\u0090\7\34\2\2\u0090"+
		"\u0091\5,\27\2\u0091\u00e7\3\2\2\2\u0092\u0093\5\60\31\2\u0093\u0094\7"+
		"\36\2\2\u0094\u0095\5*\26\2\u0095\u00e7\3\2\2\2\u0096\u0097\5\60\31\2"+
		"\u0097\u0098\7\36\2\2\u0098\u0099\5,\27\2\u0099\u00e7\3\2\2\2\u009a\u009b"+
		"\5\60\31\2\u009b\u009c\7 \2\2\u009c\u009d\5*\26\2\u009d\u00e7\3\2\2\2"+
		"\u009e\u009f\5\60\31\2\u009f\u00a0\7 \2\2\u00a0\u00a1\5,\27\2\u00a1\u00e7"+
		"\3\2\2\2\u00a2\u00a3\5\60\31\2\u00a3\u00a4\7\"\2\2\u00a4\u00a5\5*\26\2"+
		"\u00a5\u00e7\3\2\2\2\u00a6\u00a7\5\60\31\2\u00a7\u00a8\7\"\2\2\u00a8\u00a9"+
		"\5,\27\2\u00a9\u00e7\3\2\2\2\u00aa\u00ab\5\60\31\2\u00ab\u00ac\7#\2\2"+
		"\u00ac\u00ad\5*\26\2\u00ad\u00e7\3\2\2\2\u00ae\u00af\5\60\31\2\u00af\u00b0"+
		"\7#\2\2\u00b0\u00b1\5,\27\2\u00b1\u00e7\3\2\2\2\u00b2\u00b3\5\60\31\2"+
		"\u00b3\u00b4\7$\2\2\u00b4\u00b5\5\36\20\2\u00b5\u00e7\3\2\2\2\u00b6\u00b7"+
		"\5\60\31\2\u00b7\u00b8\7$\2\2\u00b8\u00b9\5,\27\2\u00b9\u00e7\3\2\2\2"+
		"\u00ba\u00bb\5\60\31\2\u00bb\u00bc\7%\2\2\u00bc\u00bd\5\36\20\2\u00bd"+
		"\u00e7\3\2\2\2\u00be\u00bf\5\60\31\2\u00bf\u00c0\7%\2\2\u00c0\u00c1\5"+
		",\27\2\u00c1\u00e7\3\2\2\2\u00c2\u00c3\5\60\31\2\u00c3\u00c4\7&\2\2\u00c4"+
		"\u00c5\5*\26\2\u00c5\u00c6\7\31\2\2\u00c6\u00c7\5*\26\2\u00c7\u00e7\3"+
		"\2\2\2\u00c8\u00c9\5\60\31\2\u00c9\u00ca\7&\2\2\u00ca\u00cb\5,\27\2\u00cb"+
		"\u00cc\7\31\2\2\u00cc\u00cd\5,\27\2\u00cd\u00e7\3\2\2\2\u00ce\u00cf\5"+
		"\60\31\2\u00cf\u00d0\7\'\2\2\u00d0\u00d1\5*\26\2\u00d1\u00d2\7\31\2\2"+
		"\u00d2\u00d3\5*\26\2\u00d3\u00e7\3\2\2\2\u00d4\u00d5\5\60\31\2\u00d5\u00d6"+
		"\7\'\2\2\u00d6\u00d7\5,\27\2\u00d7\u00d8\7\31\2\2\u00d8\u00d9\5,\27\2"+
		"\u00d9\u00e7\3\2\2\2\u00da\u00db\5\60\31\2\u00db\u00dc\7(\2\2\u00dc\u00e7"+
		"\3\2\2\2\u00dd\u00de\5\60\31\2\u00de\u00df\7)\2\2\u00df\u00e7\3\2\2\2"+
		"\u00e0\u00e1\5\60\31\2\u00e1\u00e2\7*\2\2\u00e2\u00e7\3\2\2\2\u00e3\u00e4"+
		"\5\60\31\2\u00e4\u00e5\7+\2\2\u00e5\u00e7\3\2\2\2\u00e6m\3\2\2\2\u00e6"+
		"r\3\2\2\2\u00e6v\3\2\2\2\u00e6z\3\2\2\2\u00e6~\3\2\2\2\u00e6\u0082\3\2"+
		"\2\2\u00e6\u0086\3\2\2\2\u00e6\u008a\3\2\2\2\u00e6\u008e\3\2\2\2\u00e6"+
		"\u0092\3\2\2\2\u00e6\u0096\3\2\2\2\u00e6\u009a\3\2\2\2\u00e6\u009e\3\2"+
		"\2\2\u00e6\u00a2\3\2\2\2\u00e6\u00a6\3\2\2\2\u00e6\u00aa\3\2\2\2\u00e6"+
		"\u00ae\3\2\2\2\u00e6\u00b2\3\2\2\2\u00e6\u00b6\3\2\2\2\u00e6\u00ba\3\2"+
		"\2\2\u00e6\u00be\3\2\2\2\u00e6\u00c2\3\2\2\2\u00e6\u00c8\3\2\2\2\u00e6"+
		"\u00ce\3\2\2\2\u00e6\u00d4\3\2\2\2\u00e6\u00da\3\2\2\2\u00e6\u00dd\3\2"+
		"\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e7\u00f0\3\2\2\2\u00e8"+
		"\u00e9\f \2\2\u00e9\u00ea\7\31\2\2\u00ea\u00ef\5\16\b!\u00eb\u00ec\f\37"+
		"\2\2\u00ec\u00ed\7\32\2\2\u00ed\u00ef\5\16\b \u00ee\u00e8\3\2\2\2\u00ee"+
		"\u00eb\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\17\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7\16\2\2\u00f4\u00f5"+
		"\7\26\2\2\u00f5\u00f6\5\24\13\2\u00f6\21\3\2\2\2\u00f7\u00f8\7\17\2\2"+
		"\u00f8\u00f9\7\26\2\2\u00f9\u00fa\5\24\13\2\u00fa\u00fb\7\3\2\2\u00fb"+
		"\u00fc\7\20\2\2\u00fc\u00fd\7\26\2\2\u00fd\u00fe\5\24\13\2\u00fe\u0114"+
		"\3\2\2\2\u00ff\u0100\7\17\2\2\u0100\u0101\7\26\2\2\u0101\u0114\5\24\13"+
		"\2\u0102\u0103\7\20\2\2\u0103\u0104\7\26\2\2\u0104\u0114\5\24\13\2\u0105"+
		"\u0114\5\20\t\2\u0106\u0107\7\16\2\2\u0107\u0108\7$\2\2\u0108\u0109\7"+
		"\13\2\2\u0109\u010e\5\24\13\2\u010a\u010b\7\3\2\2\u010b\u010d\5\24\13"+
		"\2\u010c\u010a\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7\f\2\2\u0112"+
		"\u0114\3\2\2\2\u0113\u00f7\3\2\2\2\u0113\u00ff\3\2\2\2\u0113\u0102\3\2"+
		"\2\2\u0113\u0105\3\2\2\2\u0113\u0106\3\2\2\2\u0114\23\3\2\2\2\u0115\u0116"+
		"\7\63\2\2\u0116\25\3\2\2\2\u0117\u0118\7\24\2\2\u0118\u0119\7\26\2\2\u0119"+
		"\u011a\5\30\r\2\u011a\u011b\7\3\2\2\u011b\u011c\7\25\2\2\u011c\u011d\7"+
		"\26\2\2\u011d\u011e\5\30\r\2\u011e\u0126\3\2\2\2\u011f\u0120\7\24\2\2"+
		"\u0120\u0121\7\26\2\2\u0121\u0126\5\30\r\2\u0122\u0123\7\25\2\2\u0123"+
		"\u0124\7\26\2\2\u0124\u0126\5\30\r\2\u0125\u0117\3\2\2\2\u0125\u011f\3"+
		"\2\2\2\u0125\u0122\3\2\2\2\u0126\27\3\2\2\2\u0127\u0128\5*\26\2\u0128"+
		"\31\3\2\2\2\u0129\u012e\5\60\31\2\u012a\u012b\7\3\2\2\u012b\u012d\5\60"+
		"\31\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0134\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0134\7\n"+
		"\2\2\u0132\u0134\5\60\31\2\u0133\u0129\3\2\2\2\u0133\u0131\3\2\2\2\u0133"+
		"\u0132\3\2\2\2\u0134\33\3\2\2\2\u0135\u0136\5\60\31\2\u0136\35\3\2\2\2"+
		"\u0137\u0138\7\13\2\2\u0138\u013d\5*\26\2\u0139\u013a\7\3\2\2\u013a\u013c"+
		"\5*\26\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7\f"+
		"\2\2\u0141\37\3\2\2\2\u0142\u0143\7\13\2\2\u0143\u0148\5\"\22\2\u0144"+
		"\u0145\7\3\2\2\u0145\u0147\5\"\22\2\u0146\u0144\3\2\2\2\u0147\u014a\3"+
		"\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u014c\7\f\2\2\u014c!\3\2\2\2\u014d\u0150\5*\26\2"+
		"\u014e\u0150\7\27\2\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2\2\2\u0150#\3"+
		"\2\2\2\u0151\u0152\7\21\2\2\u0152\u0153\5(\25\2\u0153%\3\2\2\2\u0154\u0155"+
		"\7\22\2\2\u0155\u0156\7\60\2\2\u0156\'\3\2\2\2\u0157\u0158\5\60\31\2\u0158"+
		")\3\2\2\2\u0159\u015a\7,\2\2\u015a\u015b\5\60\31\2\u015b\u015c\7,\2\2"+
		"\u015c+\3\2\2\2\u015d\u015e\7\4\2\2\u015e\u015f\5\60\31\2\u015f\u0160"+
		"\7\4\2\2\u0160-\3\2\2\2\u0161\u0162\7\62\2\2\u0162/\3\2\2\2\u0163\u0164"+
		"\7\62\2\2\u0164\61\3\2\2\2\u0165\u0166\7\63\2\2\u0166\63\3\2\2\2\25\67"+
		">BEHOUg\u00e6\u00ee\u00f0\u010e\u0113\u0125\u012e\u0133\u013d\u0148\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
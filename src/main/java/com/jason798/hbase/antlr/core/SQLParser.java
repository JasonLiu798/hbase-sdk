package com.jason798.hbase.antlr.core;

import com.jason798.hbase.antlr.SQLGrammerLexer;
import com.jason798.hbase.antlr.SQLGrammerParser;
import com.jason798.hbase.antlr.model.ColumnListDto;
import com.jason798.hbase.antlr.model.RowKeyRange;
import com.jason798.hbase.antlr.model.SQLType;
import com.jason798.hbase.antlr.model.SelectDto;
import com.jason798.hbase.antlr.visitor.ColumnListVisitor;
import com.jason798.hbase.antlr.visitor.RowKeyRangeVisitor;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.util.CheckUtil;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.StringReader;

/**
 * SQLParser
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class SQLParser {

    /**
     * get context
     *
     * @param sql
     * @return
     */
    public static SQLGrammerParser.ProgContext getProgContext(String sql) {
        CheckUtil.checkNull(sql);
        try {
            ANTLRInputStream input = new ANTLRInputStream(new StringReader(sql));
            SQLGrammerLexer lexer = new SQLGrammerLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SQLGrammerParser parser = new SQLGrammerParser(tokens);

            parser.setErrorHandler(SqlParseErrorHandler.instance);
            SQLGrammerParser.ProgContext progContext = parser.prog();
            return progContext;
        } catch (Exception e) {
            throw new HBaseException("parse sql error.", e);
        }
    }

    /**
     * judge ctx type
     *
     * @param ctx
     * @return
     */
    public static SQLType judgeType(SQLGrammerParser.ProgContext ctx) {
        if (ctx instanceof SQLGrammerParser.SelectSqlStmtContext) {
            return SQLType.SELECT;
        } else if (ctx instanceof SQLGrammerParser.DeleteSqlStmtContext) {
            return SQLType.DELETE;
        } else if (ctx instanceof SQLGrammerParser.UpdateSqlStmtContext) {
            return SQLType.PUT;
        } else {
            throw new HBaseException("unknown sql type");
        }
    }

    /**
     * parse select
     * @param ctx
     * @return
     */
    public static SelectDto parseSelect(SQLGrammerParser.ProgContext ctx) {
        CheckUtil.checkNull(ctx);
        SelectDto dto = new SelectDto();
        SQLGrammerParser.SelectSqlContext selectCtx = getSelectCtx(ctx);
        CheckUtil.checkNull(selectCtx);

        SQLGrammerParser.ColumnListContext columnListContext = selectCtx.columnList();
        ColumnListDto columnListDto = parseColumnList(columnListContext);
        dto.setColumnList(columnListDto);

        SQLGrammerParser.Table_nameContext tableNameCtx = selectCtx.table_name();
        String tableName = tableNameCtx.getText();
        dto.setTableName(tableName);
        // optional
        selectCtx.wherec();

        SQLGrammerParser.RowkeyrangeContext rowkeyrangeContext = selectCtx.rowkeyrange();
        RowKeyRange rowKeyRange = parseRowKeyRange(rowkeyrangeContext);
        dto.setRowKeyRange(rowKeyRange);

        // optional
        selectCtx.maxversionexp();
        // optional
        selectCtx.tsrange();
        // optional
        selectCtx.limitexp();

        return dto;
    }


    /**
     * parse column list,for example:
     * select c1,c2,....cn from xxx;
     * parse c1,c2,...cn
     *
     * @param ctx
     * @return
     */
    public static ColumnListDto parseColumnList(SQLGrammerParser.ColumnListContext ctx ){
        CheckUtil.checkNull(ctx);
        ColumnListVisitor visitor = new ColumnListVisitor();
        ColumnListDto res = ctx.accept(visitor);
        return res;
    }

    /**
     * parse rowKey range
     * @param ctx
     * @return
     */
    public static RowKeyRange parseRowKeyRange(SQLGrammerParser.RowkeyrangeContext ctx){
        CheckUtil.checkNull(ctx);

        RowKeyRangeVisitor visitor = new RowKeyRangeVisitor();
        RowKeyRange rowkeyRange = ctx.accept(visitor);
        return rowkeyRange;
    }


    public static <T> T getRowKeyRangeClz(SQLGrammerParser.RowkeyrangeContext ctx,Class<T> clz) {
        if( clz.isInstance(ctx)){
            return clz.cast(ctx);
        }
        throw new HBaseException("row key range context error,unknown rowkey type");
    }






    /**
     * cast to Select sql context
     *
     * @param ctx
     * @return
     */
    public static SQLGrammerParser.SelectSqlContext getSelectCtx(SQLGrammerParser.ProgContext ctx) {
        SQLGrammerParser.SelectSqlContext res = null;
        if (ctx instanceof SQLGrammerParser.SelectSqlStmtContext) {
            res = SQLGrammerParser.SelectSqlStmtContext.class.cast(ctx).selectSql();
            return res;
        } else {
            throw new HBaseException("get select context error");
        }
    }

    /**
     * cast to Update sql context
     *
     * @param ctx
     * @return
     */
    public static SQLGrammerParser.UpdateSqlContext getUpdateCtx(SQLGrammerParser.ProgContext ctx) {
        SQLGrammerParser.UpdateSqlContext res = null;
        if (ctx instanceof SQLGrammerParser.UpdateSqlStmtContext) {
            res = SQLGrammerParser.UpdateSqlStmtContext.class.cast(ctx).updateSql();
            return res;
        } else {
            throw new HBaseException("get update context error");
        }
    }

    /**
     * cast to Delete sql context
     *
     * @param ctx
     * @return
     */
    public static SQLGrammerParser.DeleteSqlContext getDeleteCtx(SQLGrammerParser.ProgContext ctx) {
        SQLGrammerParser.DeleteSqlContext res = null;
        if (ctx instanceof SQLGrammerParser.UpdateSqlStmtContext) {
            res = SQLGrammerParser.DeleteSqlStmtContext.class.cast(ctx).deleteSql();
            return res;
        } else {
            throw new HBaseException("get deleteOne context error");
        }
    }


}

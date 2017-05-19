package com.jason798.hbase.antlr.visitor;

import com.jason798.hbase.antlr.SQLGrammerBaseVisitor;
import com.jason798.hbase.antlr.SQLGrammerParser;
import com.jason798.hbase.antlr.model.ColumnListDto;
import com.jason798.hbase.util.CheckUtil;

import java.util.List;

/**
 * RowKeyRangeVisitor
 *
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ColumnListVisitor extends SQLGrammerBaseVisitor<ColumnListDto> {

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public ColumnListDto visitColumnListExt(SQLGrammerParser.ColumnListExtContext ctx) {
        List<SQLGrammerParser.Column_nameContext> ctxlist = ctx.column_name();
        CheckUtil.checkNull(ctxlist);
        int count = ctxlist.size();
        String[] colArr = new String[count];
        for(int i=0;i<count;i++){
            SQLGrammerParser.Column_nameContext ctxi = ctxlist.get(i);
            String columnName = ctxi.getText();
            colArr[i] = columnName;
        }
        return new ColumnListDto(colArr);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public ColumnListDto visitColumnListAll(SQLGrammerParser.ColumnListAllContext ctx) {
        return new ColumnListDto();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public ColumnListDto visitColumnListOne(SQLGrammerParser.ColumnListOneContext ctx) {
        String columnName = ctx.column_name().getText();
        return new ColumnListDto(columnName);
    }
}

package com.jason798.hbase.antlr.visitor;

import com.jason798.hbase.antlr.SQLGrammerBaseVisitor;
import com.jason798.hbase.antlr.model.RowKeyRange;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.util.StringHelper;
import com.jason798.hbase.antlr.SQLGrammerParser;
import com.jason798.hbase.util.CheckUtil;

import java.util.List;

/**
 * RowKeyRangeVisitor
 */
public class RowKeyRangeVisitor extends SQLGrammerBaseVisitor<RowKeyRange> {
    @Override
    public RowKeyRange visitRowkeyrangeStart(SQLGrammerParser.RowkeyrangeStartContext ctx) {
        RowKeyRange range = new RowKeyRange(HbaseConstant.ROW_KEY_START,ctx.rowkeyexp().getText());
        return range;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public RowKeyRange visitRowkeyrangeEnd(SQLGrammerParser.RowkeyrangeEndContext ctx) {
        RowKeyRange range = new RowKeyRange(ctx.rowkeyexp().getText(), HbaseConstant.ROW_KEY_END);
//        ctx.rowkeyexp().Data_Value().getSymbol();
        return range;
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override
    public RowKeyRange visitRowkeyrangeOne(SQLGrammerParser.RowkeyrangeOneContext ctx) {
        CheckUtil.checkNull(ctx);
        SQLGrammerParser.SpecrowkeyContext sctx = ctx.specrowkey();
        CheckUtil.checkNull(sctx);
        SQLGrammerParser.RowkeyexpContext rctx = sctx.rowkeyexp();
        CheckUtil.checkNull(rctx);
        String rowKey = StringHelper.filterOuterQuote(rctx.getText());
        RowKeyRange range = new RowKeyRange(rowKey);
        return range;
    }


    @Override
    public RowKeyRange visitRowkeyrangeSpec(SQLGrammerParser.RowkeyrangeSpecContext ctx) {
        CheckUtil.checkNull(ctx);
        List<SQLGrammerParser.RowkeyexpContext> rowKeyListCtx = ctx.rowkeyexp();
        CheckUtil.checkNull(rowKeyListCtx);

        int count = rowKeyListCtx.size();
        String[] rowKeyArr = new String[count];

        for(int i=0;i<count;i++){//SQLGrammerParser.RowkeyexpContext rowKeyCtx:rowKeyListCtx){
            String rowKey = rowKeyListCtx.get(i).getText();
            rowKeyArr[i]=rowKey;
        }
        RowKeyRange range = new RowKeyRange(rowKeyArr);
        return range;
    }

}

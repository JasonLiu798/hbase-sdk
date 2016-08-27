package com.jason798.hbase.antlr;

import java.io.IOException;

import com.jason798.hbase.antlr.core.SQLParser;
import com.jason798.hbase.antlr.model.SelectDto;
import org.junit.Test;


/**
 * ParseTest
 */
public class ParseTest {

    @Test
    public void testParse() throws IOException{
        long t = System.currentTimeMillis();
        SQLGrammerParser.ProgContext ctx = SQLParser.getProgContext("select c1,c2,c3 from tab1 rowkey is \"1232\" ");
        SelectDto dto = SQLParser.parseSelect(ctx);
        long t1 = System.currentTimeMillis() - t;



        System.out.println("sql parse "+dto+",cost time "+t1);


        /*
        String sql  = "update tablename23 set aaa=\"123\",bbb=\"dfew\" rowkey is \"xxxx\" ";
        //String ssql = "select abc,bcd from tab1 rowkey is \"aaa\" ";
        ANTLRInputStream input = new ANTLRInputStream(new StringReader(sql));
        SQLGrammerLexer lexer = new SQLGrammerLexer(
                input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SQLGrammerParser parser = new SQLGrammerParser(tokens);
//        StatementsParser.UpdatehqlcContext upctx = parser.updatehqlc();
//        System.out.println("update "+upctx.toString());
//        ParseTree tree = parser.
//        parser.setErrorHandler(SimpleHbaseErrorStrategy.instance);
        SQLGrammerParser.ProgContext progContext = parser.prog();

        if(progContext instanceof SQLGrammerParser.SelectSqlStmtContext){
            System.out.println("select ");
        }else if(progContext instanceof SQLGrammerParser.UpdateSqlStmtContext){
            System.out.println("update ");
        }else if(progContext instanceof SQLGrammerParser.DeleteSqlStmtContext){
            System.out.println("delete");
        }

//        List<Class<?>> list = BeanHelper.clazzList(progContext);
//        System.out.println("class list :"+list);

        SQLGrammerParser.UpdateSqlStmtContext upctx =  SQLGrammerParser.UpdateSqlStmtContext.class.cast(progContext);
        String tableName = upctx.updatesql().table_name().getText();
        String specRowKey = upctx.updatesql().specrowkey().rowkeyexp().getText();

		List<SQLGrammerParser.Column_nameContext> setlist = upctx.updatesql().assignList().column_name();
        for(SQLGrammerParser.Column_nameContext ctx : setlist){
            String colname = ctx.getText();
            System.out.println("colname "+colname);
        }
        List<SQLGrammerParser.ValuesContext> constCtx = upctx.updatesql().assignList().values();
        for(SQLGrammerParser.ValuesContext ctx : constCtx){
            String colname = ctx.getText();
            System.out.println("const "+colname);
        }

//        String setElem = upctx.updateSetList().updateSetc().updateSetElem().getText();
        System.out.println("tablename: "+tableName);
//        System.out.println("set list: "+setlist);
//        System.out.println("set elem:"+setElem);
        System.out.println("specRowKey: "+specRowKey);

//        parser.
//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk( new TestListener(), );
//        System.out.println("prog "+progContext);
//        StatementsParser.UpdatehqlcContext updatehqlcContext = progContext;

//        progContext.getToken(StatementsLexer.);
            */
    }
}

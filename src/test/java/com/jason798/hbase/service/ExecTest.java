package com.jason798.hbase.service;

import com.jason798.hbase.api.HbaseService;
import com.jason798.hbase.api.HbaseServiceFactory;
import com.jason798.hbase.api.RowDto;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;

public class ExecTest {
    private HbaseService hbaseService = HbaseServiceFactory.getHbaseService();
    //private static String tabName = "t1";


    @Test
    public void testExecuteSQL() throws Exception {
        String sql = "select f1,f2 from t1 rowkey is \"1\" ";
        long t = System.currentTimeMillis();
        List<RowDto> res = hbaseService.executeQuery(sql);
        long t2 = System.currentTimeMillis() - t;
        System.out.println("res " + res);
        System.out.println("cost time " + t2);
    }


    @Test
    public void testExecuteSQLBatch() throws Exception {
        List<Long> list = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            String sql = "select f" + i + ",f2 from t1 rowkey is \"" + i + "\" ";
            long t = System.currentTimeMillis();
            List<RowDto> res = hbaseService.executeQuery(sql);
            long t2 = System.currentTimeMillis() - t;
            list.add(t2);
            System.out.println("res " + res);
            System.out.println("cost time " + t2);
        }
        for (Long t : list) {
            System.out.println("cost time " + t);
        }
    }
}

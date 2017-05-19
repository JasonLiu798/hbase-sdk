package com.jason798.hbase.service;

import com.jason798.hbase.api.HbaseService;
import org.junit.Rule;
import java.util.Map;

import com.jason798.hbase.api.HbaseServiceFactory;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class HbaseSelectTest {

    private static String tabName = "t1";
    private static String rk = "rk0";
//    private static String cf = "f1";

	private HbaseService hbaseService = HbaseServiceFactory.getHbaseService();

    @Rule
    public ExpectedException exp = ExpectedException.none();


	@Test
	public void testGet() throws Exception{
//        String[] spec = {"f1","f3"};
//        String[] spec = null;
        Map<String,String> res = hbaseService.selectRow(tabName,rk );
		System.out.println("get row model "+res);
	}



	@Test
	public void testDel() throws Exception{
		System.out.println("del start -----------");

//		hbaseService.deleteByRowKey(tabName,rk );
//		System.out.println("del end -----------");
	}
	
	
}

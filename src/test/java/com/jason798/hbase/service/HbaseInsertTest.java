package com.jason798.hbase.service;

import com.jason798.common.ReflectUtil;
import com.jason798.hbase.api.HbaseService;
import com.jason798.hbase.api.HbaseServiceFactory;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.api.TableDto;
import com.jason798.hbase.util.FileUtils;
import com.jason798.hbase.model.TestModel;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class HbaseInsertTest {

    private static String tabName = "t1";
    private static String rk = "rk2";
    private static String cf = "f1";

	private HbaseService hbaseService = HbaseServiceFactory.getHbaseService();

	@Test
	public void testPut() throws Exception{
		System.out.println("insert start -----------");

		TestModel testModel = new TestModel();
		testModel.setTableName(tabName);
		testModel.setColumnFamily("f1");
		testModel.setRowKey(rk);
		testModel.setF1("v1");
		testModel.setF2(new BigDecimal(2.2));
		testModel.setF3(new Date());
		Map<String,String> map = ReflectUtil.getFieldMapAll(testModel);

		hbaseService.insert(tabName,rk , cf, map );
		System.out.println("insert end -----------");
	}

	@Test
	public void testPuts() throws Exception{
		System.out.println("batch insert start -----------");
		List<RowSimpleDto> list = new LinkedList<>();
		for(int i=0;i<100;i++){
			RowSimpleDto dto = new RowSimpleDto();
			TestModel testModel = new TestModel();
			testModel.setF1(String.valueOf(i));
			testModel.setF3(new Date());
			Map<String,String> map = ReflectUtil.getFieldMap(testModel);
			dto.setValues(map);
			dto.setRowkey(String.valueOf(i));
			list.add(dto);
		}
		hbaseService.insertRows(tabName,list );
		System.out.println("batch insert end -----------");
	}

	@Test
	public void checkGet() throws Exception{
        String[] spec = {"f1","f3"};
//        String[] spec = null;//{"f1","f3"};
        Map<String,String> res = hbaseService.selectRow(tabName, "rk1", spec);
		System.out.println("get row model "+res);
	}

	/**
	 * test batch get
	 * @throws Exception
	 */
	@Test
	public void checkBatchGet() throws Exception{
		String[] spec = {"f1"};
//		String[] spec = null;
		List<RowSimpleDto> res = hbaseService.selectRows(tabName,"0","99",spec);
		System.out.println(String.format("res size: %s,values: %s",res.size(),res));
	}

	/**
	 * test put byte[]
	 * @throws Exception
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testPutByte() throws Exception{
		System.out.println("insert bytes start -----------");

		TestModel testModel = new TestModel();
		testModel.setColumnFamily("f1");
		testModel.setRowKey("rkf");
		testModel.setF1("v1");
		Map<String,String> map = ReflectUtil.getFieldMapAll(testModel);

		Map<String,Object> bytemap = new HashedMap();
		byte[] content = FileUtils.getContent("D:\\service.zip");
		bytemap.put("zip",content);
		hbaseService.insertWithBytes(tabName, "rkf" , cf, bytemap, map);
		System.out.println("insert bytes end -----------");
	}

	/**
	 * test get byte[]
	 * @throws Exception
	 */
	@Test
	public void testGetByte() throws  Exception{
		System.out.println("get bytes start -----------");
		TableDto tab = new TableDto();
		tab.setTableName(tabName);
		String[] bytesColumn = {"zip"};
		Map<String,Object> res = hbaseService.selectRowWithBytes(tabName, rk, bytesColumn,null);
		byte[] zipfile = (byte[]) res.get("zip");
		FileUtils.writeFile("D:\\res.zip",zipfile);
		System.out.println("get bytes end -----------");
	}



	
}

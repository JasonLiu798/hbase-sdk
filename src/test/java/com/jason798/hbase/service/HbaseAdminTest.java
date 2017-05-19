package com.jason798.hbase.service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;
import com.jason798.hbase.action.admin.impl.CheckTableAvailableAction;
import com.jason798.hbase.action.admin.impl.CreateTableAction;
import com.jason798.hbase.api.HbaseServiceFactory;
import com.jason798.hbase.core.HbaseTemplate;
import com.jason798.hbase.action.admin.impl.GetTableColumnFamilyAction;
import com.jason798.hbase.model.param.admin.CreateTableParam;
import org.junit.Test;

public class HbaseAdminTest extends HbaseBasicTest {
//	@Test
	public void testCreateTable() {
		String t1 = "test2";
		Set<String> s = new HashSet<>();
		s.add("f1");
		boolean res = true;
		try {
			HbaseTemplate ht = new HbaseTemplate();
			ht.executeAdmin(new CreateTableAction(), new CreateTableParam(t1, s));
		} catch (Exception e) {
			res = false;
			System.out.println("create table fail");
			e.printStackTrace();
		}
		if (res)
			System.out.println("create table success ");
	}

	@Test
	public void testTableAvail() throws Exception {
		String t1 = "test2";
		boolean res = false;
		HbaseTemplate ht = new HbaseTemplate();
		res = ht.executeAdmin(new CheckTableAvailableAction(), t1);
		assertEquals(true, res);
	}

	@Test
	public void testHbaseAvail() {
		int ret = HbaseServiceFactory.isHbaseAvailable();
		assertEquals(ret, 0);
	}

	@Test
	public void testTableExist() throws Exception {
		String t1 = "test2";
		HbaseTemplate ht = new HbaseTemplate();
		boolean res = ht.executeAdmin(new CheckTableAvailableAction(), t1);
		assertEquals(true, res);
	}

	@Test
	public void listTableName() throws Exception {
		System.out.println("------test list tablename start------");
		HbaseTemplate ht = new HbaseTemplate();
//		String[] tables = ht.executeAdmin(new GetTableNamesAction());
//		CollectionUtil.printArr(tables);
		System.out.println("------test list tablename end------");
	}

	/**
	 * test get
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetTableColumnFamily() throws Exception {
		System.out.println("------test list cf start------");
		String t1 = "test1";
		HbaseTemplate ht = new HbaseTemplate();
		String[] cfs = ht.executeAdmin(new GetTableColumnFamilyAction(),t1);
//		CollectionUtil.printArr(cfs);
		System.out.println("------test list cf end------");

	}

}

package com.jason798.hbase.service;

import org.junit.BeforeClass;

public class HbaseBasicTest {

//	protected static HbaseConfig hc;
	@BeforeClass
	public static void before(){
		/**
		 * init hbase config
		 *
		hc = new HbaseConfig();
		
		Class clz =  hc.getClass();
		Map param = new HashedMap();
		param.put("hbase_zookeeper_quorum", "CNSZ22PL0060,CNSZ22PL0058,CNSZ22PL0059");
		param.put("hbase_master", "CNSZ22PL0058:600000");
		param.put("hbase_zookeeper_property_clientPort", "2181");
		ReflectUtil.setParameter(hc, param);
		System.out.println("after setter hc:"+hc);
		

		param.clear();
		param.put("hc",hc);
		*/
//		ReflectUtil.setParameter(ht, param);
		
//		ht.init();
		System.out.println("-------inited-----");
	}
	
}

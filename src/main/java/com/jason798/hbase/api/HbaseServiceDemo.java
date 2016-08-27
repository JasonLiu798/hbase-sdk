package com.jason798.hbase.api;

import java.util.Map;

/**
 * Created by async on 2016/8/28.
 */
public class HbaseServiceDemo {

	public static HbaseService hbaseService = HbaseServiceFactory.getHbaseService();

	/**
	 * search
	 */
	private static void select(){
		try {
			Map<String,String> map = hbaseService.selectRow("table1", "rk1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public static void main(String[] args) {
		select();

	}
}

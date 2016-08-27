package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD ，无参数，无返回值
 */
public interface CRUDAction extends ActionBase{
	public void service(Table table) throws Exception;
	public String getTable();
}

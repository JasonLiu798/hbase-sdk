package com.jason798.hbase.action;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD ，无参数，有返回值
 */
public interface CRUDReturnAction<T> {
	public T service(Table table) throws Exception;
	public TableName getTable();
}

package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD ，有参数，有返回值
 */
public interface CRUDParamReturnAction<P,R> extends ActionBase{
	R service(Table table,P param) throws Exception;
	String getTable();
}

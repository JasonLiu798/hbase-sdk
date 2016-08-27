package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Admin;

/**
 * DDL，无参数，有返回值
 */
public interface AdminReturnAction<T> {
	public T service(Admin admin) throws Exception;
	
}

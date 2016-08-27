package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Admin;

/**
 * DDL，有参数 T ，有返回值 V 
 */
public interface AdminParamReturnAction<P,R>  {
	public R service(Admin admin,P param) throws Exception;
}

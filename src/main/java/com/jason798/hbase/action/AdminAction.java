package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Admin;

/**
 * DDL，无参数，无返回值
 */
public interface AdminAction  {
	public void service(Admin admin) throws Exception;
	
}

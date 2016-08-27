package com.jason798.hbase.action.admin.impl;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import com.jason798.hbase.action.AdminParamReturnAction;

/**
 * check table exist
 */
public class CheckTableExistAction implements AdminParamReturnAction<String,Boolean>{
	@Override
	public Boolean service(Admin admin,String tablename) throws Exception {
		boolean res = false;
		res = admin.tableExists(TableName.valueOf(tablename));
	    return res;
	}
}

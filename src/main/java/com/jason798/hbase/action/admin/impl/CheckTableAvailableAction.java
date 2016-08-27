package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

/**
 *
 */
public class CheckTableAvailableAction implements AdminParamReturnAction<String,Boolean> {
	@Override
	public Boolean service(Admin admin,String tablename) throws Exception {
		boolean avail = false;
		avail = admin.isTableAvailable(TableName.valueOf(tablename));		
	    return avail;
	}

}

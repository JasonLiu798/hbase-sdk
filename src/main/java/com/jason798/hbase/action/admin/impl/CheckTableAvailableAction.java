package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * check table available
 * @author JasonLiu798
 * @since 1.0
 */
public class CheckTableAvailableAction implements AdminParamReturnAction<String,Boolean> {
	@Override
	public Boolean service(Admin admin,String tablename) throws HBaseException {
		boolean avail = false;
		try {
			avail = admin.isTableAvailable(TableName.valueOf(tablename));
		} catch (IOException e) {
			throw new HBaseException("hbase io exception");
		}
		return avail;
	}

}

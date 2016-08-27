package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.model.TableParamInner;
import com.jason798.hbase.action.AdminParamReturnAction;
import org.apache.hadoop.hbase.client.Admin;

/**
 * delete table
 */
public class DeleteTableAction implements AdminParamReturnAction<TableParamInner,Integer> {
	@Override
	public Integer service(Admin admin, TableParamInner param) throws Exception {
		admin.deleteTable(param.getTableName());
		return 0;
	}
}

package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.model.TableParamInner;
import org.apache.hadoop.hbase.client.Admin;
import com.jason798.hbase.action.AdminParamReturnAction;

/**
 * enable table
 */
public class EnableTableAction implements AdminParamReturnAction<TableParamInner,Integer> {
	@Override
	public Integer service(Admin admin, TableParamInner param) throws Exception {
		admin.enableTable(param.getTableName());
		return 0;
	}
}

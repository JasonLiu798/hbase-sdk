package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.model.constant.HbaseConstant;

/**
 * scan base
 */
public class ScanRowBaseAction extends CRUDBaseAction {

	public ScanRowBaseAction(String tableName) {
		super(tableName);
	}

	public String getActionName() {
		return HbaseConstant.ACTION_SCAN;
	}
}

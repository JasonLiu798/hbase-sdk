package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.ActionBase;

/**
 * base CRUD action
 */
public abstract class CRUDBaseAction implements ActionBase {
	/**
	 * for HbaseTemplate get Table
	 */
	protected String tableName;
	
	public CRUDBaseAction(String tableName){
		this.tableName = tableName;
	}

	/**
	 * for HbaseTemplate getTablename
	 * @return
	 */
	public String getTable() {
		return tableName;
	}

	/**
	 * for log trace
	 * @return
	 */
	public abstract String getActionName();
}

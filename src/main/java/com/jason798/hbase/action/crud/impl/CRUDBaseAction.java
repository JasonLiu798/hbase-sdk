
package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.ActionBase;

/**
 * crud base action
 * @author JasonLiu798
 * @since 1.0
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

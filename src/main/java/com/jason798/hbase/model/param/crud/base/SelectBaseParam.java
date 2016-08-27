package com.jason798.hbase.model.param.crud.base;

import com.jason798.hbase.model.constant.HbaseConstant;

import java.util.Arrays;

/**
 *
 */
public class SelectBaseParam {
	protected String columnFamily;
	protected String[] columnList;

	public SelectBaseParam() {
		columnFamily = HbaseConstant.DFT_COL_FAMILY;
		columnList = null;
	}

	public SelectBaseParam(String columnFamily, String[] specColumns) {
		this.columnFamily = columnFamily;
		this.columnList = specColumns;
	}

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public String[] getColumnList() {
		return columnList;
	}

	public void setColumnList(String[] columnList) {
		this.columnList = columnList;
	}

	@Override
	public String toString() {
		return "SelectBaseParam{" +
				"columnFamily='" + columnFamily + '\'' +
				", columnList=" + Arrays.toString(columnList) +
				'}';
	}
}

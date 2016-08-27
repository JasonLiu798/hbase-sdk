
package com.jason798.hbase.model.param.crud;

import com.jason798.hbase.model.param.crud.base.SelectBaseParam;

import java.util.Arrays;
public class SelectRowParam extends SelectBaseParam {
	private String rowKey;
	private String[] byteColumns;

	public SelectRowParam() {
	}

	public SelectRowParam(String rowKey, String columnFamily, String[] specColumns) {
		super(columnFamily, specColumns);
		this.rowKey = rowKey;
		this.byteColumns = null;
	}

	public SelectRowParam(String rowKey, String columnFamily, String[] specColumns, String[] byteColumns) {
		super(columnFamily, specColumns);
		this.rowKey = rowKey;
		this.byteColumns = byteColumns;
	}

	public String[] getByteColumns() {
		return byteColumns;
	}

	public void setByteColumns(String[] byteColumns) {
		this.byteColumns = byteColumns;
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
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
		return super.toString()+"SelectRowParam{" +
				"rowKey='" + rowKey + '\'' +
				", byteColumns=" + Arrays.toString(byteColumns) +
				'}';
	}
}

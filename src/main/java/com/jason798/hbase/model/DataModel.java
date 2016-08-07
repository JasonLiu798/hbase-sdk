package com.jason798.hbase.model;

/**
 * Created by async on 2016/8/6.
 */
public class DataModel {
	private String rowKey;
	private String columnName;
	private long ts;
	private byte [] bytesData;

	public byte[] getBytesData() {
		return bytesData;
	}
	public void setBytesData(byte[] bytesData) {
		this.bytesData = bytesData;
	}

	public String getRowKey() {
		return rowKey;
	}
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}

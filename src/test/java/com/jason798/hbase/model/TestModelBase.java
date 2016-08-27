package com.jason798.hbase.model;

public class TestModelBase {
	protected String tableName;
	protected String rowKey;
	protected String columnFamily;
	
	public TestModelBase(){
	}

	public TestModelBase(String tableName, String rowKey, String columnFamily) {
		super();
		this.tableName = tableName;
		this.rowKey = rowKey;
		this.columnFamily = columnFamily;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
}

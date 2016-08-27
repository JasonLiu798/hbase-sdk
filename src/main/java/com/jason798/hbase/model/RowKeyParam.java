package com.jason798.hbase.model;


/**
 *
 */
public class RowKeyParam {
	protected String rowKey;
	
	public RowKeyParam(){}
	public RowKeyParam( String rowKey) {
		this.rowKey = rowKey;
	}

//	public TableName getTableName() {
//		return tableName;
//	}
//
//	public RowKeyParam setTableName(String tableName) {
//		this.tableName = TableName.valueOf( tableName);
//		return this;
//	}
//
//	public RowKeyParam setTableName(TableName tableName) {
//		this.tableName = tableName;
//		return this;
//	}

	public String getRowKey() {
		return rowKey;
	}
	public RowKeyParam setRowKey(String rowKey) {
		this.rowKey = rowKey;
		return this;
	}

	@Override
	public String toString() {
		return "RowKeyParam{" +
				"rowKey='" + rowKey + '\'' +
				'}';
	}
}

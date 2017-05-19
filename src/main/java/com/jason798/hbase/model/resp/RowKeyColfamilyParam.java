package com.jason798.hbase.model.resp;


/**
 *
 * 
 * @author JasonLiu798
 * @since 1.0
 */
public class RowKeyColfamilyParam {
	protected String rowKey;
	protected String columnFamily;

	public RowKeyColfamilyParam() {
	}

	public RowKeyColfamilyParam(String rowKey,
                                String columnFamily) {
//		this.setTableName(tableName);
		this.rowKey = rowKey;
		this.columnFamily = columnFamily;
	}
/*
	public RowKeyColfamilyParam(TableName tableName, String rowKey,
                                String columnFamily) {
//		this.tableName = tableName;
		this.rowKey = rowKey;
		this.columnFamily = columnFamily;
	}*/

//	public TableName getTableName() {
//		return tableName;
//	}

//	public RowKeyColfamilyParam setTableName(TableName tableName) {
//		this.tableName = tableName;
//		return this;
//	}
//	public RowKeyColfamilyParam setTableName(String tableName) {
//		this.tableName = TableName.valueOf(tableName);
//		return this;
//	}

	public String getRowKey() {
		return rowKey;
	}

	public RowKeyColfamilyParam setRowKey(String rowKey) {
		this.rowKey = rowKey;
		return this;
	}

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	@Override
	public String toString() {
		return "RowKeyColfamilyParam{" +
				"rowKey='" + rowKey + '\'' +
				", columnFamily='" + columnFamily + '\'' +
				'}';
	}
}

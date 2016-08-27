package com.jason798.hbase.api;

/**
 * TODO:add config
 */
public class TableDto {
    protected String tableName;

	public TableDto(){

	}

	public TableDto(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "TableDto{" +
				"tableName='" + tableName + '\'' +
				'}';
	}
}

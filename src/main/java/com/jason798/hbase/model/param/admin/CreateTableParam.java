package com.jason798.hbase.model.param.admin;

import org.apache.hadoop.hbase.TableName;

import java.util.Set;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class CreateTableParam {
	public CreateTableParam(){
	}
	
	public CreateTableParam(String tableName, Set<String> columnFamilys) {
		super();
		this.setTableName( tableName);
		this.columnFamilys = columnFamilys;
	}
	
	private TableName tableName;
	private Set<String> columnFamilys;
	
	public TableName getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = TableName.valueOf(tableName);
	}
	public Set<String> getColumnFamilys() {
		return columnFamilys;
	}
	public void setColumnFamilys(Set<String> columnFamilys) {
		this.columnFamilys = columnFamilys;
	}

	@Override
	public String toString() {
		return "CreateTableParam{" +
				"tableName=" + tableName +
				", columnFamilys=" + columnFamilys +
				'}';
	}
}

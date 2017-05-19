package com.jason798.hbase.model.param.crud;

import com.jason798.hbase.model.CASValue;
import org.apache.hadoop.hbase.TableName;

/**
 * 
 * @author JasonLiu798
 * @since 1.0
 */
public class PutRowCASParam {
	private TableName tableName;
	private String rowKey;
	private String familyName;
	private String qualifer;
	private CASValue value;
	
	public PutRowCASParam(TableName tableName, String rowKey,
			String familyName, String qualifer, CASValue value) {
		super();
		this.tableName = tableName;
		this.rowKey = rowKey;
		this.familyName = familyName;
		this.qualifer = qualifer;
		this.value = value;
	}

	public PutRowCASParam(){
	}

	public TableName getTableName() {
		return tableName;
	}

	public void setTableName(TableName tableName) {
		this.tableName = tableName;
	}

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getQualifer() {
		return qualifer;
	}

	public void setQualifer(String qualifer) {
		this.qualifer = qualifer;
	}

	public CASValue getValue() {
		return value;
	}

	public void setValue(CASValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PutRowCASParam{" +
				"tableName=" + tableName +
				", rowKey='" + rowKey + '\'' +
				", familyName='" + familyName + '\'' +
				", qualifer='" + qualifer + '\'' +
				", value=" + value +
				'}';
	}
}

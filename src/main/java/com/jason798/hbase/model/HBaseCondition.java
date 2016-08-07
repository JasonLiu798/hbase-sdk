package com.jason798.hbase.model;


import com.jason798.hbase.api.Condition;

/**
 * Created by async on 2016/8/6.
 */
public class HBaseCondition implements Condition {

	private String OperName;

	private String fieldName;

	private String[] values;

	private String typeName;

	public String getOperName() {
		return OperName;
	}

	public void setOperName(String operName) {
		OperName = operName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}

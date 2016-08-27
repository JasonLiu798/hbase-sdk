package com.jason798.hbase.model.param.crud.base;

import com.jason798.hbase.model.resp.RowKeyColfamilyParam;

import java.util.Map;

public class PutRowParam extends RowKeyColfamilyParam {
	/**
	 * key:qualifer
	 * value:value
	 */
	private Map<String, String> values;

	/**
	 * check row exist,default not check
	 */
	private boolean checkExist = false;

	public PutRowParam(){}
	public PutRowParam(String rowKey, String columnFamily, Map<String, String> values) {
		super(rowKey, columnFamily);
		this.values = values;
		this.checkExist = false;
	}

	public PutRowParam(String rowKey, String columnFamily, Map<String, String> values, boolean checkExist) {
		super(rowKey, columnFamily);
		this.values = values;
		this.checkExist = checkExist;
	}

	public boolean isCheckExist() {
		return checkExist;
	}

	public void setCheckExist(boolean checkExist) {
		this.checkExist = checkExist;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return super.toString()+" PutRowParam{" +
				"values=" + values +
				", checkExist=" + checkExist +
				'}';
	}
}

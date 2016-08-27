package com.jason798.hbase.model.resp;

import java.util.Map;

public class RowModelByte extends RowMeta {//no ts
	/**
	 * key: columnFamily
	 * value:
	 * 		key: qualifier
	 * 		value:
	 * 				value
	 * 				---timestamp
	 */
	private Map<String, Object> values;

	public RowModelByte(){}
	public RowModelByte(Map<String, Object> byteValue) {
		this.values = byteValue;
	}

	public RowModelByte(String rowKey, String columnFamily, Map<String, Object> byteValue) {
		super(rowKey, columnFamily);
		this.values = byteValue;
	}

	public Map<String, Object> getValues() {
		return values;
	}

	public void setValues(Map<String, Object> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "RowModelByte{" +
				"values=" + values +
				'}';
	}
}

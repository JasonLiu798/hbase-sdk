
package com.jason798.hbase.model.resp;

import java.util.Map;


public class RowMultiColFamilyModel extends RowMeta {//no ts
	/**
	 * key: columnFamily
	 * value:
	 * 		key: qualifier
	 * 		value:
	 * 				value
	 * 				---timestamp
	 */
	private Map<String,Map<String, String>> values;

	public RowMultiColFamilyModel(){

	}
	public RowMultiColFamilyModel(String rowKey, String columnFamily) {
		super(rowKey, columnFamily);
	}

	public Map<String, Map<String, String>> getValues() {
		return values;
	}

	public void setValues(Map<String, Map<String, String>> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "RowModel{" +
				"values=" + values +
				'}';
	}
}

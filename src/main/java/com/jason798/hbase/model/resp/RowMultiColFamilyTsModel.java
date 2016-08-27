
package com.jason798.hbase.model.resp;


import com.jason798.hbase.model.ValueTS;

import java.util.Map;


public class RowMultiColFamilyTsModel extends RowMeta {//no ts
	/**
	 * key: columnFamily
	 * value:
	 * 		key: qualifier
	 * 		value:
	 * 				value
	 * 				---timestamp
	 */
	private Map<String,Map<String, ValueTS>> values;

	public RowMultiColFamilyTsModel(){

	}
	public RowMultiColFamilyTsModel(String rowKey, String columnFamily) {
		super(rowKey, columnFamily);
	}

	public void setValues(Map<String, Map<String, ValueTS>> values) {
		this.values = values;
	}

	public Map<String, Map<String, ValueTS>> getValues() {

		return values;
	}

	@Override
	public String toString() {
		return "RowModel{" +
				"values=" + values +
				'}';
	}
}


package com.jason798.hbase.model.resp;

import java.util.Map;




public class RowModel extends RowMeta {//no ts
	/**
	 * key: columnFamily
	 * value: 
	 * 		key: qualifier
	 * 		value: 
	 * 				value
	 * 				---timestamp
	 */
	private Map<String, String> values;

	public RowModel(){

	}
	public RowModel(String rowKey, String columnFamily) {
		super(rowKey, columnFamily);
	}

	public RowModel(String rowKey, String columnFamily, Map<String, String> values) {
		super(rowKey, columnFamily);
		this.values = values;
	}

	public Map<String, String> getValues() {
		return values;
	}


	public void setValues(Map<String, String> values) {
		this.values = values;
	}


	@Override
	public String toString() {
		return "RowModel{" +
				"values=" + values +
				'}';
	}
}

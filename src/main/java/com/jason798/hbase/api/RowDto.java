
package com.jason798.hbase.api;

import java.util.Map;

/**
 * row dto
 */
public class RowDto {
	/**
	 * rowkey
	 */
	private String rowkey;
	/**
	 * K: qualifier
	 * V: value
	 */
	private Map<String, String> values;

	public RowDto(){}

	public RowDto(String rowkey, Map<String, String> values) {
		this.rowkey = rowkey;
		this.values = values;
	}

	public String getRowkey() {
		return rowkey;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "RowDto{" +
				"rowkey='" + rowkey + '\'' +
				", values=" + values +
				'}';
	}
}

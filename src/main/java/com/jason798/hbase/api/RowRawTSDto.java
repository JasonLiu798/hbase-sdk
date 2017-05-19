package com.jason798.hbase.api;

import com.jason798.hbase.model.ValueTS;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class RowRawTSDto implements Serializable{
	/**
	 * rowkey
	 */
	private String rowkey;
	/**
	 * K: qualifier
	 * V: value
	 */
	private Map<String, ValueTS> values;

	public RowRawTSDto(){}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public Map<String, ValueTS> getValues() {
		return values;
	}

	public void setValues(Map<String, ValueTS> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "RowRawTSDto{" +
				"rowkey='" + rowkey + '\'' +
				", values=" + values +
				'}';
	}
}

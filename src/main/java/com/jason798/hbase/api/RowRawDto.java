package com.jason798.hbase.api;

import java.io.Serializable;

/**
 * TODO: more common data result include columnfamily
 */
public class RowRawDto implements Serializable {

	/**
	 * rowkey
	 */
	private String rowkey;
	private String columnFamily;
	private String qualifer;
	private String value;
	private long timestamp;

	public RowRawDto(){}

	public RowRawDto(String rowkey, String columnFamily, String qualifer, String value, long timestamp) {
		this.rowkey = rowkey;
		this.columnFamily = columnFamily;
		this.qualifer = qualifer;
		this.value = value;
		this.timestamp = timestamp;
	}

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public String getQualifer() {
		return qualifer;
	}

	public void setQualifer(String qualifer) {
		this.qualifer = qualifer;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "RowRawDto{" +
				"rowkey='" + rowkey + '\'' +
				", columnFamily='" + columnFamily + '\'' +
				", qualifer='" + qualifer + '\'' +
				", value='" + value + '\'' +
				", timestamp=" + timestamp +
				'}';
	}
}

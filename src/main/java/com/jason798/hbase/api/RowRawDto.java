package com.jason798.hbase.api;

import java.io.Serializable;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class RowRawDto implements Serializable {

	/**  */
	private static final long serialVersionUID = 1258950903969245455L;
	/**
	 * rowkey
	 */
	private String rowkey;
	private String columnFamily;
	private String qualifer;
	private Object value;
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
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

package com.jason798.hbase.api;

import java.io.Serializable;

/**
 * TODO: more common data result include columnfamily
 */
public class RowBaseDto implements Serializable {

	/**
	 * rowkey
	 */
	protected String rowkey;
	protected String columnFamily;
	protected String qualifer;
	protected String value;

	public RowBaseDto(){}

	public RowBaseDto(String rowkey, String columnFamily, String qualifer, String value) {
		this.rowkey = rowkey;
		this.columnFamily = columnFamily;
		this.qualifer = qualifer;
		this.value = value;
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


	@Override
	public String toString() {
		return "RowDto{" +
				"rowkey='" + rowkey + '\'' +
				", columnFamily='" + columnFamily + '\'' +
				", qualifer='" + qualifer + '\'' +
				", value='" + value + '\'' +
				'}';
	}
}

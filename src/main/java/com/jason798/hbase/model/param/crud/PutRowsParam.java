package com.jason798.hbase.model.param.crud;


import com.jason798.hbase.api.RowSimpleDto;

import java.util.List;

public class PutRowsParam {
	private String columnFamily;
	private List<RowSimpleDto> values;
	private boolean checkExist;

	public PutRowsParam(){

	}

	/**
	 * checkExist = false, not check row exist,for insert
	 * = true,check row exist,for update
	 * @param columnFamily
	 * @param values
	 */
	public PutRowsParam(String columnFamily, List<RowSimpleDto> values) {
		this.columnFamily = columnFamily;
		this.values = values;
		this.checkExist = false;
	}

	public PutRowsParam(String columnFamily, List<RowSimpleDto> values, boolean checkExist) {
		this.columnFamily = columnFamily;
		this.values = values;
		this.checkExist = checkExist;
	}

	public String getColumnFamily() {
		return columnFamily;
	}

	public void setColumnFamily(String columnFamily) {
		this.columnFamily = columnFamily;
	}

	public List<RowSimpleDto> getValues() {
		return values;
	}

	public void setValues(List<RowSimpleDto> values) {
		this.values = values;
	}

	public boolean isCheckExist() {
		return checkExist;
	}

	public void setCheckExist(boolean checkExist) {
		this.checkExist = checkExist;
	}

	@Override
	public String toString() {
		return "PutRowsParam{" +
				"columnFamily='" + columnFamily + '\'' +
				", values=" + values +
				", checkExist=" + checkExist +
				'}';
	}
}

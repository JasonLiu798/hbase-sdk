package com.jason798.hbase.model;

import java.util.List;

public class RowKeysParam {

	private List<String> rowKeys;

	public RowKeysParam(){
	}

	public RowKeysParam(List<String> rowKeys) {
		this.rowKeys = rowKeys;
	}

	public List<String> getRowKeys() {
		return rowKeys;
	}

	public void setRowKeys(List<String> rowKeys) {
		this.rowKeys = rowKeys;
	}

	@Override
	public String toString() {
		return "RowKeysParam{" +
				"rowKeys=" + rowKeys +
				'}';
	}
}



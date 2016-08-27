package com.jason798.hbase.model.param.crud;

import com.jason798.hbase.model.param.crud.base.SelectBaseParam;
import java.util.Arrays;


public class SelectSpecRowsParam extends SelectBaseParam {
	private String[] rowKeys;
	private int maxSize;

	public SelectSpecRowsParam(){}

	public SelectSpecRowsParam(String[] rowKeys, int maxSize) {
		this.rowKeys = rowKeys;
		this.maxSize = maxSize;
	}

	public SelectSpecRowsParam(String[] rowKeys, String columnFamily, String[] specColumns, int maxSize) {
		super(columnFamily, specColumns);
		this.rowKeys = rowKeys;
		this.maxSize = maxSize;
	}

	public String[] getRowKeys() {
		return rowKeys;
	}

	public void setRowKeys(String[] rowKeys) {
		this.rowKeys = rowKeys;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public String toString() {
		return super.toString()+" SelectSpecRowsParam{" +
				"rowKeys=" + Arrays.toString(rowKeys) +
				", maxSize=" + maxSize +
				'}';
	}
}


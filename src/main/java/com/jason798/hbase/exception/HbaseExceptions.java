package com.jason798.hbase.exception;

/**
 * Created by async on 2016/8/6.
 */
public class HbaseExceptions extends Exception {
	private int tableState;
	private String errmsg;

	public int getTableState() {
		return tableState;
	}

	public void setTableState(int tableState) {
		this.tableState = tableState;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public HbaseExceptions() {
		super();
	}

	public HbaseExceptions(String msg) {
		super(msg);
	}
}

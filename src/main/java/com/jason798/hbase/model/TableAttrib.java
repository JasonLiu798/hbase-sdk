package com.jason798.hbase.model;

/**
 * Created by async on 2016/8/6.
 */
public class TableAttrib {

	private String Tablename;
	private String WriteBufferSize;
	private String refConfId;
	private String autoflash;
	public String getTablename() {
		return Tablename;
	}
	public void setTablename(String tablename) {
		Tablename = tablename;
	}
	public String getWriteBufferSize() {
		return WriteBufferSize;
	}
	public void setWriteBufferSize(String writeBufferSize) {
		WriteBufferSize = writeBufferSize;
	}
	public String getRefConfId() {
		return refConfId;
	}
	public void setRefConfId(String refConfId) {
		this.refConfId = refConfId;
	}
	public String getAutoflash() {
		return autoflash;
	}
	public void setAutoflash(String autoflash) {
		this.autoflash = autoflash;
	}

}

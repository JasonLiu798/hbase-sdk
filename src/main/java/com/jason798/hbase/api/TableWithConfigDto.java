package com.jason798.hbase.api;


public class TableWithConfigDto {

	protected String tableName;

	private boolean bufferOn;

	private long buffersize;

	public TableWithConfigDto(){

	}

	public TableWithConfigDto(String tableName) {
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean isBufferOn() {
		return bufferOn;
	}

	public void setBufferOn(boolean bufferOn) {
		this.bufferOn = bufferOn;
	}

	public long getBuffersize() {
		return buffersize;
	}

	public void setBuffersize(long buffersize) {
		this.buffersize = buffersize;
	}

	@Override
	public String toString() {
		return "TableDto{" +
				"tableName='" + tableName + '\'' +
				'}';
	}
}

package com.jason798.hbase.model.param.crud;


import com.jason798.hbase.model.param.crud.base.SelectBaseParam;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class SelectRowsParam extends SelectBaseParam {
	private String startRowKey;
	private String endRowKey;
	private ScanCondition condition;
	private int maxSize;


	public SelectRowsParam(){}

	public String getStartRowKey() {
		return startRowKey;
	}

	public void setStartRowKey(String startRowKey) {
		this.startRowKey = startRowKey;
	}

	public String getEndRowKey() {
		return endRowKey;
	}

	public void setEndRowKey(String endRowKey) {
		this.endRowKey = endRowKey;
	}

	public ScanCondition getCondition() {
		return condition;
	}

	public void setCondition(ScanCondition condition) {
		this.condition = condition;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public SelectRowsParam(String columnFamily, String[] specColumns, String startRowKey, String endRowKey, ScanCondition condition, int maxSize) {
		super(columnFamily, specColumns);
		this.startRowKey = startRowKey;
		this.endRowKey = endRowKey;
		this.condition = condition;
		this.maxSize = maxSize;
	}

	@Override
	public String toString() {
		return super.toString()+"SelectRowsParam{" +
				"startRowKey='" + startRowKey + '\'' +
				", endRowKey='" + endRowKey + '\'' +
				", condition=" + condition +
				", maxSize=" + maxSize +
				'}';
	}
}


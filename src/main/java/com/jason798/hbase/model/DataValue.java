package com.jason798.hbase.model;

import java.io.Serializable;

/**
 * Created by async on 2016/8/6.
 */
public class DataValue implements Serializable {

	private static final long serialVersionUID = 2345634763456L;
	private String rowKey;
	private String familyKey;
	private String qualifierKey;
	private String dataValue;
	private long ts;

	public String getRowKey() {
		return this.rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public String getFamilyKey() {
		return this.familyKey;
	}

	public void setFamilyKey(String familyKey) {
		this.familyKey = familyKey;
	}

	public String getQualifierKey() {
		return this.qualifierKey;
	}

	public void setQualifierKey(String qualifierKey) {
		this.qualifierKey = qualifierKey;
	}

	public Object getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public long getTs() {
		return this.ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

	public String toString() {
		return

				"rowKey=" + this.rowKey + "familyKey=" + this.familyKey + "qualifierKey" + this.dataValue + "ts =" + this.ts;
	}
}

package com.jason798.hbase.model;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ValueTS {

	private String value;
	private long ts;
	
	
	public ValueTS(String value, long ts) {
		super();
		this.value = value;
		this.ts = ts;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public long getTs() {
		return ts;
	}
	public void setTs(long ts) {
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "ValueTS [value=" + value + ", ts=" + ts + "]";
	}
	
}

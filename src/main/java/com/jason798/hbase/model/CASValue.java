
package com.jason798.hbase.model;

/**
 *
 */
public class CASValue {
	private String value;
	private String expectValue;
	
	public CASValue(String value, String expectValue) {
		super();
		this.value = value;
		this.expectValue = expectValue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getExpectValue() {
		return expectValue;
	}
	public void setExpectValue(String expectValue) {
		this.expectValue = expectValue;
	}
	
}

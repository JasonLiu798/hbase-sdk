
package com.jason798.hbase.model;

import java.math.BigDecimal;
import java.util.Date;

public class TestModel extends TestModelBase {
	private long id;
	private String f1;
	private BigDecimal f2;
	private Date f3;
	
	public TestModel(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public BigDecimal getF2() {
		return f2;
	}

	public void setF2(BigDecimal f2) {
		this.f2 = f2;
	}

	public Date getF3() {
		return f3;
	}

	public void setF3(Date f3) {
		this.f3 = f3;
	}


	
}

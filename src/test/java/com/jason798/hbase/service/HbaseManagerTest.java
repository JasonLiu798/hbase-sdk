package com.jason798.hbase.service;

import static org.junit.Assert.*;

import com.jason798.hbase.api.HbaseServiceFactory;

import org.junit.Test;

public class HbaseManagerTest extends HbaseBasicTest {
	
	@Test
	public void testHbaseAvail() {
		int ret = HbaseServiceFactory.isHbaseAvailable();
		assertEquals(ret, 0);
	}

}

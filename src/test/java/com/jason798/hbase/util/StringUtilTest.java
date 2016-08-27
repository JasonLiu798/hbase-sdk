package com.jason798.hbase.util;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class StringUtilTest {

    @Test
    public void testFilterQuote(){
        String res = StringHelper.filterOuterQuote("\"aa\"");
        assertEquals("aa",res);
        res = StringHelper.filterOuterQuote("\"\"");
        assertEquals("",res);

    }
}

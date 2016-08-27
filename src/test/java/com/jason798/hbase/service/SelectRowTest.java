package com.jason798.hbase.service;

import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.util.CollectionHelper;
import com.jason798.hbase.api.HbaseService;
import com.jason798.hbase.api.HbaseServiceFactory;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static junit.framework.Assert.*;


@SuppressWarnings({"unchecked","rawtypes"})
public class SelectRowTest {

    private static String tabName = "t1";

	private HbaseService hbaseService = HbaseServiceFactory.getHbaseService();

    @Rule
    public ExpectedException exp = ExpectedException.none();

    /**
     * 正常
     * @throws Exception
     */
    @Test
    public void testGetRowsNormal() throws Exception{
        String[] spec = {"f1"};

        Map<String,String> res = hbaseService.selectRow(tabName, "1", HbaseConstant.DFT_COL_FAMILY, spec);
        System.out.println("get rows "+res);
    }

    /**
     * 获取指定列
     * @throws Exception
     */
    @Test
    public void testGetRowSpecColumn() throws Exception{
        String col1 = "f1";
        String[] spec = {col1};
//        String col2 = "f2";
//        String col3 = "f3";
       
		Map res = hbaseService.selectRow(tabName,"1",spec);
        System.out.println(res);
        assertNotNull(res.get(col1));
    }

    /**
     * 表不存在
     * @throws Exception
     */
	@Test
    public void testGetRowTableNotExist() throws Exception{
        //exp.expect(HBaseException.class);
		Map res = hbaseService.selectRow("tableNotExist", "1");
        Assert.assertEquals(true, CollectionHelper.isEmpty(res));
        System.out.println("res: "+res);
    }

    /**
     * column family 不存在
     * @throws Exception
     */
    
	@Test
    public void testGetRowColumnFamilyNotExist() throws Exception{
        Map res = hbaseService.selectRow(tabName,"1","cfnotexist",null);
        assertEquals(true,CollectionHelper.isEmpty(res));
    }

    /**
     * rowkey 不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsRowKeyNotExist() throws Exception{
        Map res = hbaseService.selectRow(tabName, "rknotexist");
        System.out.println("res "+res);
        assertEquals(true,CollectionHelper.isEmpty(res));
    }

    /**
     * 指定列不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsAllQualiferNotExist() throws Exception{
        String col1 = "qualiferNotExist";
        String[] spec = {col1};
//        String col2 = "f2";
//        String col3 = "f3";
        Map res = hbaseService.selectRow(tabName,"1", spec);
        System.out.println("res "+ res);
        assertEquals(true,CollectionHelper.isEmpty(res));
    }

    /**
     * rowkey为空
     * @throws Exception
     */
    @Test
    public void testGetRowsNullRowKeyList() throws Exception {
        exp.expect(NullPointerException.class);
        hbaseService.selectRow(tabName,null);
    }

    /**
     * table参数为空
     * @throws Exception
     */
    @Test
    public void testGetRowsNullTab() throws Exception{
        exp.expect(NullPointerException.class);
        hbaseService.selectRow(null,null);
    }

	
	
}

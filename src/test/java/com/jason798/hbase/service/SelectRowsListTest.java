package com.jason798.hbase.service;

import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.api.HbaseService;
import com.jason798.hbase.api.HbaseServiceFactory;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.api.TableDto;
import com.jason798.hbase.model.constant.HbaseConstant;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;
import java.util.Map;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;


public class SelectRowsListTest {

    private static String tabName = "t1";
//    private static String rk = "rk0";
    private static String cf = "f1";

	private HbaseService hbaseService = HbaseServiceFactory.getHbaseService();

    @Rule
    public ExpectedException exp = ExpectedException.none();

    /**
     * 正常
     * @throws Exception
     */
    @Test
    public void testGetRowsNormal() throws Exception{
        TableDto tab = new TableDto();
        tab.setTableName(tabName);
        //tab.setColumnFamily(cf);
        String[] spec = {"f1"};
        String[] rowKeys =  {"1","3","10"};
        //	List<RowSimpleDto> selectRows(@NotNullable String tableName, @NotNullable List<String> rowKeys, String columnFamily, @Nullable String[] qualiferList, @Nullable Integer limit) throws Exception;
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, rowKeys, HbaseConstant.DFT_COL_FAMILY,spec,null);
        assertEquals(3,res.size());
        System.out.println("get rows "+res);
    }

    /**
     * 获取指定列
     * @throws Exception
     */
    @Test
    public void testGetRowsSpecColumn() throws Exception{
        TableDto tab = new TableDto();
        tab.setTableName(tabName);
        //tab.setColumnFamily(cf)

        String col1 = "f1";
        String[] spec = {col1};
        String col2 = "f2";
        String col3 = "f3";
        String[] rowKeys =  {"1","3","10"};
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, rowKeys,spec);
        assertEquals(3,res.size());
        for(int i =0;i<res.size();i++){
            RowSimpleDto dto = res.get(i);
            Map<String,String> value = dto.getValues();
            assertNotNull(value.get(col1));
            assertNull(value.get(col2));
            assertNull(value.get(col3));
        }
        System.out.println("get rows "+res);
    }

    /**
     * 表不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsTableNotExist() throws Exception{
        List<RowSimpleDto> res = hbaseService.selectRows("tableNotExist", new String[]{"1"});
        System.out.println("res :"+res);
        Assert.assertEquals(true, CollectionUtil.isEmpty(res));
    }

    /**
     * column family 不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsColumnFamilyNotExist() throws Exception{
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, new String[]{"1"},"cfnotexist",null, null );
        assertEquals(true,CollectionUtil.isEmpty(res));
    }

    /**
     * rowkey 不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsRowKeyNotExist() throws Exception{
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, new String[]{"rknotexist"});
        System.out.println("res "+res);
        assertEquals(true,CollectionUtil.isEmpty(res));
    }

    /**
     * 部分 rowkey 不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsRowKeyNotExistPart() throws Exception{
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, new String[]{"rknotexist","3"});
        System.out.println("res "+res);
        assertEquals(1,res.size());
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
        String[] rowKeys =  {"1","3","10","15"};
//        List<String> rowKeyList = new ArrayList<>();
//        Collections.addAll(rowKeyList,rowKeys);
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, rowKeys,spec);
        System.out.println("res "+ res);
        assertEquals(true,CollectionUtil.isEmpty(res));
    }

    /**
     * 部分指定列 表中不存在
     * @throws Exception
     */
    @Test
    public void testGetRowsQualiferNotExistPart() throws Exception{
        String col1 = "qualiferNotExist";
        String col2 = "f1";
        String[] spec = {col1,col2};
        String[] rowKeys =  {"1","3","10"};
//        List<String> rowKeyList = new ArrayList<>();
//        Collections.addAll(rowKeyList,rowKeys);
        List<RowSimpleDto> res = hbaseService.selectRows(tabName, rowKeys,spec);
        System.out.println("res "+ res);
        assertEquals(false,CollectionUtil.isEmpty(res));
        if(!CollectionUtil.isEmpty(res)){
            for(RowSimpleDto rowDto:res){
                Map<String,String> valueMap = rowDto.getValues();
                assertNotNull(valueMap.get(col2));
                assertNull(valueMap.get(col1));
            }
        }
    }


    /**
     * keylist为空
     * @throws Exception
     */
    @Test
    public void testGetRowsNullRowKeyList() throws Exception {
        exp.expect(NullPointerException.class);
        hbaseService.selectRows(tabName,null);
    }

    /**
     * table参数为空
     * @throws Exception
     */
    @Test
    public void testGetRowsNullTab() throws Exception{
        exp.expect(NullPointerException.class);
        hbaseService.selectRows(null,null);
    }

	
	
}

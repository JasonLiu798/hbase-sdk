package com.jason798.hbase.util;

import java.util.Map;

import com.jason798.hbase.model.constant.HbaseConstant;

/**
 */
public class HbaseHelper {
    private static String[] metaKey = {"tableName", "rowKey", "columnFamily"};
    private static String[] metaTabRK = {"tableName", "rowKey"};

    /**
     * filter TestModelBase field
     *
     * @param map void
     */
    public static <V> void filterMeta(Map<String, V> map) {
        CollectionHelper.filterMap(map, metaKey);
    }

    public static Map<String, String> getTabRk(Object obj) throws Exception {
        Map<String, String> fieldMap = BeanHelper.getFieldMapAllSpec(obj, metaTabRK);
        return fieldMap;
    }

    public static String filterColumnFamily(String columnFamily) {
        if (StringHelper.isEmpty(columnFamily)){
            columnFamily = HbaseConstant.DFT_COL_FAMILY;
        }
        return columnFamily;
    }

    public static int filterLimit(Integer limit) {
        if (limit ==null || limit<=0){
            return HbaseConstant.DFT_SELECT_MAX_SIZE;
        }
        return limit;
    }

    /**
     * Check rowKey.
     *
     * <pre>
     * rowKey is not null.
     * the result of rowKey's toBytes is not null.
     * </pre>
     *
     *
     public static void checkRowKey(RowKey rowKey) {
     checkNull(rowKey);

     if (rowKey.toBytes() == null) {
     throw new HBaseException("rowkey bytes is null. rowKey = "
     + rowKey);
     }
     }*/

    /**
     * Check rowKey list.
     *
     * <pre>
     * rowKeyList is not null or empty.
     * each row key in list is valid.
     * </pre>
     *
     *
     public static void checkRowKeyList(List<RowKey> rowKeyList) {
     Util.checkNull(rowKeyList);
     Util.check(!rowKeyList.isEmpty());

     for (RowKey rowKey : rowKeyList) {
     Util.checkRowKey(rowKey);
     }
     } */


    /**
     * Check put request.
     *
     public static void checkPutRequest(PutRequest<?> putRequest) {
     checkNull(putRequest);
     checkRowKey(putRequest.getRowKey());
     checkNull(putRequest.getT());
     }*/

    /**
     * Check Delete request.
     *
     public static void checkDeleteRequest(DeleteRequest deleteRequest) {
     checkNull(deleteRequest);
     checkRowKey(deleteRequest.getRowKey());
     }*/

    /**
     * Close Closeable.
     * <p>
     * public static void close(@Nullable Closeable closeable) {
     * if (closeable == null) {
     * return;
     * }
     * try {
     * closeable.close();
     * } catch (IOException e) {
     * throw new HBaseException("close closeable exception.", e);
     * }
     * }
     */

    private HbaseHelper() {
    }

}

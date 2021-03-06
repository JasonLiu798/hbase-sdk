package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.param.crud.base.PutRowParam;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class PutRowAction extends PutRowBaseAction implements CRUDParamReturnAction<PutRowParam, Integer> {

    public PutRowAction(String tableName) {
        super(tableName);
    }

    @Override
    public Integer service(Table table, PutRowParam param) throws HBaseException {
        byte[] rowKey = Bytes.toBytes(param.getRowKey());
        if (param.isCheckExist()) {
            checkRowExist(table, rowKey);
        }
        Put put = new Put(rowKey);
        putString(put, param.getColumnFamily(), param.getValues());
        try {
            table.put(put);
        } catch (IOException e) {
            throw new HBaseIOException();
        }
        return 0;
    }


}

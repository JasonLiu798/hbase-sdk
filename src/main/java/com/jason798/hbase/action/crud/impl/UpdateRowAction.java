package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.model.param.crud.base.PutRowParam;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class UpdateRowAction extends CRUDBaseAction implements CRUDParamReturnAction<PutRowParam,Integer> {

    public UpdateRowAction(String tableName) {
        super(tableName);
    }

    @Override
    public Integer service(Table table, PutRowParam param) throws HBaseException {
        byte[] rk = Bytes.toBytes(param.getRowKey());
        Get get = new Get(rk);
        boolean tableExist = false;
        try {
            tableExist = table.exists(get);
        } catch (IOException e) {
            throw new HBaseIOException();
        }
        if (!tableExist) {
            throw new HBaseException(String.format("hbase update row,row not exist %s", param.getRowKey()));
        }
        Put put = new Put(Bytes.toBytes(param.getRowKey()));
        for (Map.Entry<String, String> entry : param.getValues().entrySet()) {
            if (entry.getValue() != null) {
                put.addColumn(Bytes.toBytes(param.getColumnFamily()),
                        Bytes.toBytes(entry.getKey()),
                        Bytes.toBytes(entry.getValue()));
            }
        }
        try {
            table.put(put);
        } catch (IOException e) {
            throw new HBaseIOException();
        }
        return 0;
    }


	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_PUT;
	}
}

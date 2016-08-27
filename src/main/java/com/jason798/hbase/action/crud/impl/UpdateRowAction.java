
package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.model.param.crud.base.PutRowParam;
import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import java.util.Map;

/**
 * update row
 */
public class UpdateRowAction extends CRUDBaseAction implements CRUDParamReturnAction<PutRowParam,Integer> {

    public UpdateRowAction(String tableName) {
        super(tableName);
    }

    @Override
    public Integer service(Table table, PutRowParam param) throws Exception {
        byte[] rk = Bytes.toBytes(param.getRowKey());
        Get get = new Get(rk);
        boolean tableExist = table.exists(get);
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
        table.put(put);
        return 0;
    }


	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_PUT;
	}
}

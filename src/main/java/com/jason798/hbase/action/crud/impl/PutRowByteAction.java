
package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.util.CollectionHelper;
import com.jason798.hbase.model.param.crud.PutRowByteParam;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * insert row with byte
 */
public class PutRowByteAction extends PutRowBaseAction implements CRUDParamReturnAction<PutRowByteParam,Integer> {

	public PutRowByteAction(String tableName) {
		super(tableName);
	}

	/**
	 *
	 * @param table
	 * @param param
	 *		values: nullable
	 * 		byteValues: notnullable,and type match byte[]
	 *
	 * @throws Exception
	 */
	@Override
	public Integer service(Table table, PutRowByteParam param) throws Exception {
		byte[] rowkey = Bytes.toBytes(param.getRowKey());
		if(param.isCheckExist()){
			checkRowExist(table,rowkey);
		}
		Put put = new Put(rowkey);
		if(!CollectionHelper.isEmpty(param.getValues())){
			putString(put, param.getColumnFamily(),param.getValues());
		}
		putByte(put,param.getColumnFamily(), param.getByteValuess());
		table.put(put);
		return 0;
	}


}

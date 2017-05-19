package com.jason798.hbase.action.crud.impl;

import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.param.crud.PutRowByteParam;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 *
 * @author JasonLiu798
 * @since 1.0
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
	public Integer service(Table table, PutRowByteParam param) throws HBaseException {
		byte[] rowkey = Bytes.toBytes(param.getRowKey());
		if(param.isCheckExist()){
			checkRowExist(table,rowkey);
		}
		Put put = new Put(rowkey);
		if(!CollectionUtil.isEmpty(param.getValues())){
			putString(put, param.getColumnFamily(),param.getValues());
		}
		putByte(put,param.getColumnFamily(), param.getByteValuess());
		try {
			table.put(put);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		return 0;
	}


}

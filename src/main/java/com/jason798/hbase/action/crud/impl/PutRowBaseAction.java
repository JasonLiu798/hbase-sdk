package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.api.HBaseException;

import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.Map;

/**
 * insert base
 */
public class PutRowBaseAction extends CRUDBaseAction {

	public PutRowBaseAction(String tableName) {
		super(tableName);
	}

	/**
	 * for update
	 * @param tab
	 * @param rowKey
	 * @throws Exception
	 */
	protected void checkRowExist(Table tab,byte[] rowKey) throws Exception {
		Get get = new Get(rowKey);
		if( !tab.exists(get)){
			throw new HBaseException("update row not exist!");
		}
	}

	/**
	 * for insert
	 * @param put
	 * @param columnFamily
	 * @param param
	 * @return
	 */
	protected Put putString(Put put, String columnFamily, Map<String, String> param) {
		for (Map.Entry<String, String> entry : param.entrySet()) {
			String value = entry.getValue();
			if (value != null) {
				put.addColumn(Bytes.toBytes(columnFamily),
						Bytes.toBytes(entry.getKey()),
						Bytes.toBytes(entry.getValue()));
			}
		}
		return put;
	}

	/**
	 * for insert
	 * @param put
	 * @param columnFamily
	 * @param bytes K:qualifer,V:byte[]
	 * @return
	 */
	protected Put putByte(Put put, String columnFamily, Map<String,Object> bytes) {
		for(String key:bytes.keySet()) {
			put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(key), (byte[])bytes.get(key));
		}
		return put;
	}

	public String getActionName() {
		return HbaseConstant.ACTION_PUT;
	}
}

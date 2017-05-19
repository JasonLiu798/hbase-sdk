package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.constant.HbaseConstant;
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
	protected void checkRowExist(Table tab,byte[] rowKey) throws HBaseException {
		Get get = new Get(rowKey);
		try {
			if( !tab.exists(get)){
                throw new HBaseException("row not exist");
            }
		} catch (IOException e) {
			throw new HBaseIOException();
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
	 * @param byteMap K:qualifer,V:byte[]
	 * @return
	 */
	protected Put putByte(Put put, String columnFamily, Map<String,Object> byteMap) {
		for(Map.Entry<String,Object> entry:byteMap.entrySet()) {
			String key = entry.getKey();
			byte[] byteArr = (byte[]) entry.getValue();
			put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(key), byteArr);
		}
		return put;
	}

	public String getActionName() {
		return HbaseConstant.ACTION_PUT;
	}
}

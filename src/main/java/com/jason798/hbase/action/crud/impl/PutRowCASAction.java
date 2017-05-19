package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.CASValue;
import com.jason798.hbase.model.param.crud.PutRowCASParam;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class PutRowCASAction extends PutRowBaseAction implements CRUDParamReturnAction<PutRowCASParam,Boolean> {

	public PutRowCASAction(String tableName) {
		super(tableName);
	}

	@Override
	public Boolean service(Table table, PutRowCASParam param) throws HBaseException {
		byte[] rowKey = Bytes.toBytes(param.getRowKey());
		byte[] familyName = Bytes.toBytes(param.getFamilyName());
		Boolean res = false;
		Put put = new Put(rowKey);
		CASValue casValue = param.getValue();
		if ( casValue != null) {
			byte[] qualifier = Bytes.toBytes(param.getQualifer());
			byte[] value =  Bytes.toBytes(casValue.getValue());
			put.addColumn(familyName,qualifier,value);
			byte[] expectValue =  Bytes.toBytes(casValue.getExpectValue());
			try {
				res = table.checkAndPut(rowKey, familyName, qualifier, expectValue, put);
			} catch (IOException e) {
				throw new HBaseIOException();
			}
		}
		return res;
	}


}

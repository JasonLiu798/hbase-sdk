package com.jason798.hbase.action.crud.impl;


import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.CASValue;
import com.jason798.hbase.model.param.crud.PutRowCASParam;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * insert CAS
 */
public class PutRowCASAction extends PutRowBaseAction implements CRUDParamReturnAction<PutRowCASParam,Boolean> {

	public PutRowCASAction(String tableName) {
		super(tableName);
	}

	@Override
	public Boolean service(Table table, PutRowCASParam param) throws Exception {
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
			res = table.checkAndPut(rowKey, familyName, qualifier, expectValue, put);
		}
		return res;
	}


}

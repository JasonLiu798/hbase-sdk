package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.model.param.crud.SelectRowParam;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * get one row
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class GetRowAction extends GetRowBaseAction implements
		CRUDParamReturnAction<SelectRowParam, RowSimpleDto> {
	
	public GetRowAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public RowSimpleDto service(Table table, SelectRowParam param) throws HBaseException {
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey
		addFilter(get, param.getColumnFamily(), param.getColumnList());
		
		Result result = null;
		try {
			result = table.get(get);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		RowSimpleDto res = result2RowDto(result);
		return res;
	}
	
}

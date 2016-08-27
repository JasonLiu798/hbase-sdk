package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.RowDto;
import com.jason798.hbase.model.param.crud.SelectRowParam;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;


/**
 * get row
 */
public class GetRowAction extends GetRowBaseAction implements
		CRUDParamReturnAction<SelectRowParam, RowDto> {

	public GetRowAction(String tableName) {
		super(tableName);
	}

	@Override
	public RowDto service(Table table, SelectRowParam param) throws Exception {
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey
		addFilter(get,param.getColumnFamily(),param.getColumnList());

		Result result = table.get(get);
		RowDto res = result2RowDto(result);
		return res;
	}

}

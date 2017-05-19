package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.param.crud.SelectRowParam;
import com.jason798.hbase.model.resp.RowModelByte;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * get row bytes
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class GetRowByteAction extends GetRowBaseAction implements
		CRUDParamReturnAction<SelectRowParam, RowModelByte> {

	public GetRowByteAction(String tableName) {
		super(tableName);
	}

	@Override
	public RowModelByte service(Table table, SelectRowParam param) throws HBaseException {
		RowModelByte res = new RowModelByte();
		Map<String, Object> values = new HashMap<>();
		
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey

		addFilter(get,param.getColumnFamily(),param.getColumnList());
		List<String> byteColumns = Arrays.asList(param.getByteColumns());

		Result result = null;
		try {
			result = table.get(get);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		List<Cell> list = result.listCells();
		if (list != null) {
			for (Cell cell : list) {
				String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
				Object value = null;
				byte[] byteValue = CellUtil.cloneValue(cell);
				if(byteColumns.indexOf(qualifier)<0){
					value = Bytes.toString(byteValue);
				}else{
					value = byteValue;
				}
				values.put(qualifier, value);
			}
		}
		res.setRowKey(param.getRowKey());
		res.setColumnFamily(param.getColumnFamily());
		res.setValues(values);
		return res;
	}

}

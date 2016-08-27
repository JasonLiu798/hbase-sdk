package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.resp.RowMultiColFamilyModel;
import com.jason798.hbase.model.RowKeyParam;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GetRowMultiColFamilyAction extends GetRowBaseAction implements
		CRUDParamReturnAction<RowKeyParam, RowMultiColFamilyModel> {

	public GetRowMultiColFamilyAction(String tableName) {
		super(tableName);
	}

	@Override
	public RowMultiColFamilyModel service(Table table, RowKeyParam param) throws Exception {
		RowMultiColFamilyModel res = new RowMultiColFamilyModel();
		Map<String, Map<String, String>> values = new HashMap<>();
		
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey

		Result result = table.get(get);
		List<Cell> list = result.listCells();
		if (list != null) {
			for (Cell cell : list) {
				String familyKey = Bytes.toString(CellUtil.cloneFamily(cell));
				String qualifier = Bytes
						.toString(CellUtil.cloneQualifier(cell));
				String value = Bytes.toString(CellUtil.cloneValue(cell));
				Map<String, String> qualifiers = values.get(familyKey);
				if (qualifiers == null) {
					qualifiers = new HashMap<>();
					qualifiers.put(qualifier, value);
					values.put(familyKey, qualifiers);
				} else {
					qualifiers.put(qualifier, value);
				}
			}
		}
		res.setRowKey(param.getRowKey());
		res.setValues(values);
		return res;
	}

}

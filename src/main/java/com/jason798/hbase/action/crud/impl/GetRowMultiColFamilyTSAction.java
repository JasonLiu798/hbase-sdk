package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.RowKeyParam;
import com.jason798.hbase.model.ValueTS;
import com.jason798.hbase.model.resp.RowMultiColFamilyTsModel;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JasonLiu798
 * @since 1.0
 */
public class GetRowMultiColFamilyTSAction extends GetRowBaseAction implements
		CRUDParamReturnAction<RowKeyParam, RowMultiColFamilyTsModel> {
	
	public GetRowMultiColFamilyTSAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public RowMultiColFamilyTsModel service(Table table, RowKeyParam param) throws HBaseException {
		
		RowMultiColFamilyTsModel res = new RowMultiColFamilyTsModel();
		Map<String, Map<String, ValueTS>> values = new HashMap<>();
		
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey
		
		Result result = null;
		try {
			result = table.get(get);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		List<Cell> list = result.listCells();
		if (list != null) {
			for (Cell cell : list) {
				String familyKey = Bytes.toString(CellUtil.cloneFamily(cell));
				String qualifier = Bytes
						.toString(CellUtil.cloneQualifier(cell));
				ValueTS value = new ValueTS(Bytes.toString(CellUtil
						.cloneValue(cell)), cell.getTimestamp());
				Map<String, ValueTS> qualifiers = values.get(familyKey);
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

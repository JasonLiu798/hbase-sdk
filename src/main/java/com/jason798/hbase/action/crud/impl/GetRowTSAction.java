package com.jason798.hbase.action.crud.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.ValueTS;
import com.jason798.hbase.model.resp.RowKeyColfamilyParam;
import com.jason798.hbase.model.resp.RowTsModel;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * get rows adn timestamps
 */
public class GetRowTSAction extends GetRowBaseAction implements
		CRUDParamReturnAction<RowKeyColfamilyParam, RowTsModel> {

	public GetRowTSAction(String tableName) {
		super(tableName);
	}

	@Override
	public RowTsModel service(Table table, RowKeyColfamilyParam param) throws Exception {
		
		RowTsModel res = new RowTsModel();
		Map<String, ValueTS> values = new HashMap<>();
		
		//set condition
		Get get = new Get(Bytes.toBytes(param.getRowKey()));//rowkey
		
		Result result = table.get(get);
		List<Cell> list = result.listCells();
		if (list != null) {
			for (Cell cell : list) {
				String familyKey = Bytes.toString(CellUtil.cloneFamily(cell));
				if(!familyKey.equals(param.getColumnFamily())){
					continue;
				}
				String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
				ValueTS value = new ValueTS(Bytes.toString(CellUtil.cloneValue(cell)), cell.getTimestamp());
				values.put(qualifier, value);
			}
		}
		res.setRowKey(param.getRowKey());
		res.setValues(values);
		return res;
	}

}

package com.jason798.hbase.action.crud.impl;

import com.jason798.character.StringCheckUtil;
import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.model.param.crud.ScanCondition;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * scan row
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ScanRowAction extends ScanRowBaseAction implements
		CRUDParamReturnAction<ScanCondition, List<RowSimpleDto>> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ScanRowAction.class);
	
	public ScanRowAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public List<RowSimpleDto> service(Table table, ScanCondition sc) throws HBaseException {
		Scan scan = generateScan(sc);
		String scolumnFamily = HbaseConstant.DFT_COL_FAMILY;
		String singleColumn = sc.getSingleColumn();
		if (StringCheckUtil.isNotEmpty(singleColumn)) {
			scolumnFamily = singleColumn;
		}
		/**
		 * start RPC
		 */
		ResultScanner rs = null;
		List<RowSimpleDto> res = new LinkedList<>();
		try {
			rs = table.getScanner(scan);
			int count = 0;
			for (Result r : rs) {
				if (sc.getManualPageFilter() && count >= sc.getLimit()) {
					break;
				}
				RowSimpleDto rowDto = new RowSimpleDto();
				//Map<String, String> map = new HashMap<>();
				List<Cell> cells = r.listCells();
				if (CollectionUtil.isEmpty(cells)) {
					continue;
				}
				String rowKey = Bytes.toString(r.getRow());
				Map<String, String> values = new HashMap<>();
				for (Cell cell : cells) {
					String columnFamily = Bytes.toString(CellUtil.cloneFamily(cell));
					if (columnFamily.equals(scolumnFamily)) {
						values.put(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
					}
				}
				rowDto.setRowkey(rowKey);
				rowDto.setValues(values);
				res.add(rowDto);
				count++;
			}
		} catch (Exception e) {
			throw new HBaseIOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return res;
	}
	
	
}

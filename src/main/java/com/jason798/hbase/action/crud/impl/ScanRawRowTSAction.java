package com.jason798.hbase.action.crud.impl;

import com.jason798.character.StringCheckUtil;
import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.RowRawTSDto;
import com.jason798.hbase.api.RowRawTSPkgDto;
import com.jason798.hbase.model.ValueTS;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ScanRawRowTSAction extends ScanRowBaseAction implements
		CRUDParamReturnAction<ScanCondition, RowRawTSPkgDto> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ScanRawRowTSAction.class);
	
	public ScanRawRowTSAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public RowRawTSPkgDto service(Table table, ScanCondition sc) throws HBaseException {
		Scan scan = generateScan(sc);
		String scolumnFamily = HbaseConstant.DFT_COL_FAMILY;
		String singleColumn = sc.getSingleColumn();
		if (StringCheckUtil.isNotEmpty(singleColumn)) {
			scolumnFamily = singleColumn;
		}
		
		RowRawTSPkgDto resDto = new RowRawTSPkgDto();
		/**
		 * start RPC
		 */
		ResultScanner rs = null;
		List<RowRawTSDto> list = new LinkedList<>();
		try {
			rs = table.getScanner(scan);
			
			int count = 0;
			RowRawTSDto lastRow = null;
			for (Result r : rs) {
//                if(sc.getManualPageFilter() && count>=sc.getLimit()){
//                    break;
//                }
				RowRawTSDto rowDto = new RowRawTSDto();
				//Map<String, String> map = new HashMap<>();
				List<Cell> cells = r.listCells();
				if (CollectionUtil.isEmpty(cells)) {
					continue;
				}
				String rowKey = Bytes.toString(r.getRow());
				if (count == 0) {
					resDto.setStartKey(rowKey);
				}
				Map<String, ValueTS> values = new HashMap<>();
				for (Cell cell : cells) {
					String columnFamily = Bytes.toString(CellUtil.cloneFamily(cell));
					if (columnFamily.equals(scolumnFamily)) {
						long ts = cell.getTimestamp();
						ValueTS valueTS = new ValueTS(Bytes.toString(CellUtil.cloneValue(cell)), ts);
						values.put(Bytes.toString(CellUtil.cloneQualifier(cell)), valueTS);
					}
				}
				rowDto.setRowkey(rowKey);
				rowDto.setValues(values);
				list.add(rowDto);
				lastRow = rowDto;
				count++;
			}
			if (list.size() > 0) {
				if (lastRow != null) {
					resDto.setEndKey(lastRow.getRowkey());
				}
			}
			resDto.setRows(list);
		} catch (IOException e) {
			throw new HBaseIOException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return resDto;
	}
	
	
}

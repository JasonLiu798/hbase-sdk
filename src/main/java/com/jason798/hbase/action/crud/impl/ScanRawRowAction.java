package com.jason798.hbase.action.crud.impl;

import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.RowRawDto;
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
import java.util.LinkedList;
import java.util.List;

/**
 * @author JasonLiu798
 * @since 1.0
 */
public class ScanRawRowAction extends ScanRowBaseAction implements
		CRUDParamReturnAction<ScanCondition, List<RowRawDto>> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ScanRawRowAction.class);
	
	public ScanRawRowAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public List<RowRawDto> service(Table table, ScanCondition sc) {
		Scan scan = generateScan(sc);
		ResultScanner rs = null;
		List<RowRawDto> res = new LinkedList<>();
		try {
			rs = table.getScanner(scan);
			for (Result r : rs) {
				List<Cell> cells = r.listCells();
				if (CollectionUtil.isEmpty(cells)) {
					continue;
				}
				String rowKey = Bytes.toString(r.getRow());
				for (Cell cell : cells) {
					RowRawDto rowDto = new RowRawDto();
					rowDto.setRowkey(rowKey);
					rowDto.setColumnFamily(Bytes.toString(CellUtil.cloneFamily(cell)));
					rowDto.setQualifer(Bytes.toString(CellUtil.cloneQualifier(cell)));
					rowDto.setValue(Bytes.toString(CellUtil.cloneValue(cell)));
					rowDto.setTimestamp(cell.getTimestamp());
					res.add(rowDto);
				}
			}
		} catch (IOException e) {
			throw new HBaseIOException();
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return res;
	}
	
	
}


package com.jason798.hbase.action.crud.impl;

import com.jason798.character.StringCheckUtil;
import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.model.param.crud.ScanCondition;
import org.apache.hadoop.hbase.HConstants;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * scan row base
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ScanRowBaseAction extends CRUDBaseAction {
	private static final Logger LOG = LoggerFactory.getLogger(ScanRowBaseAction.class);
	
	public ScanRowBaseAction(String tableName) {
		super(tableName);
	}
	
	public String getActionName() {
		return HbaseConstant.ACTION_SCAN;
	}
	
	public Scan generateScan(ScanCondition sc) {
		Scan scan = new Scan();
		/**
		 * SingleColumnValueFilter(
		 * 	final byte [] family,
		 * 	final byte [] qualifier,
		 * 	final CompareOp compareOp,
		 * 	final byte[] value )
		 **
		 Filter filter = new SingleColumnValueFilter(
		 Bytes.toBytes("info"), Bytes.toBytes("id"), CompareOp.EQUAL, Bytes.toBytes("1"));
		 */
		FilterList filterList = new FilterList();
		//start key
		String startRowkey = sc.getStartRowKey();
		if (StringCheckUtil.isNotEmpty(startRowkey)) {
			scan.setStartRow(Bytes.toBytes(startRowkey));
		} else {
			scan.setStartRow(HConstants.EMPTY_START_ROW);
		}
		
		//end key
		String endRowkey = sc.getEndRowKey();
		if (StringCheckUtil.isNotEmpty(endRowkey)) {
			scan.setStopRow(Bytes.toBytes(endRowkey));
		} else {
			scan.setStopRow(HConstants.EMPTY_END_ROW);
		}
		
		//row key prefix
		String rowkeyPrefix = sc.getRowKeyPrefix();
		if (StringCheckUtil.isNotEmpty(rowkeyPrefix)) {
			//scan.setRowPrefixFilter(Bytes.toBytes(rowkeyPrefix));
			Filter prefixFilter = new PrefixFilter(Bytes.toBytes(rowkeyPrefix));
			filterList.addFilter(prefixFilter);
		}
		
		long endTime = Long.MAX_VALUE;
		if (sc.getEndTimestamp() != null) {
			endTime = sc.getEndTimestamp();
		}
		long startTime = 0;
		if (sc.getStartTimestamp() != null) {
			startTime = sc.getStartTimestamp();
		}
		try {
			scan.setTimeRange(startTime, endTime);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (sc.getTimestamp() != null) {
			try {
				scan.setTimeStamp(sc.getTimestamp());
			} catch (IOException e) {
				throw new HBaseIOException("set timestamps", e);
			}
		}
		
		//limit
		//scan.setMaxResultSize(sc.getLimit());
		if (sc.getLimit() != null) {
			/**
			 * cannot guarantee that the number of results returned
			 * to a client are <= page size. This is because the filter
			 * is applied separately on different region servers.
			 *
			 * need manual filter
			 */
			Filter pageFilter = new PageFilter(sc.getLimit());
			filterList.addFilter(pageFilter);
		}
		
		//scan.setMaxVersions();
		//add column familys
		Map<String, List<String>> columnQualifier = sc.getColumnQualifier();
//		String scolumnFamily = HbaseConstant.DFT_COL_FAMILY;
		if (!CollectionUtil.isEmpty(columnQualifier)) {
			//int i=0;
			for (Map.Entry<String, List<String>> entry : columnQualifier.entrySet()) {
				String column = entry.getKey();
//				scolumnFamily = column;
				List<String> specColumns = entry.getValue();
				if (CollectionUtil.isEmpty(specColumns)) {//qualifier not speified
					scan.addFamily(Bytes.toBytes(column));
				} else {
					for (String specColumn : specColumns) {
						byte[] family = Bytes.toBytes(column);
						scan.addColumn(family, Bytes.toBytes(specColumn));
					}
				}
				break;//only get first one columnfamily
			}
		}
		
		
		if (CollectionUtil.isNotEmpty(filterList.getFilters())) {
			scan.setFilter(filterList);
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("scan condition {}", scan);
		}
		return scan;
	}
	
	
}

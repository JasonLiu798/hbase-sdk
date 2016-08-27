
package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.model.param.crud.PutRowsParam;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;

/**
 * insert rows to one table
 */
public class PutRowListAction extends PutRowBaseAction implements CRUDParamReturnAction<PutRowsParam,Integer> {
	private static final Logger LOGGER = LoggerFactory.getLogger(PutRowListAction.class);

	public PutRowListAction(String tableName) {
		super(tableName);
	}

	/**
	 * single table ,multi rows insert
	 * @param table Table
	 * @param param put parameter
	 * @throws Exception IOException,HbaseException
	 */
	@Override
	public Integer service(Table table, PutRowsParam param) throws Exception {
		List<Put> puts = new LinkedList<>();
		List<RowSimpleDto> rowDtoList = param.getValues();
		boolean checkExist = param.isCheckExist();
		for(RowSimpleDto rowKey:rowDtoList){
			byte[] rowKeyByte = Bytes.toBytes(rowKey.getRowkey());
			if(checkExist){
				Get get = new Get(rowKeyByte);
				boolean exist = table.exists(get);
				if(!exist){
					throw new HBaseException(String.format("update rows,row %s not exist",rowKey.getRowkey()));
				}
			}
			Put put = new Put(Bytes.toBytes(rowKey.getRowkey()));
			putString(put, param.getColumnFamily(),rowKey.getValues());
			puts.add(put);
		}

		if(LOGGER.isDebugEnabled())
			LOGGER.debug("put list :{}",puts);
		table.put(puts);
		return 0;
	}


}

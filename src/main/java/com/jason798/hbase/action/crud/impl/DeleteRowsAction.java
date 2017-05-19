
package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.RowKeysParam;
import com.jason798.hbase.model.constant.HbaseConstant;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * delete rows
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class DeleteRowsAction extends CRUDBaseAction implements CRUDParamReturnAction<RowKeysParam, Integer> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRowsAction.class);
	
	public DeleteRowsAction(String tableName) {
		super(tableName);
	}
	
	@Override
	public Integer service(Table table, RowKeysParam param) throws HBaseException {
		List<String> rowkeys = param.getRowKeys();
		List<Delete> deletes = new LinkedList<>();
		for (String rowKey : rowkeys) {
			Delete delete = new Delete(Bytes.toBytes(rowKey));
			deletes.add(delete);
		}
		if (LOGGER.isDebugEnabled())
			LOGGER.debug("batch deleteOne list:{}", deletes);
		try {
			table.delete(deletes);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		return 0;
	}
	
	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_DELETE;
	}
	
}

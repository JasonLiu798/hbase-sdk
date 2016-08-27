package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.RowKeysParam;
import com.jason798.hbase.model.constant.HbaseConstant;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;

/**
 * delete rows
 */
public class DeleteRowsAction extends CRUDBaseAction implements CRUDParamReturnAction<RowKeysParam,Integer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRowsAction.class);

	public DeleteRowsAction(String tableName) {
		super(tableName);
	}

	@Override
	public Integer service(Table table, RowKeysParam param) throws Exception {
		param.getRowKeys();
		List<Delete> deletes = new LinkedList<>();
		for(String rowKey:param.getRowKeys()) {
			Delete delete = new Delete(Bytes.toBytes(rowKey));
			deletes.add(delete);
		}
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("batch delete list:{}",deletes);
		table.delete(deletes);
		return 0;
	}

	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_DELETE;
	}

}

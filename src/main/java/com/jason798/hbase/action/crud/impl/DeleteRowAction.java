package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.model.RowKeyParam;
import com.jason798.hbase.model.constant.HbaseConstant;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * delete row
 */
public class DeleteRowAction extends CRUDBaseAction implements CRUDParamReturnAction<RowKeyParam,Integer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRowAction.class);

	public DeleteRowAction(String tableName) {
		super(tableName);
	}

	@Override
	public Integer service(Table table, RowKeyParam param) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("delete action service ,table {},param {}",tableName,param);
		Delete delete = new Delete(Bytes.toBytes(param.getRowKey()));
		//Get get = new Get(Bytes.toBytes(param.getRowKey()));
		table.delete(delete);
		return 0;
	}

	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_DELETE;
	}


}

package com.jason798.hbase.action.crud.impl;

import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.RowKeyParam;
import com.jason798.hbase.model.constant.HbaseConstant;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * delete one row
 * @author JasonLiu798
 * @since 1.0
 */
public class DeleteRowAction extends CRUDBaseAction implements CRUDParamReturnAction<RowKeyParam, Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRowAction.class);

    public DeleteRowAction(String tableName) {
        super(tableName);
    }

    @Override
    public Integer service(Table table, RowKeyParam param) throws HBaseException {
    	if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("deleteOne action service ,table {},param {}", tableName, param);
		}
        Delete delete = new Delete(Bytes.toBytes(param.getRowKey()));
        //Get get = new Get(Bytes.toBytes(param.getRowKey()));
        try {
            table.delete(delete);
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

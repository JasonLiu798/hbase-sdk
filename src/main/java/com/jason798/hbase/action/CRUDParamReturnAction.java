package com.jason798.hbase.action;

import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD
 *
 * @author JasonLiu798
 * @since 1.0
 */
public interface CRUDParamReturnAction<P,R> extends ActionBase{
	R service(Table table,P param) throws HBaseException;
	String getTable();
}

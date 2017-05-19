package com.jason798.hbase.action;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD
 *
 * @author JasonLiu798
 * @since 1.0
 */
public interface CRUDReturnAction<T> {
	T service(Table table) throws Exception;
	TableName getTable();
}

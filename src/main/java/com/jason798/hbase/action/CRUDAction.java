package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Table;

/**
 * CRUD
 *
 * @author JasonLiu798
 * @since 1.0
 */
public interface CRUDAction extends ActionBase {
	void service(Table table) throws Exception;
	
	String getTable();
}

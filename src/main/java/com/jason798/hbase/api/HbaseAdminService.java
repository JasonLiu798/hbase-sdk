package com.jason798.hbase.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * hbase admin service interface
 *
 */
public interface HbaseAdminService {
	/**
	 * check
	 * @return
	 */
	public int isHbaseAvailable();
	public boolean isTableAvailable(String tableName) throws Exception;
	/**
	 * create
	 * @param tableName
	 * @param columnFamily
	 * @throws Exception
	 */
	public  void createTable(String tableName, String columnFamily)  throws Exception;
	/**
	 * delete
	 * @param tableName
	 * @throws Exception
	 */
	public void deleteTable(String tableName) throws Exception;
	/**
	 * enable,disable
	 * @param tableName
	 * @throws Exception
	 */
	public void enableTable(String tableName) throws Exception;
	public void disableTable(String tableName) throws Exception;
	
	/**
	 * list
	 * @return
	 * @throws IOException
	 */
	public String[] listTablesName() throws IOException;
}

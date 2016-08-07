package com.jason798.hbase.api;

import com.jason798.hbase.model.DataValue;

import java.util.List;
import java.util.Map;

/**
 * hbase search/insert/delete/update service
 */
public interface HbaseCRUDService {


	/**
	 *  --------------------create--------------------------
	 */
	public int putData(String tableName, DataValue dataValue) throws Exception;


	/**
	 *  --------------------read--------------------------
	 */
	/**
	 * list
	 * @param tableName
	 * @param rowKey
	 * @return
	 * @throws Exception
	 */
	public List<DataValue> getRowByRowKey(String tableName,String rowKey)  throws Exception;


	/**
	 * --------------------update--------------------------
	 */
	/**
	 *
	 * @param tableName
	 * @param rowKey
	 * @param familyName
	 * @param columnLst
	 * @throws Exception
	 */
	public  void updateRow(String tableName, String rowKey,
			String familyName, Map<String, String> columnLst)  throws Exception ;

	public void updateValue(String tableName, String rowKey, String familyName,
			Map<String, String> columnLst,byte[] valueBytes)  throws Exception ;


	/**
	 * --------------------delete--------------------------
	 */
	/**
	 *
	 * @param tableName
	 * @param rowKey
	 * @throws Exception
	 */
	public  void deleteRow(String tableName, String rowKey)  throws Exception;




}

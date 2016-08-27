
package com.jason798.hbase.api;

import com.jason798.hbase.core.NotNullable;
import com.jason798.hbase.core.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * hbase api
 * TODO:implement execute(),refactor executeQuery,refactor interface suppert multi columnfamily;select add condition
 */
public interface HbaseService {
	
	/**
	 * update,delete sql
	 * @param sql
	 * @throws Exception
	 */
	public void execute(@NotNullable String sql) throws Exception;

	/**
	 * execute select sql
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<RowSimpleDto> executeQuery(@NotNullable String sql) throws Exception;

	/**
	 * insert one row
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily  @throws Exception
	 * @param param   */
	void insert(@NotNullable String tableName, @NotNullable String rowKey, @Nullable String columnFamily, @NotNullable Map<String, String> param) throws Exception;

	/**
	 * insert one row ,default column family
	 * @param tableName
	 * @param rowKey
	 * @param param
	 * @throws Exception
	 */
	void insert(@NotNullable String tableName,@NotNullable String rowKey, @NotNullable Map<String, String> param) throws Exception;

	/**
	 * insert many rows to one table
	 * @param tableName
	 * @param columnFamily
	 * @param param key:rowKey,value:qulifer,value
	 * @throws Exception
	 */
	void insertRows(@NotNullable String tableName, String columnFamily, @NotNullable List<RowSimpleDto> param) throws Exception;
	void insertRows(@NotNullable String tableName, @NotNullable List<RowSimpleDto> param) throws Exception;

	/**
	 * insert one row ,with bytes
	 * for store PDF,and its meta infos
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily
	 * @param byteValues
	 * @param param    @throws Exception    */
	void insertWithBytes(@NotNullable String tableName,@NotNullable String rowKey,@Nullable String columnFamily, @NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception;
	void insertWithBytes(@NotNullable String tableName,@NotNullable String rowKey, @NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception;

	/**
	 * delete one row
	 * @param tableName columnfamil can be null
	 * @param rowKey
	 */
	void deleteByRowKey(@NotNullable String tableName, String rowKey) throws Exception;

	/**
	 * batch delete
	 * @param tableName rowkey not used
	 * @param rowkeys
	 * @throws Exception
	 */
	void deleteByRowKeys(@NotNullable String tableName, @NotNullable List<String> rowkeys) throws Exception;


	/**
	 * update one row
	 * @param tableName ,all field not null ,rowKey must exist
	 * @param rowKey
	 *@param columnFamily
	 * @param param not null,size >=1  @throws Exception
	 */
	void update(@NotNullable String tableName,@NotNullable String rowKey,@Nullable String columnFamily, @NotNullable Map<String, String> param) throws Exception;

	/**
	 * update one row ,default column family
	 * @param tableName
	 * @param rowKey
	 * @param param
	 * @throws Exception
	 */
	void update(@NotNullable String tableName,@NotNullable String rowKey,@NotNullable Map<String, String> param) throws Exception;

	/**
	 * update one row CAS
	 * @param tableName
	 * @param rowKey
	 *@param columnFamily
	 * @param qualifer
	 * @param value
	 * @param expectValue    @return
	 * @throws Exception
	 */
	boolean updateCAS(@NotNullable String tableName, String rowKey, String columnFamily, @NotNullable String qualifer, String value, String expectValue) throws Exception;

	/**
	 * update one table batch rows
	 * @param tableName rowKey
	 * @param columnFamily
	 * @param param K:rowKey,V:[K:qualifer,V:value]  @throws Exception
	 * */
	void updateRows(@NotNullable String tableName, String columnFamily, @NotNullable List<RowSimpleDto> param) throws Exception;

	/**
	 * update different table batch rows
	 * @param param
	 * @throws Exception
	 *
	public void update(@NotNullable Map<TableDto,List<Map<String,String>>> param) throws Exception;*/

	/**
	 * update row with byte[]
	 * @param tableName ,all field not null ,rowKey must exist
	 * @param rowKey
	 * @param columnFamily
	 * @param byteValues   @throws Exception
	 * @param param
	 * */
	void updateWithBytes(@NotNullable String tableName, @NotNullable String rowKey, @Nullable String columnFamily, @NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception;
	void updateWithBytes(@NotNullable String tableName,@NotNullable String rowKey, @Nullable Map<String, String> param, @NotNullable Map<String, Object> byteValues) throws Exception;
	void updateWithBytes(@NotNullable String tableName, String rowKey, @NotNullable Map<String, Object> byteValues) throws Exception;


	/**
	 * select 按rowKey 查找一行
	 * @param  tableName
	 * @param rowKey
	 *@param columnFamily
	 * @param specColumns  @if null, return all columns; @else,return specified columns;  @throws Exception
	 * void
	 */
	Map<String,String>  selectRow(@NotNullable String tableName, String rowKey, String columnFamily, @Nullable String[] specColumns) throws Exception;
	Map<String,String>  selectRow(@NotNullable String tableName, String rowKey, String[] specQualifiers) throws Exception;
	Map<String,String>  selectRow(@NotNullable String tableName, String rowKey) throws Exception;

	/**
	 * 按 byte[] 获取指定字段
	 * @param tableName
	 * @param rowKey
	 *@param columnFamily
	 * @param bytesColumns
	 * @param specColumns   @return
	 * @throws Exception
	 */
	Map<String,Object> selectRowWithBytes(@NotNullable String tableName, String rowKey, String columnFamily, @NotNullable String[] bytesColumns, @Nullable String[] specColumns) throws Exception;
	Map<String,Object> selectRowWithBytes(@NotNullable String tableName, String rowKey, @NotNullable String[] bytesColumns, @Nullable String[] specColumns) throws Exception;

	/**
	 * select 查找多行，按rowkey list
	 * SELECT c1,c2, ... cn FROM table ROWKEY IN ('rowKey1',...'rowKeyn') limit limit
	 * @param tableName rowkey可以为空
	 * @param rowKeys 查询的rowkey list,not null,size>0
	 * @param columnFamily
	 *@param limit 最多获取行数，如rowkey list超过，则按此参数截取  @return
	 * @throws Exception
	 */
	List<RowSimpleDto> selectRows(@NotNullable String tableName, @NotNullable String[] rowKeys, String columnFamily, @Nullable String[] qualiferList, @Nullable Integer limit) throws Exception;
	List<RowSimpleDto> selectRows(@NotNullable  String tableName, @NotNullable String[] rowKeys, @Nullable String[] qualiferList) throws Exception;
	List<RowSimpleDto> selectRows(@NotNullable String tableName, @NotNullable String[] rowKeys) throws Exception;
	List<RowSimpleDto> selectRows(@NotNullable String tableName) throws Exception;

	/**
	 * select rows by start rowKey and end rowKey
	 * @param tableName rowKey not used
	 * @param startRowkey  start rowKey
	 * @param endRowKey end rowKey
	 * @param specColumns null=get all cloumns
	 * @param limit null = 1000
	 * @return K:rowkey,V:[K:qualifer,V:value]
	 * @throws Exception
	 */
	List<RowSimpleDto> selectRows(@NotNullable String tableName, @NotNullable String startRowkey, @NotNullable String endRowKey, @Nullable String columnFamily,@Nullable String[] specColumns, @Nullable Integer limit) throws Exception;

	/**
	 * select c1,c2...c3 from table STARTKEY = 'startRowKey' ENDKEY = 'endRowKey' FAMILY='default' limit defaultSize
	 * @param tableName
	 * @param startRowkey
	 * @param endRowKey
	 * @param specColumns
	 * @return
	 * @throws Exception
	 */
	List<RowSimpleDto> selectRows(@NotNullable String tableName, @NotNullable String startRowkey, @NotNullable String endRowKey, @Nullable String[] specColumns) throws Exception;
	/**
	 * select * from table STARTKEY = 'startRowKey' ENDKEY = 'endRowKey' FAMILY='default' limit defaultSize
	 * @param tableName
	 * @param startRowkey
	 * @param endRowKey
	 * @return
	 * @throws Exception
	 */
	List<RowSimpleDto> selectRows(@NotNullable String tableName,@NotNullable String startRowkey,@NotNullable String endRowKey) throws Exception;

	/**
	 * !!! ALERT DDL !!!
	 * create table
	 * @param tableName tableName
	 * @param columnFamilys column family string set
	 * @throws Exception
	 */
	void createTable(@NotNullable String tableName,Set<String> columnFamilys) throws Exception;
	
}

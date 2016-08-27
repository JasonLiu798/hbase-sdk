
package com.jason798.hbase.impl;

import java.util.*;

import com.jason798.hbase.action.admin.impl.CreateTableAction;
import com.jason798.hbase.action.crud.impl.*;
import com.jason798.hbase.antlr.SQLGrammerParser;
import com.jason798.hbase.antlr.model.RowKeyRange;
import com.jason798.hbase.antlr.model.SelectDto;
import com.jason798.hbase.api.HbaseService;
import com.jason798.hbase.api.RowDto;
import com.jason798.hbase.core.HbaseTemplate;
import com.jason798.hbase.core.NotNullable;
import com.jason798.hbase.core.Nullable;
import com.jason798.hbase.model.RowKeyParam;
import com.jason798.hbase.model.RowKeysParam;
import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.model.param.admin.CreateTableParam;
import com.jason798.hbase.model.param.crud.*;
import com.jason798.hbase.model.param.crud.base.PutRowParam;
import com.jason798.hbase.util.CheckUtil;
import com.jason798.hbase.util.CollectionHelper;
import com.jason798.hbase.util.HbaseHelper;
import com.jason798.hbase.antlr.core.SQLParser;
import com.jason798.hbase.antlr.model.ColumnListDto;
import com.jason798.hbase.model.resp.RowModelByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * hbase service implement
 */
public class HbaseServiceImpl implements HbaseService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HbaseServiceImpl.class);

	@Override
	public void execute(String sql) throws Exception {
	}

	/**
	 * hbase SQL like
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> executeQuery(String sql) throws Exception {
		long t = System.currentTimeMillis();
		SQLGrammerParser.ProgContext ctx = SQLParser.getProgContext(sql);//"select c1,c2,c3 from tab1 rowkey is \"1232\" ");
		SelectDto dto = SQLParser.parseSelect(ctx);
		long t1 = System.currentTimeMillis();
		long tt = t1-t;
		System.out.println("sql parse "+dto);
		System.out.println("sql parse cost time "+tt);

		//column list part
		ColumnListDto listDto = dto.getColumnList();
		String[] colimnList = listDto.getList();

		//from part
		String tableName = dto.getTableName();

		//where part

		List<RowDto> res = null;//
		//rowkey part
		RowKeyRange range = dto.getRowKeyRange();
		if(range.getType() == RowKeyRange.TYPE_RANGE || range.getType() == RowKeyRange.TYPE_END || range.getType()== RowKeyRange.TYPE_START ){
			String start = range.getStart();
			String end = range.getEnd();
			res = selectRows(tableName,start,end, HbaseConstant.DFT_COL_FAMILY,colimnList,null);
		} else if(range.getType() == RowKeyRange.TYPE_LIST) {
			String[] rowKeyArr = dto.getRowKeyRange().getList();
//			List<String> rowKeyList = new ArrayList<>(rowKeyArr.length);
//			Collections.addAll(rowKeyList,rowKeyArr);
			res = selectRows(tableName, rowKeyArr,HbaseConstant.DFT_COL_FAMILY,colimnList ,null);
		} else if(range.getType() == RowKeyRange.TYPE_SINGLE){
			String rowKey = range.getStart();
			Map<String,String> oneValue = selectRow(tableName,rowKey,HbaseConstant.DFT_COL_FAMILY,colimnList );
			res = new LinkedList<>();
			res.add(new RowDto(rowKey,oneValue));
		}

		long t2 = System.currentTimeMillis() - t1;

		System.out.println("sql execute cost time "+t2);
		return res;
	}
	
	/**
	 * insert one row
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily  @throws Exception
	 * @param param not null
	 * */
	@Override
	public void insert(@NotNullable String tableName, @NotNullable String rowKey, @Nullable String columnFamily, @NotNullable Map<String, String> param) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("insert model,tab {},obj {}", tableName,param);
		CheckUtil.checkNullAll(tableName, rowKey);
		CheckUtil.checkNull(param);
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowAction(tableName),new PutRowParam(rowKey, columnFamily,param));
	}
	@Override
	public void insert(@NotNullable String tableName, String rowKey, @NotNullable Map<String, String> param) throws Exception{
		insert(tableName,rowKey, HbaseConstant.DFT_COL_FAMILY, param);
	}

	/**
	 * insert rows
	 * @param tableName  rowKey nullable
	 * @param columnFamily
	 * @param param
	 * @throws Exception
	 */
	@Override
	public void insertRows(@NotNullable String tableName, @Nullable String columnFamily, @NotNullable List<RowDto> param)
			throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("insert model,tab {},obj {}", tableName,param);
		CheckUtil.checkNull(tableName);
		CheckUtil.checkNull(param);//check,PS:map content may be null
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowListAction(tableName),new PutRowsParam(columnFamily,param));
	}
	public void insertRows(@NotNullable String tableName, @NotNullable List<RowDto> param) throws Exception{
		insertRows(tableName,null,param);
	}

	/**
	 * insert one row ,with bytes
	 * for store PDF,and its meta infos
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily
	 * @param byteValues
	 * @param param    */
	@Override
	public void insertWithBytes(@NotNullable String tableName,@NotNullable String rowKey,@Nullable String columnFamily,@NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("insert model with byte,param:{},byteQuelifer:{},bytes:{}",param,byteValues);
		CheckUtil.checkNullAll(tableName,rowKey);
		CheckUtil.checkNull(byteValues);
		CheckUtil.checkType(byteValues.values(),byte[].class);//check type
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowByteAction(tableName),new PutRowByteParam(rowKey, columnFamily, param, byteValues));
	}
	public void insertWithBytes(@NotNullable String tableName,@NotNullable String rowKey, @NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception{
		insertWithBytes(tableName,rowKey,null,byteValues,param);
	}
	
	/**
	 * delete
	 * @param tableName field columnfamil can be null
	 * @param rowKey
	 */
	@Override
	public void deleteByRowKey(@NotNullable String tableName, @NotNullable String rowKey) throws Exception{
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("delete model : {}", tableName);
		CheckUtil.checkNullAll(tableName,rowKey);//check

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new DeleteRowAction(tableName),new RowKeyParam(rowKey));
	}

	/**
	 * delete rows
	 * @param tableName rowkey,column family not used
	 * @param rowkeys
	 * @throws Exception
	 * @usage:
	 * 	String[] rowKeys = {"rk1","rk2"};
	 * 	hbaseService.deleteByRowKey(new TableDto("table1",Arrays.asList(rowKeys));
	 */
	@Override
	public void deleteByRowKeys(@NotNullable String tableName, @NotNullable List<String> rowkeys)
			throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("delete models : {}", tableName);
		CheckUtil.checkNull(tableName);
		CheckUtil.checkNull(rowkeys);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new DeleteRowsAction(tableName),new RowKeysParam(rowkeys));
	}

	/**
	 * update one row
	 * @param tableName ,all field not null ,rowKey must exist
	 * @param rowKey
	 *@param columnFamily
	 * @param param not null,size >=1  @throws Exception
	 */
	@Override
	public void update(@NotNullable String tableName, String rowKey, String columnFamily, @NotNullable Map<String, String> param) throws Exception{
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("update model : {}",param);
		CheckUtil.checkNull(tableName);//check
		CheckUtil.checkNull(param);//check
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowAction(tableName),new PutRowParam(rowKey, columnFamily,param,true));
	}
	@Override
	public void update(@NotNullable String tableName,@NotNullable String rowKey,@NotNullable Map<String, String> param) throws Exception{
		update(tableName,rowKey,null,param);
	}

	/**
	 * batch upate rows
	 * @param tableName
	 * @param columnFamily
	 * @param param K:rowKey,V:[K:qualifer,V:value]  @throws Exception
	 * */
	@Override
	public void updateRows(@NotNullable String tableName,@Nullable String columnFamily, @NotNullable List<RowDto> param)
			throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("batch update rows,tab {},obj {}", tableName,param);
		CheckUtil.checkNull(tableName);
		CheckUtil.checkNull(param);//check ,PS:map content may be null
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowListAction(tableName),new PutRowsParam(columnFamily,param,true));
	}

	/**
	 * update row with byte[]
	 * @param tableName ,all field not null ,rowKey must exist
	 * @param rowKey
	 * @param columnFamily
	 * @param byteValues   @throws Exception
	 * @param param
	 * */
	@Override
	public void updateWithBytes(@NotNullable String tableName, String rowKey, String columnFamily, @NotNullable Map<String, Object> byteValues, @Nullable Map<String, String> param) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("update model with byte,param:{},byteValues:{}",param,byteValues);
		CheckUtil.checkNullAll(tableName,rowKey);
		CheckUtil.checkNull(byteValues);
		CheckUtil.checkType(byteValues.values(),byte[].class);
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		ht.execute(new PutRowByteAction(tableName),new PutRowByteParam(rowKey, columnFamily,param,byteValues,true));
	}
	@Override
	public void updateWithBytes(@NotNullable String tableName,@NotNullable String rowKey, @Nullable Map<String, String> param, @NotNullable Map<String, Object> byteValues) throws Exception{
		updateWithBytes(tableName,rowKey,null, byteValues, param);
	}
	@Override
	public void updateWithBytes(@NotNullable String tableName, String rowKey, @NotNullable Map<String, Object> byteValues) throws Exception{
		updateWithBytes(tableName,rowKey,null, byteValues);
	}

	@Override
	public boolean updateCAS(String tableName, String rowKey, String columnFamily, String qualifer, String value,
							 String expectValue) throws Exception {
		return false;
	}


	/**
	 * select 按rowKey 查找一行
	 * SELECT c1,c2 ... cn FROM table ROWKEY IS 'rowkey1'
	 * @param  tableName all field not null
	 * @param rowKey
	 *@param columnFamily
	 * @param specColumns  @if null, return all columns; @else,return specified columns;  @throws Exception
	 * void
	 */
	@Override
	public  Map<String, String> selectRow(@NotNullable String tableName,@NotNullable String rowKey,@Nullable String columnFamily, @Nullable String[] specColumns) throws Exception{
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("select one: {}", tableName);
		}

//		CheckUtil.checkNullAll(tableName,rowKey);
//		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);
		List<RowDto> res = selectRows(tableName,new String[]{rowKey},columnFamily,specColumns,1);
		if(CollectionHelper.isEmpty(res)){
			return null;
		}else{
			RowDto dto = res.get(0);
			if(dto!=null){
				return dto.getValues();
			}else{
				return null;
			}
		}


//		HbaseTemplate ht = new HbaseTemplate();
//		RowDto res = ht.execute(new GetRowAction(tableName),new SelectRowParam(rowKey, columnFamily,specColumns));
//		if(res!=null) {
//			return res.getValues();
//		}else{
//			return null;
//			//throw new HBaseException(String.format("table %s row %s not found", tableName, rowKey));
//		}
	}
	/**
	 * SELECT * FROM table ROWKEY IS 'rowkey1' FAMILY IS
	 */
	@Override
	public Map<String, String> selectRow(@NotNullable String tableName, String rowKey, String[] specQualifiers) throws Exception {
		return selectRow(tableName,rowKey , null, specQualifiers);
	}
	public Map<String,String>  selectRow(@NotNullable String tableName, String rowKey) throws Exception{
		return selectRow(tableName,rowKey,null);
	}

	/**
	 * SELECT c1,c2,...cn,b1,b2...bn  FROM table ROWKEY IS 'rowkey1'
	 * b1~bn return byte[]
	 * @param tableName
	 * @param rowKey
	 *@param columnFamily
	 * @param bytesColumns  byte column
	 * @param specColumns   specified column
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> selectRowWithBytes(@NotNullable String tableName, String rowKey, String columnFamily, @NotNullable String[] bytesColumns, @Nullable String[] specColumns) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("select model with bytes : {},{},{},{},{}", tableName,rowKey,columnFamily,Arrays.toString(bytesColumns),Arrays.toString(specColumns));
		CheckUtil.checkNullAll(tableName,rowKey);
		CheckUtil.checkNull(bytesColumns);
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);

		HbaseTemplate ht = new HbaseTemplate();
		RowModelByte res = ht.execute(new GetRowByteAction(tableName),new SelectRowParam(rowKey, columnFamily,specColumns,bytesColumns));
		return res.getValues();
	}
	@Override
	public Map<String,Object> selectRowWithBytes(@NotNullable String tableName, String rowKey, @NotNullable String[] bytesColumns, @Nullable String[] specColumns) throws Exception{
		return selectRowWithBytes(tableName,rowKey,null,bytesColumns,specColumns);
	}

	/**
	 * select 查找多行，按rowkey list
 	 * SELECT c1,c2, ... cn FROM table ROWKEY IN ('rowKey1',...'rowKeyn') limit limit
	 * @param tableName rowkey可以为空
	 * @param rowKeys 查询的rowkey list,not null,size>0
	 * @param columnFamily
	 *@param limit 最多获取行数，如rowkey list超过，则按此参数截取  @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(@NotNullable String tableName,
								   @NotNullable String[] rowKeys, String columnFamily, @NotNullable String[] qualiferList, @NotNullable Integer limit) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("select rows,tab:{},rowKeylist:{},spec:{},maxsize:{}", tableName,rowKeys, Arrays.toString(qualiferList),limit);
		CheckUtil.checkNull(tableName);
		CheckUtil.checkNull(rowKeys);
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);
		limit = HbaseHelper.filterLimit(limit);

		HbaseTemplate ht = new HbaseTemplate();
		List<RowDto> res = ht.execute(new GetRowsAction(tableName),new SelectSpecRowsParam(rowKeys, columnFamily, qualiferList,limit));
		return res;
	}

	/**
	 * select c1,c2, ... cn from table ROWKEY IN ('rowKey1',...'rowKeyn') limit DFT_SELECT_MAX_SIZE
	 * @param tableName
	 * @param rowKeys
	 * @param specQualifiers
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(String tableName, String[] rowKeys,
			String[] specQualifiers) throws Exception {
		return selectRows(tableName,rowKeys,null, specQualifiers, HbaseConstant.DFT_SELECT_MAX_SIZE);
	}

	/**
	 * select * from table ROWKEY IN ('rowKey1',...'rowKeyn') limit DFT_SELECT_MAX_SIZE
	 * @param tableName
	 * @param rowKeys
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(String tableName, String[] rowKeys)
			throws Exception {
		return selectRows(tableName,rowKeys,null);
	}

	/**
	 * select 查找多行，按startRowKey,endRowKey
 	 * select c1,c2, ... cn from table STARTKEY = 'startRowKey' ENDKEY = 'endRowKey' limit maxSize
	 * @param tab rowKey not used
	 * @param startRowkey  start rowKey
	 * @param endRowKey end rowKey
	 * @param specColumns null=get all cloumns
	 * @param limit null = 1000 >0
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(@NotNullable String tab, @NotNullable String startRowkey,@NotNullable String endRowKey, @Nullable String columnFamily,@Nullable String[] specColumns, @Nullable Integer limit) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("select rows,tab:{},start:{},end:{},spec:{},maxsize:{}",tab,startRowkey,endRowKey,specColumns, limit);
		//CheckUtil.checkNullAll(tab,startRowkey,endRowKey);
		CheckUtil.checkNullAll(tab);
		columnFamily = HbaseHelper.filterColumnFamily(columnFamily);
		limit = HbaseHelper.filterLimit(limit);

		HbaseTemplate ht = new HbaseTemplate();
		return ht.execute(new ScanRowAction(tab),new SelectRowsParam(columnFamily,specColumns,startRowkey,endRowKey,null, limit));
	}

	/**
	 * select c1,c2, ... cn from table STARTKEY = 'startRowKey' ENDKEY = 'endRowKey' limit DFT_SELECT_MAX_SIZE
	 * @param tableName
	 * @param startRowkey
	 * @param endRowKey
	 * @param specColumns
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(@NotNullable String tableName, @NotNullable String startRowkey, @NotNullable String endRowKey, @Nullable String[] specColumns) throws Exception{
		return selectRows(tableName,startRowkey,endRowKey,null,specColumns,null);
	}

	/**
 	 * select * from table STARTKEY = 'startRowKey' ENDKEY = 'endRowKey' limit DFT_SELECT_MAX_SIZE
	 * @param tableName
	 * @param startRowkey
	 * @param endRowKey
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(@NotNullable String tableName,@NotNullable String startRowkey,@NotNullable String endRowKey) throws Exception{
		return selectRows(tableName,startRowkey,endRowKey,null);
	}

	/**
	 * ！！！ ALERT ！！！
	 * 查找所有
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowDto> selectRows(@NotNullable String tableName) throws Exception{
		return selectRows(tableName,null,null,null);
	}

	/**
	 * create table
	 * @param tableName tableName
	 * @param columnFamilys column family string set
	 * @throws Exception
	 */
	@Override
	public void createTable(@NotNullable String tableName, Set<String> columnFamilys) throws Exception {
		if(LOGGER.isDebugEnabled())
			LOGGER.debug("create table ,tab:{},columnfamily:{}",tableName,columnFamilys);

		CheckUtil.checkNull(tableName);
		if(CollectionHelper.isEmpty(columnFamilys)){
			columnFamilys = new HashSet<>();
			columnFamilys.add(HbaseConstant.DFT_COL_FAMILY);
		}

		HbaseTemplate ht = new HbaseTemplate();
		ht.executeAdmin(new CreateTableAction(),new CreateTableParam(tableName,columnFamilys));
		return ;
	}


}

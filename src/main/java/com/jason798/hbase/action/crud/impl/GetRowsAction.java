
package com.jason798.hbase.action.crud.impl;

import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.model.param.crud.SelectSpecRowsParam;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 
 * @author JasonLiu798
 * @since 1.0
 */
public class GetRowsAction extends GetRowBaseAction implements
		CRUDParamReturnAction<SelectSpecRowsParam, List<RowSimpleDto>> {
	private static final Logger LOGGER = LoggerFactory.getLogger(GetRowsAction.class);
	public GetRowsAction(String tableName) {
		super(tableName);
	}

	/**
	 *
	 * @param table
	 * @param param
	 *  columnFamily not null
	 *  columnList can be null
	 *  rowKeys not null,size>0
	 *  maxSize >0
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<RowSimpleDto> service(Table table, SelectSpecRowsParam param) throws HBaseException {
		List<RowSimpleDto> res = new LinkedList<>();

		//set condition
		String[] rowKeys = param.getRowKeys();
		List<Get> getList = new ArrayList<>(rowKeys.length);
		String[] specColumns = param.getColumnList();

		//generate byte[][]
		boolean addQualiferFilter = false;
		byte[][] specColumnBytes = null;
		if( ! CollectionUtil.isEmpty(specColumns)){
			addQualiferFilter = true;
			specColumnBytes = new byte[specColumns.length][];
			for(int i=0;i<specColumnBytes.length;i++){
				specColumnBytes[i] = Bytes.toBytes(specColumns[i]);
			}
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("specified qualifiers not null,{}",Arrays.toString(specColumns));
			}
		}

		int limit = Math.min(param.getMaxSize(),rowKeys.length);
		for(int i=0; i<limit; i++){
			String rowkey = rowKeys[i];
			Get get = new Get(Bytes.toBytes(rowkey));
			addFilterForBatch(get,Bytes.toBytes(param.getColumnFamily()),specColumnBytes,addQualiferFilter);
			getList.add(get);
		}

		Result[] resultList = new Result[0];
		try {
			resultList = table.get(getList);
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		if(resultList!=null) {
			for (Result result : resultList) {
				RowSimpleDto rowDto = result2RowDto(result);
				if (rowDto != null) {
					res.add(rowDto);
				}
			}
		}
		return res;
	}

}

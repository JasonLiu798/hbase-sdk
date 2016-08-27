package com.jason798.hbase.action.crud.impl;


import com.jason798.hbase.model.constant.HbaseConstant;
import com.jason798.hbase.util.CollectionHelper;
import com.jason798.hbase.api.RowDto;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * get rows base
 */
public class GetRowBaseAction extends CRUDBaseAction{

	public GetRowBaseAction(String tableName) {
		super(tableName);
	}

	@Override
	public String getActionName() {
		return HbaseConstant.ACTION_GET;
	}


	/**
	 *
	 * @param get
	 * @param columnFamily
	 * @param specColumns
	 * @return
	 */
	protected Get addFilter(Get get, String columnFamily, String[] specColumns){
		if(!CollectionHelper.isEmpty(specColumns)){
			byte[] family = Bytes.toBytes(columnFamily);
			for(String specColumn:specColumns){
				get.addColumn(family,Bytes.toBytes(specColumn));
			}
			//addFilter(get,family,columnList);
		}else{
			get.addFamily(Bytes.toBytes(columnFamily));
		}
		return get;
	}

	/**
	 * for batch operation,move some duplicate operation to out loop
	 * @param get
	 * @param columnFamily
	 * @param specColumns
	 * @param addQuliferFilter
	 * @return
	 */
	protected Get addFilterForBatch(Get get,byte[] columnFamily, byte[][] specColumns ,boolean addQuliferFilter) {
		if(addQuliferFilter){
			byte[] family = columnFamily;
			for(byte[] specColumn:specColumns){
				get.addColumn(family,specColumn);
			}
			//addFilter(get,family,columnList);
		}else{
			get.addFamily(columnFamily);
		}
		return get;
	}

	/**
	 * Result 2 row
	 * @param result
	 * @return
	 */
	protected RowDto result2RowDto(Result result){
		if(result==null || result.isEmpty()){
			return null;
		}
		RowDto rowDto = new RowDto();
		rowDto.setRowkey(Bytes.toString(result.getRow()));
		List<Cell> list = result.listCells();
		Map<String, String> values = new HashMap<>();
		if (list != null) {
			for (Cell cell : list) {
				String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));

				String value = Bytes.toString(CellUtil.cloneValue(cell));
				values.put(qualifier, value);
			}
		}
		rowDto.setValues(values);
		return rowDto;
	}

}

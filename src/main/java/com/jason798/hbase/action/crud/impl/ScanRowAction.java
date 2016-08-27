package com.jason798.hbase.action.crud.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.RowSimpleDto;
import com.jason798.hbase.model.param.crud.SelectRowsParam;
import com.jason798.hbase.util.CollectionHelper;
import com.jason798.hbase.util.StringHelper;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * scan rows
 */
public class ScanRowAction extends ScanRowBaseAction implements
        CRUDParamReturnAction<SelectRowsParam, List<RowSimpleDto> > {

    public ScanRowAction(String tableName) {
        super(tableName);
    }

    @Override
    public List<RowSimpleDto> service(Table table, SelectRowsParam param) throws Exception {
        Scan scan = new Scan();
        /**
         * SingleColumnValueFilter(
         * 	final byte [] family,
         * 	final byte [] qualifier,
         * 	final CompareOp compareOp,
         * 	final byte[] value )
         **
         Filter filter = new SingleColumnValueFilter(
         Bytes.toBytes("info"), Bytes.toBytes("id"), CompareOp.EQUAL, Bytes.toBytes("1"));
         */
        String startRowkey = param.getStartRowKey();
        String endRowkey = param.getEndRowKey();
        if(!StringHelper.isEmpty(startRowkey)){
            scan.setStartRow(Bytes.toBytes(startRowkey));
        }
        if(!StringHelper.isEmpty(endRowkey)){
            scan.setStopRow(Bytes.toBytes(endRowkey));
        }

        scan.setMaxResultSize(param.getMaxSize());
        /*
        if (preRowKey != null && (!preRowKey.equals(""))) {
			Filter filter = new PrefixFilter(Bytes.toBytes(preRowKey));
			scan.setFilter(filter);
		}*/

        String[] specColumns = param.getColumnList();
        if(CollectionHelper.isEmpty(specColumns)){
            scan.addFamily(Bytes.toBytes(param.getColumnFamily()));
        }else{
            for(String specColumn:specColumns){
                byte[] family =Bytes.toBytes(param.getColumnFamily());
                scan.addColumn(family,Bytes.toBytes(specColumn));
            }
        }
        ResultScanner rs = null;

        List<RowSimpleDto>  res = new LinkedList<>();
        try {
            rs = table.getScanner(scan);
            for (Result r : rs) {
                RowSimpleDto rowDto = new RowSimpleDto();
                //Map<String, String> map = new HashMap<>();
                List<Cell> cells = r.listCells();
                if (CollectionHelper.isEmpty(cells)) {
                    continue;
                }
                String rowKey = Bytes.toString(r.getRow());
                Map<String, String> values = new HashMap<>();
                for (Cell cell : cells) {
                    String columnFamily = Bytes.toString(CellUtil.cloneFamily(cell));
                    if (columnFamily.equals(param.getColumnFamily())) {
                        values.put(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
                    }
                }
                rowDto.setRowkey(rowKey);
                rowDto.setValues(values);
                res.add(rowDto);
            }
        } catch (Exception e) {
            throw new HBaseException("hbase scan error!");
        } finally {
            rs.close();
        }
        return res;
    }


}

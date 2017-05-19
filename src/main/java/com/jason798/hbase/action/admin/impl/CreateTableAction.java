package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.param.admin.CreateTableParam;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * create table
 * @author JasonLiu798
 * @since 1.0
 */
public class CreateTableAction implements AdminParamReturnAction<CreateTableParam,Integer> {
	@Override
	public Integer service(Admin admin, CreateTableParam param) throws HBaseException {
		HTableDescriptor desc = new HTableDescriptor(param.getTableName());
		for(String columnFamily:param.getColumnFamilys()){
			HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes(columnFamily));
	    	desc.addFamily(coldef);
		}
		try {
			admin.createTable(desc);
		} catch (IOException e) {
			throw new HBaseIOException(e);
		}
		return 0;
	}
}

package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.model.param.admin.CreateTableParam;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * 
 */
public class CreateTableAction implements AdminParamReturnAction<CreateTableParam,Integer> {
	@Override
	public Integer service(Admin admin, CreateTableParam param) throws Exception {
		HTableDescriptor desc = new HTableDescriptor(param.getTableName());
		for(String columnFamily:param.getColumnFamilys()){
			HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes(columnFamily));
	    	desc.addFamily(coldef);
		}
		admin.createTable(desc);
		return 0;
	}
}

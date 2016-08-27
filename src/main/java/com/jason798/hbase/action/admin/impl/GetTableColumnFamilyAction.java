package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;


/**
 * get table column family
 */
public class GetTableColumnFamilyAction implements AdminParamReturnAction<String,String[]> {
	@Override
	public String[] service(Admin admin, String param) throws Exception {
		HTableDescriptor desc = admin.getTableDescriptor(TableName.valueOf(param));
		HColumnDescriptor[] hdescs = desc.getColumnFamilies();
		String[] columns = null;
		if(hdescs!=null && hdescs.length>0){
			columns = new String[hdescs.length];
			for(int i=0;i<hdescs.length;i++){
				HColumnDescriptor column = hdescs[i];
				columns[i] = column.getNameAsString();
			}
		}
		return columns;
	}

}

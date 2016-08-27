package com.jason798.hbase.action.admin.impl;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import com.jason798.hbase.action.AdminReturnAction;


/**
 * get table desc
 */
public class GetTableDescAction implements AdminReturnAction<String[]>{
	@Override
	public String[] service(Admin admin) throws Exception {
		TableName[] descArr = admin.listTableNames();
		String[] res  = null;
		if(descArr!=null && descArr.length>=1){
			res = new String[descArr.length];
			for(int i=0;i<descArr.length;i++){//HTableDescriptor desc:descArr){
				String name = descArr[i].getNameAsString();
				res[i] = name;
			}
		}
		return res;
	}

}

package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * get table name
 * @author JasonLiu798
 * @since 1.0
 */
public class GetTableNamesAction implements AdminReturnAction<List<String>> {
	@Override
	public List<String> service(Admin admin) throws HBaseException {
		TableName[] descArr = null;
		try {
			descArr = admin.listTableNames();
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		List<String> res  = new LinkedList<>();
		if(descArr!=null && descArr.length>0){
			for(int i=0;i<descArr.length;i++){//HTableDescriptor desc:descArr){
				String name = descArr[i].getNameAsString();
				res.add(name);
			}
		}
		return res;
	}

}

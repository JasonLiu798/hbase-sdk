package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.resp.TableDesc;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * get table desc
 * @author JasonLiu798
 * @since 1.0
 */
public class GetTableDescAction implements AdminParamReturnAction<String,TableDesc> {
	
	@Override
	public TableDesc service(Admin admin,String tablename) throws HBaseException {
		HTableDescriptor desc = null;
		try {
			desc = admin.getTableDescriptor( TableName.valueOf(tablename) );
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		if(desc==null){
			return null;
		}
		Map<String, String> config = desc.getConfiguration();
		Set<byte[]> columnNames = desc.getFamiliesKeys();
		List<String> list = new LinkedList<>();
		for(byte[] cn :columnNames){
			list.add(Bytes.toString(cn));
		}
		int replica = desc.getRegionReplication();
		long flushSize = desc.getMemStoreFlushSize();
		TableDesc res = new TableDesc();
		res.setColumnFamilys(list);
		res.setConfig(config);
		res.setTableName(tablename);
		res.setTableReplication( replica);
		res.setMemoryStoreFlushSize(flushSize);

		return res;
	}

}

package com.jason798.hbase.action.admin.impl;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.model.TableParamInner;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * enable table
 * todo: merge with disable table
 * @author JasonLiu798
 * @since 1.0
 */
public class EnableTableAction implements AdminParamReturnAction<TableParamInner,Integer> {
	@Override
	public Integer service(Admin admin, TableParamInner param) throws HBaseException {
		try {
			admin.enableTable(param.getTableName());
		} catch (IOException e) {
			throw new HBaseIOException();
		}
		return 0;
	}
}

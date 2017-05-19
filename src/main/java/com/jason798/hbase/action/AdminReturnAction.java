package com.jason798.hbase.action;

import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.client.Admin;

/**
 * DDL
 *
 * @author JasonLiu798
 * @since 1.0
 */
public interface AdminReturnAction<T> {
	T service(Admin admin) throws HBaseException;
	
}

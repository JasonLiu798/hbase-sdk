package com.jason798.hbase.action;

import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.client.Admin;

/**
 * @author JasonLiu798
 * @since 1.0
 */
public interface AdminParamReturnAction<P, R> {
	R service(Admin admin, P param) throws HBaseException;
}

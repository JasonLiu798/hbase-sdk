package com.jason798.hbase.action;

import org.apache.hadoop.hbase.client.Admin;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public interface AdminAction  {
	void service(Admin admin) throws Exception;
}

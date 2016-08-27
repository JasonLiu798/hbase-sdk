package com.jason798.hbase.core;

import java.io.IOException;
import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.action.AdminReturnAction;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * hbase template
 * TODO: add filter
 */
public class HbaseTemplate {
	private static final Logger LOGGER = LoggerFactory.getLogger(HbaseTemplate.class);

	@ThreadSafe
	private static Connection connection = null;
	
	public HbaseTemplate() throws IOException{
		connection = HbaseConnectionManager.getConnection();
	}

	/**
	 * CRUD execute function
	 * @param action execute action
	 * @param param input parameter
	 * @return execute result
	 * @throws Exception  IOException,HbaseException
	 */
	public <P,R> R execute(CRUDParamReturnAction<P,R> action,P param) throws Exception {
		Table table = null;
		R res = null;
    	try {
			long startTime = System.currentTimeMillis();
    		table = connection.getTable(TableName.valueOf(action.getTable()));
			if(table == null){
				throw new HBaseException(String.format("get table connection %s null",action.getTable()));
			}
			res = action.service(table,param);
			long endTime = System.currentTimeMillis();
			long duration = endTime-startTime;
			String content = String.format("action=%s, duration=%s ms, parameters=%s, res=%s",action.getActionName(),duration,param, res);
			if(LOGGER.isDebugEnabled())
				LOGGER.debug(content);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(table!=null){
				try {
					table.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}


	/**
	 * DDL,no param,return
	 * @param action admin executor no param
	 * @return execute state
	 * @throws Exception IOException
	 * T
	 */
	public <T> T executeAdmin(AdminReturnAction<T> action) throws Exception {
		Admin admin = null;
		T res = null;
    	try {
    		admin = connection.getAdmin();
			if(admin==null){
				throw new HBaseException("get admin connection null");
			}
			res = action.service(admin);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(admin!=null){
				try {
					admin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * DDL,param,return
	 * @param action admin executor
	 * @param param admin parameter
	 * @throws Exception IOException,HbaseException
	 * void
	 */
    public <P,R> R executeAdmin(AdminParamReturnAction<P,R> action, P param) throws Exception{
    	Admin admin = null;
    	R res = null;
    	try {
			admin = connection.getAdmin();
			if(admin==null){
				throw new HBaseException("get admin connection null");
			}
			res = action.service(admin,param);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(admin!=null){
				try {
					admin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    	return res;
    }
    

}

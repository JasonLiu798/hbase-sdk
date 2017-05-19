package com.jason798.hbase.core;

import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.action.AdminReturnAction;
import com.jason798.hbase.action.CRUDParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.json.JSONFastJsonUtil;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseTemplate {
    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseTemplate.class);

    @ThreadSafe
    private static Connection connection = null;

    public HbaseTemplate() throws HBaseException {

    }

    /**
     * CRUD execute function
     *
     * @param action execute action
     * @param param  input parameter
     * @return execute result
     * @throws Exception IOException,HbaseException
     */
    public <P, R> R execute(CRUDParamReturnAction<P, R> action, P param) throws HBaseException {
        Table table = null;
        R res = null;
        getConnection();
        try {
            long startTime = System.currentTimeMillis();
            table = connection.getTable(TableName.valueOf(action.getTable()));
            if (table == null) {
                throw new HBaseException("get table exception,table "+action.getTable());
            }
            res = action.service(table, param);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            String content = String.format("action=%s, duration=%s ms, parameters=%s, res=%s", action.getActionName(), duration, JSONFastJsonUtil.objectToJson( param), res);
            LOGGER.debug(content);
        } catch (IOException e) {
            throw new HBaseException("execute exception",e);
        } finally {
            if (table != null) {
                try {
                    table.close();
                } catch (IOException e) {
                    throw new HBaseException("close exception",e);
                }
            }
        }
        return res;
    }

    public void getConnection()throws HBaseException{
        connection = HbaseConnectionManager.getConnection();
        if(connection==null){
            try {
                HbaseConnectionManager.refreshConnection();
                connection = HbaseConnectionManager.getConnection();
            } catch (Exception e) {
                throw new HBaseException("refresh");
            }
            if(connection==null) {
                throw new HBaseException("get conn null");
            }
        }
    }

    /**
     * DDL,no param,return
     *
     * @param action admin executor no param
     * @return execute state
     * @throws Exception IOException
     *                   T
     */
    public <T> T executeAdmin(AdminReturnAction<T> action) throws HBaseException {
        Admin admin = null;
        T res = null;
        getConnection();
        try {
            admin = connection.getAdmin();
            if (admin == null) {
                throw new HBaseException("get admin");
            }
            res = action.service(admin);
        } catch (IOException e) {
            throw new HBaseException("execute",e);
        } finally {
            if (admin != null) {
                try {
                    admin.close();
                } catch (IOException e) {
                    throw new HBaseException("close io",e);
                }
            }
        }
        return res;
    }

    /**
     * DDL,param,return
     *
     * @param action admin executor
     * @param param  admin parameter
     * @throws Exception IOException,HbaseException
     *                   void
     */
    public <P, R> R executeAdmin(AdminParamReturnAction<P, R> action, P param) throws HBaseException {
        Admin admin = null;
        R res = null;
        getConnection();
        try {//( admin=connection.getAdmin()){
            admin = connection.getAdmin();
            if (admin == null) {
				throw new HBaseException("get admin");
            }
            res = action.service(admin, param);
        } catch (IOException e) {
            throw new HBaseException("execute admin",e);
        } finally {
            if (admin != null) {
                try {
                    admin.close();
                } catch (IOException e) {
                    throw new HBaseException("close ",e);
                }
            }
        }
        return res;
    }


}

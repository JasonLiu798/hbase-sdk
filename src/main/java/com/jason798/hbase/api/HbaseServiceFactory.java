package com.jason798.hbase.api;

import com.google.protobuf.ServiceException;
import com.jason798.hbase.core.HbaseConnectionManager;
import com.jason798.hbase.impl.HbaseServiceImpl;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseServiceFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(HbaseServiceFactory.class);
	private static volatile HbaseService instance;

	private HbaseServiceFactory(){}

	/**
	 * get hbase raw connection
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = HbaseConnectionManager.getConnection();
		}catch (Exception e){
			LOGGER.error("get hbase connection error");
			throw new IllegalStateException("hbase connection get error!");
		}
		return conn;
	}
	
	/**
	 * refresh connection
	 * 
	 * @return void
	 */
	public static void refreshConnection() {
		try {
			HbaseConnectionManager.refreshConnection();
		} catch (Exception e) {
			LOGGER.error("refresh hbase connection error");
			throw new IllegalStateException("hbase connection refresh error!");
		}
	}

	/**
	 * get hbase service
	 * @return
	 */
	public static HbaseService getHbaseService(){
		return get();
	}
	
	private static HbaseService get(){
		if(instance==null){
			synchronized (HbaseServiceFactory.class) {
				if(instance == null) {
					//use reflect,for extend
					Class<?> clz = HbaseServiceImpl.class;
					try {
						Object obj = clz.newInstance();
						instance = (HbaseService) obj;
					} catch (Exception e) {
						LOGGER.error("HbaseService instance init error");
						throw new IllegalStateException();
					}
				}
			}
		}
		return instance;
	}

	/**
	 * check hbase status
	 * @return
	 * int
	 */
	public static int isHbaseAvailable() {
		try{
			HBaseAdmin.checkHBaseAvailable(HbaseConnectionManager.getConfiguration());
		}catch( MasterNotRunningException | ZooKeeperConnectionException | ServiceException e1){
			return -3;
		}catch( IOException ex3){
			return -2;
		}catch(Exception ex2){
			return -1;
		}
		return 0;
	}

}

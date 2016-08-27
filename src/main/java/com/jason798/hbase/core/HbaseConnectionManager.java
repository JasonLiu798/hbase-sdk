package com.jason798.hbase.core;

import java.io.IOException;

import com.jason798.hbase.util.ConfigUtil;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * connection manager
 */
public class HbaseConnectionManager {
	
	private volatile static Configuration conf = null;

	@ThreadSafe
	private volatile static Connection connection = null;

	private static final Logger LOGGER = LoggerFactory.getLogger(HbaseConnectionManager.class);

	private HbaseConnectionManager(){}

	/**
	 * init conf from sysconfig.properties
	 * 
	 * void
	 */
	private static void init() {
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", ConfigUtil.get("hbase.zookeeper.quorum"));//hbase_zookeeper_quorum);
		conf.set("hbase.zookeeper.property.clientPort",
				ConfigUtil.get("hbase.zookeeper.property.clientPort"));//hbase_zookeeper_property_clientPort);
		conf.set("hbase.master", ConfigUtil.get("hbase.master"));//hbase_master);
	}
	
	public static Configuration getConfiguration() {
		if(conf == null){
            synchronized(HbaseConnectionManager.class){
                if(conf == null){
                	init();
                	//return conf;
                }
              //return conf;
            }
        }
		return conf;
	}
	
	public static Connection getConnection(){
		if (connection == null) {
			synchronized(HbaseConnectionManager.class){
				if (connection == null) {
					try {
						connection = ConnectionFactory.createConnection(getConfiguration());
					} catch (IOException e) {
						LOGGER.error("get hbase connection error");
						throw new IllegalStateException("get hbase connection error");
					}
				}
			}
		}
		return connection;
	}
	
	public static void refreshConnection() throws Exception {
		if (null != connection) {
			synchronized(HbaseConnectionManager.class){
				if (connection != null) {
					connection.close();
					connection = ConnectionFactory.createConnection(getConfiguration());
				}
			}
		}
	}
	

}

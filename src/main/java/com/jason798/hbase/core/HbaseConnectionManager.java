package com.jason798.hbase.core;

import com.jason798.config.ConfigUtil;
import com.jason798.hbase.api.HBaseIOException;
import com.jason798.hbase.api.HbaseConfig;
import com.jason798.hbase.model.constant.HbaseConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Connection creation is a heavy-weight operation.
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseConnectionManager {
    private static HbaseConfig config = null;
    private volatile static Configuration conf = null;
    private volatile static Connection connection = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(HbaseConnectionManager.class);

    private HbaseConnectionManager() {
    }

    /**
     * init conf from sysconfig.properties
     * <p>
     * void
     */
    private static void init() {
    	//(Class<T> clz, String prefixKey, String propertiesFile
        HbaseConfig hc = ConfigUtil.generateConfigModelUsePrefixKey(HbaseConfig.class, HbaseConstant.CONF_PREFIX_KEY, HbaseConstant.CONF_DFT_FILE);//, ConfigUtil.TP_CLASSPATH);
        config = hc;
        conf = config.create();
    }

    /**
     * get configuration
     *
     * @return Configuration
     */
    public static Configuration getConfiguration() {
        if (conf == null) {
            synchronized (HbaseConnectionManager.class) {
                if (conf == null) {
                    init();
                }
            }
        }
        return conf;
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (HbaseConnectionManager.class) {
                if (connection == null) {
                    try {
                        connection = ConnectionFactory.createConnection(getConfiguration());
                    } catch (IOException e) {
                        throw new HBaseIOException("get connection excep",e);
                    }
                }
            }
        }
        return connection;
    }

    /**
     * 重建connection
     *
     * @throws Exception
     */
    public static void refreshConnection() throws Exception {
        if (null != connection) {
            synchronized (HbaseConnectionManager.class) {
                if (connection != null) {
                    connection.close();
                    connection = ConnectionFactory.createConnection(getConfiguration());
                }
            }
        } else {
            if (connection == null) {
                synchronized (HbaseConnectionManager.class) {
                    if (connection == null) {
                        connection = ConnectionFactory.createConnection(getConfiguration());
                    }
                }
            }
        }
    }


}

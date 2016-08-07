package com.jason798.hbase.admin.impl;

import java.io.IOException;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.jason798.hbase.config.HbaseConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

import com.google.protobuf.ServiceException;


/**
 * 描述：hbase管理工具实现类
 * 
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID   DATE           PERSON          REASON
 *  1    2016年8月5日        01174604         Create
 * ****************************************************************************
 * </pre>
 * 
 * @author 01174604
 * @since 1.0
 */
public class HbaseAdminServiceImpl {
	private  Configuration conf = null;
//	private  Connection connection = null;
	private HbaseConfig hc;
	private HBaseAdmin ha;
	
	
	@PostConstruct 
	public void init(){
		try {
			this.conf = hc.getConfiguration();
			//connection = ConnectionFactory.createConnection(conf);
			ha = new HBaseAdmin(this.conf);
		} catch (Exception e) {
			// IOException
			e.printStackTrace();
		}
	}


	/**
	 * 取得Hbase配置信息 ，只有在本工具类未实现需要在外部重构时才用到 李活甫 20160726
	 */
	public Configuration getConfiguration() {
		return conf;
	}
	
	/**
	 * create table
	 */
	public void createTable(String tableName,Set<String> columnFamilys) throws Exception{
		HTableDescriptor desc = new HTableDescriptor(Bytes.toBytes(tableName));
		for(String columnFamily:columnFamilys){
			HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes(columnFamily));
	    	desc.addFamily(coldef);
		}
		ha.createTable(desc);
	}
	
	/**
	 * add columns
	 * @param tableName
	 * @param columnFamilys
	 * @throws Exception
	 */
	public void addColumn(String tableName,Set<String> columnFamilys) throws Exception {
		for(String columnFamily:columnFamilys){
			addColumn(tableName,columnFamily);
		}
	}
	
	/**
	 * add column family
	 * 列族被创建后不能直接修改，只能通过删除然后重新创建的方式。列族被删除的时候，列族里面的数据也会同时被删除。
	 * @param tableName
	 * @param columnFamily
	 * @throws Exception
	 */
	public void addColumn(String tableName,String columnFamily) throws Exception {
		HColumnDescriptor coldef = new HColumnDescriptor(Bytes.toBytes(columnFamily));
		ha.addColumn(Bytes.toBytes(tableName), coldef);
	}
	
	public int isHbaseAvailable() {
		try{
			HBaseAdmin.checkHBaseAvailable(this.conf);
		}catch( MasterNotRunningException | ZooKeeperConnectionException| ServiceException e1){
			return -3;
		}catch( IOException ex3){
			return -2;
		}catch(Exception ex2){
			return -1;	
		}
		return 0;
	}
	
	/**
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public boolean isTableAvailable(String tableName) throws Exception{
		boolean avail = false;
		avail = ha.isTableAvailable(Bytes.toBytes(tableName));
	    return avail;
	}
	
	
	public void deleteTable(String tableName) throws Exception{
		ha.deleteTable(Bytes.toBytes(tableName));
	}
	
	public void enableTable(String tableName) throws Exception{
		 ha.enableTable(Bytes.toBytes(tableName));
	}
	
	public void disableTable(String tableName) throws Exception{
		ha.disableTable(Bytes.toBytes(tableName));
	}
	
	public String[] getTableColumnFamily(String tableName)throws Exception{
		HColumnDescriptor[] hdescs = getTableDesc(tableName).getColumnFamilies();
		String[] columns = null;
		if(hdescs!=null && hdescs.length>0){
			columns = new String[hdescs.length];
			for(int i=0;i<hdescs.length;i++){
				HColumnDescriptor column = hdescs[i];
				columns[i] = column.getNameAsString();
			}
		}
		return columns;
	}
	
	public HTableDescriptor getTableDesc(String tableName) throws Exception{
		return ha.getTableDescriptor(Bytes.toBytes(tableName));
	}
	
	public String[] listTablesName() throws IOException{
		TableName[] descArr = ha.listTableNames();
		String[] res  = null;
		if(descArr!=null && descArr.length>=1){
			res = new String[descArr.length];
			for(int i=0;i<descArr.length;i++){//HTableDescriptor desc:descArr){
				String name = descArr[i].getNameAsString();
				res[i] = name;
			}
		}
		return res;
	}
	
	public HTableDescriptor[] listTables() throws IOException{
		return ha.listTables();
	}
	
	public boolean tableExist(String tableName) throws IOException{
		 return ha.tableExists(tableName);
	}
	
	/**
	 * 修改表的结构，异步的操作，可能需要花费一定的时间
	 * @param tableName
	 * @param htd
	 * @throws IOException
	 *
	public void modifyTable(String tableName, HTableDescriptor htd) throws IOException{
		HTableDescriptor desc = new HTableDescriptor(Bytes.toBytes(tableName));
		TableName tnName = desc.getTableName();
		ha.modifyTable(tnName,htd);
	}*/
}

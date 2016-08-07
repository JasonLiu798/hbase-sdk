package com.jason798.hbase.crud.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.jason798.hbase.config.HbaseConfig;
import com.jason798.hbase.model.DataValue;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import com.jason798.hbase.api.HbaseCRUDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * hbase
 */
public class HbaseCRUDServiceImpl implements HbaseCRUDService {
	private static Logger log = LoggerFactory.getLogger(HbaseCRUDServiceImpl.class);
	private Configuration conf = null;
	private Connection connection = null;

	private HbaseConfig hc;
	
	
	@PostConstruct
	public void init() {
		try {
			conf = hc.getConfiguration();
			connection = ConnectionFactory.createConnection(conf);
		} catch (Exception e) {
			// IOException
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		return connection;
	}

	public void refreshConnection() throws Exception {
		if (null != connection) {
			connection.close();
		}
		connection = ConnectionFactory.createConnection(conf);
	}

	public Configuration getConfiguration() {
		return conf;
	}

	/**
	 * put
	 *
	 * @param tableName
	 * @param dataValue
	 * @return
	 * @throws Exception
	 */
	public int putData(String tableName, DataValue dataValue)
			throws Exception {
		Table DataTable = connection.getTable(TableName.valueOf(tableName));
		log.debug("tableName: {} dataValue.getRowKey(): {} ", tableName, dataValue.getRowKey());
		Put putDataValue = new Put(Bytes.toBytes(dataValue.getRowKey()));
		String value = (String) dataValue.getDataValue();
		String family = dataValue.getFamilyKey();
		String qualifier = dataValue.getQualifierKey();
		connection.isClosed();//.isMasterRunning();
		putDataValue.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier),
				dataValue.getTs(), Bytes.toBytes(value));
		DataTable.put(putDataValue);
		return 0;
	}

	/**
	 * batch put
	 * @param tableName
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	public int putListData(String tableName, List<DataValue> rows)
			throws Exception {
		Table DataTable = connection.getTable(TableName.valueOf(tableName));
		List<Put> putList = new ArrayList();
		for (DataValue dataValue : rows) {
			Put putDataValue = new Put(Bytes.toBytes(dataValue.getRowKey()));
			String value = (String) dataValue.getDataValue();
			String family = dataValue.getFamilyKey();
			String qualifier = dataValue.getQualifierKey();
			putDataValue.addColumn(Bytes.toBytes(family), Bytes.toBytes(qualifier),
					dataValue.getTs(), Bytes.toBytes(value));
			putList.add(putDataValue);
		}
		DataTable.put(putList);
		return 0;
	}

	/**
	 * delete row by rowkey
	 * @param tableName
	 * @param rowKey
	 * @throws Exception
	 */
	public void deleteRow(String tableName, String rowKey)
			throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));
		try {
			Get get = new Get(Bytes.toBytes(rowKey));
			if (table.exists(get)) {
				Delete deleteAll = new Delete(Bytes.toBytes(rowKey));
				table.delete(deleteAll);
			}
		} finally {
			table.close();
		}
	}

	/**
	 * get
	 * @param tableName
	 * @param rowKey
	 * @return
	 * @throws IOException
	 */
	public List<DataValue> getRowByRowKey(String tableName, String rowKey)
			throws IOException {
		List<DataValue> dataList = new ArrayList();
		Table table = connection.getTable(TableName.valueOf(tableName));
		try {
			Get dataGet = new Get(rowKey.getBytes());
			Result r = table.get(dataGet);
			log.debug("get row by rowkey,tablename {},rowkey: {}", tableName, rowKey);
			for (Cell cell : r.rawCells()) {
				log.debug("get data,KV:{}", cell);
				DataValue dataValue = new DataValue();
				dataValue.setRowKey(rowKey);
				dataValue.setFamilyKey(String.valueOf(CellUtil.cloneFamily(cell)));
				dataValue.setQualifierKey(String.valueOf(CellUtil.cloneQualifier(cell)));
				dataValue.setTs(cell.getTimestamp());
				dataValue.setDataValue(String.valueOf(CellUtil.cloneValue(cell)));
				dataList.add(dataValue);
			}
		}catch (IOException e) {
			e.printStackTrace();
			try {
				table.close();
			}catch (IOException e1){
				e.printStackTrace();
			}
		}finally {
			try	{
				table.close();
			}catch (IOException e){
				e.printStackTrace();
			}
		}
		return dataList;
	}

	/**
	 * get
	 * @param tableName
	 * @param rowKey
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> getRowByRowKey1(String tableName,
												   String rowKey) throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			Get get = new Get(Bytes.toBytes(rowKey));
			Result result = table.get(get);
			/*
			List<Cell> list = result.listCells();
			for(Cell cell :list){			
				System.out.println("family:" + Bytes.toString(CellUtil.cloneFamily(cell)));
	            System.out.println("qualifer:" + Bytes.toString(CellUtil.cloneQualifier(cell)));
	            System.out.println("val:" + Bytes.toString(CellUtil.cloneValue(cell)));
	            System.out.println("ts:" + cell.getTimestamp());
			}
			*/
			for (KeyValue kv : result.list()) {
				map.put(Bytes.toString(kv.getQualifier()),
						Bytes.toString(kv.getValue()));
				// System.out.println("Timestamp:" + kv.getTimestamp());
			}
		} finally {
			table.close();
		}
		return map;
	}

	/**
	 *
	 * @param tableName
	 * @param rowKey
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getRowByteByRowKey(String tableName,
													  String rowKey) throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Get get = new Get(Bytes.toBytes(rowKey));

			Result result = table.get(get);
			for (KeyValue kv : result.list()) {
				String fieldName = Bytes.toString(kv.getQualifier());
				if (fieldName.equalsIgnoreCase("PDF")) {
					map.put(fieldName, kv.getValue());
				} else {
					map.put(fieldName, Bytes.toString(kv.getValue()));
				}
			}

		} finally {
			table.close();
		}
		return map;
	}


	/**
	 *
	 * @param tableName
	 * @param startRowKey
	 * @param stopRowKey
	 * @param preRowKey
	 * @param familyName
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, String>> getRowsByScann(String tableName,
														String startRowKey, String stopRowKey, String preRowKey,
														String familyName) throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));

		List<Map<String, String>> lst = new ArrayList<Map<String, String>>();
		Scan scan = new Scan();
		scan.setStartRow(Bytes.toBytes(startRowKey));
		scan.setStopRow(Bytes.toBytes(stopRowKey));
		if (preRowKey != null && (!preRowKey.equals(""))) {
			Filter filter = new PrefixFilter(Bytes.toBytes(preRowKey));
			scan.setFilter(filter);
		}
		scan.addFamily(Bytes.toBytes(familyName));
		ResultScanner rs = null;
		try {
			rs = table.getScanner(scan);
			for (Result r : rs) {
				Map<String, String> map = new HashMap<String, String>();
				for (KeyValue kv : r.list()) {
					map.put(Bytes.toString(kv.getQualifier()),
							Bytes.toString(kv.getValue()));
				}
				lst.add(map);
			}

		} finally {
			rs.close();
			table.close();
		}
		return lst;
	}


	/**
	 * get r
	 * @param tableName
	 * @param rowKey
	 * @param familyName
	 * @param columnNameLst
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> getRowsColumnByRowKey(String tableName,
														 String rowKey, String familyName, String[] columnNameLst)
			throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));
		Map<String, String> map = new HashMap<String, String>();
		try {
			Get get = new Get(Bytes.toBytes(rowKey));
			for (int i = 0; i < columnNameLst.length; i++) {
				get.addColumn(Bytes.toBytes(familyName),
						Bytes.toBytes(columnNameLst[i]));
			}
			Result result = table.get(get);
			for (KeyValue kv : result.list()) {
				map.put(Bytes.toString(kv.getQualifier()),
						Bytes.toString(kv.getValue()));
			}
		} finally {
			table.close();
		}
		return map;
	}


	public List<Map<String, String>> getRowsColumnByScann(String tableName,
															  String startRowKey, String stopRowKey, String preRowKey,
															  String familyName, String[] columnNameLst) throws Exception {
		if (null == connection) {
			connection = ConnectionFactory.createConnection(conf);
		}
		Table table = connection.getTable(TableName.valueOf(tableName));

		List<Map<String, String>> lst = new ArrayList<Map<String, String>>();
		Scan scan = new Scan();
		scan.setStartRow(Bytes.toBytes(startRowKey));
		scan.setStopRow(Bytes.toBytes(stopRowKey));
		if (preRowKey != null && (!preRowKey.equals(""))) {
			Filter filter = new PrefixFilter(Bytes.toBytes(preRowKey));
			scan.setFilter(filter);
		}
		for (int i = 0; i < columnNameLst.length; i++) {
			scan.addColumn(Bytes.toBytes(familyName),
					Bytes.toBytes(columnNameLst[i]));
		}
		ResultScanner rs = null;
		try {
			rs = table.getScanner(scan);
			for (Result r : rs) {
				Map<String, String> map = new HashMap<String, String>();
				for (KeyValue kv : r.list()) {
					map.put(Bytes.toString(kv.getQualifier()),
							Bytes.toString(kv.getValue()));
				}
				lst.add(map);
			}

		} finally {
			rs.close();
			table.close();
		}
		return lst;
	}


	@Override
	public void updateRow(String tableName, String rowKey, String familyName, Map<String, String> columnLst) throws Exception {

	}

	@Override
	public void updateValue(String tableName, String rowKey, String familyName, Map<String, String> columnLst, byte[] valueBytes) throws Exception {

	}



}

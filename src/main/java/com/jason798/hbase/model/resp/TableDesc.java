package com.jason798.hbase.model.resp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TableDesc implements Serializable{
	private static final long serialVersionUID = 863599038335382335L;
	private String tableName;
    private List<String> columnFamilys;
    private Map<String,String> config;
    private int tableReplication;
    private long memoryStoreFlushSize;

    public TableDesc() {
    }

    @Override
    public String toString() {
        return "TableDesc{" +
                "tableName='" + tableName + '\'' +
                ", columnFamilys=" + columnFamilys +
                ", config=" + config +
                ", tableReplication=" + tableReplication +
                ", memoryStoreFlushSize=" + memoryStoreFlushSize +
                '}';
    }

    public long getMemoryStoreFlushSize() {
        return memoryStoreFlushSize;
    }

    public void setMemoryStoreFlushSize(long memoryStoreFlushSize) {
        this.memoryStoreFlushSize = memoryStoreFlushSize;
    }

    public int getTableReplication() {
        return tableReplication;
    }

    public void setTableReplication(int tableReplication) {
        this.tableReplication = tableReplication;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumnFamilys() {
        return columnFamilys;
    }

    public void setColumnFamilys(List<String> columnFamilys) {
        this.columnFamilys = columnFamilys;
    }

    public Map<String, String> getConfig() {
        return config;
    }

    public void setConfig(Map<String, String> config) {
        this.config = config;
    }
}

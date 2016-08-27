package com.jason798.hbase.model.resp;

public class RowMeta {
    protected String rowKey;
    protected String columnFamily;
    public RowMeta(){}
    public RowMeta(String rowKey, String columnFamily) {
        this.rowKey = rowKey;
        this.columnFamily = columnFamily;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public void setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
    }

    @Override
    public String toString() {
        return "RowMeta{" +
                "rowKey='" + rowKey + '\'' +
                ", columnFamily='" + columnFamily + '\'' +
                '}';
    }
}

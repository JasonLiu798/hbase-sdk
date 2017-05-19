package com.jason798.hbase.api;

import com.jason798.hbase.model.constant.HbaseConstant;

/**
 * TableDto
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class TableDto {
    private String tableName;
    private String rowKey;
    private String columnFamily;

    public TableDto(){
        columnFamily = HbaseConstant.DFT_COL_FAMILY;
    }

    public TableDto(String tableName) {
        this.tableName = tableName;
        this.columnFamily = HbaseConstant.DFT_COL_FAMILY;
    }

    public TableDto(String tableName, String rowKey) {
        this.tableName = tableName;
        this.rowKey = rowKey;
        this.columnFamily = HbaseConstant.DFT_COL_FAMILY;
    }

    public TableDto(String tableName, String rowKey, String familyName) {
        this.tableName = tableName;
        this.rowKey = rowKey;
        this.columnFamily = familyName;
    }

    public String getTableName() {
        return tableName;
    }

    public TableDto setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getRowKey() {
        return rowKey;
    }

    public TableDto setRowKey(String rowKey) {
        this.rowKey = rowKey;
        return this;
    }

    public String getColumnFamily() {
        return columnFamily;
    }

    public TableDto setColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily;
        return this;
    }

    @Override
    public String toString() {
        return "TableDto{" +
                "tableName='" + tableName + '\'' +
                ", rowKey='" + rowKey + '\'' +
                ", columnFamily='" + columnFamily + '\'' +
                '}';
    }
}

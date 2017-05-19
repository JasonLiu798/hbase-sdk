package com.jason798.hbase.model;

import org.apache.hadoop.hbase.TableName;

/**
 * TableParamInner
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class TableParamInner {
    protected TableName tableName;

    public TableParamInner(){}
    public TableParamInner(String tab){
        this.setTableName(tab);
    }
    public TableParamInner(TableName tableName) {
        this.tableName = tableName;
    }

    public TableName getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = TableName.valueOf(tableName);
    }

    public void setTableName(TableName tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return "TableParamInner{" +
                "tableName=" + tableName +
                '}';
    }
}

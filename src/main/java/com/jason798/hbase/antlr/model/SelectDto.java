package com.jason798.hbase.antlr.model;

/**
 * SelectDto
 *
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class SelectDto {
    private int type;
    private String tableName;
    private RowKeyRange rowKeyRange;
    private ColumnListDto columnList;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public RowKeyRange getRowKeyRange() {
        return rowKeyRange;
    }

    public void setRowKeyRange(RowKeyRange rowKeyRange) {
        this.rowKeyRange = rowKeyRange;
    }

    public ColumnListDto getColumnList() {
        return columnList;
    }

    public void setColumnList(ColumnListDto columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return "SelectDto{" +
                "type=" + type +
                ", tableName='" + tableName + '\'' +
                ", rowKeyRange=" + rowKeyRange +
                ", columnList=" + columnList +
                '}';
    }
}

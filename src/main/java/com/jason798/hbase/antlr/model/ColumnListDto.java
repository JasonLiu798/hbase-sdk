package com.jason798.hbase.antlr.model;

import java.util.Arrays;

/**
 * ColumnListDto
 *
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ColumnListDto {
    public static final int TYPE_ALL = 0;
    public static final int TYPE_SPEC = 1;
    private String[] list;
    private int type;

    public ColumnListDto(){
        list = null;
        type = TYPE_ALL;
    }

    public ColumnListDto(String column) {
        this.list = new String[]{column};
        this.type = TYPE_SPEC;
    }

    public ColumnListDto(String[] list) {
        this.list = list;
        this.type = TYPE_SPEC;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ColumnListDto{" +
                "list=" + Arrays.toString(list) +
                ", type=" + type +
                '}';
    }
}

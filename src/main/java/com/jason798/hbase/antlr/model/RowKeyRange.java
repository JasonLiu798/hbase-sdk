package com.jason798.hbase.antlr.model;

import com.jason798.hbase.util.StringHelper;

import java.util.Arrays;

/**
 * RowKeyRange
 */
public class RowKeyRange {
    public static final int TYPE_RANGE = 0;
    public static final int TYPE_SINGLE = 1;
    public static final int TYPE_LIST = 2;
    public static final int TYPE_START = 3;
    public static final int TYPE_END = 4;

    private String start;
    private String end;
    private int type;
    private String[] list;

    /**
     * SINGLE
     * @param start
     */
    public RowKeyRange(String start) {
        this.start = start;
        this.end = start;
        this.type = TYPE_SINGLE;
        list = null;
    }

    /**
     * RANGE: start,end
     * SINGLE: start=end
     * @param start
     * @param end
     */
    public RowKeyRange(String start, String end) {
        this.start = start;
        this.end = end;
        if(StringHelper.equal(start, end)){
            type = TYPE_SINGLE;
        }else{
            type = TYPE_RANGE;
        }
        list = null;
    }

    /**
     * LIST
     * @param list
     */
    public RowKeyRange(String[] list) {
        this.list = list;
        type = TYPE_LIST;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getList() {
        return list;
    }


    public void setList(String[] list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "RowKeyRange{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", type=" + type +
                ", list=" + Arrays.toString(list) +
                '}';
    }

}

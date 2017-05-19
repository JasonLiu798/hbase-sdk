package com.jason798.hbase.api;

import com.jason798.collection.CollectionUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RowRawTSPkgDto implements Serializable{
    private String startKey;
    private String endKey;

    private List<RowRawTSDto> rows = new LinkedList<>();

    public RowRawTSPkgDto() {

    }

    public void addRow(RowRawTSDto dto){
        if(CollectionUtil.isEmpty(rows)){
            rows = new LinkedList<>();
        }
        rows.add(dto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         sb.append("RowRawTSPkgDto{" +
                "startKey='" + startKey + '\'' +
                ", endKey='" + endKey + '\'' +
                ", rows=[");
        for(RowRawTSDto dto :rows) {
            sb.append(dto.getRowkey()).append(",");
        }
        sb.append("]}");
        return sb.toString();
    }

    public String toStringRowKey(){
        return "RowRawTSPkgDto{" +
                "startKey='" + startKey + '\'' +
                ", endKey='" + endKey + '\'' +
                ", rows=" + rows +
                '}';
    }

    public String getStartKey() {
        return startKey;
    }

    public void setStartKey(String startKey) {
        this.startKey = startKey;
    }

    public String getEndKey() {
        return endKey;
    }

    public void setEndKey(String endKey) {
        this.endKey = endKey;
    }

    public List<RowRawTSDto> getRows() {
        return rows;
    }

    public void setRows(List<RowRawTSDto> rows) {
        this.rows = rows;
    }
}

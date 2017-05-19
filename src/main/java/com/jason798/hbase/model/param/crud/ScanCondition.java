package com.jason798.hbase.model.param.crud;


import com.jason798.character.StringCheckUtil;
import com.jason798.collection.CollectionUtil;
import com.jason798.hbase.model.constant.HbaseConstant;

import java.util.*;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ScanCondition {

    /**
     * rowkey
     */
    private String startRowKey;
    /**
     * The scan will include rows that are lexicographically less than the provided stopRow.
     * Note: When doing a filter for a rowKey Prefix use setRowPrefixFilter(byte[]). The 'trailing 0' will not yield the desired result.
     */
    private String endRowKey;
    /**
     * NOTE: Doing a setStartRow(byte[]) and/or setStopRow(byte[]) after this method will yield undefined results.
     */
    private String rowKeyPrefix = null;

    /**
     * column-qualifier
     */
    private Map<String, List<String>> columnQualifier = new HashMap<>();

    /**
     * specfied timestamp
     */
    private Long timestamp;
    /**
     * start ~ end timestamp
     */
    private Long startTimestamp;
    private Long endTimestamp;

    private Integer limit;// setMaxResultSize
    /**
     * get row's all version
     */
    private Boolean maxVersion = false;
    /**
     * is scan from end to start,default forward
     */
    private Boolean reverse = false;

    private Boolean manualPageFilter = true;

    public String getSingleColumn(){
        if(CollectionUtil.isEmpty(columnQualifier.keySet())){
            return null;
        }
        Set<String> cols = columnQualifier.keySet();
        if(CollectionUtil.isEmpty(cols)){
            return null;
        }
        for(String col:cols){
            return col;
        }
        return null;
    }

    public void addColumn(String column) {
        if (StringCheckUtil.isEmpty(column))
            if (columnQualifier == null) {
                columnQualifier = new HashMap<>();
            }
        columnQualifier.put(column, null);
    }

    public void addColumnQualifiers(String column, String[] qualifiers) {
        List<String> qualifiersList = new ArrayList<>();
        Collections.addAll(qualifiersList, qualifiers);
        addColumnQualifiers(column, qualifiersList);
    }

    public void addColumnQualifiers(String column, List<String> qualifiers) {
        if (CollectionUtil.isEmpty(qualifiers) || StringCheckUtil.isEmpty(column)) {
            return;
        }
        //String[] oldQualifiers = columnQualifier.get(column);
        List<String> oldQualifiers = columnQualifier.get(column);
        if (CollectionUtil.isEmpty(oldQualifiers)) {
            columnQualifier.put(column, qualifiers);
        } else {
            /*
            String[] newQualifiers = new String[oldQualifiers.length+qualifiers.length];
            System.arraycopy(oldQualifiers,0,newQualifiers,0,oldQualifiers.length);
            System.arraycopy(qualifiers,0,newQualifiers,oldQualifiers.length,qualifiers.length);
            */
            oldQualifiers.addAll(qualifiers);
            columnQualifier.put(column, oldQualifiers);
        }
    }

    public void addDefaultColumnQualifiers(List<String> qualifiers) {
        addColumnQualifiers(HbaseConstant.DFT_COL_FAMILY, qualifiers);
    }

    public void addDefaultColumnQualifiers(String[] qualifiers) {
        addColumnQualifiers(HbaseConstant.DFT_COL_FAMILY, qualifiers);
    }


    public void addColumnQualifier(String column, String qualifier) {
        if (columnQualifier == null) {
            columnQualifier = new HashMap<>();
        }
        List<String> qualifiers = columnQualifier.get(column);
        if (CollectionUtil.isEmpty(qualifiers)) {
            qualifiers = new LinkedList<>();//new String[1];
        }
        //String[] newQualifiers = new String[qualifiers.length+1];
        //System.arraycopy(qualifiers,0,newQualifiers,1,qualifiers.length);
        //qualifiers = newQualifiers;

        //qualifiers[0] = qualifier;
        qualifiers.add(qualifier);
        columnQualifier.put(column, qualifiers);
    }

    public void addDefaultColumnQualifier(String qualifier) {
        addColumnQualifier(HbaseConstant.DFT_COL_FAMILY, qualifier);
    }


    public String getRowKeyPrefix() {
        return rowKeyPrefix;
    }

    public void setRowKeyPrefix(String rowKeyPrefix) {
        this.rowKeyPrefix = rowKeyPrefix;
    }

    public Boolean getReverse() {
        return reverse;
    }

    public void setReverse(Boolean reverse) {
        this.reverse = reverse;
    }

    public String getStartRowKey() {
        return startRowKey;
    }

    public void setStartRowKey(String startRowKey) {
        this.startRowKey = startRowKey;
    }

    public String getEndRowKey() {
        return endRowKey;
    }

    public void setEndRowKey(String endRowKey) {
        this.endRowKey = endRowKey;
    }

    public Map<String, List<String>> getColumnQualifier() {
        return columnQualifier;
    }

    public void setColumnQualifier(Map<String, List<String>> columnQualifier) {
        this.columnQualifier = columnQualifier;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getMaxVersion() {
        return maxVersion;
    }

    public void setMaxVersion(Boolean maxVersion) {
        this.maxVersion = maxVersion;
    }


    public Boolean getManualPageFilter() {
        return manualPageFilter;
    }

    public void setManualPageFilter(Boolean manualPageFilter) {
        this.manualPageFilter = manualPageFilter;
    }

    public String formatCondition(String tableName){
        StringBuilder sb =new StringBuilder();
        sb.append("select ").append(columnQualifier).append(" from")
                .append(" ").append(tableName).append(" ").append("where")
                .append("start key is ").append(startRowKey).append(" ")
                .append("end key is ").append(endRowKey).append(" ")
                .append("row key prefix ").append(rowKeyPrefix).append(" ")
                .append("start ts is ").append(startTimestamp).append(" ")
                .append("end ts is ").append(endTimestamp).append(" ")
                .append("spec ts is ").append(timestamp).append(" ")
                .append("limit is ").append(limit).append(" ")
                .append("manual page filter ").append(manualPageFilter).append(" ");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ScanCondition{" +
                "startRowKey='" + startRowKey + '\'' +
                ", endRowKey='" + endRowKey + '\'' +
                ", rowKeyPrefix='" + rowKeyPrefix + '\'' +
                ", columnQualifier=" + columnQualifier +
                ", timestamp=" + timestamp +
                ", startTimestamp=" + startTimestamp +
                ", endTimestamp=" + endTimestamp +
                ", limit=" + limit +
                ", maxVersion=" + maxVersion +
                ", reverse=" + reverse +
                '}';
    }
}

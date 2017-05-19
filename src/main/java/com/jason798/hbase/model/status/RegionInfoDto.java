package com.jason798.hbase.model.status;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RegionInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;
	Map<String,String> regionInfo = new HashMap<>();

    public RegionInfoDto(){

    }

    @Override
    public String toString() {
        return "RegionInfoDto{" +
                "regionInfo=" + regionInfo +
                '}';
    }

    public Map<String, String> getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(Map<String, String> regionInfo) {
        this.regionInfo = regionInfo;
    }

    public void add(String key, String value){
        regionInfo.put(key,value);
    }

}

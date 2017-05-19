package com.jason798.hbase.model.status;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerInfoDto implements Serializable{
	private static final long serialVersionUID = 1L;

	Map<String,String> serverInfo = new HashMap<>();

    List<RegionInfoDto> regions = new LinkedList<>();


    public ServerInfoDto(){}

    public void add(String key,String value){
        serverInfo.put(key,value);
    }


    public void addRegion(RegionInfoDto regionInfoDto){
        regions.add(regionInfoDto);
    }

    public Map<String, String> getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(Map<String, String> serverInfo) {
        this.serverInfo = serverInfo;
    }

    public List<RegionInfoDto> getRegions() {
        return regions;
    }

    public void setRegions(List<RegionInfoDto> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "ServerInfoDto{" +
                "serverInfo=" + serverInfo +
                ", regions=" + regions +
                '}';
    }
}

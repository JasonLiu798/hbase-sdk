package com.jason798.hbase.model.status;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * K:clusterInfo V:map
 * K:servers V:arr {K:serverInfo map,V:regions arr[K:regionInfo map]}
 *
 */
public class ClusterInfoDto implements Serializable{
	private static final long serialVersionUID = 9188086460632946242L;
	Map<String,String> clusterInfo = new HashMap<>();
    List<ServerInfoDto> servers = new LinkedList<>();

    public void add(String key, String value){
        clusterInfo.put(key,value);
    }

    public void addServer(ServerInfoDto serverInfoDto){
        servers.add(serverInfoDto);
    }


    /**
     * K:server name
     * V:{K:region name,K:}
     *
     */

    @Override
    public String toString() {
        return "ClusterInfoDto{" +
                "clusterInfo=" + clusterInfo +
                ", servers=" + servers +
                '}';
    }

    public Map<String, String> getClusterInfo() {
        return clusterInfo;
    }

    public void setClusterInfo(Map<String, String> clusterInfo) {
        this.clusterInfo = clusterInfo;
    }

    public List<ServerInfoDto> getServers() {
        return servers;
    }

    public void setServers(List<ServerInfoDto> servers) {
        this.servers = servers;
    }

}

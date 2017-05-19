package com.jason798.hbase.action.admin.impl;

import com.jason798.character.StringCheckUtil;
import com.jason798.hbase.action.AdminParamReturnAction;
import com.jason798.hbase.api.HBaseException;
import com.jason798.hbase.model.param.admin.ClusterInfoParam;
import com.jason798.hbase.model.status.ClusterInfoDto;
import com.jason798.hbase.model.status.RegionInfoDto;
import com.jason798.hbase.model.status.ServerInfoDto;
import org.apache.hadoop.hbase.ClusterStatus;
import org.apache.hadoop.hbase.RegionLoad;
import org.apache.hadoop.hbase.ServerLoad;
import org.apache.hadoop.hbase.ServerName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class ClusterInfoAction implements AdminParamReturnAction<ClusterInfoParam, ClusterInfoDto> {
	
	@Override
	public ClusterInfoDto service(Admin admin, ClusterInfoParam param) throws HBaseException {
		ClusterInfoDto dto = new ClusterInfoDto();
		String regionPrefix = param.getRegionPrefix();
		boolean filterRegion = false;
		if (!StringCheckUtil.isEmpty(regionPrefix)) {
			filterRegion = true;
		}
		ClusterStatus status = null;
		try {
			status = admin.getClusterStatus();
		} catch (IOException e) {
			throw new HBaseException();
		}
		dto.add("hbase version", status.getHBaseVersion());
		dto.add("version", String.valueOf(status.getVersion()));
		dto.add("No. live server", String.valueOf(status.getServersSize()));
		dto.add("cluster id", status.getClusterId());
		
		dto.add("No. region", String.valueOf(status.getRegionsCount()));
		dto.add("No. request", String.valueOf(status.getRequestsCount()));
		dto.add("Avg Load", String.valueOf(status.getAverageLoad()));
		dto.add("dead servers", String.valueOf(status.getDeadServerNames()));
		
		Collection<ServerName> servers = status.getServers();
		for (ServerName server : servers) {
			ServerInfoDto serverInfoDto = new ServerInfoDto();
			serverInfoDto.add("hostname", server.getHostname());
			serverInfoDto.add("host and port", server.getHostAndPort());
			serverInfoDto.add("servername", server.getServerName());
			serverInfoDto.add("rpc port", String.valueOf(server.getPort()));
			serverInfoDto.add("start time", String.valueOf(server.getStartcode()));
			
			ServerLoad load = status.getLoad(server);
			serverInfoDto.add("load", String.valueOf(load.getLoad()));
			serverInfoDto.add("max heap(MB)", String.valueOf(load.getMaxHeapMB()));
			serverInfoDto.add("memstore size(MB)", String.valueOf(load.getMemstoreSizeInMB()));
			serverInfoDto.add("No. regions", String.valueOf(load.getNumberOfRegions()));
			serverInfoDto.add("No. req", String.valueOf(load.getNumberOfRequests()));
			serverInfoDto.add("storefile index size(MB)", String.valueOf(load.getStorefileIndexSizeInMB()));
			serverInfoDto.add("No. storefiles", String.valueOf(load.getStorefiles()));
			serverInfoDto.add("storefile size(MB)", String.valueOf(load.getStorefileSizeInMB()));
			serverInfoDto.add("used heap(MB)", String.valueOf(load.getUsedHeapMB()));
			
			for (Map.Entry<byte[], RegionLoad> entry : load.getRegionsLoad().entrySet()) {
				RegionInfoDto regionInfoDto = new RegionInfoDto();
				RegionLoad regionLoad = entry.getValue();
				String regionName = Bytes.toStringBinary(regionLoad.getName());
				if (filterRegion) {
					if (!regionName.startsWith(regionPrefix)) {
						continue;
					}
				}
				regionInfoDto.add("name", regionName);
				regionInfoDto.add("No. stores", String.valueOf(regionLoad.getStores()));
				regionInfoDto.add("No. storefiles", String.valueOf(regionLoad.getStorefiles()));
				regionInfoDto.add("storefile size(MB)", String.valueOf(regionLoad.getStorefileSizeMB()));
				regionInfoDto.add("storefile index size(MB)", String.valueOf(regionLoad.getStorefileIndexSizeMB()));
				regionInfoDto.add("memstore size(MB)", String.valueOf(regionLoad.getMemStoreSizeMB()));
				regionInfoDto.add("No. req", String.valueOf(regionLoad.getRequestsCount()));
				regionInfoDto.add("No. read req", String.valueOf(regionLoad.getReadRequestsCount()));
				regionInfoDto.add("No. write req", String.valueOf(regionLoad.getWriteRequestsCount()));
				serverInfoDto.addRegion(regionInfoDto);
			}
			dto.addServer(serverInfoDto);
		}
		return dto;
	}
}

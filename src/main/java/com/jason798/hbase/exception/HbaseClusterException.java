package com.jason798.hbase.exception;

import org.apache.hadoop.hbase.ServerName;

import java.util.Collection;

/**
 * Created by async on 2016/8/6.
 */
public class HbaseClusterException {
	private int HbaseMasterState;   //HbaseMaster状态
	private int DeadRegionServers;
	private Collection<ServerName> DeadRegionServerNames;

	public int getHbaseMasterState() {
		return HbaseMasterState;
	}
	public void setHbaseMasterState(int hbaseMasterState) {
		HbaseMasterState = hbaseMasterState;
	}
	public int getDeadRegionServers() {
		return DeadRegionServers;
	}
	public void setDeadRegionServers(int deadRegionServers) {
		DeadRegionServers = deadRegionServers;
	}
	public Collection<ServerName> getDeadRegionServerNames() {
		return DeadRegionServerNames;
	}
	public void setDeadRegionServerNames(
			Collection<ServerName> deadRegionServerNames) {
		DeadRegionServerNames = deadRegionServerNames;
	}
}

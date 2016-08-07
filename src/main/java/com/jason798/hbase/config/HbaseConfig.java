package com.jason798.hbase.config;

import javax.annotation.PostConstruct;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;


public class HbaseConfig {
	private String hbase_zookeeper_quorum;
	private String hbase_zookeeper_property_clientPort;
	private String hbase_master;
	
	private Configuration conf;

	@PostConstruct
	public void init(){
		conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", hbase_zookeeper_quorum);
		conf.set("hbase.zookeeper.property.clientPort", hbase_zookeeper_property_clientPort);
		conf.set("hbase.master",hbase_master);
	}
	
	public synchronized Configuration getConfiguration(){
		if(conf==null){
			init();
		}
		return conf;
	}

	@Override
	public String toString() {
		return "HbaseConfig [hbase_zookeeper_quorum=" + hbase_zookeeper_quorum
				+ ", hbase_zookeeper_property_clientPort="
				+ hbase_zookeeper_property_clientPort + ", hbase_master="
				+ hbase_master + ", conf=" + conf + "]";
	}
	
}

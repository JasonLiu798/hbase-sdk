package com.jason798.hbase.model.param.admin;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class ClusterInfoParam {
	public ClusterInfoParam(){
	}

	public ClusterInfoParam(String regionPrefix) {
		super();
		this.regionPrefix = regionPrefix;
	}
	
	private String regionPrefix;

	@Override
	public String toString() {
		return "ClusterInfoParam{" +
				"regionPrefix='" + regionPrefix + '\'' +
				'}';
	}

	public String getRegionPrefix() {
		return regionPrefix;
	}

	public void setRegionPrefix(String regionPrefix) {
		this.regionPrefix = regionPrefix;
	}
}

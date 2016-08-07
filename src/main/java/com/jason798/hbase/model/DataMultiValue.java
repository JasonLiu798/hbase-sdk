package com.jason798.hbase.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by async on 2016/8/6.
 */
public class DataMultiValue implements Serializable {

	private static final long serialVersionUID = 2345634763456L;
	private String rowKey;
	private String familyKey;
	private Map<String,String> qualifiers;
	private long ts;

}

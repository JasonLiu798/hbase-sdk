package com.jason798.hbase.api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by async on 2016/8/6.
 */
public interface Condition {
	final public String OPER_EQUAL = "OPER_EQUAL";
	final public String OPER_BIG = "OPER_BIG";
	final public String OPER_BETWEEN = "OPER_BETWEEN";

	final public String TYPE_DATE = "TYPE_DATE";
	final public String TYPE_STRING = "TYPE_STRING";

	final public DateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	final public DateFormat dateF = new SimpleDateFormat("YYYYMMdd");


}

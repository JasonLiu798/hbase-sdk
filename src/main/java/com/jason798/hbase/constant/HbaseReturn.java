package com.jason798.hbase.constant;

/**
 * Created by async on 2016/8/6.
 */
public class HbaseReturn {
	public static final int TABLE_ISENABLED = 0;//table可用

	public static final int TABLE_ISUNAVAILABLE = 1;//table不存在

	public static final int TABLE_ISDISABLED = 2;   //table禁用

	public static final int HBASE_NORMALSTATE = 3;  //hbase正常状态

	public static final int HBASE_MASTERNOTRUNNING = 4; //HbaseMaster没有运行

	public static final int ZOOKEEPER_CONNECTION = 5;   //zookeeper链接出问题

	public static final int IO_EXCEPTION = 6;   //regionserver异常

}

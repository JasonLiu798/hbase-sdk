package com.jason798.hbase.model.constant;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseConstant {

	public static final String CONF_PREFIX_KEY = "hbase.prefix";
	public static final String CONF_DFT_FILE = "hbase.properties";


	public static final String TAB_NAME = "tableName";
	public static final String ROW_KEY = "rowKey";
	public static final String COL_FAMILY = "columnFamily";

	public static final String DFT_COL_FAMILY = "f1";
	public static final int DFT_SELECT_MAX_SIZE = 100;


	public static final String ACTION_DELETE = "ACTION DELETE";

	public static final String ACTION_PUT = "ACTION PUT";

	public static final String ACTION_SCAN = "ACTION SCAN";

	public static final String ACTION_GET = "ACTION GET";

	public static final String ROW_KEY_END = "ROW_KEY_END";
	public static final String ROW_KEY_START = "ROW_KEY_START";
}

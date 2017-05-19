package com.jason798.hbase.model.param.crud;

import com.jason798.hbase.model.param.crud.base.PutRowParam;

import java.util.Map;

/**
 * @author JasonLiu798
 * @since 1.0
 */
public class PutRowByteParam extends PutRowParam {
	/**
	 * key:qualifer
	 * value:value
	 */
	private Map<String,Object> byteValuess;

	public PutRowByteParam(){
	}


	public PutRowByteParam(String rowKey, String columnFamily, Map<String, String> values, Map<String, Object> bytes) {
		super(rowKey, columnFamily, values);
		this.byteValuess = bytes;
	}

	public PutRowByteParam(String rowKey, String columnFamily, Map<String, String> values,Map<String, Object> bytes, boolean checkExist) {
		super(rowKey, columnFamily, values, checkExist);
		this.byteValuess = bytes;
	}

	public void setByteValuess(Map<String, Object> byteValuess) {
		this.byteValuess = byteValuess;
	}


	public Map<String, Object> getByteValuess() {
		return byteValuess;
	}

	@Override
	public String toString() {
		return super.toString()+" PutRowByteParam{" +
				"byteValuess=" + byteValuess +
				'}';
	}
}

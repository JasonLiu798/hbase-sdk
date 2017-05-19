package com.jason798.hbase.model.resp;


import com.jason798.hbase.model.ValueTS;

import java.util.Map;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class RowTsModel extends RowMeta {//no ts
	/**
	 * key: columnFamily
	 * value: 
	 * 		key: qualifier
	 * 		value: 
	 * 				value
	 * 				timestamp
	 */
	private Map<String, ValueTS> values;

	public RowTsModel(){
	}
	public RowTsModel(String rowKey, String columnFamily) {
		super(rowKey, columnFamily);
	}

	public Map<String, ValueTS> getValues() {
		return values;
	}

	public void setValues(Map<String, ValueTS> values) {
		this.values = values;
	}


	public RowTsModel(String rowKey, String columnFamily, Map<String, ValueTS> values) {
		super(rowKey, columnFamily);
		this.values = values;
	}

	@Override
	public String toString() {
		return super.toString()+" RowTsModel{" +
				"values=" + values +
				'}';
	}
}

package com.jason798.hbase.model;

import com.jason798.hbase.api.Condition;
import com.jason798.hbase.config.ConditionMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by async on 2016/8/6.
 */
public class HBaseConditonMaker  extends HBaseCondition implements
		ConditionMaker {

	private List<Condition> listConditons = new ArrayList<Condition>();
	protected String[] familyNames;

	private String logicName;

	public String getLogic() {
		return logicName;
	}

	public void setLogic(String logic) {
		this.logicName = logic;
	}

	@Override
	public Condition getCondition(int index) {
		return listConditons.get(index);
	}

	@Override
	public void addCondition(Condition condition) {
		listConditons.add(condition);

	}

	public int getConditionIndex(){
		if(listConditons != null){
			return listConditons.size();
		}

		return -1;

	}
}

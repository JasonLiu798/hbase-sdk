package com.jason798.hbase.config;

import com.jason798.hbase.api.Condition;

/**
 * Created by async on 2016/8/6.
 */
public interface ConditionMaker {

	public String CONDITION_AND = "and";
	public String CONDITION_OR = "or";
	public String CONDITION_NOT = "not";
	public String CONDITION_NULL = "nologic";

	public void addCondition(Condition condition);

	public Condition getCondition(int index);

}

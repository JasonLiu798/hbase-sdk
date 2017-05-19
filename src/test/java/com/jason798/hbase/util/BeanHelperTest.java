
package com.jason798.hbase.util;

import java.lang.reflect.Method;
import java.util.List;

import com.jason798.common.ReflectUtil;
import com.jason798.hbase.model.TestModel;

import org.junit.Test;


@SuppressWarnings("unchecked")
public class BeanHelperTest {
	
	@Test
	public void testClazzList() throws Exception{
		Class<?> clz = Class.forName("com.sf.novatar.tpl.hbase.util.BeanHelper");
		Method method = clz.getDeclaredMethod("clazzList",Object.class,ReflectUtil.ParentOpt.class);
		method.setAccessible(true);
		TestModel m = new TestModel();
		List<Class<?>> res =  (List<Class<?>>) method.invoke(null, m,ReflectUtil.ParentOpt.ALL);
		System.out.println("ALL:"+res);
		res =  (List<Class<?>>) method.invoke(null, m,ReflectUtil.ParentOpt.ALLPARENT);
		System.out.println("ONLY parent :"+res);
	}

}

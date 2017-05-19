
package com.jason798.hbase.core;

/**
 *
 * @author JasonLiu798
 * @since 1.0
 */
public class HbaseContext {
	/*
	private static Map<Class, LiteralInterpreter> buildInliteralInterpreterCache = new ConcurrentHashMap<Class, LiteralInterpreter>();
	//private Map<Class, LiteralInterpreter> literalInterpreterCache = new HashMap<Class, LiteralInterpreter>();
	static {
		List<LiteralInterpreter> buildInLiteralInterpreterList = new ArrayList<LiteralInterpreter>();
        buildInLiteralInterpreterList.add(new BooleanInterpreter());
        buildInLiteralInterpreterList.add(new ByteInterpreter());
        buildInLiteralInterpreterList.add(new CharInterpreter());
        buildInLiteralInterpreterList.add(new DateInterpreter());
        buildInLiteralInterpreterList.add(new DoubleInterpreter());
        buildInLiteralInterpreterList.add(new FloatInterpreter());
        buildInLiteralInterpreterList.add(new IntegerInterpreter());
        buildInLiteralInterpreterList.add(new LongInterpreter());
        buildInLiteralInterpreterList.add(new ShortInterpreter());
        buildInLiteralInterpreterList.add(new StringInterpreter());
        for (LiteralInterpreter interpreter : buildInLiteralInterpreterList) {
            Class type = BeanHelper.tryConvertToBoxClass(interpreter
                    .getTypeCanInterpret());
            buildInliteralInterpreterCache.put(type, interpreter);
        }
	}
	
	public Object interpret(Class type, String literalValue) {
        CheckUtil.checkNull(type);
        CheckUtil.checkNull(literalValue);
        Class temType = BeanHelper.tryConvertToBoxClass(type);
        /*
        if (literalInterpreterCache.containsKey(temType)) {
            return literalInterpreterCache.get(temType).interpret(literalValue);
        }
        if (buildInliteralInterpreterCache.containsKey(temType)) {
            return buildInliteralInterpreterCache.get(temType).interpret(
                    literalValue);
        }
        Object result = null;
        if (temType.isEnum()) {
            result = Enum.valueOf(type, literalValue);
        }
        CheckUtil.checkNull(result);
        return result;
    }
	
	public <T> T map2object(Map<String, String> paramMap,Class<T> clz) throws InstantiationException, IllegalAccessException {
        if (paramMap == null || paramMap.isEmpty())
            throw new IllegalArgumentException("parameter paramMap must have a value");
        //throw new IllegalArgumentException("bean the value of must be instantiated");
        T obj = clz.newInstance();
        // 获得key迭代器
        Iterator<String> it = paramMap.keySet().iterator();
        while (it.hasNext()) {
            String fieldName = it.next();
//            interpret()
//            setFieldValue(bean, fieldName, paramMap.get(fieldName));
        }
        return obj;
    }*/
	
	
}

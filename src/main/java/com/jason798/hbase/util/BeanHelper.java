package com.jason798.hbase.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * TODO:need refactor
 */
public final class BeanHelper {
	
	/**
	 * 获取属性值选项：
	 *  0   获取本类和所有父类
     * 	1   只获取本类
     *  2 只获取上一级父类
     *  3 获取所有父类
	 */
	public enum ParentOpt{
		ALL,//本类和所有父类，
		SELF,//只获取本类
		PARENT,//只获取上一级父类
		ALLPARENT,//获取所有父类
	}
	
	private static Map<Class<?>, Class<?>> boxTypeMap     = new HashMap<Class<?>, Class<?>>();

    static {
        boxTypeMap.put(byte.class, Byte.class);
        boxTypeMap.put(short.class, Short.class);
        boxTypeMap.put(int.class, Integer.class);
        boxTypeMap.put(long.class, Long.class);
        boxTypeMap.put(char.class, Character.class);
        boxTypeMap.put(float.class, Float.class);
        boxTypeMap.put(double.class, Double.class);
        boxTypeMap.put(boolean.class, Boolean.class);
    }
	
    /**
     * get
     */
    private static final String GET = "get";

    /**
     * Returns boxer of c or c if c can't be boxed.
     * */
    public static Class<?> tryConvertToBoxClass(Class<?> c) {
        CheckUtil.checkNull(c);
        if (boxTypeMap.containsKey(c)) {
            return boxTypeMap.get(c);
        }
        return c;
    }
    
    
    
    /**
     * 得到当前类父类列表
     *
     * @param bean
     *            {@link Object} 待取值的bean
     * @return {@link Map}
     * @throws Exception 
     */
    public static Map<String, String> getFieldMap(Object bean) throws Exception {
        return convert(getFieldValueMap(bean, false));
    }
    public static Map<String, String> getFieldMapAll(Object bean) throws Exception {
        return convert(getFieldValueMapAll(bean, false));
    }
    

    /**
     * 取Bean的属性和值对应关系的MAP
     *
     * @param bean
     *            {@link Object} 待取值的bean
     * @param allowNullValue
     *            {@link Boolean} 允许空值
     * @return {@link Map}
     * @throws Exception 
     */
    public static Map<String, String> getFieldMap(Object bean, boolean allowNullValue) throws Exception {
        return convert(getFieldValueMap(bean, allowNullValue));
    }

    /**
     * 取Bean的属性和值对应关系的MAP
     *
     * @param bean
     *            {@link Object} 待取值的bean
     * @param allowNullValue
     *            {@link Boolean} 允许空值
     * @param ignores
     *            {@link String}[] 忽略属性列表
     * @return {@link Map}
     * @throws Exception 
     */
    public static Map<String, String> getFieldMap(Object bean, boolean allowNullValue, String[] ignores) throws Exception {
        return convert(getFieldValueMapAll(bean, allowNullValue, ignores));
    }
    
    public static Map<String, String> getFieldMapAllSpec(Object bean,String[] sepcifies) throws Exception {
    	return convert(getFieldValueMapAllSpec(bean, sepcifies));
    }
    
    
    /**
     * 取Bean的属性和值对应关系的MAP
     *
     * @param bean
     *            {@link Object} 待取值的bean
     * @return Map
     * @throws Exception 
     */
    public static Map<String, Object> getFieldValueMap(Object bean) throws Exception {
        return getFieldValueMap(bean, true, ParentOpt.SELF, null, null);
    }
    public static Map<String, Object> getFieldValueMapAll(Object bean) throws Exception {
        return getFieldValueMap(bean, true,ParentOpt.ALL, null,null);
    }
    public static Map<String, Object> getFieldValueMapParent(Object bean) throws Exception {
        return getFieldValueMap(bean, true, ParentOpt.PARENT, null,null);
    }
    public static Map<String, Object> getFieldValueMap(Object bean,boolean allowNullValue) throws Exception {
        return getFieldValueMap(bean, allowNullValue, ParentOpt.SELF, null,null);
    }
    public static Map<String, Object> getFieldValueMapAll(Object bean,boolean allowNullValue) throws Exception {
        return getFieldValueMap(bean, allowNullValue, ParentOpt.ALL, null,null);
    }
    public static Map<String, Object> getFieldValueMapAll(Object bean,boolean allowNullValue,String[] ignores) throws Exception {
        return getFieldValueMap(bean, true, ParentOpt.ALL, ignores,null);
    }
    
    /**
     * 获取bean，指定 field 
     * @param bean
     * @param sepcifies
     * @return
     * @throws Exception
     * Map<String,Object>
     */
    public static Map<String, Object> getFieldValueMapAllSpec(Object bean,String[] sepcifies) throws Exception {
        return getFieldValueMap(bean, true, ParentOpt.ALL, null,sepcifies);
    }
    public static Map<String, Object> getFieldValueMapAllSpec(Object bean,boolean allowNullValue,String[] sepcifies) throws Exception {
        return getFieldValueMap(bean, allowNullValue, ParentOpt.ALL, null,sepcifies);
    }
    /**
     * 取Bean的属性和值对应关系的MAP
     *
     * @param obj
     *            {@link Object} 待取值的bean
     * @param allowNullValue {@link Boolean} 允许空值
     * @param parentOpt {@link Integer} 
     * 	获取父类值选项：
     * 		0   只获取本类
     *  	1 获取本类和所有父类
     *  	2 只获取上一级父类
     *  	3 获取所有父类
     * @param specifies 
     * 	{@link String}[] 指定field列表
     * 		空，不影响结果；
     * 		不为空，只获取指定的field列表
     * @param ignores 
     *  {@link String}[] 忽略field列表
     *  	空，不影响结果；
     *  	不为空，指定field不加入结果集
     * @return {@link Map}
     */
    public static Map<String, Object> getFieldValueMap(Object obj,
    		boolean allowNullValue,ParentOpt parentOpt, 
    		String[] ignores,String[] specifies) throws Exception{
    	List<Class<?>> clazzList = new LinkedList<>();
    	switch (parentOpt) {
    	case ALL:
    		clazzList = clazzList(obj);
    		break;
		case PARENT:
			Class<?> clz = obj.getClass().getSuperclass();
			if(clz == Object.class){
				throw new Exception();
			}
			clazzList.add(clz);
			break;
		case ALLPARENT:
			clazzList = clazzList(obj,ParentOpt.ALLPARENT);
			break;
		default://默认只获取本类
			clazzList.add(obj.getClass());
			break;
    	}
        Map<String, Object> valueMap = new HashMap<String, Object>();
        
        boolean specified = false;
        List<String> specifiedList = null;
        if(specifies!=null && specifies.length!=0){
        	specified = true;
        	specifiedList = Arrays.asList(specifies);
        }
        
        boolean ignored = false;
        List<String> ignoreList = null;
        if(ignores!=null && ignores.length!=0){
        	ignored = true;
        	ignoreList = Arrays.asList(ignores);
        }
        
        for (Class<?> cls : clazzList) {
            // 取出bean里的所有方法
            Method[] methods = cls.getDeclaredMethods();
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                try {
                    String fieldGetName = parGetName(field.getName());
                    //in specified list field,not ignore
//                    if (specified && Arrays.asList(specifies).indexOf(field.getName()) != -1){
//                    	
//                    }
                    
                    //process ignore 
                    if ( !specified && 
                    		ignored && 
                    		ignoreList.indexOf(field.getName()) != -1) {
                        continue;
                    }
                    
                    //process not specified field 
                    if ( specified && 
                    		specifiedList.indexOf(field.getName()) != -1){
                    	continue;
                    }
                    
                    //check get method exist
                    if ( !checkGetMethod(methods, fieldGetName)) {
                        continue;
                    }
                    Method fieldGetMet = cls.getMethod(fieldGetName, new Class[] {});
                    Object fieldVal = fieldGetMet.invoke(obj, new Object[] {});
                    
                    //process allow null 
                    if (allowNullValue) {
                        valueMap.put(field.getName(), fieldVal);
                        continue;
                    }
                    
                    //not allow null,not add
                    if (fieldVal == null || isEmpty(fieldVal)) {
                        continue;
                    }
                    valueMap.put(field.getName(), fieldVal);
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return valueMap;
    }
    

    /**
     * 得到当前类父类列表
     *
     * @param bean
     *            {@link Object} 待取值的bean
     * @return
     */
    public static List<Class<?>> clazzList(Object bean){
    	return clazzList(bean,ParentOpt.ALL);
    }
    private static List<Class<?>> clazzList(Object bean,ParentOpt opt) {
        List<Class<?>> clazzList = new LinkedList<Class<?>>();
        for (Class<?> clazz = bean.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
            	if(opt == ParentOpt.ALLPARENT && clazz == bean.getClass()){
            		continue;
            	}
            	clazzList.add(clazz);
            } catch (Exception e) {
                // 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会执行clazz =
                // clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return clazzList;
    }
    
    

    /**
     * 转换数据类型
     *
     * @param paramMap
     *            {@link Map} 待转换的数据
     * @return Map<String, String>
     */
    public static Map<String, String> convert(Map<String, Object> paramMap) {
        Map<String, String> params = new HashMap<String, String>();
        Iterator<String> keys = paramMap.keySet().iterator();
        while (keys.hasNext()) {
            String mapKey = keys.next();
            Object value = paramMap.get(mapKey);
            params.put(mapKey, value == null ? "" : value.toString());
        }
        return params;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredMethod
     *
     * @param object
     *            {@link Object} 子类对象
     * @param methodName
     *            {@link String} 父类中的方法名
     * @param parameterTypes
     *            {@link String}父类中的方法参数类型
     * @return {@link Method} 父类中的方法对象
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
        Method method = null;
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {
                // 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会执行clazz =
                // clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 直接调用对象方法, 而忽略修饰符(private, protected, default)
     *
     * @param object
     *            {@link Object} 子类对象
     * @param methodName
     *            {@link String} 父类中的方法名
     * @param parameterTypes
     *            {@link Class} 父类中的方法参数类型
     * @param parameters
     *            {@link Object} 父类中的方法参数
     * @return {@link Object} 父类中方法的执行结果
     */

    public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
        // 根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
        Method method = getDeclaredMethod(object, methodName, parameterTypes);
        // 抑制Java对方法进行检查,主要是针对私有方法而言
        method.setAccessible(true);
        try {
            if (null != method) {
                // 调用object 的 method 所代表的方法，其方法的参数是 parameters
                return method.invoke(object, parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 循环向上转型, 获取对象的 DeclaredField
     *
     * @param object
     *            {@link Object} 子类对象
     * @param fieldName
     *            {@link String} 父类中的属性名
     * @return {@link String} 父类中的属性对象
     */
    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                // 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                // 如果这里的异常打印或者往外抛，则就不会执行clazz =
                // clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
     *
     * @param object
     *            {@link Object} 子类对象
     * @param fieldName
     *            {@link String} 父类中的属性名
     * @param value
     *            {@link String} 将要设置的值
     */
    public static void setFieldValue(Object object, String fieldName, Object value) {
        // 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);
        try {
            // 如果获取的属性为空直接返回Null
            if (field == null) {
                return;
            }
            // 抑制Java对其的检查
            field.setAccessible(true);
            // 将 object 中 field 所代表的值 设置为 value
            field.set(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    /**
     * 将Map中的值设置到bean中，bean必须是实例化后的对象
     *
     * @param paramMap
     *            {@link Map} 参数Map
     * @param bean
     *            {@link Object} 赋值后的对象
     */
    public static void setBean(Map<String, Object> paramMap, Object bean) {
        if (paramMap == null || paramMap.isEmpty())
            throw new IllegalArgumentException("parameter paramMap must have a value");
        if (bean == null)
            throw new IllegalArgumentException("bean the value of must be instantiated");
        // 获得key迭代器
        Iterator<String> it = paramMap.keySet().iterator();
        while (it.hasNext()) {
            String fieldName = it.next();
            setFieldValue(bean, fieldName, paramMap.get(fieldName));
        }
    }
    
    

    /**
     * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
     *
     * @param object
     *            {@link Object} 子类对象
     * @param fieldName
     *            {@link String} 父类中的属性名
     * @return {@link Object} 父类中的属性值
     */

    public static Object getFieldValue(Object object, String fieldName) {
        // 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);
        // 如果获取的属性为空直接返回Null
        if (field == null) {
            return null;
        }
        try {
            // 抑制Java对其的检查
            field.setAccessible(true);
            // 获取 object 中 field 所代表的属性值
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断是否存在某属性的 get方法
     *
     * @param methods
     *            {@link Method} 方法数组
     * @param fieldGetMet
     *            {@link String} 属性get方法名称
     * @return boolean 检查属性Get方法是否存在
     */
    private static boolean checkGetMethod(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 拼接某属性的 get方法
     *
     * @param fieldName
     * @return String
     */
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        return GET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    /**
     * 对象属性copy
     *
     * @param source
     *            {@link Object} 拷贝对象来源
     * @param target
     *            {@link Object} 拷贝到目标对象
     * @param ignores
     *            {@link String[]} 忽略的属性名称
     * @param allowNull
     *            {@link Boolean} 允许空值
     */
    public static void copyProperties(Object source, Object target, String[] ignores, boolean allowNull) {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            if ("serialVersionUID".equals(field.getName())) {
                continue;
            }
            String fieldName = field.getName();
            Object sourceFieldValue = getFieldValue(source, fieldName);
            if (ignores != null && ignores.length != 0 && Arrays.asList(ignores).indexOf(fieldName) != -1) {
                continue;
            }
            if (!allowNull && sourceFieldValue == null || isEmpty(sourceFieldValue)) {
                continue;
            }
            setFieldValue(target, fieldName, sourceFieldValue);
        }
    }

    /**
     * 是否为空
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj){
        if (obj == null)
            return true;
        return false;
    }

    /**
     * 对象属性copy
     *
     * @param source
     *            {@link Object} 拷贝对象来源
     * @param target
     *            {@link Object} 拷贝到目标对象
     */
    public static void copyProperties(Object source, Object target) {
        copyProperties(source, target, null, true);
    }

    /**
     * 
     * @param obj
     * @param param
     * void
     */
	public static <T> void setParameter(T obj,Map<?, ?> param){
		Class<?> clz =  obj.getClass();
		try {
			Set<?> keys = param.keySet();
			for(Object key:keys){
				Field field = clz.getDeclaredField(String.valueOf(key));
				field.setAccessible(true);
				field.set(obj, param.get(key));
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	
}

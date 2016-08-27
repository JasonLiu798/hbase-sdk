package com.jason798.hbase.util;

import com.jason798.hbase.api.HBaseException;

import java.util.*;

/**
 * 校验用
 */
public class CheckUtil {

    /**
     * Check boolean is NOT false.
     */
    public static void check(boolean bool) {
        if (bool == false) {
            throw new HBaseException("bool is false.");
        }
    }

    /**
     * Check object is NOT null.
     */
    public static void checkNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj  is null.");
        }
    }

    /**
     * check string NOT null
     * @param obj
     */
    public static void checkNull(String obj) {
        if (StringHelper.isEmpty(obj)) {
            throw new NullPointerException("obj  is null.");
        }
    }

    /**
     * check strings ,one of the string is null
     * @param obj
     */
    public static void checkNullAll(String ...obj) {
        if(CollectionHelper.isEmpty(obj)){
            throw new NullPointerException("string array is null.");
        }
        for(String str:obj){
            if (StringHelper.isEmpty(str)) {
                throw new NullPointerException("string array,one string is null.");
            }
        }
    }

    /**
     * check T[] NOT null
     * @param obj
     * @param <T>
     */
    public static <T> void checkNull(T[] obj) {
        if (CollectionHelper.isEmpty(obj)) {
            throw new NullPointerException("array is null.");
        }
    }

    /**
     * check List<T> NOT null
     * @param obj
     * @param <T>
     */
    public static <T> void checkNull(List<T> obj) {
        if (CollectionHelper.isEmpty(obj)) {
            throw new NullPointerException("parameter check,list null or empty");
        }
    }

    /**
     * check Map NOT null
     * @param map
     * @param <K>
     * @param <V>
     */
    public static <K, V> void checkNull(Map<K, V> map) {
        if (CollectionHelper.isEmpty(map)) {
            throw new NullPointerException("map null or empty");
        }
    }

    /**
     * Check for string is NOT null or empty string.
     */
    public static void checkEmptyString(String str) {
        if (StringHelper.isEmpty(str)) {
            throw new IllegalArgumentException("str is null or empty.");
        }
    }

    /**
     * Check the value's length.
     */
    public static void checkLength(byte[] values, int length) {
        checkNull(values);
        if (values.length != length) {
            throw new IllegalArgumentException("checkLength error. values.length="
                    + values.length + " length=" + length);
        }
    }

    /**
     * Check string's length.
     */
    public static void checkLength(String str, int length) {
        checkNull(str);

        if (str.length() != length) {
            throw new IllegalArgumentException("checkLength error. str=" + str
                    + " length=" + length);
        }
    }

    /**
     * Check for 2 objects have identity type.
     */
    public static void checkIdentityType(Object one, Object other) {
        checkNull(one);
        checkNull(other);
        if (one.getClass() != other.getClass()) {
            throw new HBaseException("not same type. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * Check for 2 objects are equal.
     */
    public static void checkEquals(Object one, Object other) {
        if (one == other) {
            return;
        }
        if (one == null || other == null) {
            throw new HBaseException("null object. one = " + one
                    + " other = " + other);
        }
        if (!one.equals(other)) {
            throw new HBaseException("not equal object. one = " + one
                    + " other = " + other);
        }
    }

    /**
     * check num is natural,  [0,max)
     * @param num
     */
    public static void checkNatural(int num){
        if(num<0){
            throw new IllegalArgumentException("num not natural");
        }
    }

    /**
     * check num is positive, [1,max)
     * @param num
     */
    public static void checkPositive(int num){
        if(num<=0){
            throw new IllegalArgumentException("num not positive");
        }
    }

    /**
     * 检查参数类型
     * @param objs
     * @param clz
     */
    @SuppressWarnings("rawtypes")
    public static void checkType(Collection<Object> objs,  Class clz){
        for(Object obj:objs){
            if(obj.getClass() != clz){
                throw new IllegalArgumentException("hbase param type not match");
            }
        }
    }


}

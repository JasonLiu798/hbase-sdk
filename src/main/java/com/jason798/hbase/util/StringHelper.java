package com.jason798.hbase.util;


public class StringHelper {

    public static boolean isEmpty(String target) {
        if (target == null || target.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmptyExist(String... targets) {
        if (targets == null || targets.length == 0) {
            return true;
        }
        for (String str : targets) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> boolean isEmptyExist( T... targets) {
        if (targets == null || targets.length == 0) {
            return true;
        }
        for (T str : targets) {
            if (isEmpty(String.valueOf(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean equal(String s1,String s2){
        // all null
        if(s1==null && s2 == null){
            return true;
        }
        //one is null
        if( s1 == null || s2==null ){
            return false;
        }
        //all not null
        return s1.equals(s2);
    }


    /**
     * 过滤 外边双引号
     * null => null
     * ""   =>  空字符串
     * "aaa" => aaa
     *
     * @param string
     * @return
     */
    public static String filterOuterQuote(String string){
        if(isEmpty(string) || string.length() <2){
            return string;
        }
        if( string.length() == 2){
            return "";
        }
        int len = string.length();
        string = string.substring(1,len-1);
        return string;
    }
}


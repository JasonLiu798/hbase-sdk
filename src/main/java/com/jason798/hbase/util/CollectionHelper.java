package com.jason798.hbase.util;

import java.util.*;

/**
 * 
 */
@SuppressWarnings("hiding")
public class CollectionHelper {
	
	public static <T> boolean isEmpty(T[] arr){
		if(arr==null || arr.length <= 0){
			return true;
		}
		return false;
	}
	
	public static <E> boolean isEmpty(Collection<E> collection){
		if(collection==null || collection.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static <K,V> boolean isEmpty(Map<K,V> map){
		if(map==null || map.isEmpty()){
			return true;
		}
		return false;
	}

	
	public static <T> List<T> array2List(T[] array){
		if(CollectionHelper.isEmpty(array)){
			return null;
		}
		List<T> res = new ArrayList<>(array.length);
		Collections.addAll(res,array);
		return res;
	}
	
	public static <T> void printArr(T[] arr){
		if(arr==null || arr.length<=0){
			return;
		}
		System.out.println("Array:");
		for(int i=0;i<arr.length;i++){
			System.out.println(String.format("[%s] %s", i,arr[i]));
		}
	}
	
	/**
	 * remove filterKeys from map,
	 * thread-safe depend on map
	 * @param map
	 * @param filterKeys
	 * void
	 */
	public static <T> void filterMap(Map<String,T> map,String[] filterKeys ){
		if(isEmpty(filterKeys) || isEmpty(map)){
			return;
		}
		for(String key:filterKeys){
			map.remove(key);
		}
	}

	public static <T> Set<T> array2Set(T[] array){
		if(CollectionHelper.isEmpty(array)){
			return null;
		}
		Set<T> s = new HashSet<T>();
		for(T item:array){
			s.add(item);
		}
		return s;
	}
}

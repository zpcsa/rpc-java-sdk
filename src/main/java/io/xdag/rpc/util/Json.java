package io.xdag.rpc.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.SimpleType;


public class Json{


	/**
	 * jsonStr转换为 HashMap<String,Object>类型
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String,Object> jsonToHashMap(String jsonStr){
		ObjectMapper mapper = new ObjectMapper();

		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			map = mapper.readValue(jsonStr, HashMap.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	


	/**
	 * json转为继承Map的对象类型
	 * @param jsonStr
	 * @param T
	 * @param keyClas
	 * @param valueClass
	 * @return
	 */
	public static <K,V,T extends Map<K,V>> T jsonToMap(String jsonStr,Class<T> T,Class<K> keyClas,Class<V> valueClass){
		ObjectMapper mapper = new ObjectMapper();

			
		MapType mapType= MapType.construct(T, SimpleType.construct(keyClas), SimpleType.construct(valueClass));
		try {
			return mapper.readValue(jsonStr, mapType);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * json转换为T对象类型
	 * @param json
	 * @param cl
	 * @return
	 */
	public static <T> T jsonToClass(String json,Class<T> cl){
		ObjectMapper mapper = new ObjectMapper();
		mapper.enableDefaultTyping();
		 try {
		  return mapper.readValue(json,cl) ;
		} catch (IOException e) {
			e.printStackTrace();
		}  
		 return null;
	}
	


	/**
	 * json转换为对象类型
	 * @param jsonStr
	 * @param valueTypeRef
	 * @return
	 */
	public static <T> T jsonToClass(String jsonStr, TypeReference<T> valueTypeRef){
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(jsonStr, valueTypeRef);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 对象转为json
	 * @param obj
	 * @return
	 */
	public static String classToJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public static String toJson(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String str=mapper.writeValueAsString(obj);
			return str;
		} catch (IOException e) {
			
		}
		return null;
	}




	/**
	 * 对象转化为HashMap
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Object> classToHashMap(Object obj){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String str=mapper.writeValueAsString(obj);
			return mapper.readValue(str,HashMap.class) ;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}

	

	/**
	 * map 转换为Class
	 * @param map
	 * @param classs
	 * @return
	 */
	public static <T> T hashMapToClass(Map<String,Object> map,Class<T> classs){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String str=mapper.writeValueAsString(map);
			return mapper.readValue(str,classs) ;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}


	/**
	 * json转换为对应的数组
	 * @param obj
	 * @param classs
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] jsonToArray(String obj,Class<T> classs){
		if(ObjectUtils.isEmpty(obj)){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		JavaType j=SimpleType.construct(classs);
		ArrayType valueType=ArrayType.construct(j,null,null);
		try {
			Object pb= mapper.readValue(obj, valueType);
			return (T[]) pb;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}

	/**
	 * Json 转换为hashMap
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<HashMap<String, Object>> jsonToList(String obj){
		if(ObjectUtils.isEmpty(obj)){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		MapType j=MapType.construct(HashMap.class, SimpleType.construct(String.class), SimpleType.construct(Object.class));
		CollectionType collectionType=CollectionType.construct(List.class, j);
		try {
			Object pb= mapper.readValue(obj, collectionType);
			return (List<HashMap<String, Object>>) pb;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}


	/**
	 * 转换为K,V为指定对象类型的HashMap
	 * json转换为List<HashMap<K,V>>
	 * @param jsonStr
	 * @param keyCls
	 * @param valueClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K,V> List<HashMap<K, V>> jsonToList(String jsonStr,Class<K> keyCls,Class<V> valueClass){
		if(ObjectUtils.isEmpty(jsonStr)){
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		MapType mapType=MapType.construct(HashMap.class, SimpleType.construct(keyCls), SimpleType.construct(valueClass));
		CollectionType collectionType=CollectionType.construct(List.class, mapType);
		try {
			Object pb= mapper.readValue(jsonStr, collectionType);
			return (List<HashMap<K, V>>) pb;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}
	


	/**
	 * 转换为List<T>
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToList(String jsonStr,Class<T> cls){
		if(ObjectUtils.isEmpty(jsonStr)){
			return null;
		} 
		ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		JavaType j=SimpleType.construct(cls);
		CollectionType collectionType=CollectionType.construct(List.class, j);
		try {
			Object pb= mapper.readValue(jsonStr, collectionType);
			return (List<T>) pb;
		} catch (IOException e) {
			e.getStackTrace();
		}
		return null;
	}
	
	



	
	
}

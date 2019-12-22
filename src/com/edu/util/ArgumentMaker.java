package com.edu.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//Map类型的json转换
public class ArgumentMaker {
	private Map<String, String> paraMap;
	private static final Gson gson = new GsonBuilder().create();
	private int index;
	
	public ArgumentMaker() {
		this.index = 0;
		paraMap = new HashMap<>();
	}
	
	public ArgumentMaker addArg(String paraName, Object paraValue) {
		paraMap.put(paraName, gson.toJson(paraValue));
		return this;
	}
	
	public ArgumentMaker addArg(Object paraValue) {
		paraMap.put("arg"+ index++, gson.toJson(paraValue));
		return this;
	}
	
	@Override
	public String toString() {
		return gson.toJson(paraMap);
	}
	
}

package com.yeah.boring;

import net.sf.json.JSONArray;

public class TestSFJSON {
	public static void main(String[] args) {
		JSONArray jsonArr = new JSONArray();
		jsonArr.add("9 5");
		jsonArr.add("8");
		jsonArr.add("7");
		jsonArr.add("6");
		jsonArr.add("\"5\"");
		
		String arrStr = jsonArr.subList(0, 2).toString();
		System.out.print(JSONArray.fromObject(arrStr));
	}
	
}

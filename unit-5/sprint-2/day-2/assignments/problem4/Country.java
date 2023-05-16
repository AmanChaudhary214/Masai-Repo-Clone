package com.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Country {

	static Map<String, String> map;
	
	static {
		map.put("Afghanistan", "Kabul");
		map.put("Belgium", "Brussels");
		map.put("Canada", "Ottawa");
		map.put("Egypt", "Cairo");
		map.put("Finland", "Helsinki");
		map.put("Greece", "Athens");
		map.put("Hungary", "Budapest");
		map.put("Iraq", "Baghdad");
		map.put("Norway", "Oslo");
		map.put("South", "Seoul");
		
	}
	
	public synchronized void askCapitalName()
	{
		List<String> list = new ArrayList<>();
		list.add("Afghanistan");
		list.add("Belgium");
		list.add("Canada");
		list.add("Egypt");
		list.add("Finland");
		list.add("Greece");
		list.add("Hungary");
		list.add("Iraq");
		list.add("Norway");
		list.add("South");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

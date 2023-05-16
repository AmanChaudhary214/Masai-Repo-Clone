package com.masai.pack_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	
	public static Map<String, Student> sortMapUsingStudentName(Map<String, Student> originalMap) {
		
		Set<Entry<String, Student>> set = originalMap.entrySet();
		
		List<Entry<String, Student>> list = new ArrayList<>(set);
		
		Comparator<Entry<String, Student>> comp = (o1, o2) -> o1.getValue().getName().compareTo(o2.getValue().getName());
		
		Collections.sort(list, comp);
		
		Map<String, Student> map = new LinkedHashMap<>();
		
		for (Entry<String, Student> e : list) {
			map.put(e.getKey(), e.getValue());
		}
		
		return map;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map <String, Student> map1 = new HashMap<>();
		
		map1.put("India", new Student(1, "Ramesh", "ramesh@gmail.com", 450));
		map1.put("USA", new Student(2, "Karan", "ramesh@gmail.com", 450));
		map1.put("Australia", new Student(3, "Aman", "ramesh@gmail.com", 450));
		map1.put("China", new Student(4, "Hemant", "ramesh@gmail.com", 450));
		map1.put("Pakistan", new Student(5, "Ankit", "ramesh@gmail.com", 450));
		
		Map<String, Student> resMap = Main.sortMapUsingStudentName(map1);
		
		for (Entry<String, Student> e : resMap.entrySet()) {
			System.out.println(e.getKey() + " => " + e.getValue());
		}
	}

}

package com.assignment.day15;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;

public class HashingDemo {
	public static Map<Character, List<String>> addName(String names[]) {
		Map<Character, List<String>> map = new TreeMap<>();
		
		for (int i=0; i<names.length; i++) {
			char ch = names[i].charAt(0);
			
			if (!map.containsKey(ch)) {
				List<String> arr = new ArrayList<>();
				arr.add(names[i]);
				map.put(ch, arr);
			}
			else {
				List<String> list = map.get(ch);
				list.add(names[i]);
				map.put(ch, list);
			}
		}
		return map;
	}
	
	public static void display(Map<Character, List<String>> map) {
		
		for (Map.Entry<Character, List<String>> element : map.entrySet()) {
			List<String> arr = element.getValue();
			System.out.println(element.getKey() + ":" + String.join(", ", arr));
		}
	}
	
	public static boolean searchName(Map<Character, List<String>> map, String name) {
		char ch = name.toUpperCase().charAt(0);
		
		if (!map.containsKey(ch)) {
			return false;
		}
		List<String> arr = map.get(ch);
		return arr.contains(name);
	}
	
	public static boolean removeName(Map<Character, List<String>> map, String name) {
		char ch = name.toUpperCase().charAt(0);

		if (!map.containsKey(ch)) {
			return false;
		}
		List<String> arr = map.get(ch);
		arr.remove(name);
		if (arr.size()==0) {
			map.remove(ch);
		}
		return true;
	}
	
	public static void main(String[] args) {
	    String names[] = {"Naya", "Ishaan", "Jai", "Inaya", "Amar", "Navi", "Dhruv",
	        "Kanan", "Diya", "Shyla", "Agastya", "Ananya", "Nila", "Tenzin", "Tamia",
	        "Shaan", "Ajay", "Jaya", "Anjali", "Aditi", "Reva", "Sahil", "Darsh", "Aja",
	        "Ambar", "Deven", "Ishani", "Kavi", "Marjane", "Jasleen", "Ashwin", "Aadhira",
	        "Candy", "Kum", "Salina", "Artha", "Raghav", "Avan", "Sitara", "Shylah", "Divya",
	        "Varun", "Sona", "Shaila", "Kimaya", "Farid", "Kashvi", "Devi", "Charu", "Mihir", "Tulsi",
	        "Anila", "Anala", "Vivan", "Amitabh", "Mahika", "Sudhir", "Lata", "Anand", "Akshay"};
	    
	    Map<Character, List<String>> map = addName(names);
	    
	    System.out.println("The original map is ");
	    display(map);
	    
	    System.out.println();
	    if(searchName(map, "Farid")) {
	      System.out.println("Name 'Farid' found in Map");
	    }else {
	      System.out.println("Name 'Farid' not found in Map");
	    }
	    
	    System.out.println();
	    if(searchName(map, "Harish")) {
	      System.out.println("Name 'Harish' found in Map");
	    }else {
	      System.out.println("Name 'Harish' not found in Map");
	    }
	    
	    System.out.println();
	    if(removeName(map, "Lata")) {
	      System.out.println("Name 'lata' removed from Map");
	    }else {
	      System.out.println("Name 'lata' not in map hence not deleted");
	    }

	    System.out.println();
	    if(removeName(map, "Harish")) {
	      System.out.println("Name 'Harish' removed from Map");
	    }else {
	      System.out.println("Name 'Harish' not in map hence not deleted");
	    }
	    
	    System.out.println();
	    display(map);
	  }
}

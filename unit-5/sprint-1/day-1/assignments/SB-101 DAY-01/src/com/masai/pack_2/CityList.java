package com.masai.pack_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {

	public static void main(String[] args) {
		List<String> cities = new ArrayList<>();
		cities.add("Lucknow");
		cities.add("Delhi");
		cities.add("Bangalore");
		cities.add("Mumbai");
		cities.add("Hyderabad");
		cities.add("Kolkata");
		cities.add("Jaipur");
		cities.add("Bhopal");
		cities.add("Pune");
		cities.add("Patna");
		
		Collections.sort(cities, (a, b) -> {
			return b.compareToIgnoreCase(a);
		});
		
		for (String element : cities) {
			System.out.println(element);
		}
	}
}

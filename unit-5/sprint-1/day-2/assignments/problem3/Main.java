package com.problem3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> city = new ArrayList<>();
		city.add("Lucknow");
		city.add("Delhi");
		city.add("Bangalore");
		city.add("Mumbai");
		city.add("Hyderabad");
		
		PrintList pl = el -> {
			el.forEach(x -> System.out.println(x));
		};
		pl.display(city);
	}

}

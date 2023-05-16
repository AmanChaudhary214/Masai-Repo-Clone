package com.problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

import com.problem2.Employee;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list1 = new ArrayList<>();
		
		list1.add("Aman");
		list1.add("Hemant");
		list1.add("Karan");
		list1.add("Shivansh");
		list1.add("Nishant");
		list1.add("Ankit");
		list1.add("Avinash");
		list1.add("Anand");
		list1.add("Kapil");
		list1.add("Vishal");
		
		List<String> list2 = list1.stream().filter(l1 -> l1.length()%2==0).map(e -> e.toUpperCase()).collect(Collectors.toList());
		
		Collections.sort(list2, (a,b) -> {
			return b.compareTo(a);
		});
		
		System.out.println("======Original List======");
		list1.forEach(element -> {
			System.out.println(element);
		});
		
		System.out.println();
		
		System.out.println("======Transformed List======");
		list2.forEach(element -> {
			System.out.println(element);
		});
		
	}

}

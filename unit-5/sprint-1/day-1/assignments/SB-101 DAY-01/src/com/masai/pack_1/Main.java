package com.masai.pack_1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list = new ArrayList<>();
		
		list.add(new Employee(1, "Aman", "Lucknow", 4500));
		list.add(new Employee(2, "Hemant", "Gurugram", 10000));
		list.add(new Employee(3, "Karan", "Noida", 12000));
		list.add(new Employee(4, "Ankit", "Delhi", 4000));
		list.add(new Employee(5, "Pavan", "Bangalore", 8000));
		
		list.forEach(e -> {
			if (e.getSalary() < 5000) {
				int sal = e.getSalary()+1000;
				e.setSalary(sal);
			}
		});
		
		list.forEach(e -> System.out.println(e));
	}

}

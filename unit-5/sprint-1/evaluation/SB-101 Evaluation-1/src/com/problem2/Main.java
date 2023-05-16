package com.problem2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> list1 = new ArrayList<>();
		
		list1.add(new Student(1, "Aman", 400.00, "Lucknow"));
		list1.add(new Student(2, "Hemant", 500.00, "Delhi"));
		list1.add(new Student(3, "Karan", 550.00, "Kolkata"));
		list1.add(new Student(4, "Shivansh", 700.00, "Bangalore"));
		list1.add(new Student(5, "Nishant", 650.00, "Hyderabad"));
		
		List<Employee> list2 = list1.stream().filter(l1 -> l1.getMarks()>500)
				.map(e -> new Employee(e.getRoll(), e.getName(), e.getMarks()*10000, e.getAddress()))
				.collect(Collectors.toList());
		
		Comparator<Employee> comp = (emp1, emp2) -> {
			if(emp1.getSalary() < emp2.getSalary()) {
				return 1;
			}
			return -1;
		};
		
		System.out.println("======Original List======");
		list1.forEach(element -> {
			System.out.println(element);
		});
		
		System.out.println();
		
		System.out.println("======Transformed List(Employee) in Descending order of salary======");
		list2.stream().sorted(comp).forEach(element -> {
			System.out.println(element);
		});

	}

}

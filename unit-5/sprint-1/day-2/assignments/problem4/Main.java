package com.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "Aman", 18, 500));
		list.add(new Student(2, "Hemant", 23, 600));
		list.add(new Student(3, "Karan", 8, 700));
		list.add(new Student(4, "Ankit", 8, 400));
		list.add(new Student(5, "Ankita", 25, 300));
		list.add(new Student(6, "Somendra", 30, 600));
		list.add(new Student(7, "Raj", 5, 450));
		list.add(new Student(8, "Faisal", 28, 800));
		list.add(new Student(9, "Pavan", 12, 480));
		list.add(new Student(10, "Aryan", 22, 380));
		
		Intr i1 = el -> {
			List<Student> newList = new ArrayList<>();
			el.forEach(x -> {
				if (x.getMarks() < 500) {
					newList.add(x);
				}
			});
			return newList;
		};
		System.out.println(i1.findStudent(list));
	}

}

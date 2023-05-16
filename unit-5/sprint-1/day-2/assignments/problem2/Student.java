package com.problem2;

public class Student {

	int studentId;
	String name;
	int rollNo;
	int marks;
	
	public Student() {
		super();
	}

	public Student(int studentId, String name, int rollNo, int marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
	
	public void displayDetail(Student student) {
		System.out.println("Student [studentId=" + studentId + ", name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]");
	}

	public static void displayDetails(Student student) {
		System.out.println("Student [studentId=" + student.studentId + ", name=" + student.name + ", rollNo=" + student.rollNo + ", marks=" + student.marks + "]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student(1, "Aman", 18, 500);
		Student s2 = new Student(2, "Hemant", 23, 520);
		
		
		System.out.println("using non-static method");
		Demo d1 = s1::displayDetail;
		d1.printDetail(s1);
		System.out.println();
		
		
		System.out.println("using static method");
		Demo d2 = Student::displayDetails;
		d2.printDetail(s2);
		System.out.println();
		
		
		System.out.println("using constructor");
		Intr1 i = Student::new;
		Student s3 = i.myStudent(3, "Karan", 8, 540);
		d2.printDetail(s3);
	}
}

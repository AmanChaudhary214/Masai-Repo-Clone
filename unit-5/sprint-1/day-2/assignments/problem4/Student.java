package com.problem4;

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

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}

}

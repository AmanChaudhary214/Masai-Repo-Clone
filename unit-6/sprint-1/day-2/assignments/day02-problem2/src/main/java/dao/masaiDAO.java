package dao;

import entities.Student;

public interface masaiDAO {

	public Student findStudentById(int id);
	public String saveStudent(Student student);
	public String deleteStudentById(int id);
	public String updateStudentLevel(int id, int level);
	
}
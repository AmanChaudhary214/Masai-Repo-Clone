package dao;

import java.util.List;

import dto.Student;
import exception.StudentException;

public interface StudentDAO {

	public Student getStudentByRollNo(int rollNo)throws StudentException;

	public List<Student> getAllStudent();

	public String saveStudentDetails(Student student);

	public boolean deleteStudentByRollNo(int rollNo)throws StudentException;

	public String graceStudentMarks(int rollNo, int marks)throws StudentException;

	public List<Student> getStudentsByName(String name)throws StudentException;
}

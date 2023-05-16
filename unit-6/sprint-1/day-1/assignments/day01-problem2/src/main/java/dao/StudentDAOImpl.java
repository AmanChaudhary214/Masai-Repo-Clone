package dao;

import java.util.List;

import dto.Student;
import exception.StudentException;

public class StudentDAOImpl implements StudentDAO{

	@Override
	public Student getStudentByRollNo(int rollNo) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudentByRollNo(int rollNo) throws StudentException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String graceStudentMarks(int rollNo, int marks) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}

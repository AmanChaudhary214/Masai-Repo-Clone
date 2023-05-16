package dao;

import javax.persistence.EntityManager;

import entities.Student;
import utility.EMUtil;

public class masaiDAOImpl implements masaiDAO {

	@Override
	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Student student = em.find(Student.class, id);
		em.close();
		
		if (student!=null) {
			return student;
		}
		return null;
	}
	
	

	@Override
	public String saveStudent(Student student) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Student st = em.find(Student.class, student.getStudentCode());
		
		if (st==null) {
			em.persist(student);			
			em.close();
			return "Student saved successfully";
		}
		return "Student with same studentCode already exists";
	}

	
	
	@Override
	public String deleteStudentById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Student student = em.find(Student.class, id);
		
		if (student!=null) {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
			em.close();
			
			return "student deleted successfully";
		}
		return "student not found";
	}
	
	

	@Override
	public String updateStudentLevel(int id, int level) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Student student = em.find(Student.class, id);
		
		if (student!=null) {
			em.getTransaction().begin();
			em.merge(student);
			em.getTransaction().commit();
			em.close();
			
			return "student updated successfully";
		}
		return "student not found";
	}

}

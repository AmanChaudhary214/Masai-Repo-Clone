package com.masai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public String registerEmployee(Employee employee) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");

		EntityManager em = emf.createEntityManager();

		String res = null;

		em.getTransaction().begin();

		em.persist(employee);

		res = "Employee added successfully";

		em.getTransaction().commit();

		return res != null ? res : "Employee not added";
	}

	// -----------------------------------------------------//

	@Override
	public Employee getEmployeeById(int empId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");

		EntityManager em = emf.createEntityManager();

		return em.find(Employee.class, empId);

	}

	// -----------------------------------------------------//

	@Override
	public String deleteEmployeeById(int empId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");

		EntityManager em = emf.createEntityManager();

		Employee emp = em.find(Employee.class, empId);

		String res = null;

		em.getTransaction().begin();

		em.remove(emp);

		res = "Employee deleted successfully";

		em.getTransaction().commit();

		return res != null ? res : "Employee not deleted";

	}

	// -----------------------------------------------------//

	@Override
	public String giveBonusToEmployee(int empId, int amount) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("empUnit");

		EntityManager em = emf.createEntityManager();

		Employee emp = em.find(Employee.class, empId);

		String res = null;

		em.getTransaction().begin();

		emp.setSalary(emp.getSalary() + amount);

		res = "Bonus added successfully";

		em.getTransaction().commit();

		return res != null ? res : "Bonus not added";

	}

	// -----------------------------------------------------//

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	// -----------------------------------------------------//

}

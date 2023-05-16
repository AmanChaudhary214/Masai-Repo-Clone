package dao;

import javax.persistence.EntityManager;

import entities.Employee;
import utility.EMUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public String registerEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();

		String res = null;

		em.getTransaction().begin();

		em.persist(employee);

		res = "Employee added successfully";

		em.getTransaction().commit();
		em.close();

		return res != null ? res : "Employee not added";
	}
	

	@Override
	public Employee getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);
		em.close();
		
		return emp;
	}
	

	@Override
	public String deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);

		String res = null;

		em.getTransaction().begin();
		em.remove(emp);

		res = "Employee deleted successfully";

		em.getTransaction().commit();
		em.close();

		return res != null ? res : "Employee not deleted";
	}
	

	@Override
	public String updateEmployeeSalary(int empId, int amount) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();

		Employee emp = em.find(Employee.class, empId);

		String res = null;

		em.getTransaction().begin();
		emp.setSalary(amount);

		res = "Salary updated successfully";

		em.getTransaction().commit();
		em.close();

		return res != null ? res : "Salary not updated";
	}

}

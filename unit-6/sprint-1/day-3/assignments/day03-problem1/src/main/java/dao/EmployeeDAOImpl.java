package dao;

import javax.persistence.EntityManager;

import dto.Employee;
import utility.EMUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee employee = em.find(Employee.class, emp.getEmpId());
		
		if (employee==null) {
			em.getTransaction().begin();
			
			em.persist(employee);
			
			em.getTransaction().commit();			
			em.close();
			
			System.out.println("employee added successfully");
		}
		else System.out.println("unable to add employee");
	}

	
	
	@Override
	public String getAddressOfEmployee(int empId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee employee = em.find(Employee.class, empId);
		
		em.close();
		return employee.getAddress();
	}

	
	
	@Override
	public String giveBonusToEmployee(int empId, int bonus) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee employee = em.find(Employee.class, empId);
		
		String res = null;

		em.getTransaction().begin();
		employee.setSalary(employee.getEmpId() + bonus);

		res = "Salary updated successfully";

		em.getTransaction().commit();
		em.close();

		return res != null ? res : "Salary not updated";
	}

	
	
	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Employee emp = em.find(Employee.class, empId);

		boolean res = false;

		em.getTransaction().begin();
		em.remove(emp);

		res = true;

		em.getTransaction().commit();
		em.close();

		return res;
	}

}

package com.masai.dao;

import java.util.List;

import com.masai.dto.Employee;


public interface EmployeeDAO {

	public String registerEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public List<Employee> getAllEmployee();

	public String deleteEmployeeById(int empId);

	public String giveBonusToEmployee(int empId, int amount);

}

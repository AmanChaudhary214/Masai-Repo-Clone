package com.masai.dao;

import java.util.List;

import com.masai.dto.Employee;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface EmployeeDAO {

	void addEmployee(Employee emp) throws SomethingWentWrongException;

	List<Employee> searchEmployeeByDepartmentName(String name)throws SomethingWentWrongException, NoRecordFoundException;

}

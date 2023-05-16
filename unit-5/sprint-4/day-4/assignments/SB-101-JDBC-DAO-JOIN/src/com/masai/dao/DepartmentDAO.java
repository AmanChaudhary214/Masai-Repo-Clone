package com.masai.dao;

import java.util.List;

import com.masai.dto.Department;
import com.masai.dto.Employee;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface DepartmentDAO {

	void addDepartment(Department dept) throws SomethingWentWrongException;

	void deleteDepartment(String did) throws SomethingWentWrongException;

	List<Department> searchDepartmentDetailByAddress(String address)throws SomethingWentWrongException, NoRecordFoundException;

}

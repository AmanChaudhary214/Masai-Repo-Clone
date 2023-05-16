package com.masai.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.DepartmentDAO;
import com.masai.dao.DepartmentDAOImpl;
import com.masai.dao.EmployeeDAO;
import com.masai.dao.EmployeeDAOImpl;
import com.masai.dto.Department;
import com.masai.dto.DepartmentImpl;
import com.masai.dto.Employee;
import com.masai.dto.EmployeeImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class Main {
	
	static void addEmployee(Scanner sc) {
		System.out.print("Enter Employee Id ");
		String eid = sc.next();
		
		System.out.print("Enter Employee name ");
		String name = sc.next();
		
		System.out.print("Enter employee address ");
		String address = sc.next();
		
		System.out.print("Enter employee mobile ");
		String mobile = sc.next();
		
		System.out.print("Enter employee Deptartment Id ");
		String deptId = sc.next();
		
		//Create an object of DTO
		Employee emp = new EmployeeImpl(eid, name, address, mobile, deptId);
		
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		
		try {
			empDAO.addEmployee(emp);	
			System.out.println("Employee added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void addDepartment(Scanner sc) {
		System.out.print("Enter Department Id ");
		String did = sc.next();
		
		System.out.print("Enter Department name ");
		String name = sc.next();
		
		System.out.print("Enter location ");
		String loation = sc.next();
		
		//Create an object of DTO
		Department dept = new DepartmentImpl(did, name, loation);
		
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.addDepartment(dept);	
			System.out.println("Department added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void deleteDepartmentByDId(Scanner sc) {
		//take input employee details
		System.out.print("Enter Department Number ");
		String did = sc.next();
		
		//take an object of DAO
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		
		try {
			deptDAO.deleteDepartment(did);	
			System.out.println("Department deleted successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void searchEmployeeByDepartmentName(Scanner sc) {
		
		System.out.print("Enter Dept. Name ");
		String name = sc.next();
		
		//take an object of DAO
		EmployeeDAO empDAO = new EmployeeDAOImpl();
		try {
			List<Employee> empList = empDAO.searchEmployeeByDepartmentName(name);
			Consumer<Employee> con = emp -> System.out.println("Employee ID " + emp.getEmpId() + " Employee Name " + emp.getEname() 
			+ " Address " + emp.getAddress() + " Mobile " + emp.getMobile() + " Dept. ID " + emp.getDeptId());
			empList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	static void searchDepartmentDetailByAddress(Scanner sc) {
		
		System.out.print("Enter Employee Address ");
		String address = sc.next();
		
		//take an object of DAO
		DepartmentDAO deptDAO = new DepartmentDAOImpl();
		try {
			List<Department> empList = deptDAO.searchDepartmentDetailByAddress(address);
			Consumer<Department> con = dept -> System.out.println("Department ID " + dept.getdId() + " Department Name " + dept.getDname() 
			+ " Location " + dept.getLocation());
			empList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Employee");
			System.out.println("2. Add Department");
			System.out.println("3. Delete Department by Dept. Id");
			System.out.println("4. Search Employee By Department");
			System.out.println("5. Search Dept. Details of Employees By Address");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addEmployee(sc);
					break;
				case 2:
					addDepartment(sc);
					break;
				case 3:
					deleteDepartmentByDId(sc);
					break;
				case 4:
					searchEmployeeByDepartmentName(sc);
					break;
				case 5:
					searchDepartmentDetailByAddress(sc);
					break;
				case 0:
					System.out.println("Bye Bye");
					break;
				default:
					System.out.println("Invalid Selection please try again later");
			}
			
		}while(choice != 0);
		sc.close();
	}
}

package Ques4;

import java.util.Objects;

public class Employee {

	private String employeeId;
	private String name;
	private double salary;
	private EPFOAccount epfoAccount;
	
	
	public Employee(String employeeId, String name, double salary, EPFOAccount epfoAccount) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.epfoAccount = epfoAccount;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return employeeId == other.employeeId;
	}
	
	
	@Override
	public String toString() {
		return "Employee Id: " + employeeId + " Name: " + name + " Salary: " + salary + ", EPFO Account Details: ("
				+ epfoAccount + ")";
	}
	
	
}

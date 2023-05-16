package runner;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import entities.Employee;

public class Demo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice = "";

		do {
			System.out.println("Please select a valid option");
			System.out.println("Select 1 for register a new employee");
			System.out.println("Select 2 to display employee by empID");
			System.out.println("Select 3 to delete employee by empID");
			System.out.println("Select 4 to update Employee salary");
			System.out.println("Select 0 to close the application");

			choice = sc.next();

			switch (choice) {
				case "1":
					registerEmployee(sc);
					break;
				case "2":
					getEmployeeById(sc);
					break;
				case "3":
					deleteEmployeeById(sc);
					break;
				case "4":
					updateEmployee(sc);
					break;
				case "0":
					System.out.println("Thank you for using our service");
					break;
				default:
					System.out.println("Please select a valid option");
			}
		} while(!choice.equals("0"));
	}

	
	
	// ------------------------------------------------//
	
	
	
	public static void registerEmployee(Scanner sc) {

		System.out.println("Please enter employee ID");
		int empid = sc.nextInt();

		System.out.println("Please enter employee name");
		String name = sc.next();

		System.out.println("Please enter employee address");
		sc.nextLine();
		String address = sc.nextLine();

		System.out.println("Please enter employee salary");
		int salary = sc.nextInt();

		Employee emp = new Employee(empid, name, address, salary);

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.registerEmployee(emp));

	}


	// ------------------------------------------------//
	

	public static void getEmployeeById(Scanner sc) {

		System.out.println("Please enter employee ID");
		int empid = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.getEmployeeById(empid));

	}

	
	// ------------------------------------------------//

	
	public static void deleteEmployeeById(Scanner sc) {

		System.out.println("Please enter employee ID");
		int empid = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.deleteEmployeeById(empid));

	}

	
	// ------------------------------------------------//
	
	
	private static void updateEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter employee ID");
		int id = sc.nextInt();
		System.out.println("Please enter new salary");
		int salary = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.updateEmployeeSalary(id, salary));
	}
	
}

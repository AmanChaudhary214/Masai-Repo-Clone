package runner;

import java.util.Scanner;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dto.Employee;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice = "";

		do {
			System.out.println("Please select a valid option");
			System.out.println("Select 1 for save employee");
			System.out.println("Select 2 to display address of employee by empID");
			System.out.println("Select 3 to give bonus to employee");
			System.out.println("Select 4 to delete employee");
			System.out.println("Select 0 to close the application");

			choice = sc.next();

			switch (choice) {
				case "1":
					saveEmployee(sc);
					break;
				case "2":
					getEmployeeAddressById(sc);
					break;
				case "3":
					giveBonusToEmployee(sc);
					break;
				case "4":
					deleteEmployeeById(sc);
					break;
				case "0":
					System.out.println("Thank you for using our service");
					break;
				default:
					System.out.println("Please select a valid option");
			}
		} while(!choice.equals("0"));
	}

	
	
	private static void saveEmployee(Scanner sc) {
		// TODO Auto-generated method stub

		System.out.println("Please enter employee name");
		String name = sc.next();

		System.out.println("Please enter employee address");
		sc.nextLine();
		String address = sc.nextLine();

		System.out.println("Please enter employee salary");
		int salary = sc.nextInt();

		Employee emp = new Employee(name, address, salary);

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.save(emp));

	}
	
	

	private static void getEmployeeAddressById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter employee ID");
		int empid = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.getAddressOfEmployee(empid));
	}

	
	
	private static void giveBonusToEmployee(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter employee ID");
		int id = sc.nextInt();
		System.out.println("Please bonus amount");
		int bonus = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.giveBonusToEmployee(id, bonus));
	}
	
	

	private static void deleteEmployeeById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter employee ID");
		int empid = sc.nextInt();

		EmployeeDAO ed = new EmployeeDAOImpl();

		System.out.println(ed.deleteEmployee(empid));
	}

}
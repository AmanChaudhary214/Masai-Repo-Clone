package runner;

import java.util.Scanner;

import dao.masaiDAO;
import dao.masaiDAOImpl;
import entities.Student;

public class Demo {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice = "";

		do {
			System.out.println("Please select a valid option");
			System.out.println("Select 1 to find student");
			System.out.println("Select 2 to save student");
			System.out.println("Select 3 to delete stutend by ID");
			System.out.println("Select 4 to update student Level");
			System.out.println("Select 0 to close the application");

			choice = sc.next();

			switch (choice) {
				case "1":
					findStudent(sc);
					break;
				case "2":
					saveStudent(sc);
					break;
				case "3":
					deletestudentById(sc);
					break;
				case "4":
					updateStudent(sc);
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
		
	
	private static void updateStudent(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter student ID");
		int id = sc.nextInt();
		System.out.println("Please enter new level");
		int level = sc.nextInt();

		masaiDAO md = new masaiDAOImpl();

		System.out.println(md.updateStudentLevel(id, level));
	}

	
	// ------------------------------------------------//

	
	private static void deletestudentById(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter student ID");
		int id = sc.nextInt();

		masaiDAO md = new masaiDAOImpl();

		System.out.println(md.deleteStudentById(id));
	}

	
	// ------------------------------------------------//

	
	private static void saveStudent(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("enter student id: ");
		int id = sc.nextInt();
		System.out.println("enter student email: ");
		String email = sc.next();
		System.out.println("enter student address: ");
		String address = sc.next();
		System.out.println("enter student course: ");
		String course = sc.next();
		System.out.println("enter student level: ");
		int level = sc.nextInt();
		
		Student student = new Student(id, email, address, course, level);
		
		masaiDAO md = new masaiDAOImpl();

		System.out.println(md.saveStudent(student));
	}

	
	// ------------------------------------------------//

	
	private static void findStudent(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Please enter student ID");
		int id = sc.nextInt();

		masaiDAO md = new masaiDAOImpl();

		System.out.println(md.findStudentById(id));
	}
	
}

package com.masai.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.CarDAO;
import com.masai.dao.CarDAOImpl;
import com.masai.dto.Car;
import com.masai.dto.CarImpl;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public class Main {
	
	static void addCar(Scanner sc) {
		System.out.println("Enter Car ID");
		String carId = sc.next();
		
		System.out.println("Enter Model Name");
		String model = sc.next();
		
		System.out.println("Enter Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Total no. of Seats");
		int seats = sc.nextInt();
		
		System.out.println("Enter Company ID");
		String cId = sc.next();
		
		Car car = new CarImpl(carId, model, price, seats, cId);
		
		CarDAO cDAO = new CarDAOImpl();
		
		try {
			cDAO.addCar(car);
			System.out.println("Car details added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void displayCar() {
		
		CarDAO cDAO = new CarDAOImpl();
		
		try {
			cDAO.displayCar().forEach(s -> System.out.println(s));
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	static void updateCar(Scanner sc) {
		System.out.println("Enter Car ID");
		String carId = sc.next();
		
		System.out.println("Enter Model Name");
		String model = sc.next();
		
		System.out.println("Enter Price");
		int price = sc.nextInt();
		
		System.out.println("Enter Total no. of Seats");
		int seats = sc.nextInt();
		
		System.out.println("Enter Company ID");
		String cId = sc.next();
		
		Car car = new CarImpl(carId, model, price, seats, cId);
		
		CarDAO cDAO = new CarDAOImpl();
		
		try {
			cDAO.updateCar(car);
			System.out.println("Car details updated successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}


	static void deleteCar(Scanner sc) { 
		System.out.println("Enter Car ID");
		String carId = sc.next();
		
		CarDAO cDAO = new CarDAOImpl();
		
		try {
			cDAO.deleteCar(carId);
			System.out.println("Car details deleted successfully");
		}catch (SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}


	static void displayCompanyDetails() {
	
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Car");
			System.out.println("2. Display Car Details");
			System.out.println("3. Update Car");
			System.out.println("4. Delete Car");
			System.out.println("5. Display Company Details");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				addCar(sc);
				break;
			case 2:
				displayCar();
				break;
			case 3:
				updateCar(sc);
				break;
			case 4:
				deleteCar(sc);
				break;
			case 5:
				displayCompanyDetails();
				break;
			case 0:
				System.out.println("Thanks for querying.");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
			
		}while(choice!=0);
		sc.close();
	}
}

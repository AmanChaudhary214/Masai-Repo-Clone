package com.masai.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.MobileDAO;
import com.masai.dao.MobileDAOImpl;
import com.masai.dto.Mobile;
import com.masai.dto.MobileImpl;
import com.masai.exception.SomethingWentWrongException;
import com.masai.exception.NoRecordFoundException;

public class Main {

	
	static void addMobile(Scanner sc) {
		//take input employee details
		System.out.print("Enter Model Number ");
		String model = sc.next();
		
		System.out.print("Enter Company name ");
		String company = sc.next();
		
		System.out.print("Enter price ");
		int price = sc.nextInt();
		
		System.out.print("Enter MFG Date ");
		LocalDate mfg = LocalDate.parse(sc.next());
		
		//Create an object of DTO
		Mobile mob = new MobileImpl(model, company, price, mfg);
		
		MobileDAO mobDAO = new MobileDAOImpl();
		
		try {
			mobDAO.addMobile(mob);	
			System.out.println("Mobile added successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
		//call the method of DAO layer to add employee in database and get status
		//if successful then "mobile added successfully"
		//if failed then provide suitable message
	}
	
	
	static void updateMobile(Scanner sc) {
		//take input employee details
		System.out.print("Enter Model Number ");
		String model = sc.next();
		
		System.out.print("Enter Company name ");
		String company = sc.next();
		
		System.out.print("Enter price ");
		int price = sc.nextInt();
		
		System.out.print("Enter MFG Date ");
		LocalDate mfg = LocalDate.parse(sc.next());
		
		//Create an object of DTO
		Mobile mob = new MobileImpl(model, company, price, mfg);
		
		MobileDAO mobDAO = new MobileDAOImpl();
		
		try {
			mobDAO.updateMobile(mob);	
			System.out.println("Mobile updated successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void deleteMobile(Scanner sc) {
		//take input employee details
		System.out.print("Enter Model Number ");
		String model = sc.next();
		
		//take an object of DAO
		MobileDAO mobDAO = new MobileDAOImpl();
		
		try {
			mobDAO.deleteMobile(model);	
			System.out.println("Mobile deleted successfully");
		}catch(SomethingWentWrongException ex) {
			System.out.println(ex);
		}
	}
	
	
	static void viewMobile() {
		//take an object of DAO
		MobileDAO mobDAO = new MobileDAOImpl();
		
		try {
			List<Mobile> mobList = mobDAO.getMobileList();
			Consumer<Mobile> con = mob -> System.out.println("Model Number " + mob.getModel() + " Company " + mob.getCompany() 
			+ " Price " + mob.getPrice() + " MFG " + mob.getMfg());
			mobList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	static void searchMobileByModelNumber(Scanner sc) {
		
		System.out.print("Enter Model Number ");
		String model = sc.next();
		
		//take an object of DAO
		MobileDAO mobDAO = new MobileDAOImpl();
		try {
			List<Mobile> mobList = mobDAO.searchMobileByModelNumber(model);
			Consumer<Mobile> con = mob -> System.out.println("Model Number " + mob.getModel() + " Company " + mob.getCompany() 
			+ " Price " + mob.getPrice() + " MFG " + mob.getMfg());
			mobList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	static void searchMobileByPriceRange(Scanner sc) {
		
		System.out.print("Enter start price ");
		int start = sc.nextInt();
		
		System.out.print("Enter end price ");
		int end = sc.nextInt();
		
		//take an object of DAO
		MobileDAO mobDAO = new MobileDAOImpl();
		try {
			List<Mobile> mobList = mobDAO.searchMobileByPriceRange(start, end);
			Consumer<Mobile> con = mob -> System.out.println("Model Number " + mob.getModel() + " Company " + mob.getCompany() 
			+ " Price " + mob.getPrice() + " MFG " + mob.getMfg());
			mobList.forEach(con);
		}catch(SomethingWentWrongException | NoRecordFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("0. Exit");
			System.out.println("1. Add Mobile");
			System.out.println("2. Update Mobile");
			System.out.println("3. Delete Mobile");
			System.out.println("4. View Mobile");
			System.out.println("5. Search Mobile By Model Number");
			System.out.println("6. Search Mobile By Price Range");
			System.out.print("Enter Selection ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					addMobile(sc);
					break;
				case 2:
					updateMobile(sc);
					break;
				case 3:
					deleteMobile(sc);
					break;
				case 4:
					viewMobile();
					break;
				case 5:
					searchMobileByModelNumber(sc);
					break;
				case 6:
					searchMobileByPriceRange(sc);
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

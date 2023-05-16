package com.masai.entities;

import java.time.LocalDateTime;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println();
		System.out.println("1. Find Shipment by Id");
		System.out.println("2. Create Shipment");
		System.out.println("3. Delete Shipment");
		System.out.println("4. Update Shipment");
		System.out.println("5. Find Shipment by weightRange");
		System.out.println("6. Find Shipment by sender address");
		System.out.println("7. Find Shipment by date range");
		System.out.println("0. Exit");
		System.out.println();
		
		System.out.println("Enter choice: ");
		int choice = sc.nextInt();
		System.out.println();
		
		do {
			switch(choice) {
				case 1:
					findShipment();
					break;
				case 2:
					createShipment();
					break;
				case 3:
					deleteShipment();
					break;
				case 4:
					updateShipment();
					break;
				case 5:
					findShipmentbyWeight();
					break;
				case 6:
					findShipmentbySender();
					break;
				case 7:
					findShipmentbyDate();
					break;
				default:
					System.out.println("invalid input, try again.");
					break;
			}
		}while(choice!=0);
		
	}



	private static void updateShipment() {
		
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Enter Id to modify: ");
		int id = sc.nextInt();		

		shipment s = em.find(shipment.class, id);
		
		if(s == null) {
			System.out.println("shipment not found");
		}
		else {
			System.out.println("Enter content: ");
			String content = sc.next();
			System.out.println("Enter weight in Kgs: ");
			Double wt = sc.nextDouble();
			System.out.println("Enter reciever address: ");
			String rAdd = sc.next();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			
			s.setContent(content);
			s.setWeightinKgs(wt);
			s.setRecipientAddress(rAdd);
			
			et.commit();
			
			System.out.println("shipment updated");
		}

		em.close();
		sc.close();
		
	}
	
	

	private static void deleteShipment() {
	
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Enter Id to delete: ");
		int id = sc.nextInt();

		shipment s = em.find(shipment.class, id);
		
		if(s != null) {
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			em.remove(s);
			et.commit();
			
			System.out.println("shipment removed");
		}
		else {
			System.out.println("shipment not found");
		}
		
		em.close();
		sc.close();
	}
	
	

	private static void createShipment() {
	
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Enter package number: ");
		String pNo = sc.next();
		System.out.println("Enter content: ");
		String content = sc.next();
		System.out.println("Enter weight in Kgs: ");
		Double wt = sc.nextDouble();
		System.out.println("Enter sender address: ");
		String sAdd = sc.next();
		System.out.println("Enter reciever address: ");
		String rAdd = sc.next();
		LocalDateTime ts = LocalDateTime.now();

		shipment s = new shipment(pNo, content, wt, sAdd, rAdd, ts);
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		System.out.println("Shipment created successfully");

		em.close();
		sc.close();
		
	}

	
	
	private static void findShipment() {
	
		Scanner sc = new Scanner(System.in);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("accountUnit");
		
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Enter shipment id to search for shipment details: ");
		int id = sc.nextInt();
		
		shipment s = em.find(shipment.class, id);
		
		if(s != null) {
			System.out.println(s);
		}
		else {
			System.out.println("shipment not found");
		}

		em.close();
		sc.close();
	}
	
	
	
	private static void findShipmentbyDate() {
		// TODO Auto-generated method stub
		
	}



	private static void findShipmentbySender() {
		// TODO Auto-generated method stub
		
	}



	private static void findShipmentbyWeight() {
		// TODO Auto-generated method stub
		
	}

}

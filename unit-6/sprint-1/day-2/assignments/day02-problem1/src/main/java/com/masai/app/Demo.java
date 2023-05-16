package com.masai.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("product");
		
		EntityManager em= emf.createEntityManager();
		
		Product prod = em.find(Product.class, 2);
		
		System.out.println(prod);

		em.close();
		emf.close();
	}

}
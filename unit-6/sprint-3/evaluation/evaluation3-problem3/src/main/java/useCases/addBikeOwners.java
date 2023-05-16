package useCases;

import javax.persistence.EntityManager;

import dto.Bike;
import dto.BikeOwner;
import utitlity.EMUtil;

public class addBikeOwners {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EMUtil.provideEntityManager();
		
		BikeOwner bo1 = new BikeOwner();
		bo1.setOwnerId(1);
		bo1.setOwnerName("Aman");
		bo1.setPhoneNumber("9876543210");
		bo1.setEmailId("aman@gmail.com");
		bo1.setBike(new Bike("123", "black", "Continental-GT650"));
		
		BikeOwner bo2 = new BikeOwner();
		bo2.setOwnerId(2);
		bo2.setOwnerName("Neha");
		bo2.setPhoneNumber("9876543210");
		bo2.setEmailId("aman@gmail.com");
		bo2.setBike(new Bike("123", "red", "CInterceptor-GT650"));
		
		BikeOwner bo3 = new BikeOwner();
		bo3.setOwnerId(3);
		bo3.setOwnerName("Hemant");
		bo3.setPhoneNumber("9876543210");
		bo3.setEmailId("aman@gmail.com");
		bo3.setBike(new Bike("123", "silver", "Meteor-350"));
		
		BikeOwner bo4 = new BikeOwner();
		bo4.setOwnerId(4);
		bo4.setOwnerName("Karan");
		bo4.setPhoneNumber("9876543210");
		bo4.setEmailId("aman@gmail.com");
		bo4.setBike(new Bike("123", "grey", "Classic-350"));
		
		em.getTransaction().begin();
		em.persist(bo1);
		em.persist(bo2);
		em.persist(bo3);
		em.persist(bo4);
		em.getTransaction().commit();
		
		System.out.println("bike owner added successfully");

	}

}

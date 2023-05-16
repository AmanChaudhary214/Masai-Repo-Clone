package useCases;

import java.util.Scanner;

import javax.persistence.EntityManager;

import dto.BikeOwner;
import utitlity.EMUtil;

public class findBikeOwnersByBikeColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = EMUtil.provideEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter bike color : ");
		String color = sc.next();
		
		BikeOwner bo = em.find(BikeOwner.class, color);
		
		System.out.println(bo);
		sc.close();
	}

}

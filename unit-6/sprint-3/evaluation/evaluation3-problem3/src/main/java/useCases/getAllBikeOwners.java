package useCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import dto.Bike;
import dto.BikeOwner;
import utitlity.EMUtil;

public class getAllBikeOwners {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = EMUtil.provideEntityManager();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter model name : ");
		String modelName = sc.next();
		
		BikeOwner bo = em.find(BikeOwner.class, modelName);
		
		System.out.println(bo);
	}

}

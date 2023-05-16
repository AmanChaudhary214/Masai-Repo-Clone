package com.masai.useCases;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.model.Seller;

public class addSeller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Seller s = new Seller();
		
		s.setName("s1");
		s.setEmail("abc123@gmail.com");
		s.setPhone("9876543210");

		SellerDao dao = new SellerDaoImpl();
		dao.addSeller(s);
	}
}

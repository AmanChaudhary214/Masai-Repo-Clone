package com.masai.useCases;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.model.Product;

public class addProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p = new Product();
		
		p.setName("product1");
		p.setCategory("BOOKS");
		p.setPrice(900);
		p.setQuantity(20);
		
		int id = 1;

		SellerDao dao = new SellerDaoImpl();
		dao.addProduct(p, id);
	}

}

package com.masai.useCases;

import java.util.ArrayList;
import java.util.List;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;
import com.masai.model.Product;

public class addproducts {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<>();
		
		Product p1 = new Product();
		p1.setName("product1");
		p1.setCategory("BOOKS");
		p1.setPrice(900);
		p1.setQuantity(20);
		
		Product p2 = new Product();
		p2.setName("product1");
		p2.setCategory("BOOKS");
		p2.setPrice(900);
		p2.setQuantity(20);
		
		list.add(p1);
		list.add(p2);
		
		int id = 1;
		
		SellerDao dao = new SellerDaoImpl();
		dao.addProducts(list, id);
	}
}

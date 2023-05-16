package com.masai.useCases;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class getproduct {

	public static void main(String[] args) {
		
		int id = 1;

		SellerDao dao = new SellerDaoImpl();
		dao.getProduct(id);
	}
}

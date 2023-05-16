package com.masai.useCases;

import com.masai.dao.SellerDao;
import com.masai.dao.SellerDaoImpl;

public class getProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = 1;

		SellerDao dao = new SellerDaoImpl();
		dao.getProduct(id);
	}

}

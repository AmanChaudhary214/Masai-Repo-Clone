package com.masai.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.model.Product;
import com.masai.model.Seller;
import com.masai.utility.EMUtil;

public class SellerDaoImpl implements SellerDao {

	@Override
	public void addSeller(Seller s) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		String res = "";
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		
		res = "done";
		em.close();
		
		System.out.println(res.equals("") ? "error" : "success");
	}

	@Override
	public void addProduct(Product p, int sellerId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		String res = "";
		
		em.getTransaction().begin();
		em.persist(p);
		p.setSellerId(sellerId);
		em.getTransaction().commit();
		
		res = "done";
		em.close();
		
		System.out.println(res.equals("") ? "error" : "success");
	}

	@Override
	public void addProducts(List<Product> p, int sellerId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		String res = "";
		
		em.getTransaction().begin();
		p.forEach(s -> {
			em.persist(s);
			s.setSellerId(sellerId);			
		});
		
		em.getTransaction().commit();
		res = "done";
		em.close();
		
		System.out.println(res.equals("") ? "error" : "success");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getProducts(int SellerId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Query q = em.createQuery("select p from Product p where sellerId =:id");
		
		q.setParameter("id", SellerId);
		
		List<Product> list = q.getResultList();
		
		if (list.isEmpty()) {
			System.out.println("no data found");
		}
		else {
			list.forEach(p -> {
				System.out.println(p.getName());
				System.out.println(p.getCategory());
				System.out.println(p.getPrice());
				System.out.println(p.getQuantity());
				
				int sId = p.getSellerId();
				Seller s = em.find(Seller.class, sId);
				
				System.out.println(s.getName());
				System.out.println(s.getEmail());
				System.out.println(s.getPhone());
			});
		}
		
	}

	@Override
	public void getProduct(int productId) {
		// TODO Auto-generated method stub
		EntityManager em = EMUtil.provideEntityManager();
		
		Product p = em.find(Product.class, productId);
		
		if (p==null) {
			System.out.println("no data found");
		}
		else {
			System.out.println(p.getName());
			System.out.println(p.getCategory());
			System.out.println(p.getPrice());
			System.out.println(p.getQuantity());
			
			int sId = p.getSellerId();
			Seller s = em.find(Seller.class, sId);
			
			System.out.println(s.getName());
			System.out.println(s.getEmail());
			System.out.println(s.getPhone());
		}
	}
}

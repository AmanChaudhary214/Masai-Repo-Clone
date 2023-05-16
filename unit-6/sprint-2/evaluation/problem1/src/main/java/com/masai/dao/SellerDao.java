package com.masai.dao;

import java.util.List;

import com.masai.model.Product;
import com.masai.model.Seller;

public interface SellerDao {

	public void addProduct(Product p, int sellerId);
	public void addProducts(List<Product> p, int sellerId);
	public void getProducts(int SellerId);
	public void getProduct(int productId);
	public void addSeller(Seller s);
}

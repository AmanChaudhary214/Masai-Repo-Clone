package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;

public interface ProductService {

	public void addProduct(Product product) throws ProductException;
	
	public Product viewProductsById(Integer productId) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;
	
}

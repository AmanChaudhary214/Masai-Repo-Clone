package com.ecommerce.service;

import com.ecommerce.exception.CartException;
import com.ecommerce.model.Product;

public interface CartService {

	public Product addProductToCart(Product product) throws CartException;
	
	public Product removeProductFromCart(Product product) throws CartException;
	
}

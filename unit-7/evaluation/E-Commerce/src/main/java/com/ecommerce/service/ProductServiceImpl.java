package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository pRepo;

	
	@Override
	public void addProduct(Product product) throws ProductException {
		
		if (product==null) {
			throw new ProductException("Product is null");
		}
		
		Optional<Product> prod = pRepo.findById(product.getProductId());
		if (prod.isPresent()) {
			throw new ProductException("Product already present");
		}
		
		pRepo.save(product);
	}
	
	

	@Override
	public Product viewProductsById(Integer productId) throws ProductException {
		if (productId == null) {
			throw new ProductException("CustomerId can't be null");
		}

		Optional<Product> existingProduct = pRepo.findById(productId);
		
		if(existingProduct.isEmpty()) {
			throw new ProductException("No product exists with given productId");
		}
		
		return existingProduct.get();
	}
	
	

	@Override
	public List<Product> viewAllProducts() throws ProductException {

		List<Product> list = pRepo.findAll();
		if (list.isEmpty()) {
			throw new ProductException("List is Empty");
		}
		return list;
	}

}

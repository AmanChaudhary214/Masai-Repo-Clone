package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exception.OrdersException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.exception.UserException;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Product;
import com.ecommerce.model.Users;
import com.ecommerce.service.OrdersService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UsersService;

import jakarta.validation.Valid;

@RestController
public class EcommerceController {

	@Autowired
	private UsersService uService;
	
	@Autowired
	private OrdersService oService;
	
	@Autowired
	private ProductService pService;
	
	
	@GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUser() throws UserException {
		
    	List<Users> users = uService.viewAllUsers();
    	
    	ResponseEntity<List<Users>> allUsers = new ResponseEntity<>(users, HttpStatus.OK);
		return allUsers;
    }
    

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody @Valid Users user) throws UserException {
        uService.addUser(user);
    }
    
    
    
    @PostMapping("/placeOrder/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid Orders user, @PathVariable Integer userId) throws OrdersException {
    	oService.placeOrder(user, userId);
    }
    
    
    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<Orders>> getAllOrders(@PathVariable Integer userId) throws OrdersException {
		
    	List<Orders> orders = oService.viewOrderHistory(userId);
    	
    	ResponseEntity<List<Orders>> allOrders = new ResponseEntity<>(orders, HttpStatus.OK);
		return allOrders;
    }
    
    
    
    @PostMapping("/product/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody @Valid Product product) throws ProductException {
    	pService.addProduct(product);
    }
    
    
    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> productById(@PathVariable Integer productId) throws ProductException {
		
    	Product product = pService.viewProductsById(productId);
    	
    	ResponseEntity<Product> products = new ResponseEntity<>(product, HttpStatus.OK);
		return products;
    }
    
    
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable Integer userId) throws ProductException {
		
    	List<Product> products = pService.viewAllProducts();
    	
    	ResponseEntity<List<Product>> allProducts = new ResponseEntity<>(products, HttpStatus.OK);
		return allProducts;
    }
	
}

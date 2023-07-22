package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Entity.Order;
import com.masai.Service.SwiggyService;

@RestController
public class Controller {
	
	@Autowired
	private SwiggyService swiggyService;
	

	@PostMapping("/customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		
		swiggyService.addCustomer(customer);
		
		ResponseEntity<String> response = new ResponseEntity<>("Customer Added Successfully", HttpStatus.OK);
		return response;
		
	}
	
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getEntityAllCustomers(){
		
		List<Customer> customers = swiggyService.getAllCustomers();
		
		ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
		return response;
	}
	
	
	@PostMapping("/order")
	public ResponseEntity<String> placeOrder(Order order){
		
		swiggyService.placeOrder(order);
		
		ResponseEntity<String> response = new ResponseEntity<>("Order Placed Successfully", HttpStatus.OK);
		return response;
	}
}

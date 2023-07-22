package com.masai.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.DeliveryPartner;
import com.masai.Entity.Order;
import com.masai.Entity.Restaurant;

import jakarta.annotation.PostConstruct;

@Service
public class SwiggyService {

	private final Map<String, Customer> customers = new HashMap<>();
	private final Map<String, Restaurant> restaurants = new HashMap<>();
	private final Map<String, DeliveryPartner> deliveryPartners = new HashMap<>();
	private final Map<String, Order> orders = new HashMap<>();
	
	
	@PostConstruct
	public void init() {
		
		Customer customer1 = new Customer("c1", "John Doe", "john.doe@example.com", "123 Street");
        customers.put(customer1.getCustomerId(), customer1);
        Customer customer2 = new Customer("c2", "Ramu Doe", "ramu.doe@example.com", "123 Civil Lines");
        customers.put(customer2.getCustomerId(), customer2);
        
        Restaurant restaurant1 = new Restaurant("r1", "Pizza Hut", "456 Street");
        restaurants.put(restaurant1.getRestaurantId(), restaurant1);
        Restaurant restaurant2 = new Restaurant("r2", "Mc Donalds", "123 Chauraha");
        restaurants.put(restaurant2.getRestaurantId(), restaurant2);

        DeliveryPartner deliveryPartner1 = new DeliveryPartner("d1", "Paul", "5555555555");
        deliveryPartners.put(deliveryPartner1.getDeliveryPartnerId(), deliveryPartner1);
        DeliveryPartner deliveryPartner2 = new DeliveryPartner("d2", "John", "4445555555");
        deliveryPartners.put(deliveryPartner2.getDeliveryPartnerId(), deliveryPartner2);
        
        //validStatuses = Arrays.asList("cooking", "on the way", "delivered");
	}
	
	
	public void addCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
	}
	
	
	public List<Customer> getAllCustomers() {
		Collection<Customer> allCustomers = customers.values();
		List<Customer> customers = new ArrayList<>(allCustomers);
		return customers;
	}
	
	
	public void placeOrder(Order order) {
//		validateOrder(order);
		orders.put(order.getOrderId(), order);
	}


//	private void validateOrder(Order order) {
//	
//		if(order.getRestaurantId() == null || restaurants.get(order.getRestaurantId()) == null) {
//			throw new NotFoundException("Restaurant not found");
//		}
//		
//		if(order.getCustomerId() == null || customers.get(order.getCustomerId()) == null) {
//			throw new NotFoundException("Restaurant not found");
//		}
//	}
	
}

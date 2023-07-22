package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.Entity.Customer;
import com.masai.Entity.DeliveryPartner;
import com.masai.Entity.Order;
import com.masai.Entity.OrderStatus;
import com.masai.Entity.Restaurant;
import com.masai.Exception.SwiggyException;
import com.masai.Repository.CustomerRepository;
import com.masai.Repository.DeliveryPartnerRepository;
import com.masai.Repository.OrderRepository;
import com.masai.Repository.RestaurantRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DeliveryService {
	
	@Autowired
	private CustomerRepository cRepo ;
	
	@Autowired
	private RestaurantRepository rRepo;
	
	@Autowired
	private DeliveryPartnerRepository dRepo;
	
	@Autowired
	private OrderRepository oRepo;


    
    public void addCustomer(Customer customer) {
    	log.info("Customer added successfully");
    	
    	if(customer == null) {
    		throw new SwiggyException("Customer is null") ; 
    	}
    	
    	Optional<Customer> cus = cRepo.findById(customer.getCustomerId()) ;
    	if(cus.isPresent()) {
    		throw new SwiggyException("already present in database") ;
    	}
    	
    	cRepo.save(customer) ;
    }

    
    public void addRestaurant(Restaurant restaurant) {
    	log.info("Resturant added successfully");
  	
	  	if(restaurant == null) {
	  		throw new SwiggyException("Restaurant is null") ; 
	  	}
	  	
	  	Optional<Restaurant> cus = rRepo.findById(restaurant.getRestaurantId()) ;
	  	if(cus.isPresent()) {
	  		throw new SwiggyException("already present in database") ;
	  	}
	  	
  		rRepo.save(restaurant) ;
    }
    

    public void addDeliveryPartner(DeliveryPartner deliveryPartner) {
    	log.info("Delivary partner added successfully");
    	
    	if(deliveryPartner == null) {
    		throw new SwiggyException("DeliveryPartner is null") ; 
    	}
    	
	  	Optional<DeliveryPartner> cus = dRepo.findById(deliveryPartner.getDeliveryPartnerId()) ;
	  	if(cus.isPresent()) {
	  		throw new SwiggyException("already present in database") ;
	  	}
	  	
  		dRepo.save(deliveryPartner) ;
    }
    

    public void placeOrder(Integer customerId , Integer resId , Integer devId , Order order) {
    	log.info("Order placed successfully");
    	
    	Optional<Customer> cus = cRepo.findById(customerId) ;
    	Optional<Restaurant> res = rRepo.findById(resId) ;
    	Optional<DeliveryPartner> dpart = dRepo.findById(devId) ;
    	
    	if(cus.isEmpty() || res.isEmpty()|| dpart.isEmpty() || order == null) {
    		throw new SwiggyException("Null value") ;
    	}
    	
    	order.setCustomer(cus.get());
    	order.setRestaurant(res.get());
    	order.setDeliveryPartner(dpart.get());
    	
    	res.get().getOrders().add(order) ;
    	cus.get().getOrders().add(order) ;
    	dpart.get().getOrders().add(order) ;
    	
    	oRepo.save(order) ;
    }
    

    public void assignDeliveryPartner(Integer orderId, Integer deliveryPartnerId) {
    	log.info("Finding the dpart and order");
    	
    	Optional<DeliveryPartner> dpart = dRepo.findById(deliveryPartnerId) ;
    	Optional<Order> order = oRepo.findById(orderId) ;
    	
    	if(dpart.isEmpty() || order.isEmpty()) {
    		throw new SwiggyException("null value") ;
    	}
    	
    	dpart.get().getOrders().add(order.get()) ;
    	order.get().setDeliveryPartner(dpart.get());
    	
    	oRepo.save(order.get()) ;
    }
    

    public void updateOrderStatus(Integer orderId, OrderStatus newStatus) {
    	log.info("Updating Order Status");
    	
    	Optional<Order> order = oRepo.findById(orderId) ;
        if (order.get().getOrderStatus() == OrderStatus.DELIVERED) {
            throw new SwiggyException("Cannot change the status of a delivered order") ;
        }
        
        order.get().setOrderStatus(newStatus);
        
        oRepo.save(order.get()) ;
    }
       

    public List<Order> fetchCustomerOrderHistory(Integer customerId) {
    	log.info("Finding Order History");
    	
    	Optional<Customer> cus = cRepo.findById(customerId ) ;
    	if(cus.isEmpty()) {
    		throw new SwiggyException("null vallue") ;
    	}
    	
    	if( cus.get().getOrders().isEmpty()) {
    		throw new SwiggyException("Empty order list") ;
    	}
    	
    	return cus.get().getOrders() ;
    }

    
	public List<Customer> getAllCustomers() {
		Pageable pageable = PageRequest.of(0, 5, Sort.by("name").ascending()) ;
		
		List<Customer> customersList = cRepo.findAll(pageable).getContent() ;
		if(customersList.isEmpty()) {
			throw new SwiggyException("Empty customer list") ;
		}
		
		return customersList ;
	}
	
}
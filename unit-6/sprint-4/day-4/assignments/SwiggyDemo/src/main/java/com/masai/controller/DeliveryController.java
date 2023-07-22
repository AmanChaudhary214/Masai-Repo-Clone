package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.masai.model.Customer;
import com.masai.model.DeliveryPartner;
import com.masai.model.OrderStatus;
import com.masai.model.Orders;
import com.masai.model.Restaurant;
import com.masai.service.DeliveryService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
    	
    	List<Customer> customers = deliveryService.getAllCustomers();
    	ResponseEntity<List<Customer>> allCustomers = new ResponseEntity<>(customers, HttpStatus.OK);
		return allCustomers;
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody @Valid Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole("ROLE_"+customer.getRole());
        deliveryService.addCustomer(customer);
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody @Valid Restaurant restaurant) {
        deliveryService.addRestaurant(restaurant);
    }

    @PostMapping("/deliveryPartner")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDeliveryPartner(@RequestBody @Valid DeliveryPartner deliveryPartner) {
        deliveryService.addDeliveryPartner(deliveryPartner);
    }

    @PostMapping("/order/{cusId}/{resId}/{dpartId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@RequestBody @Valid Orders order , @PathVariable("cusId") Integer cus , @PathVariable Integer resId , @PathVariable Integer dpartId) {
    
        deliveryService.placeOrder(cus , resId , dpartId , order );
    }

    @PatchMapping("/order/{orderId}/deliveryPartner/{deliveryPartnerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void assignDeliveryPartner(@PathVariable Integer orderId, @PathVariable Integer deliveryPartnerId) {
        deliveryService.assignDeliveryPartner(orderId, deliveryPartnerId);
    }


    @PatchMapping("/order/{orderId}/status/{orderStatus}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus) {
        deliveryService.updateOrderStatus(orderId, orderStatus);
    }

    @GetMapping("/customer/{customerId}/orders")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Orders> fetchCustomerOrderHistory(@PathVariable Integer customerId) {
        return deliveryService.fetchCustomerOrderHistory(customerId);
    }


    @GetMapping("/signIn")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String fetchCustomerOrderHistory(Authentication authentication) {

        Customer customer = deliveryService.getCustomerDetailsByEmail(authentication.getName());

        return customer.getName() +" Loggin Successfylly";
    }

 
}
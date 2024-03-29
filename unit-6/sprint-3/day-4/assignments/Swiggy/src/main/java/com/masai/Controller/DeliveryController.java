package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Customer;
import com.masai.Entity.DeliveryPartner;
import com.masai.Entity.Order;
import com.masai.Entity.OrderStatus;
import com.masai.Entity.Restaurant;
import com.masai.Service.DeliveryService;

import jakarta.validation.Valid;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;
    
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
    	List<Customer> customers = deliveryService.getAllCustomers();
    	ResponseEntity<List<Customer>> allCustomers = new ResponseEntity<>(customers, HttpStatus.OK);
		return allCustomers;
    }
    

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody @Valid Customer customer) {
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
    public void placeOrder(@RequestBody @Valid Order order, @PathVariable("cusId") Integer cus, @PathVariable Integer resId, @PathVariable Integer dpartId) {
        deliveryService.placeOrder(cus , resId , dpartId , order );
    }
    

    @PatchMapping("/order/{orderId}/deliveryPartner/{deliveryPartnerId}")
    public void assignDeliveryPartner(@PathVariable Integer orderId, @PathVariable Integer deliveryPartnerId) {
        deliveryService.assignDeliveryPartner(orderId, deliveryPartnerId);
    }


    @PatchMapping("/order/{orderId}/status/{orderStatus}")
    public void updateOrderStatus(@PathVariable Integer orderId, @PathVariable OrderStatus orderStatus) {
        deliveryService.updateOrderStatus(orderId, orderStatus);
    }
    

    @GetMapping("/customer/{customerId}/orders")
    public List<Order> fetchCustomerOrderHistory(@PathVariable Integer customerId) {
        return deliveryService.fetchCustomerOrderHistory(customerId);
    }

}
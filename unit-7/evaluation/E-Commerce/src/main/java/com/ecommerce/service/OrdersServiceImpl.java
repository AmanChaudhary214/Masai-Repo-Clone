package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.exception.OrdersException;
import com.ecommerce.model.Orders;
import com.ecommerce.model.Users;
import com.ecommerce.repository.OrdersRepository;
import com.ecommerce.repository.UsersRepository;

public class OrdersServiceImpl implements OrdersService {

	
	@Autowired
	private OrdersRepository oRepo;
	
	@Autowired
	private UsersRepository uRepo;
	
	
	@Override
	public List<Orders> viewOrderHistory(Integer userId) throws OrdersException {

		Optional<Users> user = uRepo.findById(userId);
		
		if (user.isEmpty()) {
			throw new OrdersException("null value");
		}
		if (user.get().getOrderList().isEmpty()) {
			throw new OrdersException("Empty order list");
		}
		return user.get().getOrderList();
	}
	
	
	@Override
	public void placeOrder(Orders order, Integer userId) throws OrdersException {
    	
    	Optional<Users> user = uRepo.findById(userId) ;
    	
    	if(user.isEmpty() || order == null) {
    		throw new OrdersException("Null value") ;
    	}
    	
    	order.setUser(user.get());
    	
    	user.get().getOrderList().add(order) ;
    	
    	oRepo.save(order) ;
    }

}

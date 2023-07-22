package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.OrdersException;
import com.ecommerce.model.Orders;

public interface OrdersService {

	public List<Orders> viewOrderHistory(Integer userId) throws OrdersException;
	
	public void placeOrder(Orders order, Integer userId) throws OrdersException;
}

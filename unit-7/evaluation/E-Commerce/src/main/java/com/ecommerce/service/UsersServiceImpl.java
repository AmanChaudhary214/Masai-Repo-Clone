package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Users;
import com.ecommerce.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository uRepo;

	@Override
	public Users addUser(Users user) throws UserException {

		if (user == null) {
			throw new UserException("user cant be null");
		}
		
		Cart cart = new Cart();
		cart.setUser(user);
		user.setCart(cart);
		
		return uRepo.save(user);
	}

	@Override
	public List<Users> viewAllUsers() throws UserException {

		List<Users> list = uRepo.findAll();
		if (list.isEmpty()) {
			throw new UserException("List is Empty");
		}
		return list;
	}

	
	
}

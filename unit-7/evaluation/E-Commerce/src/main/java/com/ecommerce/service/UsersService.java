package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.UserException;
import com.ecommerce.model.Users;

public interface UsersService {

	public Users addUser(Users user) throws UserException;
	
	public List<Users> viewAllUsers() throws UserException;
	
}

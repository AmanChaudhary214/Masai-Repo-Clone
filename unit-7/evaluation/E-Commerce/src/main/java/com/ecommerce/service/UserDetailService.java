package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ecommerce.model.Users;
import com.ecommerce.repository.UsersRepository;

public class UserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepository uRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> opt = uRepo.findByEmail(username);
		
		if (opt.isPresent()) {
			Users users = opt.get();
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(users.getRole());
			
			authorities.add(sga);
			
			return new User(users.getUsername(), users.getPassword(), authorities);
		}
		else {
			throw new BadCredentialsException("Invalid credentials");
		}
		
	}

}

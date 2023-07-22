package com.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String str);
	
}

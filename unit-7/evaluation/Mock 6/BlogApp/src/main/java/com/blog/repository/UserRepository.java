package com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
	
}

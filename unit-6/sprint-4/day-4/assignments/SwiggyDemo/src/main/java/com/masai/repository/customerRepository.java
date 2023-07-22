package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Customer;

import java.util.Optional;

public interface customerRepository extends JpaRepository<Customer, Integer> , PagingAndSortingRepository<Customer, Integer>{

    Optional<Customer> findByEmail(String str);
}

package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> , PagingAndSortingRepository<Customer, Integer>{

}

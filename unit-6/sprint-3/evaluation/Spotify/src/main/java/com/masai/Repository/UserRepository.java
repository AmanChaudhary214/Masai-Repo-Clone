package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, PagingAndSortingRepository<User, Integer>{

}

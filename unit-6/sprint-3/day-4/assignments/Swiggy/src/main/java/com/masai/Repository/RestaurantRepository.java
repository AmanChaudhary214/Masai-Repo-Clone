package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}

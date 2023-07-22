package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

}

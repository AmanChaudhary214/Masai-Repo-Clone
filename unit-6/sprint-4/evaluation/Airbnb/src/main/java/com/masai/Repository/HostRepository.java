package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Entity.Host;

@Repository
public interface HostRepository extends JpaRepository<Host, Integer>{

}

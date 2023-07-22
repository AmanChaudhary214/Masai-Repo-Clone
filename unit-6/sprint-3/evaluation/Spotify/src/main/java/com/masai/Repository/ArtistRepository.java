package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>{

}

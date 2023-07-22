package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{

}

package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer>{

}

package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}

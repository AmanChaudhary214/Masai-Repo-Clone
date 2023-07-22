package com.masai.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer songId;
	
	@NotNull(message = "name cannot be null")
	private String name;
	
	@NotNull(message = "artistId cannot be null")
	private Integer artistId;
	
	@NotNull(message = "albumId cannot be null")
	private Integer albumId;
	
	@NotNull(message = "duration cannot be null")
	private String duration;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Artist artist;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Album album;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Playlist playlist;
	
}

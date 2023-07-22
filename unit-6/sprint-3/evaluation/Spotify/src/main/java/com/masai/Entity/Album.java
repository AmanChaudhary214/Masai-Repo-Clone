package com.masai.Entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer albumId;
	
	@NotNull(message = "name cannot be null")
	private String name;
	
	@NotNull(message = "artistId cannot be null")
	private Integer artistId;
	
	@NotNull(message = "releaseDate cannot be null")
	private Date releaseDate;
	
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Song> songs;
	
}

package com.masai.Entity;

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
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer artistId;
	
	@NotNull(message = "name cannot be null")
	private String name;
	
	@NotNull(message = "genre cannot be null")
	private String genre;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Song> songs;
	
}

package com.masai.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull(message = "name cannot be null")
	private String name;
	
	@Email(message = "email should be in valid format")
	private String email;
	
	@NotNull(message = "password cannot be null")
	private String password;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Playlist> playlists;
	
}

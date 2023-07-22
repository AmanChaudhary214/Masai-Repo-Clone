package com.masai.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hostId;
	
	@NotNull(message = "value can't be null")
	private String name;
	
	@Column(unique = true)
	private String email;
	
}

package com.ecommerce.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor	
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer userId;

	@NotNull(message = "value cannot be null")
	private String username;

	@NotNull(message = "value cannot be null")
	private String password;

	@NotNull(message = "value cannot be null")
	private String role;

	@NotNull(message = "value cannot be null")
	private String Email;

	@NotNull(message = "value cannot be null")
	private String mobile;

	@NotNull(message = "value cannot be null")
	private String address;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Orders> orderList;
	
	@OneToOne(mappedBy = "user")
	private Cart cart;
	
}

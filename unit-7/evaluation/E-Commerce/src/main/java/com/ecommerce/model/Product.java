package com.ecommerce.model;

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
@AllArgsConstructor
@NoArgsConstructor	
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer productId;
	
	@NotNull(message = "value cannot be null")
	private String title;

	@NotNull(message = "value cannot be null")
	private String description;

	@NotNull(message = "value cannot be null")
	private double price;

	@NotNull(message = "value cannot be null")
	private ProductStock stock; 

	@ManyToOne
	private Orders order;
	
	@ManyToOne
	private Cart cart;
	
}

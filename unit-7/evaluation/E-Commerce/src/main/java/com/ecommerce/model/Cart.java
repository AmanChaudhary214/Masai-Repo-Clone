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
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer cartId;
	
	@NotNull(message = "value cannot be null")
	private double totalValue;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Product> productList;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;
	
}

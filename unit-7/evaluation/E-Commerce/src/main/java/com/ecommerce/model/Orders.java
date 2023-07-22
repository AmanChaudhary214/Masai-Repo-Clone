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
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;

	@NotNull(message = "value cannot be null")
	private OrderStatus orderStatus;
	
	@NotNull(message = "value cannot be null")
	private double orderValue;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Users user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Product> productlist;

}

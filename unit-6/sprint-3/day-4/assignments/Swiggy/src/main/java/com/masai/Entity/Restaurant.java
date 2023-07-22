package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	@NotNull(message = "Address can't be null")
	private String address;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL )
	@JsonIgnore
	private List<Order> orders;
	
	@ManyToMany
	@JsonIgnore
	private List<DeliveryPartner> deliveryList = new ArrayList<>();
	
}

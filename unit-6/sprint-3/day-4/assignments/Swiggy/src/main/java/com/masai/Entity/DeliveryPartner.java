package com.masai.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPartner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryPartnerId;
	
	@NotNull(message = "Name can't be null")
	private String name;
	
	@Size(min=10, max=13, message="length should be proper")
	private String phoneNumber;

	@OneToMany (mappedBy = "deliveryPartner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Order> orders;
	
	@ManyToMany (mappedBy = "deliveryList")
	@JsonIgnore
	private List<Restaurant> restaurants = new ArrayList<>();
	
}

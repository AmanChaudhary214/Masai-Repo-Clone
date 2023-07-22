package com.masai.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
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
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@NotNull(message = "CustomerID can't be null")
	private String customerId;
	
	@NotNull(message = "RestaurantID can't be null")
	private String restaurantId;
	
	@NotNull(message = "DeliveryPartnerID can't be null")
	private String deliveryPartnerId;
	
	@NotNull(message = "value can't be null")
	private List<String> items;
	
	@NotNull(message = "Status can't be null")
	private OrderStatus orderStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL)
	private Restaurant restaurant;
	@ManyToOne(cascade = CascadeType.ALL)
	private DeliveryPartner deliveryPartner;
	
}

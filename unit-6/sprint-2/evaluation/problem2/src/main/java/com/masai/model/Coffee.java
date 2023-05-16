package com.masai.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Coffee extends Beverage {
	
	@Id
	private String coffeeId;
	private Double price;
	private String description;
	private String origin;

	public Coffee(int beverageId, int rating, String coffeeId, Double price, String description, String origin) {
		super(beverageId, rating);
		this.coffeeId = coffeeId;
		this.price = price;
		this.description = description;
		this.origin = origin;
	}

	public String getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(String coffeeId) {
		this.coffeeId = coffeeId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Coffee [coffeeId=" + coffeeId + ", price=" + price + ", description=" + description + ", origin="
				+ origin + "]";
	}
	
	
}

package com.masai.model;

import javax.persistence.Id;

public class Tea extends Beverage{

	@Id
	private String teaId;
	private Double price;
	private String description;
	private String flavor;
	
	public Tea(int beverageId, int rating, String teaId, Double price, String description, String flavor) {
		super(beverageId, rating);
		this.teaId = teaId;
		this.price = price;
		this.description = description;
		this.flavor = flavor;
	}
	
	
	public String getTeaId() {
		return teaId;
	}



	public void setTeaId(String teaId) {
		this.teaId = teaId;
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



	public String getFlavor() {
		return flavor;
	}



	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}



	@Override
	public String toString() {
		return "Tea [teaId=" + teaId + ", price=" + price + ", description=" + description + ", flavor=" + flavor + "]";
	}

}

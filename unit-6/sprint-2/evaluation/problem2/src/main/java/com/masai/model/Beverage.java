package com.masai.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Beverage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beverageId;
	private int rating;
	
	public Beverage(int beverageId, int rating) {
		super();
		this.beverageId = beverageId;
		this.rating = rating;
	}

	public int getBeverageId() {
		return beverageId;
	}

	public void setBeverageId(int beverageId) {
		this.beverageId = beverageId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Beverage [beverageId=" + beverageId + ", rating=" + rating + "]";
	}
	
}

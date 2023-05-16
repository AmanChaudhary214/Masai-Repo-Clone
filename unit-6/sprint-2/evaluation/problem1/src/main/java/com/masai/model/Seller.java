package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellerId;
	private String name;
	private String email;
	private String phone;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Product> productList = new ArrayList<>();

	public Seller() {
		// TODO Auto-generated constructor stub
		super();
	}

	

	public int getSellerId() {
		return sellerId;
	}



	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public List<Product> getProductList() {
		return productList;
	}



	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}



	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", productList=" + productList + "]";
	}
	
}

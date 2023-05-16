package com.problem1;

public class Product {

	private int productId;
	private String productNam;
	private double productPric;
	private int quantity;
	
	public Product() {
		super();
	}

	public Product(int productId, String productNam, double productPric, int quantity) {
		super();
		this.productId = productId;
		this.productNam = productNam;
		this.productPric = productPric;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductNam() {
		return productNam;
	}

	public void setProductNam(String productNam) {
		this.productNam = productNam;
	}

	public double getProductPric() {
		return productPric;
	}

	public void setProductPric(double productPric) {
		this.productPric = productPric;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productNam=" + productNam + ", productPric=" + productPric
				+ ", quantity=" + quantity + "]";
	}
	
}

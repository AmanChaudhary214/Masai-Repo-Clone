package com.masai.dto;

public class CarImpl implements Car {

	private String carId;
	private String model;
	private int price;
	private int seats;
	private String cId;
	
	public CarImpl(String carId, String model, int price, int seats, String cId) {
		super();
		this.carId = carId;
		this.model = model;
		this.price = price;
		this.seats = seats;
		this.cId = cId;
	}

	@Override
	public String getCarId() {
		return carId;
	}

	@Override
	public void setCarId(String carId) {
		this.carId = carId;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getSeats() {
		return seats;
	}

	@Override
	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String getcId() {
		return cId;
	}

	@Override
	public void setcId(String cId) {
		this.cId = cId;
	}

	@Override
	public String toString() {
		return "CarImpl [carId=" + carId + ", model=" + model + ", price=" + price + ", seats=" + seats + ", cId=" + cId
				+ "]";
	}
	
}

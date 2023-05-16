package com.masai.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;
	
	private String name;
	private String city;
	private String address;
	
	@OneToMany(mappedBy = "hotelId")
	private List<RoomType> roomType;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<RoomType> getRoomType() {
		return roomType;
	}

	public void setRoomType(List<RoomType> roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", city=" + city + ", address=" + address
				+ ", roomType=" + roomType + "]";
	}
	
}

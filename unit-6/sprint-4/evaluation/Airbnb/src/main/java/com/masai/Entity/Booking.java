package com.masai.Entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer userId;
	
	@OneToMany(mappedBy = "bookingId", cascade = CascadeType.ALL)
	private List<Room> roomList;
	
	private Date bookingDate;
	private Time bookingDuration;
	private Integer numberOfGuests;
}

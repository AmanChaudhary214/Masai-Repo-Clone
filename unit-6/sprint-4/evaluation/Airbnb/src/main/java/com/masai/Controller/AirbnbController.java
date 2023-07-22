package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Booking;
import com.masai.Entity.Host;
import com.masai.Entity.Property;
import com.masai.Entity.Room;
import com.masai.Entity.User;
import com.masai.Service.AirbnbService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class AirbnbController {

	@Autowired
	private AirbnbService airbnbService;
	
	@PostMapping("/host")
	@ResponseStatus(HttpStatus.CREATED)
	public void addHost(@RequestBody @Valid Host host) {
		airbnbService.addHost(host);
	}
	
	@PostMapping("/property")
	@ResponseStatus(HttpStatus.CREATED)
	public void addProperty(@RequestBody @Valid Property property) {
		airbnbService.addProperty(property);
	}
	
	@PostMapping("/room")
	@ResponseStatus(HttpStatus.CREATED)
	public void addRoom(@RequestBody @Valid Room room) {
		airbnbService.addRoom(room);
	}
	
	@PostMapping("/user")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody @Valid User user) {
		airbnbService.addUser(user);
	}
	
	@PostMapping("/booking")
	@ResponseStatus(HttpStatus.CREATED)
	public void addBooking(@RequestBody @Valid Booking booking) {
		airbnbService.addBooking(booking);
	}
	
	@PostMapping("/createbooking/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public void createBooking(@RequestBody @Valid Booking booking, @PathVariable Integer userId) {
		airbnbService.createBooking(booking, userId);
	}
	
	@PutMapping("/addRoomsToBooking/{bookingId}/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public void addRoomsToBooking(@RequestBody @Valid Room room, @PathVariable Integer bookingId, @PathVariable Integer userId) {
		airbnbService.addRoomsToBooking(room, bookingId, userId);
	}
	
	@PutMapping("/updateBooking/{bookingId}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBooking(@RequestBody @Valid Booking booking, @PathVariable Integer bookingId) {
		airbnbService.updateBooking(booking, bookingId);
	}
	
	@GetMapping("/userBookingHistory/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public List<Booking> userBookingHistory(@RequestBody @PathVariable Integer userId) {
		return airbnbService.fetchUserBookingHistory(userId);
	}
	
}

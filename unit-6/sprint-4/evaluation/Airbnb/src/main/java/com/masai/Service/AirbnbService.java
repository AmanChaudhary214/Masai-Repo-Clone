package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Booking;
import com.masai.Entity.Host;
import com.masai.Entity.Property;
import com.masai.Entity.Room;
import com.masai.Entity.User;
import com.masai.Exception.AirbnbException;
import com.masai.Repository.BookingRepository;
import com.masai.Repository.HostRepository;
import com.masai.Repository.PropertyRepository;
import com.masai.Repository.RoomRepository;
import com.masai.Repository.UserRepository;

@Service
public class AirbnbService {

	@Autowired
	private HostRepository hRepository;
	
	@Autowired
	private PropertyRepository pRepository;
	
	@Autowired
	private RoomRepository rRepository;
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private BookingRepository bRepository;
	
	
	public void addHost(Host host) {
		if (host == null) {
			throw new AirbnbException("host cannot be null");
		}
		Optional<Host> opt = hRepository.findById(host.getHostId());
		if (opt.isPresent()) {
			throw new AirbnbException("host already present");
		}
		hRepository.save(host);
	}
	
	public void addProperty(Property property) {
		if (property == null) {
			throw new AirbnbException("property cannot be null");
		}
		Optional<Property> opt = pRepository.findById(property.getPropertyId());
		if (opt.isPresent()) {
			throw new AirbnbException("property already present");
		}
		pRepository.save(property);
	}
	
	public void addRoom(Room room) {
		if (room == null) {
			throw new AirbnbException("room cannot be null");
		}
		Optional<Room> opt = rRepository.findById(room.getRoomId());
		if (opt.isPresent()) {
			throw new AirbnbException("room already present");
		}
		rRepository.save(room);
	}
	
	public void addUser(User user) {
		if (user == null) {
			throw new AirbnbException("user cannot be null");
		}
		Optional<User> opt = uRepository.findById(user.getUserId());
		if (opt.isPresent()) {
			throw new AirbnbException("user already present");
		}
		uRepository.save(user);
	}
	
	public void addBooking(Booking booking) {
		if (booking == null) {
			throw new AirbnbException("booking cannot be null");
		}
		Optional<Booking> opt = bRepository.findById(booking.getBookingId());
		if (opt.isPresent()) {
			throw new AirbnbException("booking already present");
		}
		bRepository.save(booking);
	}
	
	public void createBooking(Booking booking, Integer userId) {
		
		Optional<User> opt = uRepository.findById(userId);
		
		if (opt.isEmpty() || booking==null) {
			throw new AirbnbException("booking cannot be null");
		}
		booking.setUserId(userId);
		
		opt.get().getBookings().add(booking);
	}
	
	public void addRoomsToBooking(Room room, Integer bookingId, Integer userId) {
		
		Optional<Booking> booking = bRepository.findById(bookingId);
		Optional<User> user = uRepository.findById(userId);
		Optional<Room> r = rRepository.findById(room.getRoomId());
		
		if (user.isEmpty() || booking.isEmpty() || r==null) {
			throw new AirbnbException("user or booking cannot be null");
		}
		List<Room> list = booking.get().getRoomList();
		
		for (int i=0; i<list.size(); i++) {
			if(list.get(i).getRoomId() == r.get().getRoomId()) {
				throw new AirbnbException("room already present");
			}
		}
		
		booking.get().getRoomList().add(room);
	}
	
	public void updateBooking(Booking booking, Integer bookingId) {
		
		Optional<Booking> book = bRepository.findById(bookingId);
		
		if (book.isEmpty() || booking==null) {
			throw new AirbnbException("booking cannot be null");
		}
		
		book.get().setBookingDate(booking.getBookingDate());
		book.get().setBookingDuration(booking.getBookingDuration());
		book.get().setNumberOfGuests(booking.getNumberOfGuests());
	}
	
	public List<Booking> fetchUserBookingHistory(Integer userId) {
		
		Optional<User> user = uRepository.findById(userId);
		
		if (user.isEmpty()) {
			throw new AirbnbException("user cannot be null");
		}
		
		if (user.get().getBookings().isEmpty()) {
			throw new AirbnbException("no bookings found for the user");
		}
		
		return user.get().getBookings();
	}
	
}

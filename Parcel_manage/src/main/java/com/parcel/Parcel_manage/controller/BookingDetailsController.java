package com.parcel.Parcel_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.Parcel_manage.model.BookingDetails;
import com.parcel.Parcel_manage.repository.BookingDetailsRepository;

@RestController
@RequestMapping("/api/bookings")
public class BookingDetailsController {

	@Autowired
	private BookingDetailsRepository bookingRepo;

	@PostMapping
	public BookingDetails createBooking(@RequestBody BookingDetails booking) {
		return bookingRepo.save(booking);
	}

	@GetMapping
	public List<BookingDetails> getAllBookings() {
		return bookingRepo.findAll();
	}

	@GetMapping("/{id}")
	public BookingDetails getBookingById(@PathVariable int id) {
		return bookingRepo.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public BookingDetails updateBooking(@PathVariable int id, @RequestBody BookingDetails updated) {
		updated.setId(id);
		return bookingRepo.save(updated);
	}

	@DeleteMapping("/{id}")
	public void deleteBooking(@PathVariable int id) {
		bookingRepo.deleteById(id);
	}
}

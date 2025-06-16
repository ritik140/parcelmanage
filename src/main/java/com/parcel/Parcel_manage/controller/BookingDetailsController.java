package com.parcel.Parcel_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.Parcel_manage.exception.ResourceNotFoundException;
import com.parcel.Parcel_manage.model.BookingDetails;
import com.parcel.Parcel_manage.service.BookingDetailsService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingDetailsController {

	@Autowired
	private BookingDetailsService bookingService;

	@PostMapping("/book")
	public ResponseEntity<BookingDetails> createBooking(@RequestBody BookingDetails booking) {
		BookingDetails created = bookingService.createBooking(booking);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<BookingDetails>> getAllBookings() {
		List<BookingDetails> bookings = bookingService.getAllBookings();
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookingDetails> getBookingById(@PathVariable int id) {
		BookingDetails booking = bookingService.getBookingById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking ID not found: " + id));
		return new ResponseEntity<>(booking, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<BookingDetails> updateBooking(@PathVariable int id, @RequestBody BookingDetails updated) {
		BookingDetails result = bookingService.updateBooking(id, updated);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
		bookingService.deleteBooking(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// ✅ Global exception handler for this controller
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

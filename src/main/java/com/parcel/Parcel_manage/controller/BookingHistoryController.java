package com.parcel.Parcel_manage.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.Parcel_manage.exception.ResourceNotFoundException;
import com.parcel.Parcel_manage.model.BookingDetails;
import com.parcel.Parcel_manage.model.BookingHistory;
import com.parcel.Parcel_manage.model.User;
import com.parcel.Parcel_manage.repository.BookingDetailsRepository;
import com.parcel.Parcel_manage.repository.BookingHistoryRepository;
import com.parcel.Parcel_manage.repository.UserRepository;
import com.parcel.Parcel_manage.service.BookingHistoryService;

@RestController
@RequestMapping("/api/bookings/history")
@CrossOrigin
public class BookingHistoryController {

	@Autowired
	private BookingHistoryService historyService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingDetailsRepository bookingRepository;

	@Autowired
	private BookingHistoryRepository historyRepository;

	// 🔁 Create booking history
	@PostMapping("/create")
	public ResponseEntity<?> createHistory(@RequestBody BookingHistory history) {
		if (history.getUser() == null || history.getBooking() == null) {
			throw new ResourceNotFoundException("User and Booking must not be null");
		}

		long userId = history.getUser().getId();
		int bookingId = history.getBooking().getId();

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

		BookingDetails booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

		history.setUser(user);
		history.setBooking(booking);

		// ⏰ Set timestamps
		history.setCreatedAt(LocalDateTime.now());
		history.setUpdatedAt(LocalDateTime.now());
		return ResponseEntity.ok(historyService.saveHistory(history));
	}

	// 📄 Get by ID
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		BookingHistory history = historyService.getHistoryById(id);
		if (history == null) {
			throw new ResourceNotFoundException("Booking history not found with ID: " + id);
		}
		return ResponseEntity.ok(history);
	}

	// 📄 Get all histories
	@GetMapping("/all")
	public ResponseEntity<List<BookingHistory>> getAll() {
		return ResponseEntity.ok(historyService.getAllHistory());
	}

	// 📄 Get by User ID
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BookingHistory>> getByUser(@PathVariable int userId) {
		userRepository.findById((long) userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

		return ResponseEntity.ok(historyService.getByUserId(userId));
	}

	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<List<BookingHistory>> getByBooking(@PathVariable Integer bookingId) {
		bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

		return ResponseEntity.ok(historyService.getByBookingId(bookingId));
	}

	// 🔄 Update booking history
	@PutMapping("/{id}")
	public ResponseEntity<?> updateHistory(@PathVariable int id, @RequestBody BookingHistory updatedHistory) {
		BookingHistory existing = historyService.getHistoryById(id);
		if (existing == null) {
			throw new ResourceNotFoundException("Booking history not found with ID: " + id);
		}

		// update fields
		existing.setStatus(updatedHistory.getStatus());
//		existing.setCreatedAt(updatedHistory.getCreatedAt());
		existing.setUpdatedAt(LocalDateTime.now()); // only update the updatedAt timestamp

		// if user or booking changed
		if (updatedHistory.getUser() != null) {
			User user = userRepository.findById(updatedHistory.getUser().getId()).orElseThrow(
					() -> new ResourceNotFoundException("User not found with ID: " + updatedHistory.getUser().getId()));
			existing.setUser(user);
		}

		if (updatedHistory.getBooking() != null) {
			BookingDetails booking = bookingRepository.findById(updatedHistory.getBooking().getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							"Booking not found with ID: " + updatedHistory.getBooking().getId()));
			existing.setBooking(booking);
		}

		return ResponseEntity.ok(historyService.saveHistory(existing));
	}

	// ❌ Delete booking history
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHistory(@PathVariable int id) {
		BookingHistory existing = historyService.getHistoryById(id);
		if (existing == null) {
			throw new ResourceNotFoundException("Booking history not found with ID: " + id);
		}

		historyService.deleteHistory(id);
		return ResponseEntity.ok("Deleted successfully");
	}

	// 📌 Get latest status for a booking
	@GetMapping("/latest-status/{bookingId}")
	public ResponseEntity<?> getLatestStatusByBookingId(@PathVariable int bookingId) {
		BookingDetails booking = bookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));

		BookingHistory latestHistory = historyService.getLatestHistoryByBookingId(bookingId);
		if (latestHistory == null) {
			throw new ResourceNotFoundException("No history found for booking ID: " + bookingId);
		}

		return ResponseEntity.ok(latestHistory.getStatus());
	}

	@GetMapping("/top-latest")
	public ResponseEntity<List<BookingHistory>> getTopLatestUserHistories() {
		List<BookingHistory> latestHistories = historyRepository.findLatestHistoryForTopUsers();
		return ResponseEntity.ok(latestHistories);
	}

}

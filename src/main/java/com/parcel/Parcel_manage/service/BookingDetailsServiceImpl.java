package com.parcel.Parcel_manage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.Parcel_manage.model.BookingDetails;
import com.parcel.Parcel_manage.repository.BookingDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsRepository bookingRepo;

	@Override
	public BookingDetails createBooking(BookingDetails bookingDetails) {
		bookingDetails.setIsActive(true); // default
		bookingDetails.setCreatedAt(java.time.LocalDateTime.now().toString());
		return bookingRepo.save(bookingDetails);
	}

	@Override
	public List<BookingDetails> getAllBookings() {
		return bookingRepo.findAll();
	}

	@Override
	public Optional<BookingDetails> getBookingById(int id) {
		return bookingRepo.findById(id);
	}

//	@Override
//	public List<BookingDetails> getBookingsByUserId(int userId) {
//		return bookingRepo.findByUserId(userId);
//	}

	@Override
	public BookingDetails updateBooking(int id, BookingDetails updatedBooking) {
		Optional<BookingDetails> existing = bookingRepo.findById(id);
		if (existing.isPresent()) {
			BookingDetails booking = existing.get();

			booking.setParcelWeight(updatedBooking.getParcelWeight());
			booking.setPickupTime(updatedBooking.getPickupTime());
			booking.setDropOffTime(updatedBooking.getDropOffTime());
			booking.setServiceCost(updatedBooking.getServiceCost());
			booking.setDeliveryType(updatedBooking.getDeliveryType());
			booking.setPackingPreference(updatedBooking.getPackingPreference());
			booking.setBookingDate(updatedBooking.getBookingDate());
			booking.setUnit(updatedBooking.getUnit());
			booking.setContentDescription(updatedBooking.getContentDescription());
			booking.setReceiverName(updatedBooking.getReceiverName());
			booking.setReceiverMobile(updatedBooking.getReceiverMobile());
			booking.setReceiverPincode(updatedBooking.getReceiverPincode());
			booking.setReceiverEmail(updatedBooking.getReceiverEmail());
			booking.setAddress(updatedBooking.getAddress());
			booking.setCurrentStatus(updatedBooking.getCurrentStatus());

			return bookingRepo.save(booking);
		} else {
			throw new RuntimeException("Booking ID not found: " + id);
		}
	}

	@Override
	public void deleteBooking(int id) {
		bookingRepo.deleteById(id);
	}
}

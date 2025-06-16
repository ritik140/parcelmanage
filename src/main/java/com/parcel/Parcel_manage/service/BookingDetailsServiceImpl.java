package com.parcel.Parcel_manage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.Parcel_manage.exception.ResourceNotFoundException;
import com.parcel.Parcel_manage.model.BookingDetails;
import com.parcel.Parcel_manage.model.Payment;
import com.parcel.Parcel_manage.repository.BookingDetailsRepository;
import com.parcel.Parcel_manage.repository.PaymentRepository;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsRepository bookingRepo;

	@Autowired
	private PaymentRepository paymentRepo;

	@Override
	public BookingDetails createBooking(BookingDetails bookingDetails) {
		bookingDetails.setIsActive(true);
		bookingDetails.setCreatedAt(java.time.LocalDateTime.now().toString());

		// Load the full Payment entity using ID
		int paymentId = bookingDetails.getPaymentId().getId();
		Payment payment = paymentRepo.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found with ID: " + paymentId));

		bookingDetails.setPaymentId(payment);

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

	@Override
	public BookingDetails updateBooking(int id, BookingDetails updatedBooking) {
		BookingDetails booking = bookingRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking ID not found: " + id));

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
	}

	@Override
	public void deleteBooking(int id) {
		if (!bookingRepo.existsById(id)) {
			throw new ResourceNotFoundException("Booking ID not found: " + id);
		}
		bookingRepo.deleteById(id);
	}
}

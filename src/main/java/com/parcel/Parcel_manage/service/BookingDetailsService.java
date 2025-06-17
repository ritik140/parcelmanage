package com.parcel.Parcel_manage.service;

import java.util.List;
import java.util.Optional;

import com.parcel.Parcel_manage.model.BookingDetails;

public interface BookingDetailsService {

	BookingDetails createBooking(BookingDetails bookingDetails);

	List<BookingDetails> getAllBookings();

	Optional<BookingDetails> getBookingById(int id);

//	List<BookingDetails> getBookingsByUserId(int userId);

	BookingDetails updateBooking(int id, BookingDetails bookingDetails);

	void deleteBooking(int id);

}

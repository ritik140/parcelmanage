package com.parcel.Parcel_manage.service;

import java.util.List;

import com.parcel.Parcel_manage.model.BookingHistory;

public interface BookingHistoryService {
	BookingHistory saveHistory(BookingHistory history);

	BookingHistory getHistoryById(int id);

	List<BookingHistory> getAllHistory();

	List<BookingHistory> getByUserId(int userId);

	List<BookingHistory> getByBookingId(int bookingId);

	BookingHistory updateHistory(int id, BookingHistory history);

	void deleteHistory(int id);

	BookingHistory getLatestHistoryByBookingId(int bookingId);
}

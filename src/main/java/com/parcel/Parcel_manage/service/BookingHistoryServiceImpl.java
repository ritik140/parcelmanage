package com.parcel.Parcel_manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.Parcel_manage.model.BookingHistory;
import com.parcel.Parcel_manage.repository.BookingHistoryRepository;

@Service
public class BookingHistoryServiceImpl implements BookingHistoryService {

	@Autowired
	private BookingHistoryRepository repository;

	@Override
	public BookingHistory saveHistory(BookingHistory history) {
		return repository.save(history);
	}

	@Override
	public BookingHistory getHistoryById(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<BookingHistory> getAllHistory() {
		return repository.findAll();
	}

	@Override
	public List<BookingHistory> getByUserId(int userId) {
		return repository.findByUser_Id(userId);
	}

	@Override
	public List<BookingHistory> getByBookingId(int bookingId) {
		return repository.findByBooking_Id(bookingId);
	}

	@Override
	public BookingHistory updateHistory(int id, BookingHistory updatedHistory) {
		BookingHistory existing = repository.findById(id).orElse(null);
		if (existing != null) {
			existing.setStatus(updatedHistory.getStatus());
			existing.setUpdatedAt(updatedHistory.getUpdatedAt());
			existing.setCreatedAt(updatedHistory.getCreatedAt());
			return repository.save(existing);
		}
		return null;
	}

	@Override
	public void deleteHistory(int id) {
		repository.deleteById(id);
	}

	@Override
	public BookingHistory getLatestHistoryByBookingId(int bookingId) {
		return repository.findTopByBooking_IdOrderByUpdatedAtDesc(bookingId);
	}
}

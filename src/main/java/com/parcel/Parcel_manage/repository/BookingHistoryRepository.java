package com.parcel.Parcel_manage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.parcel.Parcel_manage.model.BookingHistory;

public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {
	List<BookingHistory> findByUser_Id(int userId);

	List<BookingHistory> findByBooking_Id(int bookingId);

	BookingHistory findTopByBooking_IdOrderByUpdatedAtDesc(int bookingId);

	@Query(value = """
			SELECT bh.*
			FROM booking_history bh
			INNER JOIN (
			    SELECT user_id, MAX(updated_at) AS max_updated
			    FROM booking_history
			    GROUP BY user_id
			) grouped ON bh.user_id = grouped.user_id AND bh.updated_at = grouped.max_updated
			ORDER BY bh.updated_at DESC
			LIMIT 5
			""", nativeQuery = true)
	List<BookingHistory> findLatestHistoryForTopUsers();

}
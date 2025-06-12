package com.parcel.Parcel_manage.service;

import java.util.List;
import java.util.Optional;

import com.parcel.Parcel_manage.model.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);

	List<Payment> getAllPayments();

	Optional<Payment> getPaymentById(int id);

	void deletePayment(int id);
}

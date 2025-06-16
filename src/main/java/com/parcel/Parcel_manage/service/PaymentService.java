package com.parcel.Parcel_manage.service;

import java.util.List;

import com.parcel.Parcel_manage.model.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);

	List<Payment> getAllPayments();

	Payment getPaymentById(int id);

	void deletePayment(int id);
}

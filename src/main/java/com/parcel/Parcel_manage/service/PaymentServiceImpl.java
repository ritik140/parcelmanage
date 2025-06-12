package com.parcel.Parcel_manage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcel.Parcel_manage.model.Payment;
import com.parcel.Parcel_manage.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(Payment payment) {
		payment.setCreatedAt(LocalDateTime.now().toString());
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> getPaymentById(int id) {
		return paymentRepository.findById(id);
	}

	@Override
	public void deletePayment(int id) {
		paymentRepository.deleteById(id);
	}
}

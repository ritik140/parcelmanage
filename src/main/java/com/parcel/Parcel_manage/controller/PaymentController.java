package com.parcel.Parcel_manage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.Parcel_manage.model.Payment;
import com.parcel.Parcel_manage.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/pay")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentService.createPayment(payment);
	}

	@GetMapping
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping("/{id}")
	public Optional<Payment> getPaymentById(@PathVariable int id) {
		return paymentService.getPaymentById(id);
	}

	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable int id) {
		paymentService.deletePayment(id);
	}
}

package com.parcel.Parcel_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		Payment createdPayment = paymentService.createPayment(payment);
		return ResponseEntity.ok(createdPayment);
	}

	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments() {
		return ResponseEntity.ok(paymentService.getAllPayments());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
		Payment payment = paymentService.getPaymentById(id);
		return ResponseEntity.ok(payment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable int id) {
		paymentService.deletePayment(id);
		return ResponseEntity.noContent().build(); // 204 No Content
	}
}

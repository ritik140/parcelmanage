package com.parcel.Parcel_manage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	@Column(updatable = false)
	private String createdAt;

	private float amount;

	@Enumerated(EnumType.STRING)
	private ModeOfPayment modeOfPayment;

	private long cardNumber;

	private String expiryDate;

	private int cvvNumber;

	// Enum
	public enum ModeOfPayment {
		DEBIT, CREDIT
	}

	public enum PaymentStatus {
		SUCCESS, FAILED, PENDING
	}

	// Constructors
	public Payment() {
	}

//	public Payment(PaymentStatus status, String createdAt, float amount, ModeOfPayment modeOfPayment, String cardNumber,
//			String expiryDate, String cvvNumber) {
//		this.status = status;
//		this.createdAt = createdAt;
//		this.amount = amount;
//		this.modeOfPayment = modeOfPayment;
//		this.cardNumber = cardNumber;
//		this.expiryDate = expiryDate;
//		this.cvvNumber = cvvNumber;
//	}

//	@PrePersist
//	public void prePersist() {
//		this.createdAt = LocalDateTime.now();
//	}

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
}
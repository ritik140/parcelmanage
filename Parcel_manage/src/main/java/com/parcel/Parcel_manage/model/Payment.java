package com.parcel.Parcel_manage.model;

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

	private String status;

	private String createdAt;

	private float amount;

	@Enumerated(EnumType.STRING)
	private ModeOfPayment modeOfPayment;

	private String cardNumber;

	private String expiryDate;

	private String cvvNumber;

	// Enum
	public enum ModeOfPayment {
		DEBIT, CREDIT
	}

	// Constructors
	public Payment() {
	}

	public Payment(String status, String createdAt, float amount, ModeOfPayment modeOfPayment, String cardNumber,
			String expiryDate, String cvvNumber) {
		this.status = status;
		this.createdAt = createdAt;
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.cvvNumber = cvvNumber;
	}

	// Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(String cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
}
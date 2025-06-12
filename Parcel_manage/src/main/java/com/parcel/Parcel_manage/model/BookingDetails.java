package com.parcel.Parcel_manage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userId;
	private float parcelWeight;
	private String pickupTime;
	private String dropOffTime;
	private float serviceCost;

	@Enumerated(EnumType.STRING)
	private DeliveryType deliveryType;

	private String packingPreference;
	private String bookingDate;
	private String createdAt;

	private String paymentId;
	private String unit;
	private String contentDescription;
	private Boolean isActive;

	private String receiverName;
	private String address;
	private long receiverMobile;
	private int receiverPincode;
	private String receiverEmail;
	private String currentStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(float parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getDropOffTime() {
		return dropOffTime;
	}

	public void setDropOffTime(String dropOffTime) {
		this.dropOffTime = dropOffTime;
	}

	public float getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(float serviceCost) {
		this.serviceCost = serviceCost;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	public String getPackingPreference() {
		return packingPreference;
	}

	public void setPackingPreference(String packingPreference) {
		this.packingPreference = packingPreference;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(long receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public int getReceiverPincode() {
		return receiverPincode;
	}

	public void setReceiverPincode(int receiverPincode) {
		this.receiverPincode = receiverPincode;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

}

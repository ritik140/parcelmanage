package com.parcel.Parcel_manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcel.Parcel_manage.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	Payment findByid(long id);
}
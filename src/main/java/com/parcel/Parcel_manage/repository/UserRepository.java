package com.parcel.Parcel_manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parcel.Parcel_manage.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
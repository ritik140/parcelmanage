package com.parcel.Parcel_manage.repository;

import com.parcel.Parcel_manage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
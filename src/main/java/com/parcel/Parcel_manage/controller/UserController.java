package com.parcel.Parcel_manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parcel.Parcel_manage.exception.ResourceNotFoundException;
import com.parcel.Parcel_manage.model.User;
import com.parcel.Parcel_manage.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	// Registration
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// Login
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User loginRequest) {
		User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
		return ResponseEntity.ok(user);
	}

	// Get user by ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Long id) {
		User user = userService.getUserById(id);
		if (user == null) {
			throw new ResourceNotFoundException("User not found with ID: " + id);
		}
		return ResponseEntity.ok(user);
	}

	// Get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUsers());
	}
}

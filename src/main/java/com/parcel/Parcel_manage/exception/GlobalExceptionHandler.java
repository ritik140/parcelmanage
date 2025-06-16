package com.parcel.Parcel_manage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherExceptions(Exception ex) {
		return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<String> handleInvalidCredentials(InvalidCredentialsException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
	}

}

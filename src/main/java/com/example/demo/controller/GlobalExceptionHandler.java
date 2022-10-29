package com.example.demo.controller;

import java.time.OffsetDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({ BindException.class })
	public ResponseEntity<Object> validationError(HttpServletResponse response, BindException e) {

		List<String> errors = e.getBindingResult().getFieldErrors().stream()
				.map(el -> el.getObjectName() + " , " + el.getField() + " , " + el.getDefaultMessage()).toList();

		ApiError error = new ApiError(OffsetDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				HttpStatus.BAD_REQUEST.name(), errors);

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}

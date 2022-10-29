package com.example.demo.exception;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private OffsetDateTime timestamp;
	private int status;
	private String message;
	private List<String> errors;

}

package com.bookapp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {

	private String message;
	private LocalDateTime timestamp;
	private int statusCode;
	private String error;
	private HttpStatus status;
	
}

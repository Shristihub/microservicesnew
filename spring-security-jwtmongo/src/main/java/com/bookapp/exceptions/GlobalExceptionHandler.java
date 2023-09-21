package com.bookapp.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookapp.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		headers.add("info","method not supported");
		String error = ex.getMessage();
		int statusCode = status.value();
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		ApiErrors apiErrors = new ApiErrors(headers.toString(),timestamp,statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		headers.add("info","method not supported");
		String error = ex.getMessage();
		int statusCode = status.value();
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		ApiErrors apiErrors = new ApiErrors(headers.toString(),timestamp,statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		headers.add("info","method not supported");
		String error = ex.getMessage();
		int statusCode = status.value();
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		ApiErrors apiErrors = new ApiErrors(headers.toString(),timestamp,statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		headers.add("info","method not supported");
		String error = ex.getMessage();
		int statusCode = status.value();
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		ApiErrors apiErrors = new ApiErrors(headers.toString(),timestamp,statusCode,error,httpStatus);
		return ResponseEntity.status(status).headers(headers).body(apiErrors);
	
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleTypeMismatch(ex, headers, status, request);
	}

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> handleBookNotFound(BookNotFoundException ex){
		HttpHeaders headers  = new HttpHeaders();
		headers.add("info","method not supportedook not found exception");
		String error = ex.getMessage();
		int statusCode = HttpStatus.GONE.value();
		LocalDateTime timestamp = LocalDateTime.now();
		HttpStatus httpStatus = HttpStatus.valueOf(statusCode);
		ApiErrors apiErrors = new ApiErrors(headers.toString(),timestamp,statusCode,error,HttpStatus.GONE);
		return ResponseEntity.status(httpStatus).headers(headers).body(apiErrors);
	}
	
}

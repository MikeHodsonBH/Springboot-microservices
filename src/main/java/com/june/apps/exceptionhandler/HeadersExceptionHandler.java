package com.june.apps.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.june.apps.interceptor.InvalidHeadersException;

@RestControllerAdvice
public class HeadersExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<String> handleInvalidHeaderExceptionHandler(InvalidHeadersException exception) {
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.PRECONDITION_FAILED);
		
	}
	
}

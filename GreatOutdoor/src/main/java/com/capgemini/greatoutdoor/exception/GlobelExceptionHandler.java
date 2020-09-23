package com.capgemini.greatoutdoor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<Object> exception(ProductException productException)
	{
		
		return new ResponseEntity<>(productException.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
}

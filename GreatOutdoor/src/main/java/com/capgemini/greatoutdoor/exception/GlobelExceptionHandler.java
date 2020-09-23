package com.capgemini.greatoutdoor.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobelExceptionHandler {

	@ExceptionHandler(value = ProductException.class)
	public ResponseEntity<Object> exception(ProductException productException, WebRequest webRequest) {
		CustomEntityException error = new CustomEntityException(new Date(), productException.getMessage(),
				webRequest.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

	}

}

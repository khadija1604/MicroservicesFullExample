package com.lollaby.department.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentApiExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<ApiException>  handleDepatmentException(DepartmentApiException e){
		ApiException exception= new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
		return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
	}

}

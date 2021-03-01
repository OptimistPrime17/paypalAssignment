package com.paypal.bfs.test.employeeserv.exception;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public ResponseEntity<?> handleEmployeeAlreadyExistsException(Exception e, WebRequest req) {
		ErrorDetails details = new ErrorDetails(new Date(), e.getMessage(), req.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(Exception e, WebRequest req) {
		String msg="The following fields are not allowed to be null: first_name, last_name, date_of_birth, address(line1, state, city, country ,zip). Please refer the documentation (readme.md) for an example of a valid request body";
		ErrorDetails details = new ErrorDetails(new Date(), msg, req.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpNotReadableExceptions(Exception e, WebRequest req) {
		String msg="The request body is in an improper format. Please refer the documentation (readme.md) for an example of a valid request body";
		ErrorDetails details = new ErrorDetails(new Date(), msg, req.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<?> handleExceptions(Exception e, WebRequest req) {
		String msg="Invalid input value for id. Please refer the documentation (readme.md) for an example of a valid request body";
		ErrorDetails details = new ErrorDetails(new Date(), msg, req.getDescription(false));
		return new ResponseEntity(details, HttpStatus.NOT_FOUND);

	}
	
}

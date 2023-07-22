package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> handleNotFoundException(Exception ex, WebRequest wr) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> handleNotFoundException(NotFoundException ex, WebRequest wr) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<MyErrorDetails> handleNotFoundException(InvalidEmailException ex, WebRequest wr) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<MyErrorDetails> handleNotFoundException(InvalidInputException ex, WebRequest wr) {
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails, HttpStatus.BAD_REQUEST);
	}
	
}

package com.blog.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> handleGlobalExceptions(Exception se,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(se.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> handleValidationGlobalExceptions(MethodArgumentNotValidException se){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(se.getBindingResult().getFieldError().getDefaultMessage());
		myErrorDetails.setMesseage("Validation Error"); // clear exception from IA
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> handleUserExceptions(UserException ce,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(ce.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(BlogException.class)
	public ResponseEntity<MyErrorDetails> handleBlogExceptions(BlogException ie,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(ie.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
}

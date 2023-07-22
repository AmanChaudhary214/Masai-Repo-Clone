package com.ecommerce.exception;

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
		myErrorDetails.setMesseage("Validation Error");
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> handleProductExceptions(ProductException ce,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(ce.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyErrorDetails> handleOrdersExceptions(OrdersException ce,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(ce.getMessage());
		
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
	
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> handleCartExceptions(CartException ce,WebRequest wr){
		
		MyErrorDetails myErrorDetails = new MyErrorDetails();
		
		myErrorDetails.setLocalDateTime(LocalDateTime.now());
		myErrorDetails.setDescription(wr.getDescription(false));
		myErrorDetails.setMesseage(ce.getMessage());
		
		return new ResponseEntity<MyErrorDetails>(myErrorDetails,HttpStatus.BAD_REQUEST);
	}
}

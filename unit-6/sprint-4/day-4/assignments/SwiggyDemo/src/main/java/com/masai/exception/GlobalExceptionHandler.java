package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SwiggyException.class)
    public ResponseEntity<MyError> swiggyExceptionHandler(SwiggyException ex, WebRequest web) {
        MyError myerror = new MyError();
        myerror.setTimestamp(LocalDateTime.now());
        myerror.setMessage(ex.getMessage());
        myerror.setDetails(web.getDescription(false));
        return new ResponseEntity<>(myerror, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyError> methodArgumentExceptionHandler(MethodArgumentNotValidException ex,WebRequest wb) {
        MyError myerror = new MyError();
        myerror.setTimestamp(LocalDateTime.now());
        myerror.setMessage(ex.getMessage());
        myerror.setDetails(wb.getDescription(false));
        return new ResponseEntity<>(myerror, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<MyError> handleNotFoundException(NoHandlerFoundException ex,WebRequest web) {
        MyError myerror = new MyError();
        myerror.setTimestamp(LocalDateTime.now());
        myerror.setMessage(ex.getMessage());
        myerror.setDetails(web.getDescription(false));
        return new ResponseEntity<>(myerror, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyError> handleGeneralException(Exception ex,WebRequest web) {
        MyError myerror = new MyError();
        myerror.setTimestamp(LocalDateTime.now());
        myerror.setMessage(ex.getMessage());
        myerror.setDetails(web.getDescription(false));
        return new ResponseEntity<>(myerror, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Add additional exception handlers as needed
}
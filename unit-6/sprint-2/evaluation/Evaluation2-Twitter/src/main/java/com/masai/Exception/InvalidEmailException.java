package com.masai.Exception;

public class InvalidEmailException extends RuntimeException{

	public InvalidEmailException(String message) {
		super(message);
	}

}

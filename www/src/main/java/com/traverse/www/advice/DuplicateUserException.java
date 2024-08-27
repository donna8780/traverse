package com.traverse.www.advice;

public class DuplicateUserException extends RuntimeException{

	public DuplicateUserException(String message) {
		super(message);
	}
}

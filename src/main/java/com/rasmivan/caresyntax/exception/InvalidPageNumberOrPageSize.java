package com.rasmivan.caresyntax.exception;


public class InvalidPageNumberOrPageSize extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public InvalidPageNumberOrPageSize(String message) {
		super(message);
	}

}
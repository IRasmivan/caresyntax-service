package com.rasmivan.caresyntax.exception;


public class InvalidStudyDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public InvalidStudyDetails(String message) {
		super(message);
	}

}
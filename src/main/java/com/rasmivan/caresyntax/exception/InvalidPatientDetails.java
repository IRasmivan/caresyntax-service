package com.rasmivan.caresyntax.exception;


public class InvalidPatientDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public InvalidPatientDetails(String message) {
		super(message);
	}

}
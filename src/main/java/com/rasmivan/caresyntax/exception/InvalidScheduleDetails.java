package com.rasmivan.caresyntax.exception;


public class InvalidScheduleDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public InvalidScheduleDetails(String message) {
		super(message);
	}

}
package com.rasmivan.caresyntax.exception;


public class PatientStudyNotFound extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public PatientStudyNotFound(String message) {
		super(message);
	}

}
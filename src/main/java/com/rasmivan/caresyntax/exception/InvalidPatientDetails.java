package com.rasmivan.caresyntax.exception;

/**
 * The Class InvalidPatientDetails.
 */
public class InvalidPatientDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new invalid patient details.
	 *
	 * @param message the message
	 */
	public InvalidPatientDetails(String message) {
		super(message);
	}

}
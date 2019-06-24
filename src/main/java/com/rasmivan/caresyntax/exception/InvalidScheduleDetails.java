package com.rasmivan.caresyntax.exception;

/**
 * The Class InvalidScheduleDetails.
 */
public class InvalidScheduleDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new invalid schedule details.
	 *
	 * @param message the message
	 */
	public InvalidScheduleDetails(String message) {
		super(message);
	}

}
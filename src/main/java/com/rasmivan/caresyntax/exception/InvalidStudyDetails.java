package com.rasmivan.caresyntax.exception;

/**
 * The Class InvalidStudyDetails.
 */
public class InvalidStudyDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new invalid study details.
	 *
	 * @param message the message
	 */
	public InvalidStudyDetails(String message) {
		super(message);
	}

}
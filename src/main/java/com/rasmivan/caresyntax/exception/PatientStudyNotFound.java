package com.rasmivan.caresyntax.exception;

/**
 * The Class PatientStudyNotFound.
 */
public class PatientStudyNotFound extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new patient study not found.
	 *
	 * @param message the message
	 */
	public PatientStudyNotFound(String message) {
		super(message);
	}

}
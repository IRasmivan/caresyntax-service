package com.rasmivan.caresyntax.exception;

/**
 * The Class InvalidPageNumberOrPageSize.
 */
public class InvalidPageNumberOrPageSize extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new invalid page number or page size.
	 *
	 * @param message the message
	 */
	public InvalidPageNumberOrPageSize(String message) {
		super(message);
	}

}
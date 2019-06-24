package com.rasmivan.caresyntax.exception;

/**
 * The Class InvalidRoomDetails.
 */
public class InvalidRoomDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	/**
	 * Instantiates a new invalid room details.
	 *
	 * @param message the message
	 */
	public InvalidRoomDetails(String message) {
		super(message);
	}

}
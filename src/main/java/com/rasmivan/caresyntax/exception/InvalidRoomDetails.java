package com.rasmivan.caresyntax.exception;


public class InvalidRoomDetails extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3630040717052588117L;
	
	public InvalidRoomDetails(String message) {
		super(message);
	}

}
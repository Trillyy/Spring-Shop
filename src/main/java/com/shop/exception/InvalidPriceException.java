package com.shop.exception;

public class InvalidPriceException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1149579599832940847L;

	public InvalidPriceException(String message) {
		super(message);
	}
	
	public InvalidPriceException() {}
	
}

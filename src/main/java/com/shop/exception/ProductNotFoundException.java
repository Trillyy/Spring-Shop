package com.shop.exception;

public class ProductNotFoundException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1801382393264868860L;

	public ProductNotFoundException(String message) {
		super(message);
	}
	
	public ProductNotFoundException() {}
	
}

package com.june.apps.interceptor;

public class InvalidHeadersException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public InvalidHeadersException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

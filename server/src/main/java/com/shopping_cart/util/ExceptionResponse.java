package com.shopping_cart.util;

import java.time.LocalDateTime;

public class ExceptionResponse {
	private final boolean failure;
	private final String message;

	public ExceptionResponse(boolean failure, String message) {
		this.failure  = failure;
		this.message = message;
		
	}

	
	public String getMessage() {
		return message;
	}

	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}

	public boolean isFailure() {
		return failure;
	}

}

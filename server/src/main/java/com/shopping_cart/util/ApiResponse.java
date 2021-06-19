package com.shopping_cart.util;

import java.time.LocalDateTime;
import java.util.List;



public class ApiResponse<E> {
	private final boolean success;
	private final String message;
	private final List<E> list;
	// try again
	
	public ApiResponse(boolean success, String message,List<E> list) {
		this.success = success;
		this.message = message;
		this.list = list;
	}
	
	

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}



	public List<E> getList() {
		return list;
	}
}

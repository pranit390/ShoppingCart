package com.shopping_cart.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends IllegalArgumentException{
public UserNotFoundException(String msg) {
	super(msg);
}
}

package com.shopping_cart.exception;


@SuppressWarnings("serial")
public class CartItemNotExistException extends IllegalArgumentException {
    public CartItemNotExistException(String msg) {
        super(msg);
    }
}
package com.shopping_cart.exception;

@SuppressWarnings("serial")
public class UpdateFailException extends IllegalArgumentException {
    public UpdateFailException(String msg) {
        super(msg);
    }
}
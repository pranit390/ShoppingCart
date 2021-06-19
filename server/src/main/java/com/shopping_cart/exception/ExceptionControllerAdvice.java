package com.shopping_cart.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shopping_cart.model.Cart;

import com.shopping_cart.util.ExceptionResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	MessageSource messageSource;
	@ExceptionHandler(value = ProductNotExistException.class)
	    public final ResponseEntity<ExceptionResponse> handleProductNotExistException(ProductNotExistException exception){
	        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(true,  messageSource.getMessage("error.ProductNotExistException",null,null)),  HttpStatus.OK);
	    }
	 
	 
	 @ExceptionHandler(value = CartItemNotExistException.class)
	    public final ResponseEntity<ExceptionResponse> handleCartItemNotExistException(CartItemNotExistException exception){
	        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(true, messageSource.getMessage("error.CartItemNotExistException", null, null)),  HttpStatus.OK);
	    }
	 
	 
	 
	 @ExceptionHandler(value = UpdateFailException.class)
	    public final ResponseEntity<ExceptionResponse> handleUpdateFailException(UpdateFailException exception){
	        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(true, messageSource.getMessage("error.UpdateFailException", null, null)),  HttpStatus.OK);
	    }
	 
	 @ExceptionHandler(value = UserNotFoundException.class)
	    public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException exception){
	        return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(true, messageSource.getMessage("error.UserNotFoundException", null, null)),  HttpStatus.OK);
	    }
}

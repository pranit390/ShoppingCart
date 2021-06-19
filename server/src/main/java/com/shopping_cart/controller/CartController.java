package com.shopping_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_cart.exception.CartItemNotExistException;
import com.shopping_cart.exception.ProductNotExistException;
import com.shopping_cart.exception.UpdateFailException;
import com.shopping_cart.exception.UserNotFoundException;
import com.shopping_cart.model.Cart;
import com.shopping_cart.service.CartService;
import com.shopping_cart.util.ApiResponse;



@RestController
@RequestMapping("api/addtocart")

public class CartController {

	@Autowired
	CartService cartService;

	@SuppressWarnings("rawtypes")
	@RequestMapping("addProduct")
	public ResponseEntity<?> addCartwithProduct(@RequestParam long productId, long userId, int qty)
			throws ProductNotExistException {
		cartService.addCartbyUserIdAndProductId(productId, userId, qty);
		List<Cart> obj = cartService.getCartByUserId(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse<Cart>(true, "Added to cart", obj), HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("getCartsByUserId")
	public ResponseEntity<?> getCartsByUserId(@RequestParam long userId) {

		List<Cart> obj = cartService.getCartByUserId(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse<Cart>(true, "List send", obj), HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("updateQtyForCart")
	public ResponseEntity<?> updateQtyForCart(@RequestParam long cartId, int qty, long userId)
			throws CartItemNotExistException, UpdateFailException {
       
		cartService.updateQtyByCartId(cartId, qty);
		List<Cart> obj = cartService.getCartByUserId(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse<Cart>(true, "Product has been updated", obj), HttpStatus.OK);

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("removeProductFromCart")
	public ResponseEntity<?> removeCartItemWithCartId(@RequestParam long cartId, @RequestParam long userId)
			throws CartItemNotExistException {
		cartService.removeCartByUserId(cartId);
		List<Cart> obj = cartService.getCartByUserId(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse<>(true, "Deleted", obj), HttpStatus.OK);
	}
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("removeAllProductFromCart")
	public ResponseEntity<?> removeEntireCartWithUserId(@RequestParam long userId)
			throws UserNotFoundException {
		
		cartService.removeEntireCartByUserId(userId);
		List<Cart> obj = cartService.getCartByUserId(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse<>(true, " Everything in cart Deleted", obj), HttpStatus.OK);
	}
}

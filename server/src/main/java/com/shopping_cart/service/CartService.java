package com.shopping_cart.service;

import java.util.List;

import com.shopping_cart.exception.CartItemNotExistException;
import com.shopping_cart.exception.ProductNotExistException;
import com.shopping_cart.exception.UpdateFailException;
import com.shopping_cart.exception.UserNotFoundException;
import com.shopping_cart.model.Cart;

public interface CartService {
	void addCartbyUserIdAndProductId(long productId, long userId, int qty) throws ProductNotExistException;

	void updateQtyByCartId(long cartId, int qty) throws UpdateFailException, CartItemNotExistException;

	List<Cart> getCartByUserId(long userId);

	void removeCartByUserId(long cartId) throws CartItemNotExistException;
	
	
	void removeEntireCartByUserId(long userId) throws UserNotFoundException;
}

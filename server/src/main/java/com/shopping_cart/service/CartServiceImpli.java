package com.shopping_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_cart.exception.CartItemNotExistException;
import com.shopping_cart.exception.ProductNotExistException;
import com.shopping_cart.exception.UpdateFailException;
import com.shopping_cart.exception.UserNotFoundException;
import com.shopping_cart.model.Cart;
import com.shopping_cart.repository.CartRepository;
import com.shopping_cart.repository.ProductRepository;
import com.shopping_cart.repository.UserRepository;

@Service
public class CartServiceImpli implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

//============================================================================================================================
	@Override
	public void addCartbyUserIdAndProductId(long productId, long userId, int qty) throws ProductNotExistException {

		if (cartRepository.getCartByProductIdAnduserId(userId, productId).isPresent()) {
			throw new ProductNotExistException("product already exist");
		}

		if (productRepository.findById(productId).orElse(null) == null) {
			throw new ProductNotExistException("Product not found");
		}

		Cart addCart = new Cart();
		addCart.setProduct(productRepository.findById(productId).orElse(null));
		addCart.setQuantity(qty);
		addCart.setUser(userRepository.findById(userId).orElse(null));

		cartRepository.saveAndFlush(addCart);

	}

//=================================================================================================================================
	public List<Cart> getCartByUserId(long userId) {
		return cartRepository.getCartByuserId(userId);
	}

//=======================================================================================================================	
	@Override
	public void updateQtyByCartId(long cartId, int qty) throws UpdateFailException, CartItemNotExistException {
		if (!cartRepository.existsById(cartId))
			throw new CartItemNotExistException("Cart id is invalid");
		if (qty < 0) {
			throw new UpdateFailException("Quantity less than zero");
		}
		if (qty == 0) {

			removeCartByUserId(cartId);

		}

		cartRepository.updateQtyByCartId(cartId, qty);
	}

//=============================================================================================================================	

	@Override
	public void removeCartByUserId(long cartId) throws CartItemNotExistException {

		if (!cartRepository.existsById(cartId))
			throw new CartItemNotExistException("Cart id is invalid");
		cartRepository.deleteCartByIdAndUserId(cartId);

	}
//==============================================================================================================================
	@Override
	public void removeEntireCartByUserId(long userId) throws UserNotFoundException {
		if (!userRepository.existsById(userId))
			throw new UserNotFoundException(" user id is invalid");
		cartRepository.deleteEntireCartByUserId(userId);
	}

}

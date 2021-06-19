package com.shopping_cart.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping_cart.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("Select cart FROM Cart cart WHERE cart.product.productId= :product_id and cart.user.userId=:user_id")
	Optional<Cart> getCartByProductIdAnduserId(@Param("user_id") Long user_id, @Param("product_id") Long product_id);

	@Query("Select addCart  FROM Cart addCart WHERE addCart.user.userId=:user_id")
	List<Cart> getCartByuserId(@Param("user_id") Long user_id);

	@Modifying
	@Transactional
	@Query("DELETE  FROM Cart addCart WHERE addCart.id =:cart_id")
	void deleteCartByIdAndUserId(@Param("cart_id") Long cart_id);

	@Modifying
	@Transactional
	@Query("UPDATE Cart addCart set addCart.quantity=:qty WHERE addCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id") Long cart_id, @Param("qty") Integer qty);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Cart addCart WHERE addCart.user.userId =:userId")
	void deleteEntireCartByUserId(@Param("userId") Long userId);

	
}

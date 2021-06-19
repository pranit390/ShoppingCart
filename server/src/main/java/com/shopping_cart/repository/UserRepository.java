package com.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping_cart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

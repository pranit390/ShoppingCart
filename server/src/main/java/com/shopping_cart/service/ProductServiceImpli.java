package com.shopping_cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_cart.model.Product;
import com.shopping_cart.repository.ProductRepository;

@Service
public class ProductServiceImpli implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProduct() {

		List<Product> productList = productRepository.findAll();

		return productList;
	}
}

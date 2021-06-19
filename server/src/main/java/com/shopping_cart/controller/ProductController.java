package com.shopping_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_cart.model.Product;
import com.shopping_cart.service.ProductService;
import com.shopping_cart.util.ApiResponse;

@RestController
@RequestMapping("api/product")

public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("getProducts")
	public ResponseEntity<?> getProducts() {

		List<Product> obj = productService.getAllProduct();

		return new ResponseEntity<ApiResponse<Product>>(new ApiResponse<Product>(true, "List send", obj),
				HttpStatus.CREATED);
	}

}

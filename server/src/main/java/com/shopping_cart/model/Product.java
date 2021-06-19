package com.shopping_cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="product")
public  class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@Column(name="product_name")
	private String productName;
	public Long getProductId() {
		return productId;
	}

	

	@Column(name="product_price")
	private float productPrice;
	
	public Product(String productName, float productPrice) {
		super();
		this.setProductName(productName);
		this.setProductPrice(productPrice);
	}

	public Product() {
		super();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
}

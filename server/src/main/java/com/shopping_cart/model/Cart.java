package com.shopping_cart.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart")
public class Cart {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @ManyToOne
	    @JoinColumn(name = "prodId", referencedColumnName = "productId")
	    private Product product;


	    @JsonIgnore
	    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "user_id")
	    private User user;

        private int quantity;
	   

	    public Cart() {
	    }

	   

	    public long getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }

	

	    public Product getProduct() {
	        return product;
	    }

	    public void setProduct(Product product) {
	        this.product = product;
	    }



		public int getQuantity() {
			return quantity;
		}



		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	
	
	
}

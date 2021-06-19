package com.shopping_cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userFirstName;
	private String userLastName;
	private String userPassword;
	private String userEmail;
	private Long userMobilenumber;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String userFirstName, String userLastName, String userPassword, String userEmail,
			Long userMobilenumber) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userMobilenumber = userMobilenumber;
	}
	public Long getUserId() {
		return userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public Long getUserMobilenumber() {
		return userMobilenumber;
	}


	
}

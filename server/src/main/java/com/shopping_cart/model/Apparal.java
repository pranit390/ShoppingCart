package com.shopping_cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Apparal")
public class Apparal extends Product{
	
	@Column(name="apparal_type")
	private String appralType;
	@Column(name="apparal_brand")
	private String appralBrand;
	@Column(name="apparal_design")
	private String appralDesign;
	
	
	public String getAppralType() {
		return appralType;
	}
	public void setAppralType(String appralType) {
		this.appralType = appralType;
	}
	public String getAppralBrand() {
		return appralBrand;
	}
	public void setAppralBrand(String appralBrand) {
		this.appralBrand = appralBrand;
	}
	public String getAppralDesign() {
		return appralDesign;
	}
	public void setAppralDesign(String appralDesign) {
		this.appralDesign = appralDesign;
	}
	
	public Apparal() {
		
	}
	
	public Apparal(String productName, float productPrice, String appralType, String appralBrand, String appralDesign) {
		super(productName, productPrice);
		this.appralType = appralType;
		this.appralBrand = appralBrand;
		this.appralDesign = appralDesign;
	}
	
	

}

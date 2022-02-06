package com.VegetableShoppingCentre.bean;

import java.util.List;

public class CartInputBean
{
	private Long userId;
	private List productId;
	private List quantity;
	private List price;
	
	public List getPrice() {
		return price;
	}
	public void setPrice(List price) {
		this.price = price;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List getProductId() {
		return productId;
	}
	public void setProductId(List productId) {
		this.productId = productId;
	}
	public List getQuantity() {
		return quantity;
	}
	public void setQuantity(List quantity) {
		this.quantity = quantity;
	}
	
	
}

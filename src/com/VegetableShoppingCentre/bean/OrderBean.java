package com.VegetableShoppingCentre.bean;

import java.util.List;

public class OrderBean
{
	private Integer totalProduct;
	private Long totalAmt;
	private Long userId;
	private Long addressId;
	private List productPrice;
	private List productQuantity;
	private List productId;
	
	/*----for new address---*/
	private String address1;
	private String landmark;
	private Long pincode;
	private Long mobileNo;
	private Long city;
	/*----for new address end---*/
	
	public Integer getTotalProduct() {
		return totalProduct;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public void setTotalProduct(Integer totalProduct) {
		this.totalProduct = totalProduct;
	}
	
	public Long getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(Long totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public List getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(List productPrice) {
		this.productPrice = productPrice;
	}
	public List getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(List productQuantity) {
		this.productQuantity = productQuantity;
	}
	public List getProductId() {
		return productId;
	}
	public void setProductId(List productId) {
		this.productId = productId;
	}
	
	
}

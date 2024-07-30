package com.example.demo.dto;

import java.sql.Date;

public class OrdersDTO {
	private String email;
	public String getDateTime() {
		return dateTime;
	}
	private String product_name;
    private String price;
    private String quantity;
    private String totalAmount;
    private String address;
    private String pincode;
    private String dateTime;
    public OrdersDTO(String email, String product_name, String price, String quantity, String totalAmount,
			String address, String pincode, String dateTime, String status) {
		super();
		this.email = email;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.address = address;
		this.pincode = pincode;
		this.dateTime = dateTime;
		this.status = status;
	}
	private String status;
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}

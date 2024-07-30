package com.example.demo.dto;

import java.sql.Date;

public class ProductDTO {
 private String	email;
 private String product_name;
 private String price;
 private String quantity;
 private Date produced_date;
 private Date expiration_date;
 private String category;
 private String image;
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

public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public ProductDTO(String email, String product_name, String price, String quantity, Date produced_date,
		Date expiration_date, String category, String image) {
	super();
	this.email = email;
	this.product_name = product_name;
	this.price = price;
	this.quantity = quantity;
	this.produced_date = produced_date;
	this.expiration_date = expiration_date;
	this.category = category;
	this.image = image;
}
public Date getProduced_date() {
	return produced_date;
}
public void setProduced_date(Date produced_date) {
	this.produced_date = produced_date;
}
public Date getExpiration_date() {
	return expiration_date;
}
public void setExpiration_date(Date expiration_date) {
	this.expiration_date = expiration_date;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

 
 
}

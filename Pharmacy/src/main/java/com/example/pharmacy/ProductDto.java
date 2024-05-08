package com.example.pharmacy;

import jakarta.persistence.Column;

public class ProductDto {
	private Long id;
	private String pname;
	private int quantity;
	private int price;
	public ProductDto(Long id, String pname, int quantity, int price) {
		super();
		this.id = id;
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}
	public ProductDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

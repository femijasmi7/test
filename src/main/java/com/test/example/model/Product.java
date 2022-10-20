package com.test.example.model;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	private String productID;
	private String name;
	private String hsnCode;
	private Long categoryID;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productID, String name, String hsnCode, Long categoryID) {
		super();
		this.productID = productID;
		this.name = name;
		this.hsnCode = hsnCode;
		this.categoryID = categoryID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", hsnCode=" + hsnCode + ", categoryID="
				+ categoryID + "]";
	}

}

package com.test.example.model;

public class EditProduct {
	private String name;
	private String hsnCode;
	private Long categoryID;

	public EditProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditProduct(String name, String hsnCode, Long categoryID) {
		super();
		this.name = name;
		this.hsnCode = hsnCode;
		this.categoryID = categoryID;
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
		return "EditProduct [name=" + name + ", hsnCode=" + hsnCode + ", categoryID=" + categoryID + "]";
	}

}

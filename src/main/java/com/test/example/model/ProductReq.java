package com.test.example.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductReq {
	@NotBlank(message = "product name is required")
	private String name;
	@NotNull(message = "hsnCode is required")
	private String hsnCode;
	private Long categoryID;

	public ProductReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductReq(@NotBlank(message = "product name is required") String name,
			@NotNull(message = "hsnCode is required") String hsnCode, Long categoryID) {
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
		return "ProductReq [name=" + name + ", hsnCode=" + hsnCode + ", categoryID=" + categoryID + "]";
	}

}

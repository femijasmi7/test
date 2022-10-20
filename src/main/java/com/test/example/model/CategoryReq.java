package com.test.example.model;

import javax.validation.constraints.NotBlank;

public class CategoryReq {

	@NotBlank(message = "Category name is required")
	private String name;

	public CategoryReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryReq(@NotBlank(message = "Category name is required") String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryReq [name=" + name + "]";
	}

}

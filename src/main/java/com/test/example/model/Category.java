package com.test.example.model;

import org.springframework.data.annotation.Id;

public class Category {
	@Id
	private Long categoryID;
	private String name;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long categoryID, String name) {
		super();
		this.categoryID = categoryID;
		this.name = name;
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", name=" + name + "]";
	}

}

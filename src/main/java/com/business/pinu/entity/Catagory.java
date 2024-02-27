package com.business.pinu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catagory_data")
public class Catagory {
	
	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int categoryId;
	
	@Column(name = "category_name")
	String categoryName;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Catagory(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Catagory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Catagory [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}

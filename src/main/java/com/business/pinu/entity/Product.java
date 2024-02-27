package com.business.pinu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_data")
public class Product {
	
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@JoinColumn(name = "category_id")
	@ManyToOne
	private Catagory catagory;
	
//	@Column(name = "total_variant")
//	private String variety;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Catagory getCatagory() {
		return catagory;
	}

	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}

	public Product(int productId, String productName, Catagory catagory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.catagory = catagory;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", catagory=" + catagory + "]";
	}
	
	
	
	

}

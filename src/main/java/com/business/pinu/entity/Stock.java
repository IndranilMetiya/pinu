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
@Table(name = "stock_data")
public class Stock {
	
	@Id
	@Column(name = "stock_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	
	@JoinColumn(name = "property_id")
	@ManyToOne
	private Property property;
	
	@Column(name = "quantity_available")
	private int quantityAvl;
	


	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public int getQuantityAvl() {
		return quantityAvl;
	}

	public void setQuantityAvl(int quantityAvl) {
		this.quantityAvl = quantityAvl;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", property=" + property + ", quantityAvl=" + quantityAvl + "]";
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}

package com.business.pinu.DTO;

public class StockDTO {
	
	private int stockId;
	
	private String categoryName; //wood
	private String productName;  //saaal
	private String propertyName;   //beam
	private int stockQuantityAvl;      // total quantity in stock
	private float sellingPriceProperty;   // from property
	private float heightProperty;
	private String heightUnitProperty;
	private float widthProperty;
	private String widthUnitProperty;
	private float weightProperty;
	private String weightUnitProperty;
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public int getStockQuantityAvl() {
		return stockQuantityAvl;
	}
	public void setStockQuantityAvl(int stockQuantityAvl) {
		this.stockQuantityAvl = stockQuantityAvl;
	}
	public float getSellingPriceProperty() {
		return sellingPriceProperty;
	}
	public void setSellingPriceProperty(float sellingPriceProperty) {
		this.sellingPriceProperty = sellingPriceProperty;
	}
	public float getHeightProperty() {
		return heightProperty;
	}
	public void setHeightProperty(float heightProperty) {
		this.heightProperty = heightProperty;
	}
	public String getHeightUnitProperty() {
		return heightUnitProperty;
	}
	public void setHeightUnitProperty(String heightUnitProperty) {
		this.heightUnitProperty = heightUnitProperty;
	}
	public float getWidthProperty() {
		return widthProperty;
	}
	public void setWidthProperty(float widthProperty) {
		this.widthProperty = widthProperty;
	}
	public String getWidthUnitProperty() {
		return widthUnitProperty;
	}
	public void setWidthUnitProperty(String widthUnitProperty) {
		this.widthUnitProperty = widthUnitProperty;
	}
	public float getWeightProperty() {
		return weightProperty;
	}
	public void setWeightProperty(float weightProperty) {
		this.weightProperty = weightProperty;
	}
	public String getWeightUnitProperty() {
		return weightUnitProperty;
	}
	public void setWeightUnitProperty(String weightUnitProperty) {
		this.weightUnitProperty = weightUnitProperty;
	}
	@Override
	public String toString() {
		return "StockDTO [stockId=" + stockId + ", categoryName=" + categoryName + ", productName=" + productName
				+ ", propertyName=" + propertyName + ", stockQuantityAvl=" + stockQuantityAvl
				+ ", sellingPriceProperty=" + sellingPriceProperty + ", heightProperty=" + heightProperty
				+ ", heightUnitProperty=" + heightUnitProperty + ", widthProperty=" + widthProperty
				+ ", widthUnitProperty=" + widthUnitProperty + ", weightProperty=" + weightProperty
				+ ", weightUnitProperty=" + weightUnitProperty + "]";
	}
	
	
	
	
	
	

}

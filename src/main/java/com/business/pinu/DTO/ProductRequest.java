package com.business.pinu.DTO;

import com.business.pinu.entity.Product;
import com.business.pinu.entity.Property;

public class ProductRequest {
	
	private String catagoryName;
	private String productName;
	private String propertyName;
	private int totalQuantity;
	private int quantityAvl;
	private float pricePerunit;
	private float height;
	private String heightUnit;
	private float width;
	private String widthUnit;
	private float weight;
	private String weightUnit;
	
	
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
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
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getQuantityAvl() {
		return quantityAvl;
	}
	public void setQuantityAvl(int quantityAvl) {
		this.quantityAvl = quantityAvl;
	}
	public float getPricePerunit() {
		return pricePerunit;
	}
	public void setPricePerunit(float pricePerunit) {
		this.pricePerunit = pricePerunit;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getHeightUnit() {
		return heightUnit;
	}
	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public String getWidthUnit() {
		return widthUnit;
	}
	public void setWidthUnit(String widthUnit) {
		this.widthUnit = widthUnit;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	@Override
	public String toString() {
		return "ProductRequest [catagoryName=" + catagoryName + ", productName=" + productName + ", propertyName="
				+ propertyName + ", totalQuantity=" + totalQuantity + ", quantityAvl=" + quantityAvl + ", pricePerunit="
				+ pricePerunit + ", height=" + height + ", heightUnit=" + heightUnit + ", width=" + width
				+ ", widthUnit=" + widthUnit + ", weight=" + weight + ", weightUnit=" + weightUnit + "]";
	}
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductRequest(String catagoryName, String productName, String propertyName, int totalQuantity,
			int quantityAvl, float pricePerunit, float height, String heightUnit, float width, String widthUnit,
			float weight, String weightUnit) {
		super();
		this.catagoryName = catagoryName;
		this.productName = productName;
		this.propertyName = propertyName;
		this.totalQuantity = totalQuantity;
		this.quantityAvl = quantityAvl;
		this.pricePerunit = pricePerunit;
		this.height = height;
		this.heightUnit = heightUnit;
		this.width = width;
		this.widthUnit = widthUnit;
		this.weight = weight;
		this.weightUnit = weightUnit;
	}
	
	   public Property toProperty(Product product) {
	        Property property = new Property();
	        property.setPropertyName(this.propertyName);
	        property.setProduct(product);
	        property.setToltalQuantity(this.totalQuantity);
	        // Set other properties of the property object
	        
	        return property;
	    }
	
	

}

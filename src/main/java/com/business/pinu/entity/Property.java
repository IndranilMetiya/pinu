package com.business.pinu.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "property_data")
public class Property {
	
	@Id
	@Column(name = "property_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	
	@Column(name = "property_name")
	private String propertyName;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	private Product product;
	
	@Column(name = "total_quantity")
	private int toltalQuantity;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "height")
	private float height;
	
	@Column(name = "height_unit")
	private String heightUnit;
	
	@Column(name = "width")
	private float width;
	
	@Column(name = "width_unit")
	private String widthUnit;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "weight_unit")
	private String weightUnit;
	
	
	   @Column(name = "property_creation_date_time")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date propertyCreationDateTime;

	    @Column(name = "property_updation_date_time")
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date propertyUpdationDateTime;

	    @Column(name = "last_added")
	    private int lastAdded;
	
	

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getToltalQuantity() {
		return toltalQuantity;
	}

	public void setToltalQuantity(int toltalQuantity) {
		this.toltalQuantity = toltalQuantity;
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

	





	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getPropertyCreationDateTime() {
		return propertyCreationDateTime;
	}

	public void setPropertyCreationDateTime(Date propertyCreationDateTime) {
		this.propertyCreationDateTime = propertyCreationDateTime;
	}

	public Date getPropertyUpdationDateTime() {
		return propertyUpdationDateTime;
	}

	public void setPropertyUpdationDateTime(Date propertyUpdationDateTime) {
		this.propertyUpdationDateTime = propertyUpdationDateTime;
	}

	public int getLastAdded() {
		return lastAdded;
	}

	public void setLastAdded(int lastAdded) {
		this.lastAdded = lastAdded;
	}



	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyName=" + propertyName + ", product=" + product
				+ ", toltalQuantity=" + toltalQuantity + ", price=" + price + ", height=" + height + ", heightUnit="
				+ heightUnit + ", width=" + width + ", widthUnit=" + widthUnit + ", weight=" + weight + ", weightUnit="
				+ weightUnit + ", propertyCreationDateTime=" + propertyCreationDateTime + ", propertyUpdationDateTime="
				+ propertyUpdationDateTime + ", lastAdded=" + lastAdded + "]";
	}
	
	

}

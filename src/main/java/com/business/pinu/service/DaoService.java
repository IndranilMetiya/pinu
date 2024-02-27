package com.business.pinu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.pinu.DTO.ProductRequest;
import com.business.pinu.entity.Catagory;
import com.business.pinu.entity.Product;
import com.business.pinu.entity.Property;
import com.business.pinu.entity.Stock;
import com.business.pinu.repository.CatagoryRepo;
import com.business.pinu.repository.ProductRepo;
import com.business.pinu.repository.PropertyRepo;
import com.business.pinu.repository.StockRepo;

import jakarta.transaction.Transactional;

@Service
public class DaoService {

	@Autowired
	CatagoryRepo catagoryRepo;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	PropertyRepo propertyRepo;

	@Autowired
	StockRepo stockRepo;

	@Transactional
	public String addcatagory(String catagoryName) {
		Catagory catagory = new Catagory();
		catagory.setCategoryName(catagoryName); // wood / glue / ply
		Catagory category = catagoryRepo.findByCategoryName(catagoryName);
		if (category == null) {
			catagoryRepo.save(catagory);
			System.out.println("Catagory saved with name - " + "' " + catagoryName + " '");
			return "Catagory saved with name - " + "' " + catagoryName + " '";
		} else {
			return "Data Already present with same category";
		}
	}

	@Transactional
	public void addProductWithProperty(ProductRequest productRequest) {
		System.err.println(productRequest.getCatagoryName());
		Catagory category = catagoryRepo.findByCategoryName(productRequest.getCatagoryName());
		if (category == null) {
			System.err.println("Category not found 09");
			throw new RuntimeException("Category not found");
		}

		Product product = new Product();
		product.setCatagory(category); // wood / glue / ply
		product.setProductName(productRequest.getProductName()); // shal / segun/ neem

		// Check if the product with the given name already exists
		Product existingProduct = productRepo.findByProductName(productRequest.getProductName());
		Property property = new Property();
		if (existingProduct == null) {
			// If the product does not exist, save it

			productRepo.save(product);
			System.out.println("New Product saved with name - '" + productRequest.getProductName() + "'");
			// in product 2 we will get the id
			Product product2 = productRepo.findByProductName(productRequest.getProductName());
			System.out.println(product2.getProductId() + "product id");
			property = new Property();
			property.setProduct(product2);
			property.setPropertyCreationDateTime(new Date());
		} else {
			// If the product already exists, print a message
			System.out.println("Data Already present with same category");
			// If product exists, check if property with same details exists
			System.err.println("productRequest.getProductName()" + productRequest.getProductName());
			System.err.println("productRequest.getPropertyName()" + productRequest.getPropertyName());
			System.err.println("productRequest.getPricePerunit()" + productRequest.getPricePerunit());
			System.err.println("productRequest.getHeight()" + productRequest.getHeight());
			System.err.println("productRequest.getWidth()" + productRequest.getWidth());
			System.err.println("productRequest.getWeight()" + productRequest.getWeight());
			System.err.println("productRequest.getHeightUnit()" + productRequest.getHeightUnit());
			System.err.println("productRequest.getWidthUnit()" + productRequest.getWidthUnit());
			System.err.println("productRequest.getWeightUnit()" + productRequest.getWeightUnit());

			property = propertyRepo.findByProductAndPropertyNameAndDetails(productRequest.getProductName(),
					productRequest.getPropertyName(), productRequest.getPricePerunit(), productRequest.getHeight(),
					productRequest.getWidth(), productRequest.getWeight(), productRequest.getHeightUnit(),
					productRequest.getWidthUnit(), productRequest.getWeightUnit());

			if (property == null) {
				// If property does not exist, create a new one
				property = new Property();
				property.setProduct(existingProduct);
				property.setPropertyCreationDateTime(new Date());
			} else {
				// If property exists, update lastAdded and recentAdded
				property.setPropertyUpdationDateTime(new Date());
			}
		}
		// Set other properties
		// property= new Property();
		// product.setProductId(existingProduct.getProductId());

		// chkindra property.setProduct(existingProduct); //shal / segun/ neem (wood) ,
		// fevicol,dendrite (glue)
		property.setToltalQuantity(productRequest.getTotalQuantity()); // 12 piece
		property.setPropertyName(productRequest.getPropertyName()); // beam , round , / marine, normal
		int lastAdded = productRequest.getTotalQuantity();
		property.setLastAdded(lastAdded);

		if (productRequest.getHeight() != 0.0f) {
			property.setHeight(productRequest.getHeight());
			property.setHeightUnit(productRequest.getHeightUnit());
		}

		if (productRequest.getWidth() != 0.0f) {
			property.setWidth(productRequest.getWidth());
			property.setWidthUnit(productRequest.getWidthUnit());
		}

		if (productRequest.getWeight() != 0.0f) {
			property.setWeight(productRequest.getWeight());
			property.setWeightUnit(productRequest.getWeightUnit());
		}
		if (productRequest.getPricePerunit() != 0.0f) {
			property.setPrice(productRequest.getPricePerunit());

		}
		propertyRepo.save(property);
		System.err.println("Total product with propery saved successfully");

		Property productWithProperty = property;

		Stock stock = new Stock();
		stock.setProperty(productWithProperty);
		List<Stock> stocks = stockRepo.findAll();
		boolean flag = false;
		Stock existingStock = findExistingStock(productWithProperty);
		if (existingStock != null) {
			// If existing stock found, update the quantity available
			existingStock.setQuantityAvl(existingStock.getQuantityAvl() + productWithProperty.getToltalQuantity());
			stockRepo.save(existingStock);
			System.out.println("Existing stock found. Quantity updated.");
		} else {
			// If no existing stock found, create a new stock
			Stock newStock = new Stock();
			newStock.setProperty(productWithProperty);
			newStock.setQuantityAvl(productWithProperty.getToltalQuantity());
			stockRepo.save(newStock);
			System.out.println("New stock created.");
		}

	}

	public Stock findExistingStock(Property property) {
		List<Stock> stocks = stockRepo.findAll();
		for (Stock existingStock : stocks) {
			Property existingProperty = existingStock.getProperty();
			System.out.println(existingProperty.toString());
			if (existingProperty != null && propertiesMatch1(existingProperty, property)) {
				return existingStock;
			}
		}
		return null; // If no matching stock found
	}

	private boolean propertiesMatch1(Property property1, Property property2) {
		boolean heightMatch = Float.compare(property1.getHeight(), 0.0f) == 0
				&& Float.compare(property2.getHeight(), 0.0f) == 0
				|| Float.compare(property1.getHeight(), property2.getHeight()) == 0;

		boolean widthMatch = Float.compare(property1.getWidth(), 0.0f) == 0
				&& Float.compare(property2.getWidth(), 0.0f) == 0
				|| Float.compare(property1.getWidth(), property2.getWidth()) == 0;

		boolean weightMatch = Float.compare(property1.getWeight(), 0.0f) == 0
				&& Float.compare(property2.getWeight(), 0.0f) == 0
				|| Float.compare(property1.getWeight(), property2.getWeight()) == 0;

		boolean heightUnitMatch = (property1.getHeightUnit() == null && property2.getHeightUnit() == null)
				|| (property1.getHeightUnit() != null && property1.getHeightUnit().equals(property2.getHeightUnit()));

		boolean widthUnitMatch = (property1.getWidthUnit() == null && property2.getWidthUnit() == null)
				|| (property1.getWidthUnit() != null && property1.getWidthUnit().equals(property2.getWidthUnit()));

		boolean weightUnitMatch = (property1.getWeightUnit() == null && property2.getWeightUnit() == null)
				|| (property1.getWeightUnit() != null && property1.getWeightUnit().equals(property2.getWeightUnit()));

		return property1.getProduct().equals(property2.getProduct())
				&& property1.getPropertyName().equals(property2.getPropertyName())
				&& Float.compare(property1.getPrice(), property2.getPrice()) == 0 && heightMatch && widthMatch
				&& weightMatch && heightUnitMatch && widthUnitMatch && weightUnitMatch;
	}
	
	
	private void getAllCategory() {
		List<Catagory> categories = catagoryRepo.findAll();
	}
	 
	
	
	

}

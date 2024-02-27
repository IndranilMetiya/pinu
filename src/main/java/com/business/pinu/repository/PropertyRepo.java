package com.business.pinu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.business.pinu.entity.Product;
import com.business.pinu.entity.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {

	Property findByProductAndPropertyName(Product existingProduct, String propertyName);
	
//	@Query("SELECT p FROM Property p WHERE "
//            + "p.product = :product AND "
//            + "p.propertyName = :propertyName AND "
//            + "(p.height = :height OR (:height IS NULL AND p.height IS NULL)) AND "
//            + "(p.width = :width OR (:width IS NULL AND p.width IS NULL)) AND "
//            + "(p.weight = :weight OR (:weight IS NULL AND p.weight IS NULL)) AND "
//            + "p.heightUnit = :heightUnit AND "
//            + "p.widthUnit = :widthUnit AND "
//            + "p.weightUnit = :weightUnit AND "
//            + "p.pricePerunit = :pricePerunit")
//    Property findByProductAndPropertyNameAndDetails(
//            Product product,
//            String propertyName,
//            Float height,
//            Float width,
//            Float weight,
//            String heightUnit,
//            String widthUnit,
//            String weightUnit,
//            Float pricePerunit
//    );
	
//	@Query("SELECT p FROM Property p WHERE "
//            + "p.product = :product AND "
//            + "p.propertyName = :propertyName AND "
//            + "(:height IS NULL OR p.height = :height) AND "
//            + "(:width IS NULL OR p.width = :width) AND "
//            + "(:weight IS NULL OR p.weight = :weight) AND "
//            + "p.heightUnit = :heightUnit AND "
//            + "p.widthUnit = :widthUnit AND "
//            + "p.weightUnit = :weightUnit AND "
//            + "p.price = :price")
//	Property findByProductAndPropertyNameAndDetails1(
//	        Product product,
//	        String propertyName,
//	        Float height,
//	        Float width,
//	        Float weight,
//	        String heightUnit,
//	        String widthUnit,
//	        String weightUnit,
//	        Float price
//	);

//	@Query("SELECT p FROM Property p WHERE "
//	        + "p.product = :product AND "
//	        + "p.propertyName = :propertyName AND "
//	        + "(p.height = :height OR (:height IS NULL AND p.height IS NULL)) AND "
//	        + "(p.width = :width OR (:width IS NULL AND p.width IS NULL)) AND "
//	        + "(p.weight = :weight OR (:weight IS NULL AND p.weight IS NULL)) AND "
//	        + "p.heightUnit = :heightUnit AND "
//	        + "p.widthUnit = :widthUnit AND "
//	        + "p.weightUnit = :weightUnit AND "
//	        + "p.price = :price")
//	Property findByProductAndPropertyNameAndDetails(
//	        Product product,
//	        String propertyName,
//	        Float height,
//	        Float width,
//	        Float weight,
//	        String heightUnit,
//	        String widthUnit,
//	        String weightUnit,
//	        Float price
//	);

	@Query("SELECT p FROM Property p WHERE "
	        + "p.product = :product AND "
	        + "p.propertyName = :propertyName AND "
	        + "(:height IS NULL OR p.height = :height) AND "
	        + "(:width IS NULL OR p.width = :width) AND "
	        + "(:weight IS NULL OR p.weight = :weight) AND "
	        + "(:heightUnit IS NULL OR p.heightUnit = :heightUnit) AND "
	        + "(:widthUnit IS NULL OR p.widthUnit = :widthUnit) AND "
	        + "(:weightUnit IS NULL OR p.weightUnit = :weightUnit) AND "
	        + "(:price IS NULL OR p.price = :price)")
	List<Property> findSimilarProperties(
	        @Param("product") Product product,
	        @Param("propertyName") String propertyName,
	        @Param("height") Float height,
	        @Param("width") Float width,
	        @Param("weight") Float weight,
	        @Param("heightUnit") String heightUnit,
	        @Param("widthUnit") String widthUnit,
	        @Param("weightUnit") String weightUnit,
	        @Param("price") Float price
	);
	
//	@Query(value = "SELECT * FROM property_data p " +
//            "WHERE p.product_id = (SELECT product_id FROM product_data WHERE product_name = :productName) " +
//            "AND p.property_name = :propertyName " +
//            "AND (COALESCE(:price, 0) = 0 OR p.price = :price) " +
//            "AND (COALESCE(:height, 0) = 0 OR p.height = :height) " +
//            "AND (COALESCE(:width, 0) = 0 OR p.width = :width) " +
//            "AND (COALESCE(:weight, 0) = 0 OR p.weight = :weight) " +
//            "AND (COALESCE(:heightUnit, '') = '' OR p.height_unit = :heightUnit) " +
//            "AND (COALESCE(:widthUnit, '') = '' OR p.width_unit = :widthUnit) " +
//            "AND (COALESCE(:weightUnit, '') = '' OR p.weight_unit = :weightUnit)", nativeQuery = true)
//List<Property> findByProductAndPropertyNameAndDetails(
//     @Param("productName") String productName,
//     @Param("propertyName") String propertyName,
//     @Param("price") Float price,
//     @Param("height") Float height,
//     @Param("width") Float width,
//     @Param("weight") Float weight,
//     @Param("heightUnit") String heightUnit,
//     @Param("widthUnit") String widthUnit,
//     @Param("weightUnit") String weightUnit);
//}
	
	@Query(value = "SELECT * FROM property_data p " +
            "WHERE p.product_id = (SELECT product_id FROM product_data WHERE product_name = :productName) " +
            "AND p.property_name = :propertyName " +
            "AND (:price IS NULL OR p.price = :price) " +
            "AND (:height IS NULL OR p.height = :height) " +
            "AND (:width IS NULL OR p.width = :width) " +
            "AND (:weight IS NULL OR p.weight = :weight) " +
            "AND (:heightUnit IS NULL OR p.height_unit = :heightUnit) " +
            "AND (:widthUnit IS NULL OR p.width_unit = :widthUnit) " +
            "AND (:weightUnit IS NULL OR p.weight_unit = :weightUnit)", nativeQuery = true)
Property findByProductAndPropertyNameAndDetails(
     @Param("productName") String productName,
     @Param("propertyName") String propertyName,
     @Param("price") Float price,
     @Param("height") Float height,
     @Param("width") Float width,
     @Param("weight") Float weight,
     @Param("heightUnit") String heightUnit,
     @Param("widthUnit") String widthUnit,
     @Param("weightUnit") String weightUnit);}



	/*
	  USE pinu_business;
SELECT * FROM pinu_business.property_data WHERE product_id = (
    SELECT product_id FROM product_data WHERE product_name = 'Fevicol'
) AND property_name = 'Marine' AND total_quantity = 2 AND price_per_unit = 1078 AND 
weight = 500 AND weight_unit = 'gmg';

*
SELECT * FROM property_data p 
WHERE p.product_id = (SELECT product_id FROM product_data WHERE product_name = 'Fevicol') 
AND p.property_name = 'Marine' 
AND (1078 IS NULL OR p.price = 1078) 
AND (NULL IS NULL OR p.height = NULL) 
AND (NULL IS NULL OR p.width = NULL) 
AND (500 IS NULL OR p.weight = 500) 
AND ('gmg' IS NULL OR p.weight_unit = 'gmg') 
AND (NULL IS NULL OR p.height_unit = NULL) 
AND (NULL IS NULL OR p.width_unit = NULL);
*/



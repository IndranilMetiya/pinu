package com.business.pinu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.pinu.entity.Property;
import com.business.pinu.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {

	Stock findByProperty(Property productWithProperty);

}

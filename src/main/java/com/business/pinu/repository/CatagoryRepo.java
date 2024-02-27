package com.business.pinu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.pinu.entity.Catagory;

@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Integer> {

	Catagory findByCategoryName(String catagoryName);

}

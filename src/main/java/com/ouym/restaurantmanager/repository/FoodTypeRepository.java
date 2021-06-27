package com.ouym.restaurantmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer>{

	FoodType findByTypeName(String typeName);

}

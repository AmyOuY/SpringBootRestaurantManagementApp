package com.ouym.restaurantmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{

	Food findByFoodName(String foodName);

	List<Food> findByTypeId(int typeId);

}

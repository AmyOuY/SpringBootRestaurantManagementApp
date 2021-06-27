package com.ouym.restaurantmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.DisplayFood;
import com.ouym.restaurantmanager.model.Food;
import com.ouym.restaurantmanager.model.FoodType;
import com.ouym.restaurantmanager.repository.FoodRepository;
import com.ouym.restaurantmanager.repository.FoodTypeRepository;

@Service
public class FoodService {

	
	@Autowired
	private FoodTypeRepository foodTypeRepo;
	
	@Autowired
	private FoodRepository foodRepo;
	
	
	
	public FoodType addFoodType(FoodType foodType) {
		
		return foodTypeRepo.save(foodType);
	}
	
	
	public List<FoodType> getFoodTypes(){
			
		List<FoodType> output = foodTypeRepo.findAll();
		
		output.sort((a, b) -> a.getTypeName().compareTo(b.getTypeName()));
		
		return output;
	}
	
	
	public String deleteFoodType(int id) {
		
		foodTypeRepo.deleteById(id);
		
		return "Successfully deleted food type: " + id;
	}
	
	
	public FoodType getFoodTypeById(int id) {
		
		return foodTypeRepo.findById(id).orElse(null);
	}
	
	
	public FoodType getFoodTypeByTypeName(String typeName) {
	
		return foodTypeRepo.findByTypeName(typeName);
	}
	
	
	
	public Food addFood(DisplayFood displayFood) {
		
		FoodType foodType = foodTypeRepo.findByTypeName(displayFood.getTypeName());		
		
		if (foodType == null) return null;
				
		Food food = new Food();	
		food.setTypeId(foodType.getId());
		food.setFoodName(displayFood.getFoodName());
		food.setPrice(displayFood.getPrice());
		
		return foodRepo.save(food);
	}
	
	
	public List<Food> getFoods(){
		
		return foodRepo.findAll();
	}
		
	
	public List<DisplayFood> getDisplayFoods(){
		
		List<DisplayFood> output = new ArrayList<>();
		
		List<Food> foods = foodRepo.findAll();
		
		for (Food food : foods) {
			
			DisplayFood displayFood = new DisplayFood();
			
			FoodType foodType = getFoodTypeById(food.getTypeId());
			displayFood.setId(food.getId());
			displayFood.setTypeName(foodType.getTypeName());
			displayFood.setFoodName(food.getFoodName());
			displayFood.setPrice(food.getPrice());
			
			output.add(displayFood);			
		}
		
		output.sort((a, b) -> a.getTypeName().compareTo(b.getTypeName()));
		
		return output;
	}
	
	
	
	public DisplayFood getDisplayFood(int id){
		
		DisplayFood displayFood = new DisplayFood();
		
		Food food = foodRepo.getById(id);
		
		FoodType foodType = getFoodTypeById(food.getTypeId());
		displayFood.setId(food.getId());
		displayFood.setTypeName(foodType.getTypeName());
		displayFood.setFoodName(food.getFoodName());
		displayFood.setPrice(food.getPrice());
			
		return displayFood;
	}
	
	
	public Food getFoodById(int id) {
		
		return foodRepo.findById(id).orElse(null);
	}
	
	
	public List<Food> getFoodByTypeId(int typeId){
		
		return foodRepo.findByTypeId(typeId);
	}
	
	
	public Food getFoodByFoodName(String foodName) {	
		
		return foodRepo.findByFoodName(foodName);
	}
	
	
	
	public Food updateFood(DisplayFood displayFood) {
		
		Food food = new Food();		
		FoodType foodType =  getFoodTypeByTypeName(displayFood.getTypeName());
		
		food.setId(displayFood.getId());
		food.setTypeId(foodType.getId());
		food.setFoodName(displayFood.getFoodName());
		food.setPrice(displayFood.getPrice());
		
		return foodRepo.save(food);
	}
	
	
	public String deleteFood(int id) {
		
		foodRepo.deleteById(id);
		
		return "Successfully deleted food: " + id;
	}
	
	
}

package com.ouym.restaurantmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.DisplayFood;
import com.ouym.restaurantmanager.model.FoodType;
import com.ouym.restaurantmanager.service.FoodService;


@Controller
public class FoodController {

	@Autowired
	private FoodService service;
		
	
	
	@GetMapping("/newFoodType")
	public String newFoodType() {
		
		return "food/addFoodType";
	}
	
	
	
	@RequestMapping("/addFoodType")
	public String addFoodType(FoodType foodType) {
		
		service.addFoodType(foodType);
		
		return "redirect:/foodTypes";
	}
	
	
	@GetMapping("/foodTypes")
	public ModelAndView getFoodTypes() {
		
		ModelAndView mv = new ModelAndView("food/foodTypes");
		
		List<FoodType> foodTypes = service.getFoodTypes();
		
		mv.addObject("foodTypes", foodTypes);
		
		return mv;
	}
	
	
	@RequestMapping("/deleteFoodType/{id}")
	public String deleteFoodType(@PathVariable int id) {
		
		service.deleteFoodType(id);
		
		return "redirect:/foodTypes";
	}
	
	
	
	@GetMapping("/foodTypeById/{id}")
	public FoodType getFoodTypeById(@PathVariable int id) {
		
		return service.getFoodTypeById(id);
	}
	
	
	@GetMapping("/foodTypeByTypeName/{typeName}")
	public FoodType getFoodTypeByTypeName(@PathVariable String typeName) {
		
		return service.getFoodTypeByTypeName(typeName);
	}

	
	
	@GetMapping("/newFood")
	public String newFood() {
		
		return "food/addFood";
	}
	
	
	@RequestMapping("/addFood")
	public String addFood(DisplayFood food) {
		
		service.addFood(food);
		
		return "redirect:/foods";
	}
	
	
	@GetMapping("/foods")
	public ModelAndView getFoods() {
		
		ModelAndView mv = new ModelAndView("food/foods");
		
		List<DisplayFood> foods = service.getDisplayFoods();
		
		mv.addObject("foods", foods);
		
		return mv;
	}
	
	
	
	@GetMapping("/editFood:id={id}")
	public ModelAndView editFood(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("food/editFood");
		
		DisplayFood food = service.getDisplayFood(id);
		
		mv.addObject("food", food);
		
		return mv;
	}
	
	
	@RequestMapping("/updateFood")
	public String updateFood(DisplayFood displayFood) {
		
		service.updateFood(displayFood);
		
		return "redirect:/foods";
	}
	
	
	
	@RequestMapping("/deleteFood/{id}")
	public String deleteFood(@PathVariable int id) {
		
		service.deleteFood(id);
		
		return "redirect:/foods";
	}
	
}

package com.ouym.restaurantmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ouym.restaurantmanager.model.DiningTable;
import com.ouym.restaurantmanager.service.DiningTableService;


@Controller
public class DiningTableController {
	
	@Autowired
	private DiningTableService service;
	
	
	
	@GetMapping("/newDiningTable")
	public String newDiningTable() {
		
		return "diningTable/addDiningTable";
	}
	
		
	@RequestMapping("/addDiningTable")
	public String addDiningTable(DiningTable diningTable) {
		
		service.addDiningTable(diningTable);
		
		return "redirect:/diningTables";
	}
	
	
	@GetMapping("/diningTables")
	public ModelAndView getDiningTables(){
		
		ModelAndView mv = new ModelAndView("diningTable/diningTables");
				
		List<DiningTable> diningTables = service.getDiningTables();
		
		mv.addObject("diningTables", diningTables);
		
		return mv;
	}
	
	
	@GetMapping("/editDiningTable:id={id}")
	public ModelAndView editDiningTable(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("diningTable/editDiningTable");
		
		DiningTable diningTable = service.getDiningTableById(id);
		
		mv.addObject("diningTable", diningTable);
		
		return mv;
		
	}
		
	
	@RequestMapping("/updateDiningTable")
	public String updateDiningTable(DiningTable diningTable) {
		
		service.updateDiningTable(diningTable);
		
		return "redirect:/diningTables";
	}	
	
	
	@RequestMapping("/deleteDiningTable/{id}")
	public String deleteDiningTable(@PathVariable int id) {
		
		service.deleteDiningTable(id);
		
		return "redirect:/diningTables";
	}
}

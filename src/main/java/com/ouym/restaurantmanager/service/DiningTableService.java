package com.ouym.restaurantmanager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.DiningTable;
import com.ouym.restaurantmanager.repository.DiningTableRepository;

@Service
public class DiningTableService {

	@Autowired
	private DiningTableRepository repo;
	
	
	public DiningTable addDiningTable(DiningTable diningTable) {
		
		return repo.save(diningTable);
	}
	
	
	public List<DiningTable> getDiningTables(){
		
		List<DiningTable> output = new ArrayList<>();
		
		output = repo.findAll();
		
		output.sort((a, b) -> a.getTableNumber() - b.getTableNumber());
		
		return output;
	}
	
	
	public DiningTable getDiningTableById(int id) {
		
		return repo.findById(id).orElse(null);
	}
	
	
	public DiningTable getDiningTableByTableNumber(int tableNumber) {
		
		return repo.findByTableNumber(tableNumber);
	}
	
	
	public DiningTable updateDiningTable(DiningTable diningTable) {
		
		return repo.save(diningTable);
	}
	
	
	public String deleteDiningTable(int id) {
		
		repo.deleteById(id);
		
		return "Successfully delete dining table: " + id;
	}
	
	
	public boolean validDiningTable(int tableNumber) {
		
		List<DiningTable> diningTables = repo.findAll();
		
		for (DiningTable table : diningTables) {
			if (table.getTableNumber() == tableNumber) return true;
		}
		
		return false;
	}
}

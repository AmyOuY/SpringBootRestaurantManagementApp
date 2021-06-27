package com.ouym.restaurantmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouym.restaurantmanager.model.Employee;
import com.ouym.restaurantmanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	
	public Employee addEmployee(Employee employee) {
		
		return repo.save(employee);
	}
	
	
	public List<Employee> getEmployees(){
				
		List<Employee> output = repo.findAll();
		
		output.sort((a, b) -> a.getFirstName().compareTo(b.getFirstName()));
		
		return output;
		
	}
	
	
	public Employee getEmployeeById(int id) {
		
		return repo.findById(id).orElse(null);
	}
	
	
	public Employee getEmployeeByName(String firstName, String lastName) {
		
		return repo.findByFirstNameAndLastName(firstName, lastName);
	}
	
	
	
	public Employee updateEmployee(Employee employee) {
		
		return repo.save(employee);
	}
	
	
	public String deleteEmployee(int id) {
		
		repo.deleteById(id);
		
		return "Successfully delete employee: " + id;
	}
}

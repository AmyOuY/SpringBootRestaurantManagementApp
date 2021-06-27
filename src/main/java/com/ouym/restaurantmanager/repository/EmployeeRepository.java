package com.ouym.restaurantmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findByFirstNameAndLastName(String firstName, String lastName);

}

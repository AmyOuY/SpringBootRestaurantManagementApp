package com.ouym.restaurantmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.DiningTable;

public interface DiningTableRepository extends JpaRepository<DiningTable, Integer>{

	DiningTable findByTableNumber(int tableNumber);

}

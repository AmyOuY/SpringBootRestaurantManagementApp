package com.ouym.restaurantmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findByBillPaid(boolean billPaid);

	Order findByDiningTableIdAndBillPaid(int diningTableId, boolean b);


}

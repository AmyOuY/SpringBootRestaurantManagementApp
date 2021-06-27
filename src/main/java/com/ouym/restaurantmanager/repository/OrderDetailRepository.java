package com.ouym.restaurantmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer>{

	List<OrderDetail> findAllByDiningTableId(int diningTableId);

	List<OrderDetail> findByDiningTableIdAndOrderId(int diningTableId, int i);

	

}

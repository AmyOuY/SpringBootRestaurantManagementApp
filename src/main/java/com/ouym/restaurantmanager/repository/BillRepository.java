package com.ouym.restaurantmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ouym.restaurantmanager.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	List<Bill> findAllByBillPaid(boolean b);

}

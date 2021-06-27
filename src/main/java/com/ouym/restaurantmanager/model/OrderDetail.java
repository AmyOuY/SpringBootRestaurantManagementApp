package com.ouym.restaurantmanager.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue
	private int id;
	private int diningTableId;
	private int attendantId;
	private int foodId;
	private int quantity;
	private int orderId;
	
	@Column(name = "created_date")	
	private LocalDateTime createdDate = LocalDateTime.now();	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiningTableId() {
		return diningTableId;
	}

	public void setDiningTableId(int diningTableId) {
		this.diningTableId = diningTableId;
	}

	public int getAttendantId() {
		return attendantId;
	}

	public void setAttendantId(int attendantId) {
		this.attendantId = attendantId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	
}

package com.ouym.restaurantmanager.model;

import java.time.LocalDateTime;


public class DisplayOrderDetail {

	private int id;
	private int diningTableNumber;
	private String attendant;
	private String foodName;
	private double price;
	private int quantity;	
	private LocalDateTime createdDate;
	private int orderId;
	
	public DisplayOrderDetail(int id, int diningTableNumber, String attendant, String foodName, double price,
			int quantity, LocalDateTime createdDate, int orderId) {
		super();
		this.id = id;
		this.diningTableNumber = diningTableNumber;
		this.attendant = attendant;
		this.foodName = foodName;
		this.price = price;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiningTableNumber() {
		return diningTableNumber;
	}

	public void setDiningTableNumber(int diningTableNumber) {
		this.diningTableNumber = diningTableNumber;
	}

	public String getAttendant() {
		return attendant;
	}

	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}

package com.ouym.restaurantmanager.model;


public class FillInOrderDetail {

	private int diningTableId;
	private String attendant;
	private int foodTypeId;
	private int foodId;
	private double price;
	private int quantity;
		
	
	public FillInOrderDetail(int diningTableId, String attendant, int foodTypeId, int foodId, double price,
			int quantity) {
		super();
		this.diningTableId = diningTableId;
		this.attendant = attendant;
		this.foodTypeId = foodTypeId;
		this.foodId = foodId;
		this.price = price;
		this.quantity = quantity;
	}

	public int getDiningTableId() {
		return diningTableId;
	}
	
	public void setDiningTableId(int diningTableId) {
		this.diningTableId = diningTableId;
	}
	
	public String getAttendant() {
		return attendant;
	}
	
	public void setAttendant(String attendant) {
		this.attendant = attendant;
	}
	
	public int getFoodTypeId() {
		return foodTypeId;
	}
	
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	
	public int getFoodId() {
		return foodId;
	}
	
	public void setFoodId(int foodId) {
		this.foodId = foodId;
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
	
	
	
	
}

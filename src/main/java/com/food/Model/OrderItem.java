package com.food.Model;

public class OrderItem {
private int orderItemId;
private int orderId;
private int menuId;
private int quantity;
private double itemTotal;
private int newOrderItemId;

public OrderItem( ) {
	
}

public OrderItem(int orderItemId, int quantity, double itemTotal) {
	this.orderItemId=orderItemId;
	this.quantity=quantity;
	this.itemTotal=itemTotal;
	
}

public OrderItem(int newOrderItemId,  int quantity, double itemTotal, int orderItemId) {
	
	this.newOrderItemId=newOrderItemId;
	this.quantity = quantity;
	this.itemTotal = itemTotal;
	this.orderItemId = orderItemId;
	
	
}

public OrderItem(int orderItemId,  int orderId, int menuId, int quantity, double itemTotal) {
	
	this.orderItemId = orderItemId;
	this.orderId = orderId;
	this.menuId = menuId;
	this.quantity = quantity;
	this.itemTotal = itemTotal;
}




public int getOrderItemId() {
	return orderItemId;
}


public void setOrderItemId(int orderItemId) {
	this.orderItemId = orderItemId;
}


public int getOrderId() {
	return orderId;
}


public void setOrderId(int orderId ){
	this.orderId = orderId;
}


public int getMenuId() {
	return menuId;
}


public void setMenuId(int menuId) {
	this.menuId = menuId;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public double getItemTotal() {
	return itemTotal;
}


public void setItemTotal(double itemTotal) {
	this.itemTotal = itemTotal;
}

public void setNewOrderItemId(int newOrderItemId) {
	this.newOrderItemId=newOrderItemId;
}

public int getNewOrderItemId() {
	return newOrderItemId;
}

@Override
	public String toString() {
	return orderItemId+" "+orderId+" "+menuId+" "+quantity+" "+itemTotal;
	}

		

}

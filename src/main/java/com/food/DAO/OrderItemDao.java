package com.food.DAO;

import java.util.List;

import com.food.Model.OrderItem;



public interface OrderItemDao {
	void addOrderItem(OrderItem orderItem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItem(int orderItemId);
	List <OrderItem> getOrderItemsByOrder(int orderId);
}

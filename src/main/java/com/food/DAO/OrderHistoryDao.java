package com.food.DAO;

import java.util.List;

import com.food.Model.OrderHistory;

public interface OrderHistoryDao {
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List <OrderHistory> getOrderHistoriesByUser(int userId);
	
}

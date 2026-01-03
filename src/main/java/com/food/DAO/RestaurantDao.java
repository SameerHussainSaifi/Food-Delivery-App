package com.food.DAO;

import java.util.List;

import com.food.Model.Restaurant;


public interface RestaurantDao {
	void addRestaurant(Restaurant user);
	Restaurant getRestaurant(int RestaurantId);
	void updateRestaurant(Restaurant user);
	void deleteRestaurant(int RestaurantId);
	List <Restaurant> getAllRestaurant();
}

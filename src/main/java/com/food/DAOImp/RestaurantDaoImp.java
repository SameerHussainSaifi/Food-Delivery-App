package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDao;
import com.food.Model.Restaurant;

public class RestaurantDaoImp implements RestaurantDao{
	public static String url="jdbc:mysql://localhost:3306/online_food_delivery";
	public static String userName="root";
	public static String password="root";
	public Connection connection=null;
	public PreparedStatement stmt=null;
	public RestaurantDaoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		String query="insert into `restaurant` ( Name, cuisineType, DeliveryTime, Address, Rating, IsActive) values (?,?,?,?,?,?)";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2,restaurant.getCuisineType());
			stmt.setInt(3,restaurant.getDeliveryTime());
			stmt.setString(4,restaurant.getAddress());
			stmt.setDouble(5, restaurant.getRating());
			stmt.setBoolean(6,restaurant.getActive());
			int val=stmt.executeUpdate();
			System.out.println(val);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		String sql="select * from restaurant where RestaurantID=?";
		Restaurant restaurant=null;
       try {
		stmt=connection.prepareStatement(sql);
		stmt.setInt(1,restaurantId);
		ResultSet res=stmt.executeQuery();
		
		if(res.next()) {
			restaurant=(Restaurant) extractRestaurantFromResultSet(res);
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
       return restaurant;
	}

	private Object extractRestaurantFromResultSet(ResultSet res) throws SQLException {
		Restaurant restaurant=new Restaurant();
		restaurant.setName(res.getString("Name"));
		restaurant.setCuisineType(res.getString("cuisineType"));
		restaurant.setDeliveryTime(res.getInt("DeliveryTime"));
		restaurant.setAddress(res.getString("Address"));
		restaurant.setAdminUserId(res.getInt("AdminUserID"));
		restaurant.setRating(res.getDouble("Rating"));
		restaurant.setActive(res.getBoolean("IsActive"));
		restaurant.setImagePath(res.getString("ImagePath"));
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant user) {
		String sql="update restaurant set RestaurantID=?, Name=?, cuisineType=?, DeliveryTime=?, Address=?, Rating=?, IsActive=?  where RestaurantID=?"; 		
	    try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, user.getRestaurantId());
			stmt.setString(2, user.getName());
			stmt.setString(3, user.getCuisineType());
			stmt.setInt(4, user.getDeliveryTime());
			stmt.setString(5,user.getAddress());
			//stmt.setInt(6,user.getAdminUserId());
			stmt.setDouble(6,user.getRating());
			stmt.setBoolean(7, user.getActive());
			stmt.setInt(8, user.getRestaurantId());
			int val=stmt.executeUpdate();
			System.out.println(val);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int RestaurantId) {
		String sql="delete from restaurant where RestaurantId=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, RestaurantId);
			int val=stmt.executeUpdate();
			System.out.println(val);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		String sql="select * from restaurant";
		ArrayList <Restaurant> restaurants=new ArrayList <Restaurant>();
		Restaurant restaurant=null;
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery(sql);
			while(res.next()) {
				restaurant=(Restaurant) extractRestaurantFromResultSet(res);
				restaurants.add(restaurant);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return restaurants;
	}

}

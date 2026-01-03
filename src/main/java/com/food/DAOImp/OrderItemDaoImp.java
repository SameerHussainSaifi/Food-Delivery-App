package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.food.DAO.OrderItemDao;
import com.food.Model.OrderItem;

public class OrderItemDaoImp implements OrderItemDao{
public static String url="jdbc:mysql://localhost:3306/online_food_delivery";
public static String username="root";
public static String password="root";
Connection connection=null;
PreparedStatement stmt=null;
public OrderItemDaoImp() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
}
	@Override
	public void addOrderItem(OrderItem orderItem) {
		String query="insert into orderitem ( OrderItemId,  Quantity, ItemTotal) values (?,?,?)";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, orderItem.getOrderItemId());
			stmt.setInt(2,orderItem.getQuantity());
			stmt.setDouble(3, orderItem.getItemTotal());
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		String sql="select * from orderitem where OrderItemId=?";
		OrderItem orderItem=null;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, orderItemId);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				orderItem=   (OrderItem) extractOrderItemFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  orderItem;
	}

	private Object extractOrderItemFromResultSet(ResultSet res) throws SQLException {
		OrderItem orderItem=new OrderItem();
		orderItem.setOrderItemId(res.getInt("orderItemId"));
		orderItem.setOrderId(res.getInt("orderId"));
		orderItem.setMenuId(res.getInt("menuid"));
		orderItem.setQuantity(res.getInt("quantity"));
		orderItem.setItemTotal(res.getDouble("itemTotal"));
		
		return orderItem;
	}
	@Override
	public void updateOrderItem(OrderItem orderItem) {
	String sql="update orderitem  set OrderItemId=?, Quantity=?, ItemTotal=? where OrderItemId=?";
	try {
		stmt=connection.prepareStatement(sql);
		stmt.setInt(1, orderItem.getNewOrderItemId());
		stmt.setInt(2, orderItem.getQuantity());
		stmt.setDouble(3, orderItem.getItemTotal());
		stmt.setInt(4, orderItem.getOrderItemId());
		int n=stmt.executeUpdate();
		System.out.println(n);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		String sql="delete from orderitem where OrderItemId=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, orderItemId);
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getOrderItemsByOrder(int orderId) {
		String sql="select * from orderitem";
		OrderItem orderItem=null;
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery(sql);
			if(res.next()) {
				orderItem=(OrderItem) extractOrderItemFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  (List<OrderItem>) orderItem;
	}
	
	
	
	

}

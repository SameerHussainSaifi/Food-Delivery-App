package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderDao;
import com.food.Model.Order;

public class OrderDaoImp implements OrderDao{
	
	public String url="jdbc:mysql://localhost:3306/online_food_delivery";
	public String username="root";
	public String password="root";
	public Connection connection=null;
	public PreparedStatement stmt=null;
	public OrderDaoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void addOrder(Order order) {
		String query="insert into ordertable (OrderId,   TotalAmount, Status, PaymentMethod) values (?,?,?,?)";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, order.getOrderId());
			
			stmt.setDouble(2, order.getTotalAmount());
			stmt.setString(3, order.getStatus());
			stmt.setString(4, order.getPaymentMethod());
			int n=stmt.executeUpdate();
			System.out.println(n);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Order getOrder(int orderId) {
		String sql="select * from ordertable where orderId=?";
		Order order=null;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, orderId);
			ResultSet res=stmt.executeQuery();
			
			if(res.next()) {
				order = (Order)extractOrderFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return order;
	}

	private Object extractOrderFromResultSet(ResultSet res) throws Exception{
		Order order=new Order();
		order.setOrderId(  res.getInt("OrderId"));
		order.setUserId( res.getInt("UserId"));
		order.setRestaurantId(res.getInt("RestaurantId"));
		order.setOrderDate(res.getDate("OrderDate"));
		order.setTotalAmount(res.getDouble("TotalAmount"));
		order.setStatus(res.getString("Status"));
		order.setPaymentMethod(res.getString("PaymentMethod"));
		return order;
		
	}

	@Override
	public void updateOrder(Order order) {
		String sql="update ordertable set OrderId=?,  TotalAmount=?, Status=?, PaymentMethod=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, order.getOrderId());
			stmt.setDouble(2, order.getTotalAmount());
			stmt.setString(3, order.getStatus());
			stmt.setString(4, order.getPaymentMethod());
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		String sql="delete from ordertable where orderId=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, orderId);
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		Order order;
		ArrayList<Order> orders=new ArrayList<Order>();
		String sql="select * from ordertable";
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery(sql);
			while(res.next()) {
				order=(Order) extractOrderFromResultSet(res);
				orders.add(order);
			}
		} catch (SQLException e) {


			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orders;
	}

}

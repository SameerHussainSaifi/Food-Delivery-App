package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.OrderHistoryDao;
import com.food.Model.OrderHistory;

public class OrderHistoryDaoImp implements OrderHistoryDao{
public String url="jdbc:mysql://localhost:3306/online_food_delivery";
public String username="root";
public String password="root";
Connection connection=null;
PreparedStatement stmt=null;
	public OrderHistoryDaoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		String query="insert into orderhistory (OrderHistoryID, TotalAmount, Status) values (?,?,?)";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1,  orderHistory.getOrderHistoryId());
			stmt.setDouble(2, orderHistory.getTotalAmount());
			stmt.setString(3, orderHistory.getStatus());
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		String query="select * from orderhistory where orderHistoryId=?";
		OrderHistory orderHistory=null;
		try {
			
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, orderHistoryId);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				orderHistory=(OrderHistory) extractOrderHistoryFromResultSet(res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  orderHistory;
	}

	private OrderHistory extractOrderHistoryFromResultSet(ResultSet res) throws SQLException {
		OrderHistory oh=new OrderHistory();
		oh.setOrderHistoryId(res.getInt("orderHistoryId"));
		oh.setUserId(res.getInt("userId"));
		oh.setOrderHistoryId(res.getInt("orderId"));
		oh.setOrderDate(res.getDate("orderDate"));
		oh.setTotalAmount(res.getDouble("totalAmount"));
		oh.setStatus(res.getString("status"));
		return oh;
	}
	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		String query="update orderhistory set OrderHistoryID=?, TotalAmount=?, Status=? where OrderHistoryID=?";
        try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, orderHistory.getOrderHistoryId());
			stmt.setDouble(2, orderHistory.getTotalAmount());
			stmt.setString(3,orderHistory.getStatus());
			stmt.setInt(4, orderHistory.getNewOrderHistoryId());
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		String query="delete from orderhistory where OrderHistoryID=?";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, orderHistoryId);
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List <OrderHistory>  getOrderHistoriesByUser(int userId) {
		OrderHistory orderHistory = null;
		List <OrderHistory>list=new ArrayList <OrderHistory>();
		String query="select * from orderhistory";
		try {
			Statement stmt=connection.createStatement();
			ResultSet res=stmt.executeQuery(query);
			if(res.next()) {
				orderHistory=extractOrderHistoryFromResultSet(res);
				list.add(orderHistory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return   (List<OrderHistory>) orderHistory;
	}

}

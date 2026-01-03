package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.food.DAO.UserDao;
import com.food.Model.User;

public class UserDaoImp implements UserDao{
Connection connection=null;

	String url="jdbc:mysql://localhost:3306/online_food_delivery";
	String user="root";
	String password="root";
	PreparedStatement stmt=null;;
	public UserDaoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		String query="insert into `user` ( `UserName`, `Password`, `EmailID`, `Address`, `Role`, `Phone`) values (?,?,?,?,?,?)";
		try {
			 stmt=connection.prepareStatement(query);
			//stmt.setInt(1, user.getUserId());
			 stmt.setString(1,user.getUserName());
			 stmt.setString(2, user.getPassword());
			 stmt.setString(3, user.getEmail());
			 stmt.setString(4, user.getAddress());
			 stmt.setString(5, user.getRole());
			 stmt.setLong(6, user.getPhone());
			 stmt.executeUpdate();
			//System.out.println(value);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId) {
		User user=null;
		String sql="select * from `user` where `userId`=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, userId);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				user=extractUserFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	private User extractUserFromResultSet(ResultSet res) throws SQLException {
		User user=new User();
		user.setUserId(res.getInt("UserID"));
		user.setUserName(res.getString("UserName"));
		user.setPassword(res.getString("Password"));
		user.setEmail(res.getString("EmailID"));
		user.setAddress(res.getString("Address"));
		user.setRole(res.getString("Role"));
		user.setPhone(res.getLong("Phone"));
		return user;
	}

	@Override
	public void updateUser(User user) {
		String sql="update `user` set UserID=?, UserName=?, Password=?, EmailID=?, Address=?, Role=?, Phone=? where UserID=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1,user.getUserId());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getRole());
			stmt.setLong(7, user.getPhone());
			stmt.setInt(8, user.getUserId());
			int value=stmt.executeUpdate();
			System.out.println(value);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		String sql="delete from user where UserID=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1,user.getUserId());
			int val=stmt.executeUpdate();
			System.out.println(val);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
    
	
}

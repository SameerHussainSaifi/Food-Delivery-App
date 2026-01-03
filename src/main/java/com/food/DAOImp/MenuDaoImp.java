package com.food.DAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.food.DAO.MenuDao;
import com.food.Model.Menu;

public class MenuDaoImp implements MenuDao{
String username="root";
String password="root";
String url="jdbc:mysql://localhost:3306/online_food_delivery";
public PreparedStatement stmt=null;
public Connection connection =null;
public MenuDaoImp() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	@Override
	public void addMenu(Menu menu) {
		String query="insert into menu (MenuId,  ItemName, Description, Price, IsAvailable ) values (?,?,?,?,?)";
		try {
			stmt=connection.prepareStatement(query);
			stmt.setInt(1, menu.getMenuId());
			stmt.setString(2,menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setDouble(4, menu.getPrice());
			stmt.setBoolean(5, menu.isAvailable());
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Menu getMenu(int menuId) {
		Menu menu=null;
		String sql="select * from menu where menuId=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, menuId);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				menu=extractMenuFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return menu;
	}

	private Menu extractMenuFromResultSet(ResultSet res) throws SQLException {
	Menu menu=new Menu();
	menu.setMenuId(res.getInt("menuId"));
	menu.setRestaurantId(res.getInt("restaurantId"));
	menu.setItemName(res.getString("itemName"));
	menu.setDescription(res.getString("description"));
	menu.setPrice(res.getDouble("price"));
	menu.setAvailable(res.getBoolean("isAvailable"));
	
	
		return menu;
	}
	@Override
	public void updateMenu(Menu menu) {
	String sql="update menu set MenuId=?, ItemName=?, Description=?, Price=?, IsAvailable=? where MenuId=?";
	
	try {
		stmt=connection.prepareStatement(sql);
		stmt.setInt(1, menu.getMenuId());
		stmt.setString(2, menu.getItemName());
		stmt.setString(3,menu.getDescription());
		stmt.setDouble(4,menu.getPrice());
		stmt.setBoolean(5,menu.isAvailable());
		stmt.setInt(6, menu.getNewMenuId());
		int n=stmt.executeUpdate();
		System.out.println(n);
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		
	}

	@Override
	public void deleteMenu(int MenuId) {
		String sql="delete from menu where menuId=?";
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, MenuId);
			int n=stmt.executeUpdate();
			System.out.println(n);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Menu> getAllMenuByRestaurant(int restaurantId) {
		String sql="select * from menu where restaurantId=?";
		Menu menu=null;
		try {
			stmt=connection.prepareStatement(sql);
			stmt.setInt(1, restaurantId);
			ResultSet res=stmt.executeQuery();
			if(res.next()) {
				menu=extractMenuFromResultSet(res);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  (List<Menu>) menu;
	}

}

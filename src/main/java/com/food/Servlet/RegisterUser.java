package com.food.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDao;
import com.food.DAOImp.UserDaoImp;

@WebServlet("/registeruser")
public class RegisterUser extends HttpServlet{
	
	UserDao userDao;
	
	@Override
	public void init() throws ServletException {
		new UserDaoImp();
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
}
}

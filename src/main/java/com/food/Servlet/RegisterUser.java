package com.food.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.UserDao;
import com.food.DAOImp.UserDaoImp;
import com.food.Model.User;

@WebServlet("/registeruser")
public class RegisterUser extends HttpServlet{
	
	//UserDao userDao;
	
	@Override
	public void init() throws ServletException {
//		new UserDaoImp();
	}
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String name=req.getParameter("username");
	 String email=req.getParameter("email");
	 String address=req.getParameter("address");
	 String phone=req.getParameter("phone");
	 String password=req.getParameter("password");
	 String role=req.getParameter("role");
	 
	 User user=new User(name,email,address,phone,password,role);
	 UserDaoImp udi=new UserDaoImp();
	 int n= udi.addUser(user);
	 if(n==1) {
		 RequestDispatcher rd=req.getRequestDispatcher("WEB-INF/views/auth/login.jsp");
		 rd.forward(req, resp);
	 }else {
		 RequestDispatcher rd= req.getRequestDispatcher("WEB-INF/views/auth/registerFailure.jsp");
		 rd.forward(req, resp);
	 }
}


}

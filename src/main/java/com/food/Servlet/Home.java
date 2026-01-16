package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAOImp.RestaurantDaoImp;
import com.food.Model.Restaurant;
import com.food.Model.User;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1. Check login
        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
               .forward(req, resp);
            return;
           
        }

        // 2. Load data
        RestaurantDaoImp rdi = new RestaurantDaoImp();
        List<Restaurant> restaurantList = rdi.getAllRestaurant();

        session.setAttribute("restaurantList", restaurantList);

        // 3. Forward to home
        if(user.getRole().equals("customer")){
        req.getRequestDispatcher("/WEB-INF/views/auth/home.jsp")
           .forward(req, resp);
    }else {
    	req.getRequestDispatcher("/WEB-INF/views/auth/adminHome.jsp")
    	.forward(req,resp);
    }
        
  }
}

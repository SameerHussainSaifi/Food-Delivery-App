package com.food.Servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.food.DAO.UserDao;
import com.food.DAOImp.UserDaoImp;
import com.food.Model.User;

@WebServlet("/login")
public class Login extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImp();
    }

    // GET → show login page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp")
           .forward(req, resp);
    }

    // POST → process login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userDao.getUser(email);

        if (user != null && password.equals(user.getPassword())) {

            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);

            req.getRequestDispatcher("/WEB-INF/views/auth/Home.jsp")
               .forward(req, resp);

        } else {
            req.setAttribute("error", "Invalid email or password");

            req.getRequestDispatcher("/WEB-INF/views/auth/error.jsp")
               .forward(req, resp);
        }
    }
}

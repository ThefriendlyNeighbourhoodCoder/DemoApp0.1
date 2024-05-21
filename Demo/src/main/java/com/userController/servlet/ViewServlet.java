package com.userController.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.user.bean.User;
import com.userDetails.dao.userDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> userList = userDao.getAllUser();
        req.setAttribute("userList", userList); // Set the user list as an attribute
        
        // Forward to viewUser.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewUser.jsp");
        dispatcher.forward(req, resp);
	
		
	}
}

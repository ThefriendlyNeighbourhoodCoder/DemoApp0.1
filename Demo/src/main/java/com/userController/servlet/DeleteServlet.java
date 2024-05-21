package com.userController.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.userDetails.dao.userDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int uid = Integer.parseInt(id);
		int status = userDao.delete(uid);
		PrintWriter out = resp.getWriter();
		
		if (status > 0) {
			resp.sendRedirect("viewUser.jsp");
		}
		else {
			out.println("Sorry! unable to update record");
		}
	}
}

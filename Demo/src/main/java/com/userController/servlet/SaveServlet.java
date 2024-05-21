package com.userController.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.user.bean.User;
import com.userDetails.dao.userDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String uname = req.getParameter("name");
		String upwd = req.getParameter("pass");
		String uemail = req.getParameter("email");
		String umobile = req.getParameter("contact");
		String role = req.getParameter("role");
		
		User u = new User();
		u.setId(id);
		u.setUname(uname);
		u.setUpwd(upwd);
		u.setUemail(uemail);
		u.setUmobile(umobile);
		u.setRole(role);
		
		int status = userDao.save(u);
		if (status > 0 ) {
			out.print("<font color=green><p>Record saved!!! </p><font>");
			req.getRequestDispatcher("admin.jsp").include(req, resp);
		}
		else {
			out.println("<font color=red> Sorry! unable to save record </font>");
			req.getRequestDispatcher("admin.jsp").include(req, resp);
		}
	}
}

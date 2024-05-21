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

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<h1>Update User</h1>");
		String id = req.getParameter("id");
		int uid = Integer.parseInt(id);
		
		User u = userDao.getUserById(uid);
		
		out.println("<form action='EditSaveServlet' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + u.getId() + "'/></td></tr>");
		out.print("<tr><td>Name</td><td><input type='text' name='name' value='" + u.getUname() + "'/></td></tr>");
		out.print("<tr><td>Password</td><td><input type='text' name='pass' value='" + u.getUpwd() + "'/></td></tr>");
		out.print("<tr><td>Email</td><td><input type='text' name='email' value='" + u.getUemail() + "'/></td></tr>");
		out.print("<tr><td>Mobile</td><td><input type='text' name='contact' value='" + u.getUmobile() + "'/></td></tr>");
		out.print("<tr><td>Role</td><td><input type='text' name='role' value='" + u.getRole() + "'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save' /></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
		
		
	
	}
}

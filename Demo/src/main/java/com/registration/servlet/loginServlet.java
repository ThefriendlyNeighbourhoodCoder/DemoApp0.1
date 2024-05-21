package com.registration.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("username");
		String upwd = request.getParameter("password");
		
		HttpSession session = request.getSession();
		//RequestDispatcher dispatcher = null;
		
		if(uemail == null || uemail.equals("")) {
			request.setAttribute("status", "invalidEmail");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); 
			dispatcher.forward(request, response);
		}
		if(upwd == null || upwd.equals("")) {
			request.setAttribute("status", "invalidPassword");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); 
			dispatcher.forward(request, response);
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false", "root","123456789");
			
			PreparedStatement pst = con.prepareStatement("select role,uname from userDetails where uemail = ? and upwd = ?");
			
			
			pst.setString(1, uemail);
			pst.setString(2, upwd);
			
			System.out.println(pst.toString());
			ResultSet rs = pst.executeQuery();
			
						
			
			if(rs.next()){
				session.setAttribute("name", rs.getString("uname"));
				String role = rs.getString("role");
				System.out.println(role);
					if(role.equals("admin")) {
						System.out.println("admin page redirect");
						RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
						dispatcher.forward(request, response);
					}else if (role.equals("user")) {
						System.out.println("user page redirect");
						RequestDispatcher dispatcher = request.getRequestDispatcher("user.jsp");
						dispatcher.forward(request, response);
					}
			}else {
				request.setAttribute("status", "failed");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

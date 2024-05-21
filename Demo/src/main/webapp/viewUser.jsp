<%@page import="com.userDetails.dao.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.userDetails.dao.userDao"%>
<%@page import="java.util.*" %>
<%@page import="com.user.bean.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href='admin.jsp'>Add New User</a>
<h3>User List</h3>
<table border='1' width='100%'>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Password</th>
<th>Email</th>
<th>Mobile</th>
<th>Role</th>
<th>Edit</th>
<th>Del</th>
</tr>
</thead>
<tbody>

<%
userDao userDao =new userDao(DbConnect.getConnection());
List<User> list = userDao.getAllUser();

for (User u:list)
{%>
<tr>
<td><%=u.getId() %></td>
<td><%=u.getUname()%></td>
<td><%=u.getUpwd()%></td>
<td><%=u.getUemail()%></td>
<td><%=u.getUmobile()%></td>
<td><%=u.getRole()%></td>
<td><a href='EditServlet?id=<%=u.getId() %>'>edit</a></td>
<td><a href='DeleteServlet?id=<%=u.getId()%>'>del</a></td>
</tr>
	
<%}
%>



</tbody>
		
		

</table>
</body>
</html>
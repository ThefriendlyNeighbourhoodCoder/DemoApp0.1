<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="SaveServlet" method="post">
<table>
<tr><td>Id</td><td><input type="text" name="id" id="id"/></td></tr>
<tr><td>Name</td><td><input type="text" name="name" id="name"/></td></tr>
<tr><td>Email</td><td><input type="text" name="email" id="email"/></td></tr>
<tr><td>Password</td><td><input type="text" name="pass" id="pass"/></td></tr>
<tr><td>Mobile</td><td><input type="text" name="contact" id="contact"/></td></tr>
<tr><td>Role</td><td><input type="text" name="role" id="role"/></td></tr>

<tr><td colspan="2"><input type="submit" value="save" /></td></tr>
</table>
</form>
<br/>
<a href="viewUser.jsp">View User</a>
<br>
<a href="logout">LogOut</a>
</body>
</html>
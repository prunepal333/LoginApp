<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Login | My Application</title>
</head>
<body>
	<form action="LoginServlet" method="POST">
		<% 
		   System.out.println(session.getAttribute("isAuthenticated"));
		   if(session.getAttribute("isAuthenticated") != null &&
				(Boolean)session.getAttribute("isAuthenticated") == false) {
				out.write("Authentication failed! Check username and/or password<br>");
			}
			else
			{
				out.write("Please enter your credentials!<br>");
			}
		%>
		<label for="user">User name:</label>
		<input type="text" name="user" /> <br />
		<label for="pass">Password: </label>
		<input type="password" name="pass" /><br />
		<input type="submit" name="submit" value="Login" />
	</form>
		<a href="register.jsp">Register</a> a new account
</body>
</html>
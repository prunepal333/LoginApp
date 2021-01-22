<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% 
	String userErr = (String)request.getAttribute("userErr");
	if(userErr == null) userErr = "";
%>
<!DOCTYPE html>
<html>
<head>
<title>Login | My Application</title>
</head>
<body>
	<form action="SignUpServlet" method="POST">
		<%=userErr %>
		<label for="user">User name:</label>
		<input type="text" name="user" /> <br />
		<label for="pass">Password: </label>
		<input type="password" name="pass" /><br />
		<label for="firstName">First name: </label>
		<input type="text" name="firstName" /><br />
		<label for="lastName">Last name: </label>
		<input type="text" name="lastName" /><br />
		<label for="profileInfo">Bio: </label><br />
		<textarea name="profileInfo" rows="10" cols="30"></textarea><br />
		<input type="submit" name="submit" value="Register" />
	</form>
	Already have an account? <a href="login.jsp">Login</a>
</body>
</html>
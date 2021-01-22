<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="io.sadish.web.dto.User" %>

<% User user = (User)session.getAttribute("user");
	System.out.println(user);
	if(user == null)
	{
		response.sendRedirect("login.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>Update Profile | <%=user.getFirstName() %> <%=user.getLastName() %></h2>
	<form action="ProfileUpdateServlet" method="POST" enctype="multipart/form-data">
		<input type="text" name="firstName" placeholder="Enter your firstname" /><br />
		<input type="text" name="lastName" placeholder="Enter your lastname" /><br />
		<textarea rows="10" cols="30" name="profileInfo" placeholder="Enter profile bio" ></textarea><br />
		Profile picture: <input type="file" name="profilePicture" size="50" /><br />
		<input type="submit" name="submit" value="submit" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<%@ page import="io.sadish.web.dto.User" %>

<%
	User user = (User)session.getAttribute("user");
	Boolean isAuthenticated = (Boolean)session.getAttribute("isAuthenticated");
	if(user == null || !isAuthenticated)
	{
		request.setAttribute("isAuthenticated", false);
		response.sendRedirect("login.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
<title>Login | My Application</title>
</head>
<body>
	<h2>Profile</h2>
	
	<div class="bio">
		<h4>
			<%=user.getFirstName() %> <%=user.getLastName() %>
		</h4>
		<p><%=user.getProfileInfo() %></p>
	</div>
	<div class="logout"><a href="LogoutServlet">Logout</a></div>
</body>
</html>
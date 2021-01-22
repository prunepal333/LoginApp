<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<%@ page import="io.sadish.web.dto.User" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileOutputStream" %>


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
<%-- 		<%  --%>
// 			FileInputStream fin = user.getProfilePicture();
// 			String fileName = "file_" + Math.abs(new java.util.Random().nextInt()) + ".jpg";
// 			FileOutputStream fout = new FileOutputStream(fileName);
// 			int b;
// 			while((b = fin.read()) != -1)
// 			{
// 				fout.write((byte)b);
// 			}
// 			fin.close();
// 			fout.close();
<%-- 		%> --%>
		<p><img src="<%= user.getProfilePictureName() %>" alt="" />
		<p><%=user.getProfileInfo() %></p>
	</div>
	<div><a href="update_profile.jsp">Update Profile</a></div>
	<div class="logout"><a href="LogoutServlet">Logout</a></div>
</body>
</html>
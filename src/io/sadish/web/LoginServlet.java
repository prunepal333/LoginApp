package io.sadish.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.sadish.web.dto.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		LoginService loginService = LoginService.getInstance();
		boolean isAuthenticated = loginService.authenticate(username, password);
		request.getSession().setAttribute("isAuthenticated", isAuthenticated);
		if(isAuthenticated)
		{
			User user = loginService.getUserDetails(username);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("profile.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.sendError(405);
	}
}


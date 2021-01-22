package io.sadish.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String profileInfo = request.getParameter("profileInfo");
		
		RegisterService registerService = (RegisterService)FormService.getInstance("register");
		PrintWriter out = response.getWriter();
		if(registerService.isUsernameAvailable(username))
		{
			request.getSession().setAttribute("userErr", "Username already taken!");
			response.sendRedirect("register.jsp");
			return;
		}
		if(registerService.addUserDetails(username, password, firstName, lastName, profileInfo)){
			out.println("Success! Go to <a href='login.jsp'>Login</a>");
		}else {
			out.println("Failed to create account!");
			out.println("Register again! Go to <a href='register.jsp'>Register</a>");
		}
	}
}

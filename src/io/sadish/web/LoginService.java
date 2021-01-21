package io.sadish.web;

import java.sql.*;
import io.sadish.web.dto.User;
import com.mysql.jdbc.Driver;

@SuppressWarnings("unused")
public class LoginService {
	Connection conn;
	
	public static LoginService loginService = null;
	public LoginService()
	{
		//initiates the database connection from here.
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample_db_for_myapp", "root", "");
		}catch(Exception ex)
		{
			System.err.println("Ex: " + ex.getMessage());
		}
	}
	public static LoginService getInstance()
	{
		if(loginService == null)
			return new LoginService();
		return loginService;
	}
	public User getUserDetails(String username)
	{
		try {
			String query = "SELECT user_id, user_name, first_name, last_name, profile_info " +
						   "from user WHERE user_name=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			User user = new User();
			
			resultSet.next();
			
			user.setUserId(resultSet.getInt("user_id"));
			user.setUserName(resultSet.getString("user_name"));
			user.setFirstName(resultSet.getString("first_name"));
			user.setLastName(resultSet.getString("last_name"));
			user.setProfileInfo(resultSet.getString("profile_info"));
			
			return user;
		}
		catch(SQLException ex) {
			System.err.println("Exception: " + ex.getMessage());
			return null;
		}
	}
	public boolean authenticate(String username, String password)
	{
		String query = "SELECT user_pass FROM user WHERE user_name=?";
		try
		{
			if(conn == null) throw new SQLException("Connection hasn't been established!");
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString("user_pass").equals(password);
			return false;
		}catch(SQLException ex)
		{
			System.err.println("Exception: " + ex.getMessage());
			return false;
		}
	}
}

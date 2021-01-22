package io.sadish.web;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterService extends FormService {
	
	public RegisterService() {super();}
	public boolean addUserDetails(String username, String password, String firstName, String lastName, String profileInfo )
	{
		try {
			String query = "INSERT into user (user_name, user_pass, first_name, last_name, profile_info) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, profileInfo);
			int result = ps.executeUpdate();
			return result == 1;
		}catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
	public boolean isUsernameAvailable(String username)
	{
		String query = "SELECT user_id from user WHERE user_name = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return true;
		}catch(SQLException ex)
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
		return false;
	}
}

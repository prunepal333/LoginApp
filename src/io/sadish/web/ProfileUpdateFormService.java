package io.sadish.web;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfileUpdateFormService extends FormService{
	
	public boolean updateProfile(String username, String firstName, String lastName, String profileInfo, FileInputStream profilePicture)
	{
		//MySQL Update Query
		String query = "UPDATE user SET first_name = ?, last_name = ?, profile_info = ?, profile_picture = ? WHERE user_name = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, profileInfo);
			ps.setBinaryStream(4, profilePicture);
			ps.setString(5, username);
			int result = ps.executeUpdate();
			return result == 1;
		}catch(SQLException ex)
		{
			System.err.println("SQLException: " + ex.getMessage());
			return false;
		}
	}
}

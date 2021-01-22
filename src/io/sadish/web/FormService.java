package io.sadish.web;

import java.sql.*;
import io.sadish.web.dto.User;
import com.mysql.jdbc.Driver;

@SuppressWarnings("unused")
public abstract class FormService {
	Connection conn;
	static FormService formService = null;
	public FormService()
	{
		//initiates the database connection from here.
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sample_db_for_myapp", "root", "");
		}catch(Exception ex)
		{
			System.err.println("Ex: " + ex.getMessage());
		}
	}
	public static FormService getInstance(String name)
	{
		if(formService == null) {
			if(name.equalsIgnoreCase("login") || name.equalsIgnoreCase("sigin"))
				return new LoginService();
			else if(name.equalsIgnoreCase("signup") || name.equalsIgnoreCase("register"))
				return new RegisterService();
			else if(name.equalsIgnoreCase("profileupdate") || name.equalsIgnoreCase("updateprofile"))
				return new ProfileUpdateFormService();
			else
				return null;
		}
		return formService;
	}
}
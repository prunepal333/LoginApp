package io.sadish.web.dto;

import java.io.FileInputStream;
import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 122L;
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String profileInfo;
	private FileInputStream profilePicture = null;
	private String profilePictureName;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfileInfo() {
		return profileInfo;
	}
	public void setProfileInfo(String profileInfo) {
		this.profileInfo = profileInfo;
	}
	public void setProfilePicture(FileInputStream profilePicture) {
		this.profilePicture = profilePicture;
	}
	public FileInputStream getProfilePicture() {
		return this.profilePicture;
	}

	public String getProfilePictureName() {
		return profilePictureName;
	}
	public void setProfilePictureName(String profilePictureName) {
		this.profilePictureName = profilePictureName;
	}
}

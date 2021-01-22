package io.sadish.web;

import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.sadish.web.dto.User;

import org.apache.commons.fileupload.FileItem;
// import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/ProfileUpdateServlet")
public class ProfileUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
    	String firstName = request.getParameter("firstName");
    	String lastName = request.getParameter("lastName");
    	String profileInfo = request.getParameter("profileInfo");
    	
    	String filePath = getServletContext().getInitParameter("file-upload");
    	
    	if(!ServletFileUpload.isMultipartContent(request)) {
    		response.sendRedirect("update_profile.jsp");
    	}
    	
    	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
    	
    	ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
    	servletFileUpload.setSizeMax(50000000);
    	
    	FileInputStream profilePicture = null;
    	String profilePictureName = null;
    	try
    	{
    		List<FileItem> fileItems = servletFileUpload.parseRequest(request);
    		Iterator<FileItem> fileItemIterator = fileItems.iterator();
    		while(fileItemIterator.hasNext())
    		{
    			FileItem fileItem = (fileItemIterator.next());
    			File file = new File(filePath + fileItem.getName());
    			profilePictureName = fileItem.getName();
    			fileItem.write(file);
    			profilePicture = new FileInputStream(file);
    		}
    	}catch (Exception ex) {
    		System.err.println("Exception while writing to the file in the server: " + ex.getMessage());
    		@SuppressWarnings("unused") 
    		String err = (String)request.getSession().getAttribute("error");
    		err = ex.getMessage();
    		response.sendRedirect("update_profile.jsp");
    	}
    	
    	ProfileUpdateFormService pufs = (ProfileUpdateFormService)FormService.getInstance("profileupdate");
    	User user = (User)(request.getSession().getAttribute("user"));
    	if(pufs.updateProfile(user.getUserName(), firstName, lastName, profileInfo, profilePicture))
    	{
    		user.setFirstName(firstName);
    		user.setLastName(lastName);
    		user.setProfileInfo(profileInfo);
    		user.setProfilePicture(profilePicture);
    		user.setProfilePictureName(profilePictureName);
    		response.sendRedirect("profile.jsp");
    	}
    	else
    	{
    		System.err.println("Error during update");
    		response.sendRedirect("update_profile.jsp");
    	}
    }
}

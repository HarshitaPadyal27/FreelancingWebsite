package com.code.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.code.dbcon.DbConnection;

/**
 * Servlet implementation class UploadPost
 */
@WebServlet("/UploadPost")
public class UploadPost extends HttpServlet {
	static Connection con=null;
	public void init(ServletConfig config) throws ServletException {
		try {
			con = DbConnection.getConnection();

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String description = request.getParameter("description");
		String technology = request.getParameter("technology");
		String days = request.getParameter("days");
		
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String c_date = df.format(dateobj);
		System.out.println("C Date " + c_date);
	
		try 
		{
			PreparedStatement ps1=con.prepareStatement("INSERT INTO `requirment_details`(`req_by`, `requirment`, `technology`, `days`) VALUES ('"+email+"','"+description+"','"+technology+"','"+days+"')");
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Post Send Sucesfully");
				response.sendRedirect("uploadPost.jsp?send=done");
			}
			else
			{
				System.out.println("Post Sending Fail ");
				response.sendRedirect("uploadPost.jsp?fail=send");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
		}
	}
}	
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

import com.code.dbcon.DbConnection;


/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
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
		String fname = request.getParameter("fname")+" "+request.getParameter("lname");
	
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String user_type = request.getParameter("user_type");
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String c_date = df.format(dateobj);
		System.out.println("C Date " + c_date);
	
		try 
		{
			PreparedStatement ps1=con.prepareStatement("INSERT INTO `user_details`(`full_name`, `mobile_number`,`user_type`, `email`, `password`,`acc_c_date`) VALUES ('"+fname+"','"+mobile+"','"+user_type+"','"+email+"','"+password+"','"+c_date+"')");
			int i=ps1.executeUpdate();
			if(i>0)
			{
				System.out.println("Registration Sucesfully");
				response.sendRedirect("userLogin.jsp?reg=done");
			}
			else
			{
				System.out.println("Registration Fail ");
				response.sendRedirect("userLogin.jsp?fail=reg");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exception " + e);
		}
	}
}
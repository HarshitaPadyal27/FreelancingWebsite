package com.code.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class SendResponse
 */
@WebServlet("/SendResponse")
public class SendResponse extends HttpServlet {

	static Connection con=null;
	public void init(ServletConfig config) throws ServletException {
		try {
			con = DbConnection.getConnection();

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		
		try 
		{
				PreparedStatement ps1=con.prepareStatement("UPDATE `bidding_details` SET status='Accept' where id="+id+"");
				int i=ps1.executeUpdate();
				if(i>0)
				{
					System.out.println("Bidding Response Send Done");
					response.sendRedirect("viewUploadPost.jsp?send=req");
				}
		}
		catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}
	}
}
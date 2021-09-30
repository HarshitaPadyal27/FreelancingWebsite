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

@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		String id=request.getParameter("id");
		String amt=request.getParameter("amt");
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateobj = new Date();
		String c_date = df.format(dateobj);
		System.out.println("C Date " + c_date);
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("Select * from bidding_details where user_id='"+email+"' AND req_id='"+id+"'");
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("INSERT INTO `bidding_details`(`user_id`, `req_id`, `amount_details`, `c_date`) VALUES ('"+email+"','"+id+"','"+amt+"','"+c_date+"')");
				int i=ps1.executeUpdate();
				if(i>0)
				{
					System.out.println("Bidding Request Send Done");
					response.sendRedirect("userViewPost.jsp?send=req");
				}
			}
			else
			{
				System.out.println("Already Send Request");
				response.sendRedirect("userViewPost.jsp?fail=send");
			}
		}
		catch (Exception e) 
		{
			System.out.println("Exc "+e);
		}
	}
}
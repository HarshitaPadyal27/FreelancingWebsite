package com.code.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.code.dbcon.DbConnection;


public class GlobalFunction {

	static Connection con=DbConnection.getConnection();
	
	public int getCount(HttpServletRequest req,String req_id) 
	{
		
		int result=0;
		try 
		{
			PreparedStatement ps=con.prepareStatement("SELECT COUNT(id) FROM `bidding_details` where req_id='"+req_id+"'");
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				result=rs.getInt(1);
			}
			 	
		} catch (Exception e) 
		{
			System.out.println("Exception ww "+e);
		}
		return result; 
	}
	public HashMap<String, String> getRequirmentDetails(String r_id,String email) 
	{
		HashMap<String, String> req_details=new HashMap<>();
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from requirment_details where id='"+r_id+"'");
			ResultSet rs=ps.executeQuery();
			System.out.println("Ex "+ps);
			if(rs.next())
			{
				req_details.put("req_by",rs.getString("req_by"));
				req_details.put("requirment",rs.getString("requirment"));
				req_details.put("technology",rs.getString("technology"));
				req_details.put("days",rs.getString("days"));
				req_details.put("status",rs.getString("status"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exc------ "+e);
		}
		return req_details;
		
	}

	public HashMap<String, String> getUserProfile(String u_id) 
	{
		HashMap<String, String> req_details=new HashMap<>();
		
		try 
		{
			PreparedStatement ps=con.prepareStatement("select * from user_details where email='"+u_id+"'");
			ResultSet rs=ps.executeQuery();
			System.out.println("Ex "+ps);
			if(rs.next())
			{
				req_details.put("full_name",rs.getString("full_name"));
				req_details.put("mobile_number",rs.getString("mobile_number"));
				req_details.put("email",rs.getString("email"));
				req_details.put("acc_c_date",rs.getString("acc_c_date"));
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Exc------ "+e);
		}
		return req_details;
		
	}
	
}

package com.code.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	static Connection con=null;
	public static Connection getConnection() 
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/freelancer", "root", "");
			return con;
		}
		catch (Exception e) 
		{
			System.out.println("Exception is 1 " + e);
		}

		
		return con;
	}
}

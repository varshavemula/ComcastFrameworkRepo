package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con;
	public void getDBConnection(String url,String username,String password) throws Exception
	{
		try
		{

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		    con=DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e)
		{
		}
	}
	
	public void getDBConnection() throws Exception
	{
		try
		{

			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_schema","root","root");
		
		}
		catch(Exception e)
		{
		}
	}
	
	public void closeDBConnection() throws SQLException
	{
		con.close();
	}
	
	public ResultSet executeConSelectQuery(String query) throws Throwable
	{
		 ResultSet result=null;
	   try
	   {
		   Statement stmt=	con.createStatement();
		   result=stmt.executeQuery(query);
	   }
	   catch(Exception e)
	   {
	   }
	    return result;
	}
	
	public int executeNonSelectQuery(String query)
	{
		int result=0;
		 try
		   {
			   Statement stmt=	con.createStatement();
			   result=stmt.executeUpdate(query);
		   }
		   catch(Exception e)
		   {
		   }
		 return result;
	}
	
}

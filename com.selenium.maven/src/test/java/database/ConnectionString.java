package database;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectionString {

	
	@Test
	public void testDB()
	{
		
		try
		
		{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		System.out.println("Driver Loaded");
		
	    Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","Root");
		
		System.out.println("Connected To My DataBase");
		
		Statement smt =con.createStatement();
		
		ResultSet rs =smt.executeQuery("Select * From Orders");

		while(rs.next())
		
		{
		
			String orderId=rs.getString("orderid");
			
			System.out.println("OrderId From OrdersTable  : "+orderId);
			
            String orderNo=rs.getString("OrderName");
			
			System.out.println("orderNo From OrdersTable: "+orderNo);
			
			
			
			//con.close();
			
		}
		
		
		
		
		
		
		}
		
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
	}
	
	
}

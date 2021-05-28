package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC1 {

	public static void main(String[] args) {

		
		try
		{
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "Root");
		
		Statement smt=con.createStatement();
		
		ResultSet rs=smt.executeQuery("Select * From Orders");
		
		while(rs.next())
		{
			
			System.out.println(rs.getInt("OrderId")+" "+rs.getString("OrderId"));
			
			System.out.println(rs.getString("OrderName"));
			
		}
		
		
		}
		
		
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		
	}

}

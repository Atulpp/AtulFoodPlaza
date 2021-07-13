package in.coder.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 

{
	public static Connection getDBConnect()
	{
	
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atul_foodplaza","root","");
		
		return conn;	
	
		}
		catch(Exception e)
		{
		e.printStackTrace();
	}
		return null;
}
	

}

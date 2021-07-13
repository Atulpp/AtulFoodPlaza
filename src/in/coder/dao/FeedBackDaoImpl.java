package in.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import in.coder.pojo.Food;
import in.coder.utility.DBConnection;

public class FeedBackDaoImpl implements FeedBackDao {
	
	PreparedStatement ps=null;
	Connection conn=null;

	boolean flag;
	
	@Override
	public boolean addfeedback(String username,String email,String type,String question)
	{
	
		
		
		try
		{
			conn=DBConnection.getDBConnect();

			String sql="insert into question(username,email,type,question)value(?,?,?,?)";

			ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,email);
			ps.setString(3,type);
			ps.setString(4,question);

			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			return false;
		
	}
	
	
	
	}

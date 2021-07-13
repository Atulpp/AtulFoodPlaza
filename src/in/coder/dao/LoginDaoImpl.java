package in.coder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.coder.utility.DBConnection;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean adminLogin(String username, String password) {
		try
		{
			Connection conn = DBConnection.getDBConnect();
			String sql="select * from atul_admin where username=? and password=?";
			
					PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
	
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return false;
		
	
	}



	@Override
	public boolean CustLogin(String custEmail, String custPass) {
		try
		{
			Connection conn = DBConnection.getDBConnect();
			String sql="select * from atul_customer where custEmail=? and custPass=?";
			
					PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,custEmail);
			ps.setString(2,custPass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
	
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public boolean changePassword(String username, String password,String npassword) {
		
		try{
			
			Connection conn = DBConnection.getDBConnect();
			String sql="select * from atul_admin where username=? and password=?";
			
					PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				try
				{
					Connection conn1 = DBConnection.getDBConnect();
					String sql1="update atul_admin set password=? where username=?";
					
					PreparedStatement ps1 = conn.prepareStatement(sql1);
					ps1.setString(1,npassword);
					ps1.setString(2,username);
					ps1.executeUpdate();
				
						return true;
					
			
					
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
				
				return false;
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		return false;
		
		
	
	}

}

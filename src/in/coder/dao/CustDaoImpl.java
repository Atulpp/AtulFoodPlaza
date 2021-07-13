
package in.coder.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import in.coder.pojo.Customer;
import in.coder.pojo.Food;
import in.coder.utility.DBConnection;

	
	

	public class CustDaoImpl implements CustDao
	{
		PreparedStatement ps=null;
		Connection conn=null;
		
		public boolean addCust(Customer c)
		{
			
			try
			{
			conn=DBConnection.getDBConnect();
			String sql="insert into atul_customer(CustName,CustAdd,CustCon,CustEmail,custPass)value(?,?,?,?,?)";
			
					ps=conn.prepareStatement(sql);
			ps.setString(1,c.getCustName());
			ps.setString(2,c.getCustAdd());
			ps.setInt(3,c.getCustCon());
			ps.setString(4,c.getCustEmail());
			ps.setString(5,c.getCustPass());
			
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

		@Override
		public boolean updateCust(Customer c) {
			try
			{
			conn=DBConnection.getDBConnect();
			String sql="update atul_customer set custName=?,custAdd=?,custCon=?,custEmail=?,custPass=? where custId=?";
			
					ps=conn.prepareStatement(sql);
			ps.setString(1,c.getCustName());
			ps.setString(2,c.getCustAdd());
			ps.setInt(3,c.getCustCon());
			ps.setString(4,c.getCustEmail());
			ps.setString(5,c.getCustPass());
			ps.setInt(6,c.getCustId());
			
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


	

		@Override
		public Customer displayCustById(int custId) {
			try
			{
			conn=DBConnection.getDBConnect();
			String sql="select * from atul_customer where custId=?";
			
					ps=conn.prepareStatement(sql);

			ps.setInt(1,custId);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer c=new Customer();
						c.setCustId(rs.getInt("custId"));
						
						c.setCustName(rs.getString("custName"));
						c.setCustAdd(rs.getString("custAdd"));
						c.setCustCon(rs.getInt("custCon"));
						c.setCustEmail(rs.getString("custEmail"));
						c.setCustPass(rs.getString("custPass"));
						
						return c;
				
			}
		
			
			
		
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		public boolean deleteCustById(int cId) {
			// TODO Auto-generated method stub
			try
			{
			conn=DBConnection.getDBConnect();
			String sql="delete from atul_customer where CustId=?";
			
					ps=conn.prepareStatement(sql);

			ps.setInt(1,cId);
			
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

		@Override
		public List<Customer> displayAllCust() {
			// TODO Auto-generated method stub
			try{
				
				List <Customer> cList=new ArrayList<Customer>();
				conn=DBConnection.getDBConnect();
				String sql="select * from atul_customer";
				
		ps=conn.prepareStatement(sql);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Customer c=new Customer();
							c.setCustId(rs.getInt("custId"));
							
							c.setCustName(rs.getString("custName"));
							c.setCustAdd(rs.getString("custAdd"));
							c.setCustCon(rs.getInt("custCon"));
							c.setCustEmail(rs.getString("custEmail"));
							c.setCustPass(rs.getString("custPass"));
							
							
							cList.add(c);
					
				}
				return cList;
				}
				catch(Exception e)
				{
					
				e.printStackTrace();
				
				
			}
					return null;
		}

		public Customer searchCustomerByEmail(String custEmail) {
			
			try
			{
			conn=DBConnection.getDBConnect();
			String sql="select * from atul_customer where custEmail=?";
			
					ps=conn.prepareStatement(sql);

			ps.setString(1,custEmail);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Customer c=new Customer();
						c.setCustId(rs.getInt("custId"));
						
						c.setCustName(rs.getString("custName"));
						c.setCustAdd(rs.getString("custAdd"));
						c.setCustCon(rs.getInt("custCon"));
						c.setCustEmail(rs.getString("custEmail"));
						c.setCustPass(rs.getString("custPass"));
						
						return c;
				
			}
		
			
			
		
			
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

			
		
			
		}
		

		

	


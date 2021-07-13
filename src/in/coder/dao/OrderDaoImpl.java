package in.coder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.coder.pojo.Cart;
import in.coder.pojo.Food;
import in.coder.pojo.Ordero;
import in.coder.utility.DBConnection;


public class OrderDaoImpl implements OrderDao{
	PreparedStatement ps;
	Connection conn;
	
	boolean flag;
	
	@Override
	public int placeOrder(String custEmail, double totalBill) {
		int generatedOrderId=0;
		try
		{
		conn=DBConnection.getDBConnect();
		Date d=new Date();
		String date = d.toString();
		String sql="insert into atul_order(custEmail,total_bill,date,status) values(?,?,?,?)";
		ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, custEmail);
		ps.setDouble(2, totalBill);
		ps.setString(3, date);
		ps.setString(4, "Processing");
		int rows = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		while(rs.next())
		{
			generatedOrderId=rs.getInt(1);
		}		
			
		
		if(rows>0)
		{
			CartDaoImpl cdi=new CartDaoImpl();
			boolean flag=cdi.deleteCartByEmail(custEmail);
			if(flag)
				return generatedOrderId;
		}
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			return generatedOrderId;
	}

	@Override
	public List<Ordero> displayAllOrder() {
		// TODO Auto-generated method stub
		try{
			
			List <Ordero> oList=new ArrayList<Ordero>();
			conn=DBConnection.getDBConnect();
			String sql="select * from atul_order";
			
	ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Ordero o=new Ordero();
						o.setOrder_id(rs.getInt("order_id"));
						
						o.setCustEmail(rs.getString("custEmail"));
						o.setTotal_bill(rs.getDouble("total_bill"));
						o.setDate(rs.getString("date"));
						o.setStatus(rs.getString("status"));
						
					
						
						oList.add(o);
				
			}
			return oList;
			}
			catch(Exception e)
			{
				
			e.printStackTrace();
			
			
		}
				return null;
	}

}

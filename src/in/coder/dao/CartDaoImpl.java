package in.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.coder.pojo.Cart;
import in.coder.pojo.Food;
import in.coder.utility.DBConnection;

public class CartDaoImpl implements CartDao
{
	
	PreparedStatement ps;
	Connection conn;
	List<Cart> lcart=new ArrayList<Cart>();
	boolean flag;
	
	public boolean addToCart(Cart ct)
	{
	
		
		boolean flag;
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="insert into atul_cart(custEmail,foodId,foodQty)values(?,?,?)";
		
				ps=conn.prepareStatement(sql);
		ps.setString(1,ct.getcustEmail());
		ps.setInt(2,ct.getFoodId());
		ps.setDouble(3,ct.getFoodQty());
		
		int i=ps.executeUpdate();
		
		
		if(i>0)
		{
			flag = true;
		}
		
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			return false;
		
		
	}
	public boolean deleteCartById(int cartId)
	{
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="delete from atul_cart where cartId=?";
		
				ps=conn.prepareStatement(sql);
			
				ps.setInt(1,cartId);
				
			
		
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
	public boolean deleteCartByEmail(String custEmail) {
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="delete from atul_cart where custEmail=?";
		
				ps=conn.prepareStatement(sql);

		ps.setString(1,custEmail);
		
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
	public List<Cart> displayCartByEmail(String custEmail) {
		// TODO Auto-generated method stub
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="select cartId,foodName,FoodPrice,foodQty from atul_cart as ct inner join atul_food as f on f.foodId=ct.foodId where custEmail=?" ;
		
				ps=conn.prepareStatement(sql);

		ps.setString(1,custEmail);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Cart ct=new Cart();
					ct.setCartId(rs.getInt(1));
					
					ct.setFoodName(rs.getString(2));
					
					ct.setFoodPrice(rs.getDouble(3));
					ct.setFoodQty(rs.getInt(4));
					
					lcart.add(ct);
					
			
		}
		return lcart;
	
	
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	

		
	



}

package in.coder.dao;

import java.io.*;
import java.io.OutputStream;
import java.sql.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.coder.pojo.Food;
import in.coder.utility.DBConnection;

public class foodDaoImpl implements FoodDao
{
	PreparedStatement ps=null;
	Connection conn=null;

	
	public boolean addFood(Food f)
	{
		
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="insert into atul_food(foodName,foodType,foodPrice,foodImage)value(?,?,?,?)";
		
				ps=conn.prepareStatement(sql);
		ps.setString(1,f.getFoodName());
		ps.setString(2,f.getFoodType());
		ps.setDouble(3,f.getFoodPrice());

		 
            //files are treated as BLOB objects in database
            //here we're letting the JDBC driver
            //create a blob object based on the
            //input stream that contains the data of the file
            ps.setBlob(4,f.getFoodImage());
        
		 
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
	public List<Food> searchType(String filter,String food)
	{
		
			
			try{
				
				List <Food> fList=new ArrayList<Food>();
				conn=DBConnection.getDBConnect();
				String sql="select * from atul_food where foodType=?";
				
				ps=conn.prepareStatement(sql);

		ps.setString(1,food);
		
		ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Food f=new Food();
							f.setFoodId(rs.getInt("foodId"));
							
							f.setFoodName(rs.getString("foodName"));
							f.setFoodType(rs.getString("foodType"));
							f.setFoodPrice(rs.getDouble("foodPrice"));
							f.setFoodImg(rs.getBlob("foodImage"));
							
							fList.add(f);
					
				}
				return fList;
			}
			catch(Exception e)
			{
				
			e.printStackTrace();
			
			return null;
		}
				
				
				
		}
		
	@Override
	public List<Food> searchName(String filter,String food)
	{
		
			
			try{
				
				List <Food> fList=new ArrayList<Food>();
				conn=DBConnection.getDBConnect();
				String sql="select * from atul_food where foodName=?";
				
				ps=conn.prepareStatement(sql);

		ps.setString(1,food);
		
		ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					Food f=new Food();
							f.setFoodId(rs.getInt("foodId"));
							
							f.setFoodName(rs.getString("foodName"));
							f.setFoodType(rs.getString("foodType"));
							f.setFoodPrice(rs.getDouble("foodPrice"));
							f.setFoodImg(rs.getBlob("foodImage"));
							
							fList.add(f);
					
				}
				return fList;
			}
			catch(Exception e)
			{
				
			e.printStackTrace();
			
			return null;
		}
				
				
				
		}
		

	@Override
	public boolean updateFood(Food f) {
		// TODO Auto-generated method stub
		
		try
		{
			
			
				conn=DBConnection.getDBConnect();
				String sql="update atul_food set foodName=?,foodType=?,foodPrice=?,foodImage=? where foodId=?";
				
						ps=conn.prepareStatement(sql);
				ps.setString(1,f.getFoodName());
				ps.setString(2,f.getFoodType());
				ps.setDouble(3,f.getFoodPrice());
			
					ps.setBlob(4,f.getFoodImage());
				
				
				ps.setInt(5,f.getFoodId());
			
		int i=ps.executeUpdate();
		
			
			
		if(i>0)
		return true;
		}	
		
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			return false;
		}
		


	@Override
	public boolean deleteFoodById(int foodId) {
		// TODO Auto-generated method stub
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="delete from atul_food where foodId=?";
		
				ps=conn.prepareStatement(sql);

		ps.setInt(1,foodId);
		
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
	public List<Food> displayAllFood() {
		
		try{
		
		List <Food> fList=new ArrayList<Food>();
		conn=DBConnection.getDBConnect();
		String sql="select * from atul_food";
		
ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Food f=new Food();
					f.setFoodId(rs.getInt("foodId"));
					
					f.setFoodName(rs.getString("foodName"));
					f.setFoodType(rs.getString("foodType"));
					f.setFoodPrice(rs.getDouble("foodPrice"));
					f.setFoodImg(rs.getBlob("foodImage"));
					
					fList.add(f);
			
		}
		return fList;
		}
		catch(Exception e)
		{
			
		e.printStackTrace();
		
		
	}
			return null;
	}
	
	@Override
	public Food displayFoodById(int foodId) {
		// TODO Auto-generated method stub
		OutputStream img;
		try
		{
		conn=DBConnection.getDBConnect();
		String sql="select * from atul_food where foodId=?";
		
				ps=conn.prepareStatement(sql);

		ps.setInt(1,foodId);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			Food f=new Food();
					f.setFoodId(rs.getInt("foodId"));
					
					f.setFoodName(rs.getString("foodName"));
					f.setFoodType(rs.getString("foodType"));
					f.setFoodPrice(rs.getDouble("foodPrice"));
					f.setFoodImg(rs.getBlob("foodImage"));
				//	Blob image = rs.getBlob("foodImage");
//byte barray[]=rs.getBytes(5);
//response.setContentType("foodImage/png");
//img=response.getOutputStream();
//img.write(barray);
//img.flush();
//img.close();
				//	byte[] img = image.getBytes(1,(int)image.length());
				//	f.setFoodImage(img);
					//Blob image = (rs.getBlob("foodImage"));
					// img = image.getBytes(1,(int)image.length());
					//f.setFoodImage(rs.getBlob("foodImage"));
				
					return f;
			
		}
		
	
		
		
	
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}



	



	






}

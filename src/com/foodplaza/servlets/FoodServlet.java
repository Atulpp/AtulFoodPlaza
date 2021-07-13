package com.foodplaza.servlets;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;

/**
 * Servlet implementation class FoodServlet
 */


@WebServlet("/FoodServlet")
@MultipartConfig(maxFileSize = 16177215)
public class FoodServlet extends HttpServlet {
	 private static final int BUFFER_SIZE = 4096;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Food f=new Food();
		foodDaoImpl fdi=new foodDaoImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String opt=request.getParameter("operation");
		OutputStream img;
		if(opt!=null && opt.equals("update"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			f=fdi.displayFoodById(fid);
			
		//	byte barray[]=(f.getFoodImage());
			//response.setContentType("foodImage/png");
			//img=response.getOutputStream();
		//	img.write(barray);
			//img.flush();
			//img.close();
			
			session.setAttribute("food",f);
			
			

			response.sendRedirect("UpdateFood.jsp");
		}
		else if(opt!=null && opt.equals("delete"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			boolean flag=fdi.deleteFoodById(fid);
			response.sendRedirect("FoodServlet");
			
		}
		
		
		else{
		List<Food> flist=fdi.displayAllFood();
		session.setAttribute("foodlist",flist);
				response.sendRedirect("FoodList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Food f=new Food();
		foodDaoImpl fdi=new foodDaoImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		// TODO Auto-generated method stub
		// InputStream inputStream = null;
		String opt=request.getParameter("operation");
		
		if(opt!=null && opt.equals("addFood"))
		{
			 
		String foodname=request.getParameter("fName");
		String foodcat=request.getParameter("fType");
		double foodprice=Double.parseDouble(request.getParameter("fPrice"));
		
		 javax.servlet.http.Part getPart = request.getPart("foodImage");
	     
		 
	            InputStream foodImage= getPart.getInputStream();
		    
	        
		f.setFoodType(foodcat);
		f.setFoodName(foodname);
		f.setFoodPrice(foodprice);
	
		f.setFoodImage(foodImage);
	      
		
		boolean flag=fdi.addFood(f);
		if(flag)
		{
			//out.write("Food added");
			request.setAttribute("success", "Food added");
			List<Food>flist=fdi.displayAllFood();
			
			session.setAttribute("foodlist",flist);
			RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
					rd.forward(request, response);
		}
		else
			out.write("error");
			
		
		}
		else if(opt!=null && opt.equals("updateFood"))
		{
		String foodname=request.getParameter("fName");
		String foodcat=request.getParameter("fType");
		double foodprice=Double.parseDouble(request.getParameter("fPrice"));
		int fid=Integer.parseInt(request.getParameter("fid"));
	//	InputStream foodImage;
		Part gp=request.getPart("foodImage");
				if(gp.getSize()!=0)
		{
			
					javax.servlet.http.Part getPart = request.getPart("foodImage");
					 InputStream foodImage= getPart.getInputStream();
					 f.setFoodImage(foodImage);

			
			
		}
		else{
	
			
			Blob blob = ((Food)session.getAttribute("food")).getFoodImg();
			
			 try {
				InputStream is = blob.getBinaryStream();
				 f.setFoodImage(is);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
	           
		    
		}
					///////////
		
	
		
		f.setFoodId(fid);
		f.setFoodType(foodcat);
		f.setFoodName(foodname);
		f.setFoodPrice(foodprice);
		
		
		
		boolean flag=fdi.updateFood(f);
		if(flag)
		{
			response.sendRedirect("FoodServlet");
			
		}
		else
			response.sendRedirect("UpdateFood.jsp");
		
		}
		else if(opt!=null && opt.equals("search"))
		{
			
			String filter=request.getParameter("filter");
			String food=request.getParameter("food");
			
			if(filter.equals("foodName"))
			{
				
				List<Food> flist=fdi.searchName(filter,food);
				session.setAttribute("foodlist",flist);
						response.sendRedirect("FoodLists.jsp");
			}
			else if(filter.equals("foodType"))
{
				
				List<Food> flist=fdi.searchType(filter,food);
				session.setAttribute("foodlist",flist);
						response.sendRedirect("FoodLists.jsp");
			}
			
		
		
		}
	}

}

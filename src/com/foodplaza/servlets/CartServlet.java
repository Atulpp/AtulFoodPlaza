package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.CartDaoImpl;
import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Cart;
import in.coder.pojo.Food;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartDaoImpl cdi=new CartDaoImpl();
		HttpSession session=request.getSession();
		String opt=request.getParameter("operation");
		boolean flag;
		String custEmail=(String)session.getAttribute("custEmail");
	
		
		if(opt!=null && opt.equals("addToCart"))
		{
			
			int fid=Integer.parseInt(request.getParameter("fid"));
			Cart ct=new Cart();
			
			ct.setcustEmail(custEmail);			
			ct.setFoodId(fid);
			ct.setFoodQty(1);
			
			
			flag=cdi.addToCart(ct);
			response.sendRedirect("FoodServlet");
		}
		else if(opt!=null && opt.equals("delete"))
		{
			int cartId=Integer.parseInt(request.getParameter("cartId"));
					flag=cdi.deleteCartById(cartId);
			
					
			response.sendRedirect("CartServlet");
		}
		else
		{
			List<Cart> lcart=cdi.displayCartByEmail(custEmail);
			session.setAttribute("cartList", lcart);
			response.sendRedirect("CartList.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}

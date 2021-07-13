package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.OrderDaoImpl;
import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;
import in.coder.pojo.Ordero;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		OrderDaoImpl oodi=new OrderDaoImpl();
		
		HttpSession session=request.getSession();
		List<Ordero> olist=oodi.displayAllOrder();
		session.setAttribute("orderlist",olist);
				response.sendRedirect("Orderlist.jsp");
				
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameterValues("foodPrice")==null)
		{
			
request.setAttribute("order", "Cart Cannot Be Empty");
			
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
					rd.forward(request, response);	
		}
		else{
		
		String foodPrice[]=request.getParameterValues("foodPrice");
		String foodQty[]=request.getParameterValues("foodQty");
		HttpSession session=request.getSession();
		
		String custEmail=(String)session.getAttribute("custEmail");
		double totalBill=0.0;
		for(int i=0;i<foodPrice.length;i++){
			totalBill=totalBill+(Integer.parseInt(foodQty[i]))*(Double.parseDouble(foodPrice[i]));
		}
			
			OrderDaoImpl odi=new OrderDaoImpl();
			int generatedOrderId=odi.placeOrder(custEmail, totalBill);
		
			
			
			request.setAttribute("order", "Order Placed Successfully with order ID :"+generatedOrderId);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
		
		}
	}

}

package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.CustDaoImpl;
import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Customer;
import in.coder.pojo.Food;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/CustServlet")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Customer c =new Customer();
		CustDaoImpl cdi=new CustDaoImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String opt=request.getParameter("operation");
		String custEmail=(String)session.getAttribute("custEmail");
		
		
		if(opt!=null && opt.equals("update"))
		{
			int cid=Integer.parseInt(request.getParameter("cid"));
			c=cdi.displayCustById(cid);
			session.setAttribute("customer",c);
			response.sendRedirect("UpdateCust.jsp");
		}
		else if(opt!=null && opt.equals("delete"))
		{
			int cid=Integer.parseInt(request.getParameter("cid"));
			boolean flag=cdi.deleteCustById(cid);
			response.sendRedirect("CustServlet");
			
		}
		
		
		else if(opt!=null && opt.equals("updateCust"))
		{
			c=cdi.searchCustomerByEmail(custEmail);
			session.setAttribute("customer",c);
			response.sendRedirect("UpdateCust.jsp");
			
		}
		
		
		else{
		List<Customer> clist=cdi.displayAllCust();
		session.setAttribute("custlist",clist);
				response.sendRedirect("CustList.jsp");
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		CustDaoImpl cdi=new CustDaoImpl();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
String opt=request.getParameter("operation");
		
		if(opt!=null && opt.equals("addCust"))
		{
		
		String custname=request.getParameter("cName");
		String custadd=request.getParameter("cAdd");
		int custcon=Integer.parseInt(request.getParameter("cCon"));
		String custemail=request.getParameter("cEmail");
		String custpass=request.getParameter("cPass");
		
		
		c.setCustName(custname);
		c.setCustAdd(custadd);
		c.setCustCon(custcon);
		c.setCustEmail(custemail);
		c.setCustPass(custpass);
		
		
		boolean flag=cdi.addCust(c);
		if(flag)
		{
			//out.write("Customer added");
			request.setAttribute("success", "Customer added");
		
			RequestDispatcher rd=request.getRequestDispatcher("AddCustomer.jsp");
					rd.forward(request, response);
		}
		else{
			//out.write("error");
			request.setAttribute("error", "Error in adding customer");
			
			RequestDispatcher rd=request.getRequestDispatcher("AddCustomer.jsp");
					rd.forward(request, response);
		}
		}
	
	else if(opt!=null && opt.equals("updateCust"))
	{
		int cid=Integer.parseInt(request.getParameter("cid"));
	String custname=request.getParameter("cName");
	String custadd=request.getParameter("cAdd");
	int custcon=Integer.parseInt(request.getParameter("cCon"));
	String custemail=request.getParameter("cEmail");
	String custpass=request.getParameter("cPass");

	
	c.setCustId(cid);
	c.setCustName(custname);
	c.setCustAdd(custadd);
	c.setCustCon(custcon);
	c.setCustEmail(custemail);
	c.setCustPass(custpass);
	
	boolean flag=cdi.updateCust(c);
	if(flag)
	{
		//response.sendRedirect("index.jsp");
		request.setAttribute("updatedcust", "Customer Updated");
		
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
	}
	else
	{
		out.write("UpdateCust.jsp");
	}

	}
}
}

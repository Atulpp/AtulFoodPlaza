package com.foodplaza.servlets;

import java.io.IOException;
import java.util.List;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.LoginDaoImpl;
import in.coder.pojo.Food;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Part;

import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equals("logout")){
			
			
			
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	String opt=request.getParameter("operation");
	

	LoginDaoImpl ldi=new LoginDaoImpl();

	
	if(opt!=null && opt.equals("login"))
	{

		String type=request.getParameter("type");
	String username=request.getParameter("username");
	String password=request.getParameter("password");

	if(type.equals("user"))
		
	{
	
		boolean flag=ldi.CustLogin(username, password);
		if(flag)
		{
			
			session.setAttribute("custEmail", username);
			//response.sendRedirect("index.jsp");
			request.setAttribute("loginuser", "Welcome To Food Plaza");
	
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
		}
		else{
			request.setAttribute("wrong", "Your Email Or Password is Incorrect!..");

		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
		}
	}
	else if(type.equals("admin"))
	{
		
		boolean flag=ldi.adminLogin(username, password);
		if(flag)
		{
			session.setAttribute("username", username);
			//response.sendRedirect("FoodServlet");
			request.setAttribute("loginadmin", "Welcome To Food Plaza ATUL");
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
		}
		else{
			request.setAttribute("wrong", "Your Email Or Password is Incorrect!..");

		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
		}
	}
	
	}
	else if(opt!=null && opt.equals("changepassword"))
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String npassword=request.getParameter("npassword");
		
		boolean flag=ldi.changePassword(username, password,npassword);
		if(flag)
		{
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("npassword", npassword);
			
			response.sendRedirect("Login.jsp");
		}
		else
		{
			request.setAttribute("wrong", "Your Old Password Didn't Match");

		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
		
		}
	}
		
	}

	}



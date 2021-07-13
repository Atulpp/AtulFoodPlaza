package com.foodplaza.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import in.coder.pojo.*;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;

/**
 * Servlet implementation class ImgServlet
 */
@WebServlet("/ImgServlet")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgServlet() {
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
		if(opt!=null && opt.equals("img"))
		{
			int fid=Integer.parseInt(request.getParameter("fid"));
			f=fdi.displayFoodById(fid);
session.setAttribute("food",f);
			
			

		//	response.sendRedirect("UpdateFood.jsp");
			
			

			response.sendRedirect("retrieve.jsp");

			

			 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

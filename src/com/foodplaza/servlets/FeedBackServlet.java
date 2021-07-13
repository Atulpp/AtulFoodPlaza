package com.foodplaza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.dao.FeedBackDaoImpl;
import in.coder.dao.foodDaoImpl;
import in.coder.pojo.Food;


/**
 * Servlet implementation class FeedBack
 */
@WebServlet("/FeedBackServlet")
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		FeedBackDaoImpl fbi=new FeedBackDaoImpl();
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String type=request.getParameter("type");
		String question=request.getParameter("question");
		boolean flag=fbi.addfeedback(username, email,type,question);
		
		if(flag)
		{
			
			
			//response.sendRedirect("index.jsp");
			request.setAttribute("feed", "Your Feedback Form Is Submitted.Thankyou");

			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
		}
		else{
			response.sendRedirect("radioForm.jsp");
		}
		
	}
}

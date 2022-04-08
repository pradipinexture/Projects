package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.UserDao;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

/**
 * Servlet implementation class DelUser
 */
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//UserDao.deleteUser(request.getParameter("email"));
		//response.sendRedirect("adminhome.jsp");
		try {
			response.setContentType("text/html");  
			PrintWriter out = response.getWriter(); // for printing	
			
			UserDao u=new UserDao();
			if((request.getParameter("isCheck")) != null){
				if(u.checkUserAvailability(request.getParameter("cuEmail"))){
					out.print("!! Email already exist");
				}	
			}
			else {
				if(u.deleteUser(request.getParameter("cuEmail"))) {
					out.print("deleted successfully");
				}
				else {
					out.print(" Not deleted successfully");
				}
			}
		}
		catch(Exception e) {
			System.out.print("Error is : "+e);
			response.sendRedirect("index.jsp");
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

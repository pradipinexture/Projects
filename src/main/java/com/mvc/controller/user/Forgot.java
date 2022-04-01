package com.mvc.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.UserDao;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;
import com.mvc.util.EncryDecryAES;

/**
 * Servlet implementation class Forgot
 */
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		UserServiceInterface service=new UserServiceImp();
		if(service.passwordUpadate(request.getParameter("email"), EncryDecryAES.encrypt(request.getParameter("password")))) {
			response.sendRedirect("index.jsp");
		}
		else {
			request.getRequestDispatcher("forgot.jsp").include(request, response);
			out.println("<div style='color:red;text-align:center'>!! Please enter valid data</div>");
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

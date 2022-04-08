package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(request.getParameter("editEmail") != null) {
				UserServiceInterface service=new UserServiceImp();
				HttpSession session=request.getSession(false); 
				UserModel userObj=(UserModel)session.getAttribute("user");
				
				UserModel u = service.getUserDetail(request.getParameter("editEmail"));
				request.setAttribute("sUser", u); // first pass user object with request
				List<AddressModel> addModelObj= service.getAllUserAddresses(Integer.parseInt(request.getParameter("editId")));
				request.setAttribute("addresses", addModelObj); // pass perticular  user's  addresses with request
				
				request.getRequestDispatcher("/Register.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("Profile");
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

package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.UserDao;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceInterface service=new UserServiceImp();
		HttpSession session=request.getSession(false); 
		UserModel userObj=(UserModel)session.getAttribute("user");
		request.setAttribute("user", userObj); // first pass user object with request
		
		List<AddressModel> addModelObj= service.getAllUserAddresses(userObj.getId());
		request.setAttribute("addresses", addModelObj); // pass perticular  user's  addresses with request
		
		request.getRequestDispatcher("/profile.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

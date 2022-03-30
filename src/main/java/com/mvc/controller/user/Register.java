package com.mvc.controller.user;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.UserDao;
import com.mvc.model.UserModel;
import com.mvc.util.EncryDecryAES;
import com.mvc.model.AddressModel;
/**
 * Servlet implementation class Register
 */
@MultipartConfig
//@MultipartConfig(maxFileSize = 16177215)	// upload file's size up to 16MB
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();
				UserModel userObj=new UserModel();
				AddressModel addModel;
				List<AddressModel> addArrList=new ArrayList<AddressModel>();
				/*String email=request.getParameter("email");
				if(UserDao.checkUserAvailability(email)) {
					out.println("User exist.");
				}
				else {
					out.println("User not exist.");
				}*/
				// Take all values from dom and set it in model
				userObj.setName(request.getParameter("name"));
				userObj.setEmail(request.getParameter("email"));
				userObj.setMobile(request.getParameter("mobile"));
				userObj.setBirthdate(request.getParameter("birthdate"));
				userObj.setHobby(request.getParameter("hobby"));
				userObj.setGender(request.getParameter("gender"));
				userObj.setPassword(request.getParameter("password"));
				userObj.setCpassword(request.getParameter("cpassword"));
				userObj.setDecryPass(EncryDecryAES.encrypt(request.getParameter("password")));
				userObj.setImage(request.getPart("image").getInputStream());
				String address[]=request.getParameterValues("address");
				String city[]=request.getParameterValues("city");
				String state[]=request.getParameterValues("state");
				String pincode[]=request.getParameterValues("pincode");
				for(int i =0 ; i < address.length ; i++) {
					addModel=new AddressModel();
					addModel.setAddress(address[i]);
					addModel.setCity(city[i]);
					addModel.setState(state[i]);
					addModel.setPincode(pincode[i]);
					addArrList.add(addModel);
				}
				if(!UserDao.insertData(userObj)) {
					UserDao.insertAddress(addArrList,userObj.getEmail());
					response.sendRedirect("index.jsp");
					
					
				}
				/*
				if(RegisterService.validateFields(userObj)) {
					response.sendRedirect("Login");
				}
				else {
					out.print("Not Done");
				}*/
				 // insert all data into user table
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

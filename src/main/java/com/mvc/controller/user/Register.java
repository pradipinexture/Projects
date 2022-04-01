package com.mvc.controller.user;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
				//Make a needable objects
				UserModel userObj=new UserModel();
				AddressModel addModel;
				List<AddressModel> addArrList=new ArrayList<AddressModel>();
				UserServiceInterface service=new UserServiceImp();
		
				// set all datas into usermodel and addressmodel
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
				// take one address then set into addressmodel and then pass that object in arraylist for number of addresses
				for(int i =0 ; i < address.length ; i++) {
					addModel=new AddressModel();
					addModel.setAddress(address[i]);
					addModel.setCity(city[i]);
					addModel.setState(state[i]);
					addModel.setPincode(pincode[i]);
					addArrList.add(addModel);
				}
				
				// Now call we call service method for validating and inserting data
				if(service.insertData(userObj,addArrList)) {
					response.sendRedirect("index.jsp");	
				}
				
				else {
					response.sendRedirect("Register.jsp");	
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

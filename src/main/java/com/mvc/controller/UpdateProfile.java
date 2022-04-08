package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mvc.dao.UserDao;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;
import com.mvc.util.EncryDecryAES;

/**
 * Servlet implementation class UpdateProfile
 */
@MultipartConfig
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Make a needable objects
		UserModel userObj=new UserModel();
		AddressModel addModel;
		List<AddressModel> insertData=new ArrayList<AddressModel>();
		List<AddressModel> updateData=new ArrayList<AddressModel>();
		UserServiceInterface service=new UserServiceImp();
		UserDao u=new UserDao();
		
					
//						
//					UserModel userObjec=(UserModel) (session.getAttribute("user"));
//					if(userObjec.getRoletype()== 1) {
//						response.sendRedirect("AdminHome");
//					}
//					else {
//						response.sendRedirect("Profile");
//					}	
//				}
				
		
		
		
		try {
			int id=Integer.parseInt(request.getParameter("userId"));
			userObj.setId(id);
			userObj.setName(request.getParameter("name"));
			userObj.setEmail(request.getParameter("email"));
			userObj.setMobile(request.getParameter("mobile"));
			userObj.setBirthdate(request.getParameter("birthdate"));
			userObj.setHobby(request.getParameter("hobby"));
			userObj.setGender(request.getParameter("gender"));
			userObj.setPassword(request.getParameter("password"));
			userObj.setCpassword(request.getParameter("cpassword"));
			userObj.setDecryPass(EncryDecryAES.encrypt(request.getParameter("password")));
			
			if(request.getPart("image").getSize() <= 0) {
				System.out.println("Image is not present");
			}
			else {
				//userObj.setImage(request.getPart("image").getInputStream());
				System.out.println("Image is  present");
			}
			
			String address[]=request.getParameterValues("address");
			String city[]=request.getParameterValues("city");
			String state[]=request.getParameterValues("state");
			String pincode[]=request.getParameterValues("pincode");
			String status[]=request.getParameterValues("newOldStatus");
			// take one address then set into addressmodel and then pass that object in arraylist for number of addresses
			for(int i =0 ; i < status.length ; i++) {

				addModel=new AddressModel();
				if(status[i].equals("new")) { // for update
					addModel.setAddress(address[i]);
					addModel.setCity(city[i]);
					addModel.setState(state[i]);
					addModel.setPincode(pincode[i]);
					insertData.add(addModel);
				}
				
				else { // for insert 
					addModel.setId(Integer.parseInt(status[i]));
					addModel.setAddress(address[i]);
					addModel.setCity(city[i]);
					addModel.setState(state[i]);
					addModel.setPincode(pincode[i]);
					updateData.add(addModel);
				}

			}
			if(service.updateUserData(userObj,insertData,updateData)) {
				HttpSession session=request.getSession(true);
				UserModel userSession=(UserModel) (session.getAttribute("user"));
				// Below condition for session update after all detail get update
				if(userSession.getId() == id) {
					System.out.println("Session user updated");
					UserModel userObj1=service.getUserDetail(userSession.getEmail());
					session.setAttribute("user",userObj1); // user object save in session
					response.sendRedirect("Profile");
				}
				else {
					response.sendRedirect("AdminHome");
				}
				

			}
			else {	
				System.out.println("User not updated");
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

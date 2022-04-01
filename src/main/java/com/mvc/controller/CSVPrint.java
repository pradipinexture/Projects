package com.mvc.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.UserDao;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

/**
 * Servlet implementation class CSVPrint
 */
public class CSVPrint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSVPrint() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String filename = "C:\\csv\\users.csv";
				try
				{
				FileWriter fw = new FileWriter(filename);
				fw.append("ID,Name,Mobile Number,Email,Hobby,Gender,Birthdate,Address,City,State,Pincode\n");
				
				
				List<UserModel> userModelObj= UserDao.getAllUsers();
				for(int i=0;i<userModelObj.size();i++){
					fw.append("\n"+userModelObj.get(i).getId()+','+userModelObj.get(i).getName()+','+userModelObj.get(i).getMobile()+','+userModelObj.get(i).getEmail()+','+userModelObj.get(i).getHobby()+','+userModelObj.get(i).getGender()+','+userModelObj.get(i).getBirthdate()+',');
					List<AddressModel> addModelObj= new ArrayList<AddressModel>(UserDao.getAllUserAddresses(userModelObj.get(i).getId()));
					for(int j=0;j<addModelObj.size();j++){
						fw.append(addModelObj.get(j).getAddress().replace(',', ' ')+','+addModelObj.get(j).getCity()+','+addModelObj.get(j).getState()+','+addModelObj.get(j).getPincode()+','+"\n,,,,,,,");
					}	
				}
				fw.flush();
				fw.close();
				response.sendRedirect("AdminHome");
				} catch (Exception e) {}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

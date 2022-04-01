package com.mvc.controller;
import com.mvc.util.CSVPrinting;
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
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

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
		CSVPrinting csvObj=new CSVPrinting();	
		if(csvObj.printCSV()) {
			response.sendRedirect("AdminHome");
		}
		else {
			System.out.println("There is some error");
			response.sendRedirect("AdminHome");
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

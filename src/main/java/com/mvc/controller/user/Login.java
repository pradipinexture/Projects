package com.mvc.controller.user;
import com.mvc.util.EncryDecryAES;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.UserDao;
import com.mvc.dao.UserDaoInterface;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); // for printing	
		// Service class object for call dao method
		UserServiceInterface service =new UserServiceImp();
		// Take data from jsp page
		String email=request.getParameter("email");
		String password=request.getParameter("password");


		UserDaoInterface userDao=new UserDao();
		String decryPassword=EncryDecryAES.encrypt(password);
		request.getRequestDispatcher("index.jsp").include(request, response); 
		if(service.loginCheck(email, decryPassword)) {

			UserModel userObj=service.getUserDetail(email);

			HttpSession session=request.getSession(true);
			session.setAttribute("user",userObj); // user object save in session

			UserModel userObjec=(UserModel) (session.getAttribute("user"));
			if(userObjec.getRoletype()== 1) {
				response.sendRedirect("AdminHome");
			}
			else {
				response.sendRedirect("Profile");
			}	
		}
		else {
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

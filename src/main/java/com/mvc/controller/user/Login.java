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
		
		
		
			//if(email != null && password != null) {
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
						response.sendRedirect("profile.jsp");
					}	
				}
				else {
					
					out.println("<div style='color:red;text-align:center'>!! Please enter valid data</div>");
				}
		//	}
			
//				if(service.loginCheck(email, password)) {
		//String password=EncryDecryAES.encrypt();
//					UserModel userObj=service.getUserDetail(email);
//					HttpSession session=request.getSession(true);
//					session.setAttribute("user",userObj); // user object save in session
//					UserModel userObjec=(UserModel) (session.getAttribute("user"));
//					if(userObjec.getRoletype()== 1) {
//						response.sendRedirect("AdminHome");
//					}
//					else {
//						response.sendRedirect("profile.jsp");
//					}	
//				}
//				else {
//					out.println("<div style='color:red;text-align:center'>!! Please enter valid data</div>");
//				}
//			}
		}
		//else if(session1.getAttribute("admin") != null) {
		//	response.sendRedirect("AdminHome");
	//	}
//		else {
//			out.print("Session is not active : "+session1);
//			//response.sendRedirect("profile.jsp");
//		}
		
//		HttpSession session1=request.getSession(false); 
//		UserServiceInterface service =new UserServiceImp();
//		
//		response.setContentType("text/html");  
//		PrintWriter out = response.getWriter(); // for printing	
//		
//		out.println("THis is login page");
//}
//		String email=request.getParameter("email");
//		String password=request.getParameter("password");
//		
//		
//		request.getRequestDispatcher("index.jsp").include(request, response); 
//		UserModel userObjec=(UserModel) (session1.getAttribute("user")).;
//		if(userObjec. != null) {
//			out.print("Session active");
//		}
//		else{
//			if(!email.isEmpty() && !password.isEmpty()) {
//				String encryPassword=EncryDecryAES.encrypt(password);
//				if(service.loginCheck(email, password)) {
//					UserModel userObj=service.getUserDetail(email);
//					HttpSession session=request.getSession(true);
//					session.setAttribute("user",userObj);
//					if(userObj.getRoletype() == 1) {
//						response.sendRedirect("AdminHome");
//					}
//					else {
//						response.sendRedirect("profile.jsp");
//					}	
//				}
//				out.print("Session not active");
//			}
//			else {
//				out.print("null");
//			}
//			
//}
//			if(email != null && password != null) {
//				if(service.loginCheck(email, password)) {
//					UserModel userObj=service.getUserDetail(email);
//					HttpSession session=request.getSession(true);
//					session.setAttribute("user",userObj);
//					if(userObj.getRoletype() == 1) {
//						response.sendRedirect("AdminHome");
//					}
//					else {
//						response.sendRedirect("profile.jsp");
//					}	
//				}
//				else {
//					out.println("<div style='color:red;text-align:center'>!! Please enter valid data</div>");
//				}
//			}
		
		
	/*	else if(userObjec.getRoletype() != 0) {
			response.sendRedirect("AdminHome");
		}
		else {
			response.sendRedirect("profile.jsp");
		}*/

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

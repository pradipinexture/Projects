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
		HttpSession session1=request.getSession(false);  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); // for printing	
		String email=request.getParameter("email");
		String password=EncryDecryAES.encrypt(request.getParameter("password"));
		request.getRequestDispatcher("index.jsp").include(request, response); 
		
		if(session1.getAttribute("user") == null && session1.getAttribute("admin") == null){//|| session1.getAttribute("email").equals("")) {
			UserDao e =new UserDao();
			if(email != null && password != null) {
				if(e.emailPasswordCheck(email, password)) {
					UserModel userObj=UserDao.getUserDetail(email);
					HttpSession session=request.getSession(true);
					
					if(UserDao.adminCheck(email)) {
						
						session.setAttribute("admin",userObj);
						response.sendRedirect("adminhome.jsp");
					}
					else {
						session.setAttribute("user",userObj); // user object save in session
						response.sendRedirect("profile.jsp");
					}	
				}
				else {
					out.println("<div style='color:red;text-align:center'>!! Please enter valid data</div>");
				}
			}
		}
		else if(session1.getAttribute("admin") != null) {
			response.sendRedirect("adminhome.jsp");
		}
		else {
			response.sendRedirect("profile.jsp");
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

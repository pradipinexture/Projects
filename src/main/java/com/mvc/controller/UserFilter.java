package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;
import com.mvc.util.EncryDecryAES;

/**
 * Servlet Filter implementation class UserFilter
 */
public class UserFilter  implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public UserFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		chain.doFilter(request, response);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path=httpRequest.getServletPath();
		((HttpServletResponse) response).setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
		HttpSession session=httpRequest.getSession(false);
		UserModel userObjec=null;
		boolean isOtherPage=path.startsWith("/Register") || path.startsWith("/index") || path.startsWith("/Login") || path.startsWith("/forgot");
		if(session != null) {
			userObjec=(UserModel) (session.getAttribute("user"));
		}
		
		if(userObjec  !=null) {
        	 
        	 if(path.startsWith("/index") || path.startsWith("/Login") || path.startsWith("/forgot")) {
        		 ((HttpServletResponse) response).sendRedirect("Profile");
            }
         	else {
         		chain.doFilter(request, response);
         	}
        }
        else{
        	if(isOtherPage) {
        		chain.doFilter(request, response);
           }
        	else {
        		((HttpServletResponse) response).sendRedirect("index.jsp");
        	}
        }		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

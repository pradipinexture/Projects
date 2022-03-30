<%@ page import="com.mvc.dao.UserDao" %>
	<%
		
		if(UserDao.checkUserAvailability(request.getParameter("cuEmail"))){
			out.print("!! Email already exist");
		}
	%>
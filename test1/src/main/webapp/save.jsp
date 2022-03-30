<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="java.sql.*,java.util.*"%>
<%
String first_name=request.getParameter("fname");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/pradip", "root", "99097@Pradip");
Statement st=conn.createStatement();

if(st.executeUpdate("insert into try(fname)values('"+first_name+"')") != 0){
	out.println("Data");
}
else{
	out.println("Not");
}
	


}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
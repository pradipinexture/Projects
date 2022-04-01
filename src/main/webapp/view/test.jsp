<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%
Blob image = null;
Connection con = null;
byte[] imgData = null;
Statement stmt = null;
ResultSet rs = null;
try {

	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql:// localhost:3306/project", "root", "99097@Pradip");
	stmt = con.createStatement();
	rs = stmt.executeQuery("select image from user where id = 84");
	if (rs.next()) {
		
	//	image = rs.getBlob(1);
		//imgData = image.getBytes(1, (int) image.length());
	} 
	else {
		out.println("Display Blob Example");
		out.println("image not found for given id>");
		return;
	}
	// display the image
	//response.setContentType("image/jpg");
	//OutputStream o = response.getOutputStream();
	//o.write(imgData);
	//o.flush();
	//o.close();
} catch (Exception e) {}
%>
<td><img src="<%=rs.getString(1) %>" height="100px" width="100px"></td>

sdfghfh
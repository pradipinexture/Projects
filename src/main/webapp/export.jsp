<%@ page import="java.io.*,java.sql.*,java.util.*"%>
<%@ page import="com.mvc.dao.UserDao" %>
<%@ page import="com.mvc.model.AddressModel" %>
<%@ page import="com.mvc.model.UserModel" %>

<html>
<body>
	<% 
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
		response.sendRedirect("adminhome.jsp");
		} catch (Exception e) {}
	%>

</body>
</html>
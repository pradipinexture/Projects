<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mvc.dao.UserDao" %>
<%@ page import="com.mvc.model.UserModel" %>
<%@ page import="java.util.*" %>
<%
	UserModel userObj=null;
	if(session.getAttribute("admin") == null){
		response.sendRedirect("index.jsp");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- 1.Library -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
			<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">
<!-- 2.custom file -->
<link href="assets/css/custom.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	.form-section2{
		height: auto;
		min-height: 510px;
	}
</style>

<script type="text/javascript" src="assets/javascript/jquery-3.6.0.min.js"></script>
</head>
<body>	
	
	<jsp:include page="header.jsp"/>
	<%
		List<UserModel> addModelObj= UserDao.getAllUsers();
		if(!addModelObj.isEmpty()){
	
	%>
	<section class="form-section2">
		<table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Name</th>
		      <th scope="col">Email</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Edit</th>
		      <th scope="col">Delete</th>
		      
		    </tr>
		  </thead>
		  <tbody>
		  	<%
				for(int i=0;i<addModelObj.size();i++){
			%>
		    <tr class="row">
		      <th scope="row"><%=i+1 %></th>
		      <td><a href="#"><%=addModelObj.get(i).getName() %></a></td>
		      <td><%=addModelObj.get(i).getEmail() %></td>
		      <td><%=addModelObj.get(i).getGender() %></td>
		      <td><button type="button" class="btn btn-success">Edit</button></td>
		      <td><a id='<%=addModelObj.get(i).getEmail() %>' class="btn btn-danger" >Delete</a></td>
		    </tr>
		    <%}}else{out.print("!! Sorry Users are not avilable.");}%>
		    <tr class="row">
		      <td><a class="btn btn-success" href="CSVPrint">Generate CSV File</a></td>
		    </tr>
		  </tbody>
			</table>

	</section>
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>

	<script>
	$(document).ready(function() {
		
		$(function() {
			$("#table_id").dataTable();
		});
		// crating new click event for save button
		$(".btn").click(function() {
			var cuEmail=$(this).attr('id');
				$.ajax({
				url: "DelUser",
				type: "post",
				data: {
					cuEmail : cuEmail,
				},
				success : function(data){}
				});
				$(this).parents(".row").animate("fast").animate({
			        opacity: "hide"
			    }, "slow");
		});
	});
</script>
	
</body>
</html>
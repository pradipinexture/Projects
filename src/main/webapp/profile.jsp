<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mvc.dao.UserDao" %>
<%@ page import="com.mvc.model.UserModel" %>
<%@ page import="com.mvc.model.AddressModel" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<!-- Css File links -->

<!-- 1.Library -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<!-- 2.custom file -->
<link href="assets/css/custom.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.fields *, .a-field * {
	display: inline-block;
}

.fields, .p-address, .personal h4 {
	margin: 15px;
}

.p-address .a-field {
	margin-left: 25px;
}

.personal .fields {
	margin-left: 40px;
}

label {
	font-size: 16px;
	color: blue;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- Banner section -->
	<aside></aside>
	<!-- Main section for other content  -->
	<%
	UserModel userObj=null;
	if(session.getAttribute("admin") != null){
		userObj=(UserModel)session.getAttribute("admin");
	}
	else if(session.getAttribute("user") != null){
		userObj=(UserModel)session.getAttribute("user");
	}
	else{
		response.sendRedirect("index.jsp");
	}
	%>
	
	<main>
	
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<div class="personal">
							<h4>Personal Information :</h4>
							<div class="fields">
								<label>Name : </label>
								<div class="fields-value"><%=userObj.getName() %></div>
							</div>
							<div class="fields">
								<label>Mobile : </label>
								<div class="fields-value"><%=userObj.getMobile() %></div>
							</div>
							<div class="fields">
								<label>Email : </label>
								<div class="fields-value"><%=userObj.getEmail() %></div>
							</div>
							<div class="fields">
								<label>Gender : </label>
								<div class="fields-value"><%=userObj.getGender() %></div>
							</div>
							<div class="fields">
								<label>Birthdate : </label>
								<div class="fields-value"><%=userObj.getBirthdate() %></div>
							</div>
							<div class="fields">
								<label>Hobby : </label>
								<div class="fields-value"><%=userObj.getHobby() %></div>
							</div>
						</div>
						<%
							UserDao userDao=new UserDao();
							List<AddressModel> addModelObj= userDao.getAllUserAddresses(userObj.getId());
							for(int i=0;i<addModelObj.size();i++){
						%>
						<div class="p-addresses">
							<div class="p-address">
								<h4>Address <%=i+1 %> :</h4>
								<div class="a-field">
									<label>Address : </label>
									<div class="fields-value"><%=addModelObj.get(i).getAddress() %></div>
								</div>
								<div class="a-field">
									<label>City : </label>
									<div class="fields-value"><%=addModelObj.get(i).getCity() %></div>
								</div>
								<div class="a-field">
									<label>State : </label>
									<div class="fields-value"><%=addModelObj.get(i).getState() %></div>
								</div>
								<div class="a-field">
									<label>Pincode : </label>
									<div class="fields-value"><%=addModelObj.get(i).getPincode() %></div>
								</div>
							</div>
						
						</div>
						<% }%>
						<form id="data-form" action="Register.jsp" method="post">
							<div class="form-button">
								<input id="data" type="submit" value="Update Profile">
							</div>
						</form>
					</section>
				</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="footer.jsp" />

	<!-- Javascript file links -->

	<!-- 1.Already created file -->
	<script type="text/javascript"
		src="assets/javascript/jquery-3.6.0.min.js"></script>
	<!-- 2. Custom file -->
	<script type="text/javascript" src="assets/javascript/custom.js">
	
	
	</script>


</body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.mvc.dao.UserDao" %>
<%@ page import="com.mvc.model.UserModel" %>
<%@ page import="com.mvc.model.AddressModel" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
#profile-img{
	height:10%;
	width:20%;
	border: 1px solid black;
	border-radius:50%;
	margin-left:37%; 
}
</style>

</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- Banner section -->
	<aside></aside>
	<!-- Main section for other content  -->

	
	<main>
	
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<div class="personal">
					
							<h4>Personal Information :</h4>
							<div class="fields">
									<!-- assets/images/Image.png -->
									<img id="profile-img" alt="Profile Image" src="Test">
								
							</div>
							<div class="fields">
								<label>Name : </label>
								<div class="fields-value"><c:out value="${user.name}" /></div>
							</div>
							<div class="fields">
								<label>Mobile : </label>
								<div class="fields-value"><c:out value="${user.mobile}" /></div>
							</div>
							<div class="fields">
								<label>Email : </label>
								<div class="fields-value"><c:out value="${user.email}" /></div>
							</div>
							<div class="fields">
								<label>Gender : </label>
								<div class="fields-value"><c:out value="${user.gender}" /></div>
							</div>
							<div class="fields">
								<label>Birthdate : </label>
								<div class="fields-value"><c:out value="${user.birthdate}" /></div>
							</div>
							<div class="fields">
								<label>Hobby : </label>
								<div class="fields-value"><c:out value="${user.hobby}" /></div>
							</div>
						</div>
		<c:choose>
			<c:when test="${empty addresses}">
				<p>Address not available.</p>
			</c:when>
			<c:otherwise>
						<c:forEach var="addr" items="${addresses}">	
							<div class="p-addresses">
								<div class="p-address">
									<h4>Address :</h4>
									<div class="a-field">
										<label>Address : </label>
										<div class="fields-value"><c:out value="${addr.address}" /></div>
									</div>
									<div class="a-field">
										<label>City : </label>
										<div class="fields-value"><c:out value="${addr.city}" /></div>
									</div>
									<div class="a-field">
										<label>State : </label>
										<div class="fields-value"><c:out value="${addr.state}" /></div>
									</div>
									<div class="a-field">
										<label>Pincode : </label>
										<div class="fields-value"><c:out value="${addr.pincode}" /></div>
									</div>
								</div>
							</div>					
							
						</c:forEach>
			</c:otherwise>
		</c:choose>
							<div class="form-button">
								<a id="data" href="EditProfile?editEmail=<c:out value="${user.email}"/>&editId=<c:out value="${user.id}"/>"  class="btn btn-success">Edit</a>
							</div>					
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

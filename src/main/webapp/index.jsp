<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="assets/javascript/jquery-3.6.0.min.js"></script>

</head>

<body>
	<%
	if(session.getAttribute("admin") != null){
		response.sendRedirect("adminhome.jsp");
	}
	else if(session.getAttribute("user") != null){
		response.sendRedirect("profile.jsp");
	}
	%>
	<!-- Banner section -->
	<aside></aside>

	<!-- Main section for other content -->
	<main>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<form id="login-form" action="Login" method="post">
							<!-- Below div for form heading -->
							<div class="form-heading">
								<h2>Login Page</h2>
							</div>

							<!-- Below div for email of user -->
							<div class="form-group1">
								<label for="">Email :</label> <input type="email"
									class="form-control" id="email" name="email"
									placeholder="Please enter valid email">
								<p class="field-error" id="email-error"></p>

							</div>

							<!-- Below div for password of user -->
							<div class="form-group1">
								<label for="password">Password :</label> <input type="password"
									class="form-control" id="password" name="password"
									placeholder="Please enter Password">
								<p class="field-error" id="password-error"></p>
							</div>
							
							<div class="form-group1">
								<a href="forgot.jsp">Forgot password ? </a>
							</div>
							
							<div class="form-button">
								<input id="data" type="submit"  value="submit">
							</div>
							
							<div class="form-group">
								<label for="Register.jsp">Don't have an account ? </label>
								<a href="Register.jsp">Register  </a>
							</div>
							
						</form>
						<!-- Below div for button  -->
						
					</section>
				</div>
			</div>
		</div>
	</main>


	<!-- Javascript file links -->

	<!-- 1.Already created file -->
	<!-- 2. Custom file <script type="text/javascript" src="assets/javascript/custom.js">-->
	
	
 
 
	
	

</body>

</html>
	
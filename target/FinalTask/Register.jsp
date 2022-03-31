<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Register Page</title>
<!-- Css File links -->

<!-- 1.Library -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<!-- 2.custom file -->
<link href="assets/css/custom.css" type="text/css" rel="stylesheet" />

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
<main>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<form  action="Register" id="register-form" method="post" enctype='multipart/form-data'>
							<!-- Below div for form heading -->
							<div class="form-heading">
								<h2>Register Page</h2>
							</div>

							<!-- Below div for name of user -->
							<div class="form-group">
								<label for="name">Name :</label> <input type="text"
									class="form-control" id="name"  name="name" placeholder="Please enter name" >
								<p class="field-error" id="name-error"></p>
							</div>


							<!-- Below div for mobile of user -->
							<div class="form-group">
								<label for="mobile">Mobile :</label> <input type="number"
									class="form-control" id="mobile" name="mobile"
									placeholder="Please enter mobile number" >
								<p class="field-error" id="mobile-error"></p>
							</div>
							<!-- Below div for email of user -->
							<div class="form-group">
								<label for="">Email :</label> <input type="text"
									class="form-control" id="email" name="email"
									placeholder="Please enter valid email"  >
								<p class="field-error" id="email-error"></p>

							</div>

							<!-- Below div for url of user -->
							<div class="form-group">
								<label for="date">Birth Date :</label> <input type="date"
									class="form-control" id="birthdate" name="birthdate"
									placeholder="Please enter birthdate" >
								<p class="field-error" id="birthdate-error"></p>
							</div>


							<!-- Below div for gender of user -->
							<div class="form-group">
								<label for="">Gender :</label>
								<div class="radio">
									<label> <input type="radio" name="gender" id="male"
										value="male"  > Male
									</label> <label> <input type="radio" name="gender" id="female"
										value="female" > Female
									</label> <label> <input type="radio" name="gender" id="other"
										value="other" > other
									</label>
								</div>
								<p class="field-error" id="radio-error"></p>
							</div>
							<!-- Below div for Hobby of user -->
							<div class="form-group">
								<label for="hobby">Hobby :</label> <select class="form-control"
									id="hobby" name="hobby" >
									<option value="not">Select Hobby</option>
									<option value="cricket">Cricket</option>
									<option value="travel">Travelling</option>
									<option value="read">Reding Books</option>
									<option value="thing">Learning New Things</option>
								</select>
								<p class="field-error" id="drop-error"></p>
							</div>
							<!-- Below div for Address of user -->
							<div class="addresses">
								<div class="form-group address-section">
									<label for="address">Address :</label>
									<textarea class="form-control" rows="3" id="address" placeholder="Please enter Address" name="address" ></textarea>
									<div class="add-style">
										<span>
											<select class="form-control"
												id="city" name="city" >
												<option value="not">Select City</option>
												<option value="botad">Botad</option>
												<option value="ahmedabad">Ahmedabad</option>
												<option value="baroda">Baroda</option>
												<option value="rajkot">Rajkot</option>
											</select>
										</span>
										
										<span>
											<select class="form-control"
												id="state" name="state" >
												<option value="not">Select State</option>
												<option value="gujarat">Gujarat</option>
												<option value="rajasthan">Rajasthan</option>
												<option value="madhyapradesh">Madhyapradesh</option>
											</select>	
										</span>
										<span>
											<input type="number" class="form-control" id="pincode" name="pincode" placeholder="Please enter pincode" >
										</span>
										<span><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></span>
									</div>
									<p class="field-error" id="address-error"></p>
								</div>
							</div>
							
							<div class="form-group">
 								<p class="field-error" id="address-max-error"></p>
							</div>
							<div class="form-button">
								<button class="btn btn-primary list_add_button" type="button">+</button>
							</div>
							<!-- Below div for password of user -->
							<div class="form-group">
								<label for="password">Password :</label> <input type="password" name="password"
									class="form-control" id="password"
									placeholder="Please enter Password" >
								<p class="field-error" id="password-error"></p>
							</div>

							<!-- Below div for conform password of user -->
							<div class="form-group">
								<label for="c-password">Confirm Password :</label> <input
									type="password" class="form-control" id="c-password" name="cpassword"
									placeholder="Please enter confirm Password" >
								<p class="field-error" id="cpassword-error"></p>
							</div>
							<!-- Below div for image input of user -->
							<div class="form-group demo-image">
								<label for="image">File input</label> <input type="file" name="image"
									id="imageclick" accept="image/png,image/jpg,image/jpeg"  >
								<p class="field-error" id="image-error"></p>
							</div>
							
							<div class="form-button">
								<input id="data" type="submit" value="submit">
							</div>
							
							<div class="form-group">
								<label for="">Already have an account ? </label>
								<a href="index.jsp">Login</a>
							</div>
						</form>
					</section>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="footer.jsp"/>
	<!-- Javascript file links -->

	<!-- 1.Already created file -->
	<script type="text/javascript" src="assets/javascript/jquery-3.6.0.min.js"></script>
	<!-- 2. Custom file <script type="text/javascript" src="assets/javascript/custom.js"></script>-->
	<script type="text/javascript">
		$('#email').blur(function(){
			
			var cuEmail=$(this).val();
				
				$.ajax({
				url: "DelUser",
				type: "post",
				data: {
					cuEmail : cuEmail,
					isCheck : "email",
				      },
				success : function(data){
					if(data != null){
						$("#email-error").text(data);
					}
				}
				});
		
		});
	
		var x = 1; 
		$('.list_add_button').click(function() {
			    if(x++ < 5){ 
			         var list_fieldHTML = '<div class="form-group"><label for="address'+x+'">Address '+x+' :</label><textarea class="form-control" rows="3" id="address" placeholder="Please enter Address" name="address"></textarea>'+
											'<div class="add-style"><span><select class="form-control"id="city" name="city" required><option value="not">Select City</option>'+
											'<option value="botad">Botad</option><option value="ahmedabad">Ahmedabad</option><option value="baroda">Baroda</option>'+
											'<option value="rajkot">Rajkot</option></select></span><span><select class="form-control"id="state" name="state" required>'+
											'<option value="not">Select State</option><option value="gujarat">Gujarat</option><option value="rajasthan">Rajasthan</option>'+
											'<option value="madhyapradesh">Madhyapradesh</option></select></span><span>'+
											'<input type="number" class="form-control" id="pincode" name="pincode" placeholder="Please enter pincode" required></span><span><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></span></div></div>';
			      $('.addresses').append(list_fieldHTML); //Add field html
			    }
	
	     });
	    
		/* Below function for remove address field from dom and one address can not delelte */
	     $('.addresses').on('click', '.list_remove_button', function() {
			if(x > 1){
				$(this).parent().parent().parent().remove(); //Remove field html
		           x--;
			}
	     });
	</script>
</body>

</html>
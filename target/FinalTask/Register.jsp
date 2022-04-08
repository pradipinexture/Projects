<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script type="text/javascript"
		src="assets/javascript/jquery-3.6.0.min.js"></script>
</head>

<body>

	<!-- Banner section -->
	<aside></aside>
	<c:set var = "formAction" scope = "session" value = "Register"></c:set>
	<c:if test="${sUser.roletype != null}">
		<jsp:include page="header.jsp" />
		<c:set var = "formAction" scope = "session" value = "UpdateProfile"></c:set>
	</c:if>
	<main>
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<section class="form-section">
						<form action="<c:out value = "${formAction}"/>" id="register-form" method="POST" enctype='multipart/form-data'>
							<!-- Below div for form heading -->
							<div class="form-heading">
								<h2>Register Page</h2>
							</div>
							<input type='hidden' name='userId' value='<c:out value="${sUser.id}" />'>
							<!-- Below div for name of user -->
							<div class="form-group">
								<label for="name">Name :</label> <input type="text"
									class="form-control" id="name" name="name"
									placeholder="Please enter name"
									value='<c:out value="${sUser.name}" />'>
								<p class="field-error" id="name-error"></p>
							</div>

							
							<!-- Below div for mobile of user -->
							<div class="form-group">
								<label for="mobile">Mobile :</label> <input type="number"
									class="form-control" id="mobile" name="mobile"
									placeholder="Please enter mobile number"
									value='<c:out value="${sUser.mobile}" />'>
								<p class="field-error" id="mobile-error"></p>
							</div>
							<!-- Below div for email of user -->
							<div class="form-group">
								<label for="">Email :</label> <input type="text"
									class="form-control" id="email" name="email"
									placeholder="Please enter valid email"
									value='<c:out value="${sUser.email}" />'>
								<p class="field-error" id="email-error"></p>

							</div>

							<!-- Below div for url of user -->
							<div class="form-group">
								<label for="date">Birth Date :</label> <input type="date"
									class="form-control" id="birthdate" name="birthdate"
									placeholder="Please enter birthdate"
									value='<c:out value="${sUser.birthdate}" />'>
								<p class="field-error" id="birthdate-error"></p>
							</div>

	
							<!-- Below div for gender of user -->
							<div class="form-group">
								<label for="">Gender :</label>
								<div class="radio">
									<label> <input type="radio" name="gender" id="male"
										value="male"> Male
									</label> <label> <input type="radio" name="gender" id="female"
										value="female"> Female
									</label> <label> <input type="radio" name="gender" id="other"
										value="other"> other
									</label>
								</div>
								<p class="field-error" id="radio-error"></p>
							</div>
							<!-- Below div for Hobby of user -->
							<div class="form-group">
								<label for="hobby">Hobby :</label> <select class="form-control"
									id="hobby" name="hobby">
									<option value="not">Select Hobby</option>
									<option value="cricket">Cricket</option>
									<option value="travel">Travelling</option>
									<option value="read">Reding Books</option>
									<option value="thing">Learning New Things</option>
								</select>
								<p class="field-error" id="drop-error"></p>
							</div>

							<c:choose>
								<c:when test="${empty addresses}">
									<div class="addresses">
										<div class="form-group address-section">
											<label for="address">Address :</label>
											<textarea class="form-control" rows="3" class="address"
												placeholder="Please enter Address" name="address"></textarea>
											<div class="add-style">
												<span> <select class="form-control" id="city"
													name="city">
														<option value="not">Select City</option>
														<option value="botad">Botad</option>
														<option value="ahmedabad">Ahmedabad</option>
														<option value="baroda">Baroda</option>
														<option value="rajkot" >Rajkot</option>
												</select>
												</span> <span> <select class="form-control" id="state"
													name="state">
														<option value="not">Select State</option>
														<option value="gujarat">Gujarat</option>
														<option value="rajasthan">Rajasthan</option>
														<option value="madhyapradesh">Madhyapradesh</option>
												</select>
												</span> <span> <input type="number" class="form-control"
													id="pincode" name="pincode"
													placeholder="Please enter pincode">
												</span> <span><a href="javascript:void(0);"
													class="list_remove_button btn btn-danger">-</a></span>
											</div>
											<input type="hidden"  name="newOldStatus" value="new">
											<p class="field-error1" id="address-error"></p>
										</div>
									</div>
								</c:when>
								<c:otherwise>
								<div class="addresses">
									<c:forEach var="addr" items="${addresses}" varStatus="count"	>
										
											<div class="form-group address-section">
												<label for="address">Address :<c:out value="${count.index}" /></label>
												<textarea class="form-control" rows="3" 
													placeholder="Please enter Address" name="address"><c:out
														value="${addr.address}" /></textarea>
												<div class="add-style">
													<span> <select class="form-control" 
														name="city" id="city<c:out value="${count.index}" />">
															<option value="not">Select City</option>
															<option value="botad">Botad</option>
															<option value="ahmedabad">Ahmedabad</option>
															<option value="baroda">Baroda</option>
															<option value="rajkot">Rajkot</option>
													</select>
													</span> <span> <select class="form-control" 
														name="state" id="state<c:out value="${count.index}" />">
															<option value="not">Select State</option>
															<option value="gujarat">Gujarat</option>
															<option value="rajasthan">Rajasthan</option>
															<option value="madhyapradesh">Madhyapradesh</option>
													</select>
													</span> <span> <input type="number" class="form-control"
														 name="pincode"
														placeholder="Please enter pincode"
														value='<c:out value="${addr.pincode}" />'>
													</span> <span>
														<a href="javascript:void(0);"
														class="list_remove_button btn btn-danger">-</a>
													</span>
												</div>
												<input type='hidden' name='newOldStatus' value='<c:out value="${addr.id}" />'>
												<p class="field-error" id="address-error"></p>
											</div>
											<script type="text/javascript">
												$("#state<c:out value="${count.index}" /> ").val ("<c:out value="${addr.state}" />");
												$("#city<c:out value="${count.index}" />").val ("<c:out value="${addr.city}" />");
											</script>
									</c:forEach>
									</div>
								</c:otherwise>
							</c:choose>
							<div class="form-group">
								<p class="field-error" id="address-max-error"></p>
							</div>
							<div class="form-button">
								<button class="btn btn-primary list_add_button" type="button">+</button>
							</div>
							<!-- Below div for password of user -->
							<div class="form-group">
								<label for="password">Password :</label> <input type="password"
									name="password" class="form-control" id="password"
									placeholder="Please enter Password"
									value='<c:out value="${sUser.password}" />'>
								<p class="field-error" id="password-error"></p>
							</div>

							<!-- Below div for conform password of user -->
							<div class="form-group">
								<label for="c-password">Confirm Password :</label> <input
									type="password" class="form-control" id="c-password"
									name="cpassword" placeholder="Please enter confirm Password"
									value='<c:out value="${sUser.password}" />'>
								<p class="field-error" id="cpassword-error"></p>
							</div>
							<!-- Below div for image input of user -->
							<div class="form-group demo-image">
								<label for="image">File input</label> <input type="file"
									name="image" id="imageclick"
									accept="image/png,image/jpg,image/jpeg" value="	assets/images/Image.png">
								<p class="field-error" id="image-error"></p>
							</div>

							<div class="form-button">
								<c:choose>
									<c:when test="${sUser != null}">
										<input id="data" type="submit" value="Update">
									</c:when>
									<c:otherwise>
										<input id="data" type="submit" value="Submit">
									</c:otherwise>
								</c:choose>
							</div>


							<div class="form-group">
								<label for="">Already have an account ? </label> <a
									href="index.jsp">Login</a>
							</div>
						</form>
					</section>
				</div>
			</div>
		</div>

	</main>

	<jsp:include page="footer.jsp" />
	<!-- Javascript file links -->
	<script type="text/javascript"
		src="assets/javascript/jquery-3.6.0.min.js"></script>
	<!-- 1.Already created file -->

	<!-- 2. Custom file <script type="text/javascript" src="assets/javascript/custom.js"></script>-->

	<script type="text/javascript">
$(document).ready(function(){
	var x = 1;
	<c:if test="${sUser != null}">
		$("#<c:out value="${sUser.gender}" />").attr('checked', true);
		$("#hobby").val ("<c:out value="${sUser.hobby}" />");  
	</c:if>
	console.log($('[name="city"]').length);
	$('#email').blur(function() {
	
		var cuEmail = $(this).val();
	
		$.ajax({
			url : "DelUser",
			type : "post",
			data : {
				cuEmail : cuEmail,
				isCheck : "email",
			},
			success : function(data) {
				if (data != null) {
					$("#email-error").text(data);
				}
	
			}
		});
	
	});
	
	$('.list_add_button').on('click', function() {
		addAddress();
	});
	/* Below function for remove address field from dom and one address can not delelte */
	$('.addresses').on('click', '.list_remove_button', function() {
		console.log($(this).parent().parent().$("p").text="hello");
	});
	
	$('.addresses').on('click', '.list_remove_button', function() {
		removeAddress(this);
	});
	
	function addAddress(){
		var numOfAddress =$('[name="city"]').length;
		if (numOfAddress < 5) {
			var list_fieldHTML = '<div class="form-group"><label for="address'+numOfAddress+'">Address '
					+ numOfAddress
					+ ' :</label><textarea class="form-control" rows="3" class="address" placeholder="Please enter Address" name="address"></textarea>'
					+ '<div class="add-style"><span><select class="form-control"id="city'+numOfAddress+'" name="city" required><option value="not">Select City</option>'
					+ '<option value="botad">Botad</option><option value="ahmedabad">Ahmedabad</option><option value="baroda">Baroda</option>'
					+ '<option value="rajkot">Rajkot</option></select></span><span><select class="form-control"id="state'+numOfAddress+'" name="state" required>'
					+ '<option value="not">Select State</option><option value="gujarat">Gujarat</option><option value="rajasthan">Rajasthan</option>'
					+ '<option value="madhyapradesh">Madhyapradesh</option></select></span><span>'
					+ '<input type="number" class="form-control" id="pincode" name="pincode" placeholder="Please enter pincode" required></span><span><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></span></div><input type="hidden"  name="newOldStatus" value="new"><p class="field-error" id="address-error"></p></div>';
			$('.addresses').append(list_fieldHTML); //Add field html
		}
	}
	function removeAddress(element){
		if ($('[name="city"]').length > 1) {
			$(element).parent().parent().parent().remove(); //Remove field html
		}
	}
    $("#register-form").submit(function(e){
		if(!imageCheck($("#imageclick")[0],"#image-error") | !birthDateCheck() | !alphabets($("#name").val(), "#name-error") | 
				!numberCheck($("#mobile").val(),"#mobile-error") | !genderMust() |  !passwordCheck($("#password").val(),"#password-error")
				| !cPasswordCheck("#password","#c-password","#cpassword-error") | !dropCheck($("#hobby").val(),"#drop-error")
				| !emailCheck($("#email").val(),"#email-error") ){
			alert("Please fill all fields");
			console.log($("#image").value);
			e.preventDefault(e);
		}
    });

	/* Below function add preview image after user add some image */	
	$('#imageclick').change(function(){
	        const file = this.files[0];
	        
	        if(imageCheck($("#imageclick")[0],"#image-error")){
	        	if (file){
	  	          let reader = new FileReader();
	  	          reader.onload = function(event){
	  	        	  $(".demo-image").append($("<img id='imgPreview'  alt='Profile preview' width='250px' height='200px'/>"));
	  	            $('#imgPreview').attr('src', event.target.result);
	  	          }
	  	          reader.readAsDataURL(file);
	  	        }
	        }   
	        
	        
	 });
	$('#password').blur(function(){
		passwordCheck($("#password").val(),"#password-error");
	});
	$('#c-password').blur(function(){
		cPasswordCheck("#password","#c-password","#cpassword-error");
	});
	/* Below function for check name only contain alphabets only */	
	$('#name').blur(function(){
		alphabets($("#name").val(), "#name-error");
	});
	
	/* Below function for check name only contain digits only */
	$('#mobile').blur(function(){
		numberCheck($("#mobile").val(),"#mobile-error");
		
		
	});
	$('#email').blur(function(){
		emailCheck($("#email").val(),"#email-error");
		
	});
	  $('#hobby').blur(function(){
			dropCheck($(this[this.selectedIndex]).val(),"#drop-error");
		}); 
		$('#hobby').focus(function(){
			genderMust();
		});
		/* Below function check date like (1. date is below 31 (2. month is below 12  (3. year is less then current year  */	
		$('#birthdate').blur(function(){
			birthDateCheck();				
		});

		function addressCheck(){
			if($("#address").val().length !== 0){
				
				$("#address-error").text("");
			}
			else{
				$("#address-error").text("Please enter general address");
			}
		}
		function imageCheck(imgval,errorField){
			if(imgval.files.length === 0){
				$(errorField).text("Please select image");
				return false;	
			}
			else{
				$(errorField).text("");
				return true;
			}
		}
		  function dropCheck(dropval,errorField){
				if(dropval != "not"){
					$(errorField).text("");
					return true;					
				}
				else{
					$(errorField).text("Please select value");
					return false;	

				}
			}
		     
			function birthDateCheck(){
				var dt = new Date( $("#birthdate").val());
				console.log(dt.getFullYear());
				console.log(dt.getMonth());
				console.log(dt.getDate());
				if(dt.getFullYear() > 0){
					if( new Date().getFullYear() < dt.getFullYear() && dt.getMonth() <= 12 && dt.getDate() <= 31){
						$("#birthdate-error").text("Please enter valid date");
						return false;	
					}
					else{
						$("#birthdate-error").text("");
						return true;
					}
					
				}
				else{
					$("#birthdate-error").text("Please select date");
				}
				
			}
			
			function genderMust(){
				if($('input[name="gender"]:checked').length == 0){
					$("#radio-error").text("Please select gender");
					return false;	
				}
				else{
					$("#radio-error").text("");
					return true;
				}
			}
			function nullCheck(fValue,errorField){
				if(fValue.length == 0){
						$(errorField).text("Please enter field value.");
						return false;
				}	
				else{
						$(errorField).text("");
						return true;
						
				}
			}
			function alphabets(fValue,errorField){
				var regex = /^[A-Za-z ]+$/;		
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
						$(errorField).text("Please enter alphabets only");
						return false;
				}	
				else{
						return true;
				}
			}
			
			function numberCheck(fValue,errorField){
				var regex = /^[1-9]{1}[0-9]{9}$/;
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
					$(errorField).text("Please enter number only");
					return false;
				}	
				else{
						return true;
				}
			}
			
			function emailCheck(fValue,errorField){
				var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
					$(errorField).text("Please enter valid email.");
					return false;
				}	
				else{
					return true;
				}
			}
			function passwordCheck(fValue,errorField){
				var regex = /^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/;	
				if(nullCheck(fValue,errorField) && !regex.test(fValue)){
					$(errorField).text("Please enter valid password.");
					return false;
				}	
				else{
						return true;
				}
			}
			function cPasswordCheck(fValue,fValue2,errorField){
				if(nullCheck($(fValue2).val(),errorField) && $(fValue).val() != $(fValue2).val()){
					console.log(fValue2);
					$(errorField).text("Password and confirm password not same");
					return false;
				}	
				else{
						return true;
				}
			
			}
});

	</script>
</body>

</html>
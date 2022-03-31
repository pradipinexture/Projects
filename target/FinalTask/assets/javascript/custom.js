
$(document).ready(function(){
	
        $("#register-form").submit(function(e){
			if(!alphabets($("#name").val()) || !numberCheck($("#mobile").val()) || !genderMust() ||  !passwordCheck($("#password").val()) || !cPasswordCheck() ){
				e.preventDefault(e);
			}
        });
        $("#login-form").submit(function(e){
			if(!passwordCheck($("#password").val())){
				e.preventDefault(e);
			}
        });
            	
    
        $('#hobby').blur(function(){
			if(dropCheck($(this[this.selectedIndex]).val())){
				$("#drop-error").text("Please select hobby");
			}
			else{
				$("#drop-error").text("");
			}
			
		});  
		$('#hobby').focus(function(){
			genderMust();
		});
		/* Below function check date like (1. date is below 31 (2. month is below 12  (3. year is less then current year  */	
		$('#birthdate').blur(function(){
			birthDateCheck();				
		});
	
		/* Below function add preview image after user add some image */	
		$('#imageclick').change(function(){
		        const file = this.files[0];
		        if (file){
		          let reader = new FileReader();
		          reader.onload = function(event){
		        	  $(".demo-image").append($("<img id='imgPreview'  alt='Profile preview' width='250px' height='200px'/>"));
		            $('#imgPreview').attr('src', event.target.result);
		          }
		          reader.readAsDataURL(file);
		        }
		 });
		$('#password').blur(function(){
			if(!passwordCheck($("#password").val())){
				$("#password-error").text("Please enter valid password");
			}	
			else{
				$("#password-error").text("");
			}
			
		});
		$('#c-password').blur(function(){
			cPasswordCheck();
		});
		/* Below function for check name only contain alphabets only */	
		$('#name').blur(function(){
			console.log();
			if(!alphabets($("#name").val())){
				$("#name-error").text("Please enter valid name");
			}	
			else{
				$("#name-error").text("");
			}
			
		});
		
		/* Below function for check name only contain digits only */
		$('#mobile').blur(function(){
			if(!numberCheck($("#mobile").val())){
					$("#mobile-error").text("Please enter valid mobile");
			}	
			else{
					$("#mobile-error").text("");
			}
			
		});
		
		/* Below function for email validation*/
		$('#email').blur(function(){
			/*if(!emailCheck($("#email").val())){
				$("#email-error").text("Please enter valid email");
			}	
			else{
				$("#email-error").text("");
			}*/
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
		
		
		/* Below function for add address field in dom */
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
            
});

        function recField() {
	        for (var i = 0; i < 11; i++) {
	            var input1 = document.getElementsByClassName("form-control")[i].value;
	            if (input1.length == 0)
	                document.getElementsByClassName("field-error")[i].innerHTML = " !! This field required.";
	            else
	            	document.getElementsByClassName("field-error")[i].innerHTML = "";
	        }
	    }

	     function dropCheck(dropval){
			if(dropval != "not"){
				return false;	
			}
			else{
				return true;
			}
		}
	     
		function birthDateCheck(){
			var dt = new Date( $("#birthdate").val());
			if(new Date().getFullYear() < dt.getFullYear() && dt.getMonth() <= 12 && dt.getDate() <= 31){
				$("#birthdate-error").text("Please enter valid number");
				return false;	
			}
			else{
				$("#birthdate-error").text("");
				return true;
			}
				//date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear();  // For current date			
			
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
		
		function alphabets(fValue){
			var regex = /^[A-Za-z ]+$/;	
			if(!regex.test(fValue)){
					return false;
			}	
			else{
					return true;
			}
		}
		
		function numberCheck(fValue){
			var regex = /^[1-9]{1}[0-9]{9}$/;
			if(!regex.test(fValue)){
					return false;
			}	
			else{
					return true;
			}
		}
		
		function emailCheck(fValue){
			var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
			if(!regex.test(fValue)){
					return false;
			}	
			else{
					return true;
			}
		}
		function passwordCheck(fValue){
			var regex = /^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/;	
			if(!regex.test(fValue)){
					return false;
			}	
			else{
					return true;
			}
		}
		function cPasswordCheck(){
			if($("#password").val() != $("#c-password").val()){
					$("#cpassword-error").text("Password and confirm password not same.");
					return false;
			}	
			else{
					$("#cpassword-error").text("");	
					return true;
			}
		}
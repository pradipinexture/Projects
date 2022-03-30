
$(document).ready(function(){
		 /*var a=0;
            $("form").submit(function(e){
                if(){
                }
                else{
                	e.preventDefault(e);
                }
            });*/
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

	
		$('#name').blur(function(){
			if(!alphabets($("#name").val()) ){
					$("#name-error").text("Please enter valid name");
			}	
			else{
					$("#name-error").text("");	
			}
		});
		$('#mobile').blur(function(){
			if(!numberCheck($("#mobile").val()) ){
					$("#mobile-error").text("Please enter valid number");
			}	
			else{
					$("#mobile-error").text("");	
			}
		});
		$('#email').blur(function(){
			if(!emailCheck($("#email").val())){
					$("#email-error").text("Please enter valid email");
			}	
			else{
					$("#email-error").text("");	
			}
		});
		
		
		
		var x = 1; //Initial field counter
	        //Once add button is clicked
		$('.list_add_button').click(function() {
		    //Check maximum number of input fields
			    if(x++ < 5){ 
			         var list_fieldHTML = '<div class="form-group"><label for="address'+x+'">Address '+x+' :</label><textarea class="form-control" rows="3" id="address" placeholder="Please enter Address" name="address"></textarea>'+
											'<div class="add-style"><span><input type="text" class="form-control" id="city" name="city" placeholder="Please enter city" required>'+
											'</span><span><input type="text" class="form-control" id="state" name="state" placeholder="Please enter state" required>'+
											'</span><span><input type="number" class="form-control" id="pincode" name="pincode" placeholder="Please enter pincode" required></span><span><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></span></div>'+
											'</div>';
			     //   var list_fieldHTML = '<div class="row"><div class="col-xs-4 col-sm-4 col-md-4"><div class="form-group"><input name="list['+x+'][]" type="text" placeholder="Type Item Name" class="form-control"/></div></div><div class="col-xs-7 col-sm-7 col-md-7"><div class="form-group"><input name="list['+x+'][]" type="text" placeholder="Type Item Quantity" class="form-control"/></div></div><div class="col-xs-1 col-sm-7 col-md-1"><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></div></div>'; //New input field html 
			        $('.addresses').append(list_fieldHTML); //Add field html
			    }

	     });
	    
	        //Once remove button is clicked
	        $('.addresses').on('click', '.list_remove_button', function() {
		if(x > 1){
			$(this).parent().parent().parent().remove(); //Remove field html
	           x--;
		}
	            //Decrement field counter
	        });
});
function alphabets(alphaString){
	var regex = /^[A-Za-z ]+$/;	
	return regex.test(alphaString);
}
function numberCheck(alphaString){
	var regex = /^[1-9]{1}[0-9]{9}$/;	
	return regex.test(alphaString);
}
function emailCheck(alphaString){
	var regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;	
	return regex.test(alphaString);
}
function passCheck(alphaString){
}
	/*
	$("#add-address-button").click(function(){
		console.log("Done");
		if(count++ < 2) {
			$(".addresses").append('<div class="form-group"><label for="address">Address :</label><textarea class="form-control" rows="3" id="address" placeholder="Please enter Address" name="address"></textarea>'+
										'<input type="text" class="form-control" id="city" name="city" placeholder="Please enter city">'+
										'<input type="text" class="form-control" id="state" name="state" placeholder="Please enter state">'+
										'<input type="number" class="form-control" id="pincode" name="pincode" placeholder="Please enter pincode">'+
										'<input type="button" id="removeButton" value="(-)" /></div>');
		}
		else{
			$(this).parent().remove();
			//$("#address-max-error").text("!! Address limit is 5.");
		}
	});
	 $("#removeButton").click(function(){
		console.log("Done");
		 $(this).parent().remove();
	 }); 
  */

package com.mvc.service;

import com.mvc.model.UserModel;
import com.mvc.util.Validation;
public class RegisterService {

	public static boolean validateFields(UserModel userObj) {
		
		Validation valObj = new Validation();
	
		if(valObj.AlphaValidate(userObj.getName())&& 
				valObj.mobileValidate(userObj.getMobile())&& 
					valObj.emailValidate(userObj.getEmail()) && 
						valObj.passwordValidate(userObj.getPassword())  && 
							valObj.cPasswordValidate(userObj.getPassword(),userObj.getCpassword()) ) {
			return true;
		}
		else {
			return false;
		}
	}

}

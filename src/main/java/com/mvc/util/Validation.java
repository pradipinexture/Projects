package com.mvc.util;

public class Validation {

	public Validation() {
		// TODO Auto-generated constructor stub
	}
	public boolean nullCheck(String alphaString){
		
		if(alphaString != null)
			return true;
		
		else
			return false;
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean emailValidate(String email){
		String emailReg = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if(email != null && email.matches(emailReg))
			return true;
		
		else
			return false;
	}
	
	public boolean passwordValidate(String pass){
//		String passReg = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		if(pass != null && pass.length() > 4)
			return true;
		
		else
			return false;
	}
	public boolean cPasswordValidate(String pass,String cPass){
		if(pass != null && cPass != null && pass.equals(cPass))
			return true;
		
		else
			return false;
	}
	
	/**
	 * 
	 * @param mobile
	 * @return
	 */
	
	public boolean mobileValidate(String mobile){
		String mobileReg = "^\\d{10}$";
		if(mobile != null && mobile.matches(mobileReg))
			return true;
		
		else
			return false;
	}
	/**
	 * 
	 * @param alphaString
	 * @return
	 */
	public boolean AlphaValidate(String alphaString){
		String AlphaReg = "^[a-zA-Z ]+$";
		if(alphaString != null && alphaString.matches(AlphaReg))
			return true;
		
		else
			return false;
	}
	
}

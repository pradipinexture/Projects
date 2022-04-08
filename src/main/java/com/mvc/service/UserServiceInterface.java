package com.mvc.service;

import java.util.List;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

public interface UserServiceInterface {

	public boolean insertData(UserModel userObj,List<AddressModel> addobj); // insert all personal data and multiple address also
	
	public boolean loginCheck(String email,String password); // it check email password exist or not
	
	public  boolean checkUserAvailability(String email); // it check email exist or not
	
	public UserModel getUserDetail(String email);  // for get perticular user detail
	
	public  List<AddressModel> getAllUserAddresses(int id); // get all addresses of perticular user
	
	public  List<UserModel> getAllUsers(); // this  function for admin site show all users	
	
	public boolean passwordUpadate(String email,String password); // this function first check user available or not then update password
	
	public boolean deleteUser(String email); // admin delete perticular user

	public boolean updateUserData(UserModel userObj, List<AddressModel> insertData, List<AddressModel> updateData);

}

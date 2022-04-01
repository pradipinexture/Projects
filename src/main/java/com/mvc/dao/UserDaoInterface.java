package com.mvc.dao;

import java.util.List;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

public interface UserDaoInterface {

	boolean insertData(UserModel userObj,List<AddressModel> addobj);
	public boolean emailPasswordCheck(String email,String password);
	public  boolean checkUserAvailability(String email);
	public boolean passwordUpadate(String email,String password);
	public UserModel getUserDetail(String email);
	public  List<AddressModel> getAllUserAddresses(int id);
	public  List<UserModel> getAllUsers();
	public boolean deleteUser(String email);
	
}

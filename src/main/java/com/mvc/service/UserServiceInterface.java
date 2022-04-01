package com.mvc.service;

import java.util.List;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

public interface UserServiceInterface {
	public boolean insertData(UserModel userObj,List<AddressModel> addobj);
	public boolean loginCheck(String email,String password);
	public UserModel getUserDetail(String email);

}

package com.mvc.service;
import com.mvc.dao.UserDao;
import com.mvc.dao.UserDaoInterface;
import java.util.List;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.util.Validation;

public class UserServiceImp implements UserServiceInterface {
	UserDaoInterface userDao=new UserDao();
	Validation validate=new Validation();
	
	public  boolean insertData(UserModel userObj,List<AddressModel> addobj) {
		
		if(validate.validateFields(userObj)) {
			return userDao.insertData(userObj, addobj);
		}
		else {
			return false;
		}
		
	}
	@Override
	public boolean loginCheck(String email, String password) {
		return userDao.emailPasswordCheck(email, password);
	}
	@Override
	public UserModel getUserDetail(String email) {
		return userDao.getUserDetail(email);
	}
	@Override
	public List<UserModel> getAllUsers() {
		return userDao.getAllUsers();
	}
	@Override
	public boolean checkUserAvailability(String email) {
		return checkUserAvailability(email);
	}
	@Override
	public boolean passwordUpadate(String email, String password) {
		if(userDao.checkUserAvailability(email)) {
			return userDao.passwordUpadate(email, password);
		}
		else {
			return false;
		}
	}
	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(email);
	}
	@Override
	public List<AddressModel> getAllUserAddresses(int id) {
		// TODO Auto-generated method stub
		return userDao.getAllUserAddresses(id);
	}
	@Override
	public boolean updateUserData(UserModel userObj, List<AddressModel> insertData, List<AddressModel> updateData) {
		// TODO Auto-generated method stub
		return userDao.updateUserData(userObj,insertData,updateData);
	}
	

}

package com.mvc.dao;
import org.apache.log4j.Logger;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletOutputStream;

import com.mvc.util.ConnectionClass;
import com.mvc.util.EncryDecryAES;

public class UserDao implements UserDaoInterface{
	public static final ConnectionClass conInstance=ConnectionClass.getInstance();
	public static final Connection conObject=conInstance.getConnection();
	private final Logger logger = Logger.getLogger(this.getClass());

	/*Insert user data into table
	 * get user id that currently added
	 * then add role into role table using userid
	 * at last add all addresses into address table by userid*/

	public  boolean insertData(UserModel userObj,List<AddressModel> addobj) {
		try {
			String sql="INSERT INTO USER(NAME, MOBILE,EMAIL,HOBBY,GENDER,BIRTHDATE,PASSWORD,IMAGE) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement stateObject = conObject.prepareStatement(sql);
			stateObject.setString(1, userObj.getName());
			stateObject.setString(2, userObj.getMobile());
			stateObject.setString(3, userObj.getEmail());
			stateObject.setString(4, userObj.getHobby());
			stateObject.setString(5, userObj.getGender());
			stateObject.setString(6, userObj.getBirthdate());
			stateObject.setString(7, userObj.getDecryPass());
			stateObject.setBlob(8, userObj.getImage());
			if(stateObject.executeUpdate() != 0) {
				PreparedStatement stateObject1 = conObject.prepareStatement("select id from user where email=?;");
				stateObject1.setString(1,userObj.getEmail() );
				ResultSet rs=stateObject1.executeQuery();
				rs.next();
				PreparedStatement stateObject3 = conObject.prepareStatement("insert into role(userid,roletype) values(?,0);");
				stateObject3.setInt(1,rs.getInt(1));
				stateObject3.executeUpdate();
				addressInsert(addobj,rs.getInt(1));
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}

	}
	/*Insert user addresses*/
	public  boolean addressInsert(List<AddressModel> addobj,int userid) {
		try {

				for(int i=0;i<addobj.size();i++){		
					PreparedStatement stateObject = conObject.prepareStatement("insert into address(userid,address,city,state,pincode) values(?,?,?,?,?);");
					stateObject.setInt(1,userid);
					stateObject.setString(2, addobj.get(i).getAddress());
					stateObject.setString(3, addobj.get(i).getCity());
					stateObject.setString(4, addobj.get(i).getState());
					stateObject.setString(5, addobj.get(i).getPincode());
					stateObject.execute();
				}
				return true;
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}

	}
	/*Bleow function check user's email id exist or not*/
	public  boolean checkUserAvailability(String email) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("select email from user where email=?;");
			stateObject.setString(1, email);
			ResultSet rs=stateObject.executeQuery();

			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}
	}
	
	/*Below funtion for check email and password are same or not */
	public boolean emailPasswordCheck(String email,String password) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("select * from user where email=? and password=?;");
			stateObject.setString(1, email);
			stateObject.setString(2, password);
			ResultSet rs=stateObject.executeQuery();
			return rs.next();
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}
	}
	/*This function for forgot password functionality*/
	public boolean passwordUpadate(String email,String password) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("update user set password=? where email=?;");
			stateObject.setString(1, password);
			stateObject.setString(2, email);
			if(stateObject.execute() != true) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}
	}
	
	/*Below function for get perticular user detail 
	 * and then all fetched data store into usermodel
	 * return usermodel object*/
	public  UserModel getUserDetail(String userEmail) {
		UserModel user = new UserModel();
		ResultSet rs=null;
		try {

			PreparedStatement stateObject = conObject.prepareStatement("select u.id,u.name,u.mobile,u.email,u.hobby,u.gender,u.birthdate,u.password,u.image ,r.roletype from user u,role r where u.id=r.userid and u.email=?;");
			stateObject.setString(1, userEmail);
			rs=stateObject.executeQuery();
			while(rs.next()) {	
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setMobile(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setHobby(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setBirthdate(rs.getString(7));
				user.setDecryPass(rs.getString(8));
				user.setPassword(EncryDecryAES.decrypt(rs.getString(8)));	
				user.setImageString((Base64.getEncoder().encodeToString(rs.getBytes(9))));
				user.setRoletype(rs.getInt(10));
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
		}
		return user;
	}
	
	/*Below function for get all users detail 
	 * and then all fetched data store into usermodel
	 * store usermodel object into arraylist
	 * return arraylist object */
	public  List<UserModel> getAllUsers() {
		List<UserModel> userObj = new ArrayList<UserModel>();
		try {
			Statement statement = conObject.createStatement();
			ResultSet rs = statement.executeQuery("select DISTINCT  u.id,u.name,u.mobile,u.email,u.hobby,u.gender,u.birthdate from user u,role r where u.id=r.userid and roletype=0;");

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setMobile(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setHobby(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setBirthdate(rs.getString(7));
				userObj.add(user);
			}
		} catch (SQLException e) {
			logger.error("There is error : "+e);
		}

		return userObj;
	}
	
	/*Below function for get all users addresses 
	 * and then all fetched address store into addressmodel
	 * store addressmodel object into arraylist
	 * return arraylist object*/
	public  List<AddressModel> getAllUserAddresses(int id) {
		List<AddressModel> addressObj = new ArrayList<AddressModel>();
		try {
			Statement statement = conObject.createStatement();
			ResultSet rs = statement.executeQuery("select * from address where userid="+id+";");

			while (rs.next()) {
				AddressModel address = new AddressModel();
				address.setId(rs.getInt(1));
				address.setAddress(rs.getString(3));
				address.setCity(rs.getString(4));
				address.setState(rs.getString(5));
				address.setPincode(rs.getString(6));
				addressObj.add(address);
			}
		} 
		catch (SQLException e) {
			logger.error("There is error : "+e);
		}

		return addressObj;
	}
	/* Beloow function for delete perticular user email*/
	public boolean deleteUser(String email) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("delete from user where email=?;");
			stateObject.setString(1, email);
			if(stateObject.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}
	}
	@Override
	public boolean updateUserData(UserModel userObj, List<AddressModel> insertData, List<AddressModel> updateData) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("update user set name=?,mobile=? ,email=?, hobby=?, gender=?,birthdate=?, password=?,image=?  where id=?;");
			
			stateObject.setString(1, userObj.getName());
			stateObject.setString(2, userObj.getMobile());
			stateObject.setString(3, userObj.getEmail());
			stateObject.setString(4, userObj.getHobby());
			stateObject.setString(5, userObj.getGender());
			stateObject.setString(6, userObj.getBirthdate());
			stateObject.setString(7, userObj.getDecryPass());
			stateObject.setBlob(8, userObj.getImage());
			stateObject.setInt(9, userObj.getId());
			
			if(stateObject.execute() != true) {
				addressDelete(updateData,userObj.getId());
				addressInsert(insertData,userObj.getId());
				for(int i=0;i<updateData.size();i++){		
					stateObject = conObject.prepareStatement("UPDATE address SET address =? ,city=? ,state=? ,pincode =? WHERE id = ?;");
					stateObject.setString(1, updateData.get(i).getAddress());
					stateObject.setString(2, updateData.get(i).getCity());
					stateObject.setString(3, updateData.get(i).getState());
					stateObject.setString(4, updateData.get(i).getPincode());
					stateObject.setInt(5,updateData.get(i).getId());
					stateObject.execute();
				}
				
				return true;
			}
			else {
				return true;
			}
		}
		catch(Exception e) {
			System.out.println("There is error : "+e);
			return false;
		}
	}
	private boolean addressDelete(List<AddressModel> updateData, int id) {
		try {
			StringBuilder sb= new StringBuilder();
			for(int i=0;i<updateData.size();i++){  
				if(i == updateData.size()-1) {
					sb.append( " "+updateData.get(i).getId());
				}
				else {
					sb.append( " "+updateData.get(i).getId()+"," );
				}
			}
			
			PreparedStatement stateObject1 = conObject.prepareStatement("delete from address where id not in ("+sb+") and userid="+id+";");
			
			if(stateObject1.executeUpdate() != 0) {
				System.out.println("User deleted");
				return true;
				
			}
			else {
				System.out.println("User not deleted");
				return false;
			}
		}
		catch(Exception e) {
			logger.error("There is error : "+e);
			return false;
		}
		
		
	}

	

}

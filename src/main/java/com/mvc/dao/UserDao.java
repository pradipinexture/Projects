package com.mvc.dao;
import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.util.ConnectionClass;

public class UserDao {
	public static final ConnectionClass conInstance=ConnectionClass.getInstance();
	public static final Connection conObject=conInstance.getConnection();
	

	public static boolean insertData(UserModel userObj) {
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
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
		
	}
	public static boolean insertAddress(List<AddressModel> addobj,String userName) {
		try {
	         	PreparedStatement stateObject1 = conObject.prepareStatement("select id from user where email=?;");
	         	stateObject1.setString(1,userName );
				ResultSet rs=stateObject1.executeQuery();
				rs.next();
				PreparedStatement stateObject3 = conObject.prepareStatement("insert into role(userid,roletype) values(?,0);");
	         	stateObject3.setInt(1,rs.getInt(1));
				stateObject3.executeUpdate();

	            for(int i=0;i<addobj.size();i++){
					String sql="insert into address(userid,address,city,state,pincode) values(?,?,?,?,?);";				
					PreparedStatement stateObject = conObject.prepareStatement(sql);
	    			stateObject.setInt(1,rs.getInt(1));
	    			stateObject.setString(2, addobj.get(i).getAddress());
	    			stateObject.setString(3, addobj.get(i).getCity());
	    			stateObject.setString(4, addobj.get(i).getState());
	    			stateObject.setString(5, addobj.get(i).getPincode());
	    			stateObject.execute();
	            }
		}	
		catch(Exception e) {
			return false;
		}
		return true;
	}	
	public static boolean checkUserAvailability(String email) {
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
			return false;
		}
	}
	public boolean emailPasswordCheck(String email,String password) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("select * from user where email=? and password=?;");
         	stateObject.setString(1, email);
         	stateObject.setString(2, password);
			ResultSet rs=stateObject.executeQuery();
			return rs.next();
		}
		catch(Exception e) {
			return true;
		}
	}
	public static boolean passwordUpadate(String email,String password) {
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
			return true;
		}
	}
	public static boolean adminCheck(String email) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("select u.email from role r, user u  where u.id=r.userid and r.roletype=1 and u.email=?");
         	stateObject.setString(1, email);
			ResultSet rs=stateObject.executeQuery();
			return rs.next();
		}
		catch(Exception e) {
			return false;
		}
	}
	public static boolean imageAdd(InputStream st ) {
		try {
			PreparedStatement stateObject = conObject.prepareStatement("insert into image(img) values(?)");
         	stateObject.setBlob(1, st);
			if(stateObject.executeUpdate() != 0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
	}
	public static UserModel getUserDetail(String userEmail) {
		UserModel user = new UserModel();
		ResultSet rs=null;
		try {
			
			PreparedStatement stateObject = conObject.prepareStatement("select * from user where email=?;");
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
			}
		}
		catch(Exception e) {}
		return user;
	}
	public static List<AddressModel> getAllUserAddresses(int id) {
	  List<AddressModel> addressObj = new ArrayList<AddressModel>();
	  try {
	      Statement statement = conObject.createStatement();
	      ResultSet rs = statement.executeQuery("select * from address where userid="+id+";");
	      
	      while (rs.next()) {
	    	  AddressModel address = new AddressModel();
	    	  address.setAddress(rs.getString(3));
	    	  address.setCity(rs.getString(4));
	    	  address.setState(rs.getString(5));
	    	  address.setPincode(rs.getString(6));
	    	  addressObj.add(address);
	      }
	  } catch (SQLException e) {
	      e.printStackTrace();
	  }
	
	  return addressObj;
	}
	public static List<UserModel> getAllUsers() {
		  List<UserModel> userObj = new ArrayList<UserModel>();
		  try {
		      Statement statement = conObject.createStatement();
		      ResultSet rs = statement.executeQuery("select u.name,u.email from user u,role r where u.id=r.userid and roletype=0;");
		      
		      while (rs.next()) {
		    	  UserModel user = new UserModel();
		    	  user.setName(rs.getString(1));
		    	  user.setEmail(rs.getString(2));
		    	  userObj.add(user);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		
		  return userObj;
	}
	public static boolean deleteUser(String email) {
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
			return false;
		}
	}

}

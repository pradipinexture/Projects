package com.mvc.util;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.mvc.model.AddressModel;
import com.mvc.model.UserModel;
import com.mvc.service.UserServiceImp;
import com.mvc.service.UserServiceInterface;

public class CSVPrinting {
	public boolean printCSV() {
		String filename = "C:\\csv\\users.csv";
		try
		{
		FileWriter fw = new FileWriter(filename);
		fw.append("ID,Name,Mobile Number,Email,Hobby,Gender,Birthdate,Add ID,Address,City,State,Pincode\n");
		
		UserServiceInterface service=new UserServiceImp();
		
		List<UserModel> userModelObj= service.getAllUsers();
		for(int i=0;i<userModelObj.size();i++){
			fw.append("\n"+userModelObj.get(i).getId()+','+userModelObj.get(i).getName()+','+userModelObj.get(i).getMobile()+','+userModelObj.get(i).getEmail()+','+userModelObj.get(i).getHobby()+','+userModelObj.get(i).getGender()+','+userModelObj.get(i).getBirthdate()+',');
			List<AddressModel> addModelObj= new ArrayList<AddressModel>(service.getAllUserAddresses(userModelObj.get(i).getId()));
			for(int j=0;j<addModelObj.size();j++){
				fw.append(String.valueOf(addModelObj.get(j).getId())+','+addModelObj.get(j).getAddress().replace(',', ' ')+','+addModelObj.get(j).getCity()+','+addModelObj.get(j).getState()+','+addModelObj.get(j).getPincode()+','+"\n,,,,,,,");
			}	
//			addModelObj.get(j).getCity()+','+addModelObj.get(j).getCity()+','
		}
		fw.flush();
		fw.close();
		
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}

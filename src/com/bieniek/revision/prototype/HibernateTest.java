package com.bieniek.revision.prototype;

import com.bieniek.revision.model.User;
import com.bieniek.revision.model.UserInfo;
import com.bieniek.revision.service.UserService;
import com.bieniek.revision.service.serviceimplementation.UserServiceImplementation;
import com.bieniek.revision.utility.HibernateUtility;

public class HibernateTest 
{
	private static UserService service = new UserServiceImplementation();
	
	public static void main(String[] args)
	{
		User user = service.findUser(new Long(2));
		UserInfo userInfo = user.getUserInfo();
		userInfo.setPhoneNumber("111222888");
		
		service.updateUser(user);
		HibernateUtility.getSessionFactory().close();
		
	}
}

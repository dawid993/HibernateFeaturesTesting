package com.bieniek.revision.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bieniek.revision.model.User;
import com.bieniek.revision.model.UserInfo;
import com.bieniek.revision.service.UserService;

public class HibernateTest 
{		
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("springbean.xml");
		UserService userService = (UserService) context.getBean("userServiceImplementation"); 
		
		User user1 = userService.findUser(new Long(1));
		UserInfo info = user1.getUserInfo();
		info.setPhoneNumber("+48 991 222 777");
		userService.updateUser(user1);
		
	}
}

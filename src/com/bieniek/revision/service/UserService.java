package com.bieniek.revision.service;

import java.util.List;

import com.bieniek.revision.model.User;
import com.bieniek.revision.model.UserInfo;

public interface UserService 
{
	public void saveUser(User user);
	
	public void addInfoToUser(User user,UserInfo userInfo);
	
	public void deleteUser(User user);
	
	public User findUser(Long id);
	
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	
	public void deleteAllUsers();
	
}

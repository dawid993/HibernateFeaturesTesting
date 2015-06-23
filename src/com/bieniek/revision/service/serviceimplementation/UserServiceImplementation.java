package com.bieniek.revision.service.serviceimplementation;

import java.util.List;

import com.bieniek.revision.dao.daoimplementation.UserDAOImplementation;
import com.bieniek.revision.model.User;
import com.bieniek.revision.model.UserInfo;
import com.bieniek.revision.service.UserService;

public class UserServiceImplementation implements UserService
{
	private static UserDAOImplementation userDAO;
	
	public UserServiceImplementation()
	{
		userDAO = new UserDAOImplementation();
	}

	@Override
	public void saveUser(User user)
	{
		userDAO.openSessionAndTransaction();
		userDAO.create(user);
		userDAO.closeSessionAndTransaction();
	}

	@Override
	public void addInfoToUser(User user,UserInfo userInfo)
	{
		userDAO.openSessionAndTransaction();
		user.setUserInfo(userInfo);
		userDAO.update(user);
		
	}

	@Override
	public void deleteUser(User user) 
	{
		userDAO.openSessionAndTransaction();
		userDAO.delete(user);
		userDAO.closeSessionAndTransaction();
	}

	@Override
	public User findUser(Long id)
	{		
		userDAO.openSessionAndTransaction();
		User user = userDAO.read(id);
		userDAO.closeSessionAndTransaction();
		
		return user;
	}

	@Override
	public List<User> getAllUsers() 
	{
		userDAO.openSessionAndTransaction();
		List<User> users = userDAO.readAllEntities();
		userDAO.closeSessionAndTransaction();
		
		return users;
	}

	@Override
	public void deleteAllUsers() 
	{
		userDAO.openSessionAndTransaction();
		userDAO.deleteAll();
		userDAO.closeSessionAndTransaction();
	}

	@Override
	public void updateUser(User user) 
	{
		userDAO.openSessionAndTransaction();
		userDAO.update(user);
		userDAO.closeSessionAndTransaction();
		
	}

}

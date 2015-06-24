package com.bieniek.revision.service.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bieniek.revision.dao.GenericDAO;
import com.bieniek.revision.dao.daoimplementation.UserDAOImplementation;
import com.bieniek.revision.model.User;
import com.bieniek.revision.model.UserInfo;
import com.bieniek.revision.service.UserService;

@Service(value="userServiceImplementation")
public class UserServiceImplementation implements UserService
{
	@Autowired
	private GenericDAO<User, Long> userDAO;
	
	public UserServiceImplementation()
	{
		userDAO = new UserDAOImplementation();
	}

	@Override
	@Transactional
	public void saveUser(User user)
	{	
		userDAO.create(user);		
	}

	@Override
	@Transactional
	public void addInfoToUser(User user,UserInfo userInfo)
	{		
		user.setUserInfo(userInfo);	
	}

	@Override
	@Transactional
	public void deleteUser(User user) 
	{		
		userDAO.delete(user);		
	}

	@Override
	@Transactional
	public User findUser(Long id)
	{	
		return userDAO.read(id);	
	}

	@Override
	@Transactional
	public List<User> getAllUsers() 
	{
		return userDAO.readAllEntities();
	}

	@Override
	@Transactional
	public void deleteAllUsers() 
	{
		userDAO.deleteAll();	
	}

	@Override
	@Transactional
	public void updateUser(User user) 
	{
		userDAO.update(user);			
	}

}

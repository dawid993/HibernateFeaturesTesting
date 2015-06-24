package com.bieniek.revision.dao.daoimplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bieniek.revision.dao.GenericDAO;
import com.bieniek.revision.model.User;

@Service(value="userDaoImplementation")
public class UserDAOImplementation implements GenericDAO<User,Long>
{
	@Autowired
	private SessionFactory sessionFactory;	

	@Override
	public void create(User entity) 
	{
		getCurrentSession().save(entity);
	}

	@Override
	public void update(User entity) 
	{
		getCurrentSession().update(entity);
	}

	@Override
	public void delete(User entity) 
	{
		getCurrentSession().delete(entity);
	}

	@Override
	public User read(Long id) 
	{		
		return (User) getCurrentSession().get(User.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> readAllEntities()
	{		
		List<User> users = (List<User>) getCurrentSession().createQuery("from User");
		return users;		
	}

	@Override
	public void deleteAll() 
	{
		List<User> users = readAllEntities();
		for(User user:users)
			delete(user);
	}	
	
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}	
}

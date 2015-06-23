package com.bieniek.revision.dao.daoimplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bieniek.revision.dao.GenericDAO;
import com.bieniek.revision.model.User;
import com.bieniek.revision.utility.HibernateUtility;

public class UserDAOImplementation implements GenericDAO<User,Long>
{
	private Session currentSession;
	private Transaction currentTransaction;		

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
	
	public Session getCurrentSession()
	{		
		return currentSession;
	}
	
	public Transaction getCurrentTransaction()
	{
		return currentTransaction;
	}
	
	public void openSessionAndTransaction()
	{
		currentSession = HibernateUtility.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
	}
	
	public void closeSessionAndTransaction()
	{
		currentTransaction.commit();
		currentSession.close();
	}
	
	

}

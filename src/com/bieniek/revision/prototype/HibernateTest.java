package com.bieniek.revision.prototype;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bieniek.revision.utility.HibernateUtility;

public class HibernateTest 
{
	
	public static void main(String[] args)
	{
		Session session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		try
		{
			String hql = "select u.name,u.surname FROM User u";
			Query query = session.createQuery(hql);
			List<Object[]> result = query.list();
			
			for(Object[] user:result)
				System.out.println(user[0]+" "+user[1]);
		} 
		catch(Exception ex)
		{
			ex.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
			HibernateUtility.shutdown();
		}
	}
}

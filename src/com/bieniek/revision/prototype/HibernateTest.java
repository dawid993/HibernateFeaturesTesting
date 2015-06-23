package com.bieniek.revision.prototype;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bieniek.revision.utility.HibernateUtility;

public class HibernateTest 
{
	public static void main(String[] args)
	{
		Session  session = HibernateUtility.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try
		{
			transaction = session.beginTransaction();			
		}
		catch(Exception ex)
		{
			transaction.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}
}

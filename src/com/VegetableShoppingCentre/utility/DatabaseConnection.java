package com.VegetableShoppingCentre.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection
{
	public static SessionFactory getConnection()
	{
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
		//return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	}
	
	public static void closeConnection(Session session, SessionFactory factory)
	{
		session.close();
		factory.close();
	}
}

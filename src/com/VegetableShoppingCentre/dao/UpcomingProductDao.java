package com.VegetableShoppingCentre.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class UpcomingProductDao
{
	public List getUpcomingProductDao()
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" select pro.imagePath, pro.productName, pro.price, pro.devileryBy "+
								" from Product pro "+
								" where pro.isactive='Y' and pro.isupcoming='Y' "+
								" order by pro.createddate desc ");
		
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	
	
	
	public void main(String a[])
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" select pro.productName, pro.description "+
								" from Product pro "+
								" where pro.isactive='y' and availableQuantity >:quantity "+
								" order by pro.createddate desc ");
		
		query.setInteger("quantity", 1);
		
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		
		System.out.println(list);
		for(int i=0; i<list.size(); i++)
		{
			Object object[]  = (Object[]) list.get(i);
			System.out.println(object[0]);
			System.out.println(object[1]);
		}
	}
	
}





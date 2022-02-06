package com.VegetableShoppingCentre.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class NewProductDao
{
	public List getNewProductDao()
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select pro.pkProductId, pro.imagePath, pro.productName, pro.price, pro.devileryBy, pro.description "+
								" from Product pro "+
								" where pro.isactive='Y' and pro.isnew='Y' and availableQuantity >:quantity "+
								" order by pro.createddate desc ");
		
		query.setInteger("quantity", 1);
		
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	
	public void main(String[] args)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" select pro.pkProductId, pro.imagePath, pro.productName, pro.price, pro.devileryBy, pro.availableQuantity "+
								" from Product pro "+
								" where pro.isactive='Y' and pro.isnew='Y' and availableQuantity >:quantity "+
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
			System.out.println(object[2]);
		}
	}
}

package com.VegetableShoppingCentre.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class OrderHistory
{
	public List getOrderDetail(Long userId)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" select pro.imagePath, pro.productName, log.productQuantity, log.ef1, add.address1, add.landmark,add.pincode, add.billerMobileNo, log.createddate, detail.pkOrderDetail "+
									" from OrderLog log join log.orderDetail detail join detail.userInfo user join log.product pro join detail.address add "+
									" where user.pkUserId=:id "+
									" order by log.createddate desc");
		
		query.setLong("id", userId);
		
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			System.out.println(object[0]+","+object[1]);
		}
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	public static void main(String[] args)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" select pro.productName, log.productQuantity "+
									" from OrderLog log join log.orderDetail detail join detail.userInfo user join log.product pro "+
									" where user.pkUserId=:id "+
									" order by log.createddate desc");
		
		query.setLong("id", 1L);
		
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			System.out.println(object[0]+","+object[1]);
		}
		DatabaseConnection.closeConnection(session, factory);
	}
}

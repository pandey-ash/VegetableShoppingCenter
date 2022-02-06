package com.VegetableShoppingCentre.dao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.AddressBean;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class AddressDao
{
	public HashMap getState()
	{
		HashMap stateCity = new HashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" select sta.pkStateCity, sta.state "+" from StateCity sta "+" where sta.city is null ");
		
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			stateCity.put(object[0], object[1]);
		}
		DatabaseConnection.closeConnection(session, factory);
		return stateCity;
	}
	
	public HashMap getCity(Long stateId)
	{
		HashMap stateCity = new HashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" select sta.pkStateCity, sta.city "+" from StateCity sta join sta.stateCity sta1 "+" where sta1.pkStateCity=:id ");
		
		query.setLong("id", stateId);
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			stateCity.put(object[0], object[1]);
		}
		DatabaseConnection.closeConnection(session, factory);
		return stateCity;
	}
	
	public List getUserAddressDao(AddressBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select add.pkAddressId, add.address1, add.landmark, add.pincode, city.city, state.state, add.billerMobileNo "+
									" from Address add join add.userInfo user join add.stateCity city join city.stateCity state "+
									" where user.pkUserId=:id ");
		query.setLong("id", bean.getUserId());
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	
	public static void main(String[] args)
	{
		HashMap stateCity = new HashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" select sta.pkStateCity, sta.city "+" from StateCity sta join sta.stateCity sta1 "+" where sta1.pkStateCity=:id ");
		
		query.setLong("id", 4);
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			stateCity.put(object[0], object[1]);
		}
		DatabaseConnection.closeConnection(session, factory);
	}
}











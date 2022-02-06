package com.VegetableShoppingCentre.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.VegetableShoppingCentre.bean.DropDownBean;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class DropDownDao
{
	public List getCategoryDao()
	{
		LinkedHashMap cartProduct = new LinkedHashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select cat.categoryName from Category cat ");
		
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	
	public List getProductDropDownDao(DropDownBean bean)
	{
		LinkedHashMap cartProduct = new LinkedHashMap();
		
		String categoryName = bean.getCategoryName();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select cat.products from Category cat where cat.categoryName=:name ");
		query.setString("name", categoryName);
	
		List list = query.list();
		List productList = new ArrayList();
		DatabaseConnection.closeConnection(session, factory);
		for(int i=0; i<list.size(); i++)
		{
			Product product = (Product) list.get(i);
			if("N".equals(product.getIsupcoming()))
			{
				productList.add(list.get(i));
			}
		}
		return productList;
	}
	
	public  void main(String[] args)
	{
		LinkedHashMap cartProduct = new LinkedHashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" select distinct pro.productName from Category cat join cat.products pro where cat.categoryName='fruit' and pro.isupcoming='Y' ");

		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
	}
}





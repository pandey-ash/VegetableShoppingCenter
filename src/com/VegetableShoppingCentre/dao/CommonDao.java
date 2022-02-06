package com.VegetableShoppingCentre.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.dom4j.bean.BeanAttribute;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.CartInputBean;
import com.VegetableShoppingCentre.bean.LoginInputBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.pojo.Cart;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.recompile;

public class CommonDao
{
	public boolean checkMailDao(String email)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Query query = session.createQuery(" from UserInfo user "+
										  " where user.email=:email");
		
		query.setString("email", email);
		List list = query.list();
		for(int i =0; i<list.size(); i++)
		{
			DatabaseConnection.closeConnection(session, factory);
			return true;
		}
		DatabaseConnection.closeConnection(session, factory);
	    return false;
	}
	
	public LinkedHashMap getStoredCartProductDao(CartInputBean bean)
	{
		LinkedHashMap cartProduct = new LinkedHashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" from Cart cart "+
								" where cart.isactive='Y' and createdby=:id ");
		

		query.setLong("id", bean.getUserId());
		
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Cart cart = (Cart) list.get(i);
			Product product = cart.getProduct();
			System.out.println(product.getDescription());
			List productDetail = new ArrayList();
			productDetail.add(product.getPkProductId());
			productDetail.add(product.getImagePath());
			productDetail.add(cart.getEf1());
			/*this was added later*/
			//productDetail.add(product.getPrice());
			/*this was added later end*/
			productDetail.add(product.getProductName());
			productDetail.add(product.getDevileryBy());
			productDetail.add(cart.getQuantity());
			
			cartProduct.put(product.getPkProductId(), productDetail);
		}
		System.out.println(cartProduct);
		DatabaseConnection.closeConnection(session, factory);
		return cartProduct;
	}
	
	public OutputBean validateLogin(LoginInputBean inputbean) throws SQLException
	{
		LinkedHashMap login = new LinkedHashMap();
		OutputBean ob = new OutputBean();
		
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" select user.isadmin, user.pkUserId from UserInfo user where user.email=:email and user.password=:passwd ");
		query.setString("email", inputbean.getEmail());
		query.setString("passwd", inputbean.getPasswd());
		List list = query.list();
		if(list.isEmpty())
		{
			System.out.println("in if");
			login.put("false", 'N');
		    ob.setLogin(login);
		    return ob;
		}
		Object object[] = (Object[]) list.get(0);
		login.put("true", object[0]);
		login.put("id", object[1]);
	    ob.setLogin(login);
	    DatabaseConnection.closeConnection(session, factory);
	    return ob;
	}
	
	public void main(String a[])
	{
		LinkedHashMap cartProduct = new LinkedHashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Query query = session.createQuery(" from Cart cart "+
								" where cart.isactive='Y' and createdby=:id ");
		

		query.setLong("id", 1L);
		
		List list = query.list();
		for(int i=0; i<list.size(); i++)
		{
			Cart cart = (Cart) list.get(i);
			Product product = cart.getProduct();
			System.out.println(product.getDescription());
			List productDetail = new ArrayList();
			productDetail.add(product.getPkProductId());
			productDetail.add(product.getImagePath());
			productDetail.add(product.getProductName());
			productDetail.add(product.getPrice());
			productDetail.add(product.getDevileryBy());
			cartProduct.put(product.getPkProductId(), productDetail);
		}
		System.out.println(cartProduct);
		DatabaseConnection.closeConnection(session, factory);
		
	}
}




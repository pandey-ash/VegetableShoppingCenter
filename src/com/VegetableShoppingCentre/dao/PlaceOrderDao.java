package com.VegetableShoppingCentre.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.OrderBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.pojo.Address;
import com.VegetableShoppingCentre.pojo.OrderDetail;
import com.VegetableShoppingCentre.pojo.OrderLog;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.pojo.StateCity;
import com.VegetableShoppingCentre.pojo.UserInfo;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class PlaceOrderDao
{
	public boolean placeOrderNewAddressDao(OrderBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List productId = bean.getProductId();
		List productPrice = bean.getProductPrice();
		List productQuantity = bean.getProductQuantity();
		
		UserInfo userInfo = (UserInfo) session.get(UserInfo.class, bean.getUserId());
		StateCity stateCity = (StateCity) session.get(StateCity.class, bean.getCity());
		
		Address address = new Address();
		address.setUserInfo(userInfo);
		address.setAddress1(bean.getAddress1());
		address.setLandmark(bean.getLandmark());
		address.setPincode(bean.getPincode());
		address.setStateCity(stateCity);
		address.setBillerMobileNo(bean.getMobileNo());
		address.setCreatedby(bean.getUserId());
		address.setCreateddate(new Date());
		address.setIsactive("Y");
		OrderDetail detail = new OrderDetail();
		
		detail.setTotalProduct(bean.getTotalProduct());
		detail.setUserInfo(userInfo);
		detail.setAddress(address);
		detail.setTotalAmount(bean.getTotalAmt());
		detail.setCreatedby(bean.getUserId());
		detail.setCreateddate(new Date());
		detail.setIsactive("Y");
		transaction.commit();
		session.close();
		
		
		for(int i =0; i<productId.size(); i++)
		{
			session = factory.openSession();
			session.beginTransaction();
			OrderLog log = new OrderLog();
			Product product = (Product) session.get(Product.class, Long.valueOf((String)productId.get(i)));
			product.setAvailableQuantity(product.getAvailableQuantity() - Integer.valueOf((String)productQuantity.get(i)));
			log.setOrderDetail(detail);
			log.setProduct(product);
			log.setProductQuantity(Integer.valueOf((String)productQuantity.get(i)));
			log.setEf1((String)productPrice.get(i));
			log.setCreatedby(bean.getUserId());
			log.setCreateddate(new Date());
			log.setIsactive("Y");
			
			session.save(log);
			session.getTransaction().commit();
			session.close();
		}
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Cart cart set cart.isactive = 'N'" +
				  " where cart.createdby = :usrId");
		query.setLong("usrId", bean.getUserId());
		int result = query.executeUpdate();
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	public boolean placeOrderDao(OrderBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		List productId = bean.getProductId();
		List productPrice = bean.getProductPrice();
		List productQuantity = bean.getProductQuantity();
		
		UserInfo userInfo = (UserInfo) session.get(UserInfo.class, bean.getUserId());
		Address address = (Address) session.get(Address.class, bean.getAddressId());
		OrderDetail detail = new OrderDetail();
		
		detail.setTotalProduct(bean.getTotalProduct());
		detail.setUserInfo(userInfo);
		detail.setAddress(address);
		detail.setTotalAmount(bean.getTotalAmt());
		detail.setCreatedby(bean.getUserId());
		detail.setCreateddate(new Date());
		detail.setIsactive("Y");
		transaction.commit();
		session.close();
		
		
		for(int i =0; i<productId.size(); i++)
		{
			session = factory.openSession();
			session.beginTransaction();
			OrderLog log = new OrderLog();
			Product product = (Product) session.get(Product.class, Long.valueOf((String)productId.get(i)));
			product.setAvailableQuantity(product.getAvailableQuantity() - Integer.valueOf((String)productQuantity.get(i)));
			log.setOrderDetail(detail);
			log.setProduct(product);
			log.setProductQuantity(Integer.valueOf((String)productQuantity.get(i)));
			log.setEf1((String)productPrice.get(i));
			log.setCreatedby(bean.getUserId());
			log.setCreateddate(new Date());
			log.setIsactive("Y");
			
			session.save(log);
			session.getTransaction().commit();
			session.close();
		}
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Cart cart set cart.isactive = 'N'" +
				  " where cart.createdby = :usrId");
		query.setLong("usrId", bean.getUserId());
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	public void main(String[] args)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		OutputBean outputBean = new OutputBean();
		
		UserInfo userInfo = (UserInfo) session.get(UserInfo.class, 1L);
		Address address = (Address) session.get(Address.class, 1L);
		OrderDetail detail = new OrderDetail();
		detail.setTotalProduct(4);
		detail.setUserInfo(userInfo);
		detail.setAddress(address);
		detail.setTotalAmount(40L);
		detail.setCreatedby(1L);
		detail.setCreateddate(new Date());
		detail.setIsactive("Y");
		transaction.commit();
		session.close();
		
		
		for(int i =0; i<3; i++)
		{
			session = factory.openSession();
			session.beginTransaction();
			Long j = (long) i;
			OrderLog log = new OrderLog();
			Product product = (Product) session.get(Product.class, 1L);
			log.setOrderDetail(detail);
			log.setProduct(product);
			log.setProductQuantity(i+1);
			log.setCreatedby(1L);
			log.setCreateddate(new Date());
			log.setIsactive("Y");
			
			session.save(log);
			session.getTransaction().commit();
			session.close();
		}
	}
}










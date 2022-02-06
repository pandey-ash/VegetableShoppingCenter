package com.VegetableShoppingCentre.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.CartInputBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.pojo.Cart;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.pojo.UserInfo;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class CartProduct
{
	
	public OutputBean storeCartProductDao(CartInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		OutputBean outputBean = new OutputBean();
		
		
		
		Long userId = bean.getUserId();
		
		
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Cart cart set cart.isactive = 'N'" +
										  " where cart.createdby = :usrId");
		query.setLong("usrId", userId);
		int result = query.executeUpdate();
		session.flush();
		session.getTransaction().commit();
		session.close();
		List<Long> productId = bean.getProductId();
		List<Integer> quantity = bean.getQuantity();
		List<String> price = bean.getPrice();
		System.out.println(productId);
		
		for(int i=0; i<productId.size(); i++)
		{
			session = factory.openSession();
			session.beginTransaction();
			UserInfo userInfo = (UserInfo) session.get(UserInfo.class, userId);
			Product product = (Product) session.get(Product.class, productId.get(i));
			
			
//			query = session.createQuery(" select pro.pkProductId, user.pkUserId "+
//			                           	" from Cart cart join cart.product pro join cart.userInfo user "+
//										" where cart.isactive='Y' and pro.pkProductId=:proId and user.pkUserId=:usrId ");
//			
//			query.setLong("proId", productId.get(i));
//			query.setLong("usrId", userId);
			
//			List list = query.list();
//			if(!list.isEmpty())
//			{
//				continue;
//			}
			Cart cart = new Cart();
			cart.setUserInfo(userInfo);
			cart.setProduct(product);
			cart.setQuantity(quantity.get(i));
			cart.setEf1(price.get(i));
			cart.setCreatedby(userId);
			cart.setCreateddate(new Date());
			cart.setIsactive("Y");
			
			session.save(cart);
			session.getTransaction().commit();
			session.close();
		}
		outputBean.setFlag(true);
		//DatabaseConnection.closeConnection(session, factory);
		return outputBean;
	}
	
	public List getCartProductDao(Long productId)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Product product = (Product) session.get(Product.class, productId);
		
		List list = new ArrayList();
		list.add(product.getPkProductId());
		list.add(product.getImagePath());
		list.add(product.getPrice());
		list.add(product.getProductName());
		list.add(product.getDevileryBy());
		
		
		DatabaseConnection.closeConnection(session, factory);
		return list;
	}
	
	public void main(String a[])
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		OutputBean outputBean = new OutputBean();
			Session session = factory.openSession();
			session.beginTransaction();
			
			Query query1 = session.createQuery(" from UserInfo user where user.pkUserId=:userid ");
			Query query2 = session.createQuery(" from Product pro where pro.pkProductId=:productid ");
			query1.setLong("userid", 1L);
			query2.setLong("productid", 2L);
			List list1 = query1.list();
			List list2 = query2.list();
			UserInfo userInfo = (UserInfo) list1.get(0);
			Product product = (Product) list2.get(0);
			System.out.println(userInfo.getEmail());
			System.out.println(product.getDescription());
			/*UserInfo userInfo = (UserInfo) session.get(UserInfo.class, 1L);
			Product product = (Product) session.get(Product.class, 2L);*/
			Transaction transaction = session.getTransaction();
			Cart cart = new Cart();
			cart.setUserInfo(userInfo);
			cart.setProduct(product);
			cart.setQuantity(3);
			cart.setCreatedby(1L);
			cart.setCreateddate(new Date());
			cart.setIsactive("Y");
			
			session.save(cart);
			session.getTransaction().commit();
			session.close();
//			if (!transaction.wasCommitted())
//			{
//				transaction.commit();
//			}
		System.out.println("Success");
		
	}
}

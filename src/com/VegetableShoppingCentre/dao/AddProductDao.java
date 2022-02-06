package com.VegetableShoppingCentre.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.bean.CategoryInputBean;
import com.VegetableShoppingCentre.pojo.Category;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class AddProductDao
{
	
	public boolean addProductDao(AddInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = (Category) session.get(Category.class, bean.getCategory()); 
		Product product = new Product();
		product.setCategory(category);
		product.setProductName(bean.getProductName());
		product.setDescription(bean.getProductDesc());
		product.setPrice(bean.getPrice());
		product.setAvailableQuantity(bean.getQuantity());
		product.setImagePath(bean.getImagePath());
		product.setDevileryBy(bean.getDelivery());
		product.setCreatedby(bean.getCreatedby());
		product.setCreateddate(new Date());
		product.setIsactive("Y");
		product.setIsnew(bean.getIsNew());
		product.setIsupcoming(bean.getUpComing());
		
		session.save(product);
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		return true;
	}
	
	public boolean editProductDao(AddInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = (Category) session.get(Category.class, bean.getCategory()); 
		Product product = (Product) session.get(Product.class, bean.getProductId());
		product.setCategory(category);
		product.setProductName(bean.getProductName());
		product.setDescription(bean.getProductDesc());
		product.setPrice(bean.getPrice());
		product.setAvailableQuantity(bean.getQuantity());
		product.setImagePath(bean.getImagePath());
		product.setDevileryBy(bean.getDelivery());
		product.setModifiedby(bean.getCreatedby());
		product.setModifieddate(new Date());
		product.setIsactive("Y");
		product.setIsnew(bean.getIsNew());
		product.setIsupcoming(bean.getUpComing());
		
		session.save(product);
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		return true;
	}
	
	public boolean deleteProductDao(AddInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		 
		Product product = (Product) session.get(Product.class, bean.getProductId());
		product.setModifiedby(bean.getCreatedby());
		product.setModifieddate(new Date());
		product.setIsactive("N");
		
		session.save(product);
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		return true;
	}
	
	public boolean addCategoryDao(CategoryInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = new Category();
		category.setCategoryName(bean.categoryNmae);
		category.setLevel(1);
		category.setIsRoot("Y");
		category.setCreatedby(bean.getCreatedBy());
		category.setCreateddate(new Date());
		category.setIsactive("Y");
		
		session.save(category);
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		return true;
	}
	
	public boolean duplicateCategory(String categoryName)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(" from Category cat where cat.categoryName=:name ");
		query.setString("name", categoryName);
		
		List list = query.list();
		if(list.isEmpty())
		{
			transaction.commit();
			DatabaseConnection.closeConnection(session, factory);
			return false;
		}
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		return true;
	}
	
	public HashMap getCategoryDao()
	{
		HashMap categoryDetail = new HashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery(" select cat.pkCategoryId, cat.categoryName "+
		                                  " from Category cat "+
				                          " where cat.isRoot='Y' ");
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		for(int i=0; i<list.size(); i++)
		{
			Object object[] = (Object[]) list.get(i);
			categoryDetail.put(object[0], object[1]);
		}
		return categoryDetail;
	}
	
	public  void main(String[] args)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Category category = (Category) session.get(Category.class, 1L); 
		Product product = new Product();
		product.setCategory(category);
		product.setProductName("testing");
		product.setDescription("testting description");
		product.setPrice(45.7);
		product.setAvailableQuantity(55);
		product.setImagePath("testing.jpg");
		product.setDevileryBy("testing dilevery");
		product.setCreatedby(1L);
		product.setCreateddate(new Date());
		product.setIsactive("Y");
		product.setIsnew("Y");
		product.setIsupcoming("N");
		
		session.saveOrUpdate(product);
		transaction.commit();
		DatabaseConnection.closeConnection(session, factory);
		System.out.println("success");
	}
}

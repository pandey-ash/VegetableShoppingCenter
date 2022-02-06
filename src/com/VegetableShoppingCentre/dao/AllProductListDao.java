package com.VegetableShoppingCentre.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.AdminInputBean;
import com.VegetableShoppingCentre.pojo.Category;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class AllProductListDao
{
	
	public List getEditProductDetailDao(AdminInputBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		Product product =  (Product) session.get(Product.class, bean.getProductid());
		Category category = product.getCategory();
		
		List list = new ArrayList();
		list.add(product.getPkProductId());
		list.add(product.getProductName());
		list.add(product.getDescription());
		list.add(product.getDevileryBy());
		list.add(product.getPrice());
		list.add(product.getAvailableQuantity());
		list.add(category.getPkCategoryId());
		list.add(product.getIsupcoming());
		list.add(product.getIsnew());
		return list;
	}
	public HashMap getEditAllProductListDao()
	{
		HashMap allProduct = new HashMap();
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" from Product pro where pro.isactive='Y' ");
		
		List list = query.list();
		
		
		for(int i=0; i<list.size(); i++)
		{
			Product product = (Product) list.get(i);
			Category category = product.getCategory();
			List productDetail = new ArrayList();
			productDetail.add(product.getPkProductId());
			productDetail.add(product.getProductName());
			productDetail.add(product.getDescription());
			productDetail.add(product.getDevileryBy());
			productDetail.add(product.getPrice());
			productDetail.add(product.getAvailableQuantity());
			productDetail.add(category.getCategoryName());
			productDetail.add(product.getIsupcoming());
			productDetail.add(product.getIsnew());
			
			allProduct.put(i, productDetail);
		}
		DatabaseConnection.closeConnection(session, factory);
		return allProduct;
		
	}

	public List getAllProductList()
	{
		
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" select pro.imagePath, pro.productName, pro.price, pro.devileryBy "+
								" from Product pro "+
								" where pro.isactive='y' "+
								" order by pro.createddate desc ");
		
		List list = query.list();
		DatabaseConnection.closeConnection(session, factory);
		return list;
		
	}
	public void main(String[] args)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		
		
		Query query = session.createQuery(" from Product ");
		
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
	


package com.VegetableShoppingCentre.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.dao.AddProductDao;
import com.VegetableShoppingCentre.pojo.Category;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class AddProductImpl
{
	public boolean addProductImpl(AddInputBean bean)
	{
		return new AddProductDao().addProductDao(bean);
	}
	
	public boolean editProductImpl(AddInputBean bean)
	{
		return new AddProductDao().editProductDao(bean);
	}
	
	public boolean deleteProductImpl(AddInputBean bean)
	{
		return new AddProductDao().deleteProductDao(bean);
	}
	
	public HashMap getCategoryImpl()
	{
		return new AddProductDao().getCategoryDao();
	}
}

package com.VegetableShoppingCentre.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.CategoryInputBean;
import com.VegetableShoppingCentre.dao.AddProductDao;
import com.VegetableShoppingCentre.pojo.Category;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class CategoryImpl
{
	public boolean addCategoryImpl(CategoryInputBean bean)
	{
		return new AddProductDao().addCategoryDao(bean); 
	}
}

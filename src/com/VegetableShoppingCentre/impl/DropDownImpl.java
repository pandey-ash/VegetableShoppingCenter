package com.VegetableShoppingCentre.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.VegetableShoppingCentre.bean.DropDownBean;
import com.VegetableShoppingCentre.dao.DropDownDao;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class DropDownImpl
{
	public List getCategoryImpl()
	{
		return new DropDownDao().getCategoryDao();
	}
	
	public List getProductDropDownImpl(String categoryName)
	{
		DropDownBean bean = new DropDownBean();
		bean.setCategoryName(categoryName);
		return new DropDownDao().getProductDropDownDao(bean);
	}
}

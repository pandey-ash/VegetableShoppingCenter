package com.VegetableShoppingCentre.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.VegetableShoppingCentre.bean.AdminInputBean;
import com.VegetableShoppingCentre.dao.AllProductListDao;
import com.VegetableShoppingCentre.pojo.Category;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class EditProductImpl
{
	public List getEditProductDetailImpl(AdminInputBean bean)
	{
		return new AllProductListDao().getEditProductDetailDao(bean);
	}
	public HashMap getEditAllProductListImpl()
	{
		return new AllProductListDao().getEditAllProductListDao();
	}
}

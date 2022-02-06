package com.VegetableShoppingCentre.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.dao.NewProductDao;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class NewProductImpl
{
	public List getNewProductImpl()
	{
		return new NewProductDao().getNewProductDao();
	}
}

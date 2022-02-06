package com.VegetableShoppingCentre.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.dao.UpcomingProductDao;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class UpcomingProductImpl
{
	public List getUpcomingProductImpl()
	{
		return new UpcomingProductDao().getUpcomingProductDao();
	}
}

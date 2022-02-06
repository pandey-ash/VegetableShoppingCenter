package com.VegetableShoppingCentre.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.OrderBean;
import com.VegetableShoppingCentre.dao.PlaceOrderDao;
import com.VegetableShoppingCentre.pojo.Address;
import com.VegetableShoppingCentre.pojo.OrderDetail;
import com.VegetableShoppingCentre.pojo.OrderLog;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.pojo.UserInfo;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class PlaceOrderImpl
{
	public boolean placeOrderImpl(OrderBean bean)
	{
		return new PlaceOrderDao().placeOrderDao(bean);
	}
}

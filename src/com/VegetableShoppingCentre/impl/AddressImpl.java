package com.VegetableShoppingCentre.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.VegetableShoppingCentre.bean.AddressBean;
import com.VegetableShoppingCentre.dao.AddressDao;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class AddressImpl
{
	public List getUserAddressImpl(Long userId)
	{
		AddressBean bean = new AddressBean();
		bean.setUserId(userId);
		return new AddressDao().getUserAddressDao(bean);
	}
}

package com.VegetableShoppingCentre.impl;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.RegisterBean;
import com.VegetableShoppingCentre.dao.UserDataDao;
import com.VegetableShoppingCentre.pojo.UserInfo;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class UserInfoimpl
{
	public boolean saveUserDataImpl(RegisterBean bean)
	{
		return new UserDataDao().saveUserDataDao(bean);
	}
}

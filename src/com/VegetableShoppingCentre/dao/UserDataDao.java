package com.VegetableShoppingCentre.dao;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.RegisterBean;
import com.VegetableShoppingCentre.pojo.UserInfo;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class UserDataDao
{
	public boolean saveUserDataDao(RegisterBean bean)
	{
		SessionFactory factory = DatabaseConnection.getConnection();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		UserInfo info = new UserInfo();
		info.setFirstname(bean.getFirstName());
		info.setLastname(bean.getLastName());
		info.setIsadmin(bean.getIsAdmin());
		info.setGender(bean.getGender());
		info.setMobileNo(bean.getMblNo());
		info.setPassword(bean.getPasswd());
		info.setEmail(bean.getEmailId());
		info.setIsactive("Y");
		info.setCreatedby(1L);
		info.setCreateddate(new Date());
		session.save(info);
		transaction.commit();
		return true;
	}
}

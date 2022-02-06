package com.VegetableShoppingCentre.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.VegetableShoppingCentre.bean.CartInputBean;
import com.VegetableShoppingCentre.bean.LoginInputBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.dao.CartProduct;
import com.VegetableShoppingCentre.dao.CommonDao;
import com.VegetableShoppingCentre.pojo.Cart;
import com.VegetableShoppingCentre.pojo.Product;
import com.VegetableShoppingCentre.utility.DatabaseConnection;

public class CartProductImpl
{
	public List getCartProductImpl(Long productId)
	{
		return new CartProduct().getCartProductDao(productId);
	}
	
	public OutputBean storeCartProductImpl(CartInputBean bean)
	{
		return new CartProduct().storeCartProductDao(bean);
	}
	
	public LinkedHashMap getStoredCartProductImpl(CartInputBean bean)
	{
		return new CommonDao().getStoredCartProductDao(bean);
	}
}

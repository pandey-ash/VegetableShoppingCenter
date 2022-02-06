package com.VegetableShoppingCentre.helper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
























import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.bean.AddressBean;
import com.VegetableShoppingCentre.bean.AdminInputBean;
import com.VegetableShoppingCentre.bean.CartInputBean;
import com.VegetableShoppingCentre.bean.CategoryInputBean;
import com.VegetableShoppingCentre.bean.DropDownBean;
import com.VegetableShoppingCentre.bean.LoginInputBean;
import com.VegetableShoppingCentre.bean.OrderBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.bean.RegisterBean;
import com.VegetableShoppingCentre.dao.AddProductDao;
import com.VegetableShoppingCentre.dao.AddressDao;
import com.VegetableShoppingCentre.dao.AllProductListDao;
import com.VegetableShoppingCentre.dao.CartProduct;
import com.VegetableShoppingCentre.dao.CommonDao;
import com.VegetableShoppingCentre.dao.DropDownDao;
import com.VegetableShoppingCentre.dao.PlaceOrderDao;
import com.VegetableShoppingCentre.dao.UpcomingProductDao;
import com.VegetableShoppingCentre.dao.UserDataDao;
import com.VegetableShoppingCentre.impl.AddProductImpl;
import com.VegetableShoppingCentre.impl.AddressImpl;
import com.VegetableShoppingCentre.impl.CartProductImpl;
import com.VegetableShoppingCentre.impl.CategoryImpl;
import com.VegetableShoppingCentre.impl.DropDownImpl;
import com.VegetableShoppingCentre.impl.EditProductImpl;
import com.VegetableShoppingCentre.impl.NewProductImpl;
import com.VegetableShoppingCentre.impl.PlaceOrderImpl;
import com.VegetableShoppingCentre.impl.UpcomingProductImpl;
import com.VegetableShoppingCentre.impl.UserInfoimpl;

public class Helper
{
	public List getEditProductDetail(AdminInputBean bean)
	{
		return new EditProductImpl().getEditProductDetailImpl(bean);
	}
	
	public OutputBean storeCartProduct(CartInputBean bean)
	{
		return new CartProductImpl().storeCartProductImpl(bean);
	}
	
	public List getUpcomingProduct()
	{
		return new UpcomingProductImpl().getUpcomingProductImpl();
	}
	
	public List getNewProduct()
	{
		return new NewProductImpl().getNewProductImpl();
	}
	
	public List getCartProduct(Long productId)
	{
		return new CartProductImpl().getCartProductImpl(productId);
	}
	
	public OutputBean getLoginStatus(LoginInputBean inputbean) throws SQLException
	{
		return new CommonDao().validateLogin(inputbean);
	}
	
	public LinkedHashMap getStoredCartProduct(CartInputBean bean)
	{
		return new CartProductImpl().getStoredCartProductImpl(bean);
	}
	
	public HashMap getCategory()
	{
		return new AddProductImpl().getCategoryImpl();
	}
	
	public boolean addProduct(AddInputBean bean)
	{
		return new AddProductImpl().addProductImpl(bean);
	}
	public HashMap getEditAllProductList()
	{
		return new EditProductImpl().getEditAllProductListImpl();
	}
	
	public boolean addCategory(CategoryInputBean bean)
	{
		return new CategoryImpl().addCategoryImpl(bean); 
	}
	
	public boolean deleteProduct(AddInputBean bean)
	{
		return new AddProductImpl().deleteProductImpl(bean);
	}
	
	public List getCategoryDropDown()
	{
		return new DropDownImpl().getCategoryImpl();
	}
	
	public List getProductDropDownImpl(String categoryName)
	{
		return new DropDownImpl().getProductDropDownImpl(categoryName);
	}
	
	public List getUserAddress(Long userId)
	{
		return new AddressImpl().getUserAddressImpl(userId);
	}
	
	public boolean placeOrder(OrderBean bean)
	{
		return new PlaceOrderImpl().placeOrderImpl(bean);
	}
	public boolean saveUserData(RegisterBean bean)
	{
		return new UserInfoimpl().saveUserDataImpl(bean);
	}
}

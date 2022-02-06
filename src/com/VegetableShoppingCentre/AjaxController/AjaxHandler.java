package com.VegetableShoppingCentre.AjaxController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
















import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.bean.AdminInputBean;
import com.VegetableShoppingCentre.bean.CartInputBean;
import com.VegetableShoppingCentre.bean.CategoryInputBean;
import com.VegetableShoppingCentre.bean.LoginInputBean;
import com.VegetableShoppingCentre.bean.OrderBean;
import com.VegetableShoppingCentre.bean.OutputBean;
import com.VegetableShoppingCentre.dao.PlaceOrderDao;
import com.VegetableShoppingCentre.helper.Helper;
import com.VegetableShoppingCentre.impl.AddProductImpl;
import com.VegetableShoppingCentre.impl.CartProductImpl;
import com.VegetableShoppingCentre.impl.CategoryImpl;
import com.VegetableShoppingCentre.impl.EditProductImpl;
import com.VegetableShoppingCentre.impl.PlaceOrderImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AjaxHandler
{
	public boolean orderNewAddrAjax(Long userId, Integer totalProduct, Long totalAmt, List productId, List productQty, List productPrice, String address1, String landmark, Long pincode, Long city, Long mobileNo)
	{
		OrderBean bean = new OrderBean();
		bean.setUserId(userId);
		bean.setTotalProduct(totalProduct);
		bean.setTotalAmt(totalAmt);
		bean.setProductId(productId);
		bean.setProductPrice(productPrice);
		bean.setProductQuantity(productQty);
		bean.setAddress1(address1);
		bean.setLandmark(landmark);
		bean.setPincode(pincode);
		bean.setCity(city);
		bean.setMobileNo(mobileNo);
		return new PlaceOrderDao().placeOrderNewAddressDao(bean);
	}
	public boolean placeOrderAjax(Long userId, Long addressId, Integer totalProduct, Long totalAmt, List productId, List productQty, List productPrice)
	{
		OrderBean bean = new OrderBean();
		bean.setAddressId(addressId);
		bean.setUserId(userId);
		bean.setTotalProduct(totalProduct);
		bean.setTotalAmt(totalAmt);
		bean.setProductId(productId);
		bean.setProductPrice(productPrice);
		bean.setProductQuantity(productQty);
		return new PlaceOrderImpl().placeOrderImpl(bean);
	}
	
	public boolean deleteProductAjax(Long productId, Long userId)
	{
		AddInputBean bean = new AddInputBean();
		bean.setProductId(productId);
		bean.setCreatedby(userId);
		return new AddProductImpl().deleteProductImpl(bean);
	}
	
	public boolean addCategoryAjax(String categoryName, Long userId)
	{
		CategoryInputBean bean = new CategoryInputBean();
		bean.setCategoryNmae(categoryName);
		bean.setCreatedBy(userId);
		return new CategoryImpl().addCategoryImpl(bean); 
	}
	
	public List getEditProductDetailAjax(String productid)
	{
		AdminInputBean bean = new AdminInputBean();
		bean.setProductid(Long.valueOf(productid));
		return new EditProductImpl().getEditProductDetailImpl(bean);
	}
	
	public HashMap getEditAllProductListAjax()
	{
		return new Helper().getEditAllProductList();
	}
	
	public boolean addProductAjax(String productName, String productDesc, String delivery, String price, String category, String upComing, String isNew, String quantity, String imagePath, Long userId)
	{
		AddInputBean bean = new AddInputBean();
		bean.setProductName(productName);
		bean.setProductDesc(productDesc);
		bean.setDelivery(delivery);
		bean.setPrice(Double.valueOf(price));
		bean.setCategory(Long.valueOf(category));
		bean.setUpComing(upComing);
		bean.setIsNew(isNew);
		bean.setQuantity(Integer.valueOf(quantity));
		bean.setImagePath(imagePath);
		bean.setCreatedby(userId);
		
		return new AddProductImpl().addProductImpl(bean);
	}
	
	
	public boolean editProductAjax(String productName, String productDesc, String delivery, String price, String category, String upComing, String isNew, String quantity, String imagePath, Long userId, Long productId)
	{
		AddInputBean bean = new AddInputBean();
		bean.setProductId(productId);
		bean.setProductName(productName);
		bean.setProductDesc(productDesc);
		bean.setDelivery(delivery);
		bean.setPrice(Double.valueOf(price));
		bean.setCategory(Long.valueOf(category));
		bean.setUpComing(upComing);
		bean.setIsNew(isNew);
		bean.setQuantity(Integer.valueOf(quantity));
		bean.setImagePath(imagePath);
		bean.setCreatedby(userId);
		
		return new AddProductImpl().editProductImpl(bean);
	}
	public HashMap getCategoryAjax()
	{
		return new Helper().getCategory();
	}
	public OutputBean storeCartData(Long userId, List productId, List quantity, List price)
	{
		CartInputBean bean = new CartInputBean();
		bean.setUserId(userId);
		bean.setProductId(productId);
		bean.setQuantity(quantity);
		bean.setPrice(price);
		return new Helper().storeCartProduct(bean);
	}
	
	public LinkedHashMap getCartProductAjax(String userId)
	{
		CartInputBean bean = new CartInputBean();
		bean.setUserId(Long.valueOf(userId));
		return new Helper().getStoredCartProduct(bean);
	}
	
	public List getCartProductDetail(String productId)
	{
		return new Helper().getCartProduct(Long.valueOf(productId));
	}
	
	public OutputBean getLoginInfo(String email, String passwd)
	{
		try
		{
			LoginInputBean inputbean = new LoginInputBean();
			inputbean.setEmail(email);
			inputbean.setPasswd(passwd);
			Helper help = new Helper();
			return help.getLoginStatus(inputbean);
		}catch(Exception e)
		{
			System.out.println("exception occurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr"+ e.getMessage());
			return null;
		}
	}
}

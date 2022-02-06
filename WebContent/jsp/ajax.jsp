<%@page import="com.VegetableShoppingCentre.dao.CommonDao"%>
<%@page import="com.VegetableShoppingCentre.dao.AddressDao"%>
<%@page import="com.VegetableShoppingCentre.bean.AddressBean"%>
<%@page import="com.VegetableShoppingCentre.dao.AddProductDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.hibernate.Session"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.IOException"%>
<%@page import="com.VegetableShoppingCentre.bean.OutputBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.VegetableShoppingCentre.AjaxController.AjaxHandler"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!

public String toJSON(Object jsonObject)
{
	Gson gson= new GsonBuilder().create();
	return gson.toJson(jsonObject);
}

public void getCartProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String userId)
{
	LinkedHashMap cartProduct = new AjaxHandler().getCartProductAjax(userId);
	List savedCartProduct = new ArrayList();
	Iterator product = cartProduct.entrySet().iterator();
	HttpSession session = request.getSession();
	List list = (List) session.getAttribute("cartProduct");
	if(list == null)
	{
		list = new ArrayList();
	}
	Outer:
	while (product.hasNext()) {
	    Map.Entry entry = (Map.Entry) product.next();
	    String key = entry.getKey().toString();
	    List cartProductDetail = (List)entry.getValue();
	    
	    for(int i=0; i<list.size(); i++)
	    {
	    	List productDetail = (List) list.get(i);
	    	if(cartProductDetail.get(0).equals(productDetail.get(0)))
	    	{
	    		continue Outer;
	    	}
	    }
	    list.add((List)entry.getValue());
	}
	
	session.setAttribute("cartProduct", list);
	out.print(toJSON(cartProduct));
}

public void saveCartDetail(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException
{
	List list1= new ArrayList(Arrays.asList(request.getParameter("productId").split(",")));
	List list2 = new ArrayList(Arrays.asList(request.getParameter("quantity").split(",")));
	List list3 = new ArrayList(Arrays.asList(request.getParameter("productPrice").split(",")));
	HttpSession session = request.getSession();
	Long user = new Long(session.getAttribute("userId").toString());
	List productId = new ArrayList();
	List quantity = new ArrayList();
	List price = new ArrayList();
	
	if("".equals(request.getParameter("quantity")))
	{
		OutputBean bean = new AjaxHandler().storeCartData( user, productId, quantity, price);
		out.print("hello");
		return;
	}
	for(int i=0; i<list1.size(); i++)
	{
		String tempProductId = list1.get(i).toString();
		String tempQuantity = (String) list2.get(i);
		String tempPice = list3.get(i).toString();
		productId.add(Long.valueOf(tempProductId));
		quantity.add(Integer.valueOf(tempQuantity));
		price.add(tempPice);
	}
	
	/* for(int i=0; i<list2.size(); i++)
	{
		String strNumber = (String) list2.get(i);
		quantity.add(Integer.valueOf(strNumber));
	} */
	
	
	OutputBean bean = new AjaxHandler().storeCartData( user, productId, quantity, price);
	out.print("hello");
}

public void checkLoginData(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException
{
	String email = request.getParameter("email");
	String passwd = request.getParameter("passwd");
	AjaxHandler ah = new AjaxHandler();
	OutputBean ob = ah.getLoginInfo(email, passwd);
	if(ob.getLogin().containsKey("true"))
	{
		HttpSession session = request.getSession();
		session.setAttribute("userId", ob.getLogin().get("id").toString());
		session.setAttribute("email", email);
		session.setAttribute("admin", ob.getLogin().get("true")+"");
		getCartProduct(request, response, out, ob.getLogin().get("id").toString());
		response.sendRedirect(request.getContextPath());
		out.print("true");
	}else
	{
		out.print("false");
	}
}

public void addProdctToCart(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	List list =  new AjaxHandler().getCartProductDetail(request.getParameter("productId"));
	list.add("1");
	HttpSession session = request.getSession();
	List cartProduct = new ArrayList();
	cartProduct.add(list);
	if (session.getAttribute("cartProduct") != null)
	{
		List list1 = (List) session.getAttribute("cartProduct");
		list1.add(list);
		session.setAttribute("cartProduct", list1);
	}
	else
	{
		session.setAttribute("cartProduct", cartProduct);
	}
	out.println(toJSON(list));
}

public void updateQuantity(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String productId, String quantity, String price)
{
	Long product = new Long(productId);
	HttpSession session = request.getSession();
	List cartList = (List) session.getAttribute("cartProduct");
	for(int i=0; i<cartList.size(); i++)
	{
		List productDetail = (List) cartList.get(i);
		if(product.equals(productDetail.get(0)))
		{
			productDetail.set((productDetail.size()-1), quantity);
			productDetail.set(2, price);
			cartList.set(i, productDetail);
			session.setAttribute("cartProduct", cartList);
			out.println("true");
			break;
		}
		
	}
}
public void removeProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out, String productId)
{
	Long product = new Long(productId);
	HttpSession session = request.getSession();
	List cartList = (List) session.getAttribute("cartProduct");
	for(int i=0; i<cartList.size(); i++)
	{
		List productDetail = (List) cartList.get(i);
		if(product.equals(productDetail.get(0)))
		{
			cartList.remove(i);
			session.setAttribute("cartProduct", cartList);
			out.println("true");
			break;
		}
	}
}

public void getRootCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HashMap category = new AjaxHandler().getCategoryAjax();
	out.println(toJSON(category));
}

public void addNewProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	Long userId =  Long.valueOf((String)session.getAttribute("userId"));
	boolean result = new AjaxHandler().addProductAjax(request.getParameter("productName"), request.getParameter("productDesc"), request.getParameter("delivery"), request.getParameter("price"), request.getParameter("category"), request.getParameter("upComing"), request.getParameter("isNew"), request.getParameter("quantity"), request.getParameter("imagePath"), userId);
	Boolean boolean1 = new Boolean(result);
	out.println(toJSON(boolean1));
}

public void editProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	Long userId =  Long.valueOf((String)session.getAttribute("userId"));
	Long productId = Long.valueOf(request.getParameter("productId"));
	boolean result = new AjaxHandler().editProductAjax(request.getParameter("productName"), request.getParameter("productDesc"), request.getParameter("delivery"), request.getParameter("price"), request.getParameter("category"), request.getParameter("upComing"), request.getParameter("isNew"), request.getParameter("quantity"), request.getParameter("imagePath"), userId, productId);
	Boolean boolean1 = new Boolean(result);
	out.println(toJSON(boolean1));
}

public void getEditProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	out.print(toJSON(new AjaxHandler().getEditAllProductListAjax()));
}

public void getEditProductDetail(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	out.print(toJSON(new AjaxHandler().getEditProductDetailAjax(request.getParameter("productid"))));
}

public void addCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	Long userId =  Long.valueOf((String)session.getAttribute("userId"));
	out.print(toJSON(new Boolean(new AjaxHandler().addCategoryAjax(request.getParameter("categoryName"), userId))));
}

public void deleteProduct(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	Long userId =  Long.valueOf((String)session.getAttribute("userId"));
	Long productId = Long.valueOf(request.getParameter("productId"));
	out.print(toJSON(new Boolean(new AjaxHandler().deleteProductAjax(productId, userId))));
}

public void checkDuplicateCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	out.print(toJSON(new Boolean(new AddProductDao().duplicateCategory(request.getParameter("categoryName")))));	
}

public void placeOrder(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	List productId= new ArrayList(Arrays.asList(request.getParameter("productId").split(",")));
	List productQty = new ArrayList(Arrays.asList(request.getParameter("quantity").split(",")));
	List productPrice = new ArrayList(Arrays.asList(request.getParameter("productPrice").split(",")));
	Boolean boolean1 = new Boolean(new AjaxHandler().placeOrderAjax( Long.valueOf((String)session.getAttribute("userId")), Long.valueOf((String)request.getParameter("addressId")), Integer.valueOf(request.getParameter("totalProduct")), Long.valueOf(request.getParameter("totalAmt")), productId, productQty, productPrice));
	if(boolean1.booleanValue())
	{
		session.removeAttribute("cartProduct");
		out.print(toJSON(boolean1));
	}
	out.print(toJSON(boolean1));
	//out.print(toJSON(new Boolean(new AjaxHandler().placeOrderAjax( Long.valueOf((String)session.getAttribute("userId")), Long.valueOf((String)request.getParameter("addressId")), Integer.valueOf(request.getParameter("totalProduct")), Long.valueOf(request.getParameter("totalAmt")), productId, productQty, productPrice))));	
}

public void getState(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	out.print(toJSON(new AddressDao().getState()));	
}

public void getCity(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	out.print(toJSON(new AddressDao().getCity(Long.valueOf(request.getParameter("stateId")))));	
}

public void orderNewAddr(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	HttpSession session = request.getSession();
	List productId= new ArrayList(Arrays.asList(request.getParameter("productId").split(",")));
	List productQty = new ArrayList(Arrays.asList(request.getParameter("quantity").split(",")));
	List productPrice = new ArrayList(Arrays.asList(request.getParameter("productPrice").split(",")));
	Boolean boolean1 = new Boolean(new AjaxHandler().orderNewAddrAjax( Long.valueOf((String)session.getAttribute("userId")), Integer.valueOf(request.getParameter("totalProduct")), Long.valueOf(request.getParameter("totalAmt")), productId, productQty, productPrice, request.getParameter("address1"), request.getParameter("landmark"), Long.valueOf(request.getParameter("pincode")), Long.valueOf(request.getParameter("city")), Long.valueOf(request.getParameter("mobileNo"))));
	if(boolean1.booleanValue())
	{
		session.removeAttribute("cartProduct");
		out.print(toJSON(boolean1));
	}
	out.print(toJSON(boolean1));
	//out.print(toJSON(new Boolean(new AjaxHandler().orderNewAddrAjax( Long.valueOf((String)session.getAttribute("userId")), Integer.valueOf(request.getParameter("totalProduct")), Long.valueOf(request.getParameter("totalAmt")), productId, productQty, productPrice, request.getParameter("address1"), request.getParameter("landmark"), Long.valueOf(request.getParameter("pincode")), Long.valueOf(request.getParameter("city")), Long.valueOf(request.getParameter("mobileNo"))))));	
}

public void checkDuplicateEmail(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
{
	String email = request.getParameter("email");
	out.print(new CommonDao().checkMailDao(email));
}
%>

<%
	String action = request.getParameter("action");
	if("add product to cart".equals(action))
	{
		addProdctToCart(request, response, response.getWriter());
	}
	else if("login".equals(request.getParameter("action")))
	{
		checkLoginData(request, response, response.getWriter());
	}
	else if("save cart product".equals(action))
	{
		saveCartDetail(request, response, response.getWriter());
	}
	else if("get cart data".equals(action))
	{
		getCartProduct(request, response, response.getWriter(),  request.getParameter("userId"));
	}
	
	else if("remove product".equals(action))
	{
		removeProduct(request, response, response.getWriter(), request.getParameter("productId"));
	}
	else if("add quantity detail".equals(action))
	{
		updateQuantity(request, response, response.getWriter(), request.getParameter("productId"), request.getParameter("quantity"), request.getParameter("price"));
	}
	
	else if("get category".equals(action))
	{
		getRootCategory(request, response, response.getWriter());
	}
	
	else if("add-product".equals(action))
	{
		addNewProduct(request, response, response.getWriter());
	}
	else if("edit-product".equals(action))
	{
		editProduct(request, response, response.getWriter());
	}
	else if("get all product".equals(action))
	{
		getEditProduct(request, response, response.getWriter());
	}
	else if("get edit product".equals(action))
	{
		getEditProductDetail(request, response, response.getWriter());
	}
	else if("add category".equals(action))
	{
		addCategory(request, response, response.getWriter());
	}
	else if("delete product".equals(action))
	{
		deleteProduct(request, response, response.getWriter());
	}
	else if("duplicate categoryName".equals(action))
	{
		checkDuplicateCategory(request, response, response.getWriter());
	}
	else if("place order".equals(action))
	{
		placeOrder(request, response, response.getWriter());
	}
	else if("get state".equals(action))
	{
		getState(request, response, response.getWriter());
	}
	else if("get city".equals(action))
	{
		getCity(request, response, response.getWriter());
	}
	else if("place order with new address".equals(action))
	{
		orderNewAddr(request, response, response.getWriter());
	}
	else if("duplicate_email".equals(request.getParameter("action")))
	{
		checkDuplicateEmail(request, response, response.getWriter());	
	}
	
	
%>
</body>
</html>
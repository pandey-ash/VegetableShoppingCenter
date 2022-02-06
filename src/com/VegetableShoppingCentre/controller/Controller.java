package com.VegetableShoppingCentre.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.bean.RegisterBean;
import com.VegetableShoppingCentre.helper.Helper;
import com.VegetableShoppingCentre.impl.AddProductImpl;
import com.oreilly.servlet.MultipartRequest;

public class Controller extends HttpServlet
{  
	private boolean isMultipart;
	private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    public void init( )
    {
	      filePath = getServletContext().getInitParameter("file-upload"); 
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		if("register".equals(action))
		{
			RegisterBean bean = new RegisterBean();
			bean.setEmailId(request.getParameter("email"));
			bean.setPasswd(request.getParameter("password"));
			bean.setFirstName(request.getParameter("first_name"));
			bean.setLastName(request.getParameter("last_name"));
			bean.setIsAdmin(request.getParameter("is_admin"));
			bean.setGender(request.getParameter("gender"));
			bean.setMblNo((Long.valueOf((String)request.getParameter("mobile_no"))));
			if(new Helper().saveUserData(bean))
			{
				response.sendRedirect(request.getContextPath()+"/jsp/success.jsp?msg=Registered Successfully&url="+request.getContextPath());
			}
		}
	}

}


//System.out.println("iffffffffffffffffffffffffffffffffffffffffff");
//HttpSession session = request.getSession();
//Long userId =  Long.valueOf((String)session.getAttribute("userId"));
//AddInputBean bean = new AddInputBean();
//MultipartRequest multipartRequest = new MultipartRequest(request, "D:\\dev\\projects\\FileUpload\\WebContent\\images");
//System.out.println(multipartRequest.getOriginalFileName("file_name"));
//bean.setProductName(request.getParameter("productName"));
//bean.setProductDesc(request.getParameter("productDesc"));
//bean.setDelivery(request.getParameter("delivery"));
//bean.setPrice(Double.valueOf(request.getParameter("price")));
//bean.setCategory(Long.valueOf(request.getParameter("category")));
//bean.setUpComing(request.getParameter("upComing"));
//bean.setIsNew(request.getParameter("isNew"));
//bean.setQuantity(Integer.valueOf(request.getParameter("quantity")));
//bean.setImagePath(multipartRequest.getOriginalFileName("file_name"));
//bean.setCreatedby(userId);
//boolean operation =  new AddProductImpl().addProductImpl(bean);
//if(operation)
//{
//	response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
//}
//else
//{
//	out.print("unsuccess");
//}
package com.VegetableShoppingCentre.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.VegetableShoppingCentre.bean.AddInputBean;
import com.VegetableShoppingCentre.impl.AddProductImpl;

public class FileUpload extends HttpServlet
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
		  String action= null;
		  isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	   
	      if( !isMultipart )
	      {
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	   
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	   
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );
	      try { 
	          // Parse the request to get file items.
	          List fileItems = upload.parseRequest(request);
	 	
	          // Process the uploaded file items
	          Iterator i = fileItems.iterator();

	          out.println("<html>");
	          out.println("<head>");
	          out.println("<title>Servlet upload</title>");  
	          out.println("</head>");
	          out.println("<body>");
	          
	          AddInputBean bean = new AddInputBean();
//	          HttpSession session = request.getSession();
//	          Long userId =  Long.valueOf((String)session.getAttribute("userId"));
//	          bean.setCreatedby(userId);
	          while ( i.hasNext () ) 
	          {
	             FileItem fi = (FileItem)i.next();
	             if ( !fi.isFormField () )
	             {
	                // Get the uploaded file parameters
	                String fieldName = fi.getFieldName();
	                String fileName = fi.getName();
	                bean.setImagePath(fileName);
	                String contentType = fi.getContentType();
	                boolean isInMemory = fi.isInMemory();
	                long sizeInBytes = fi.getSize();
	             
	                // Write the file
	                if( fileName.lastIndexOf("\\") >= 0 ) {
	                   file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
	                } else {
	                   file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\")+1)) ;
	                }
	                fi.write( file ) ;
	                //out.println("Uploaded Filename: " + fileName + "<br>");
	             }
	             else
	             {
	            	 String name = fi.getFieldName();
	            	 if("product_name".equals(name))
	            	 {
	            		 bean.setProductName(fi.getString());
	            		 String value = fi.getString();
	            	 }
	            	 else if("product_desc".equals(name))
	            	 {
	            		 bean.setProductDesc(fi.getString());
	            	 }
	            	 else if("delievry_time".equals(name))
	            	 {
	            		 bean.setDelivery(fi.getString());
	            	 }
	            	 else if("price".equals(name))
	            	 {
	            		 bean.setPrice(Double.valueOf(fi.getString()));
	            	 }
	            	 else if("quantity".equals(name))
	            	 {
	            		 bean.setQuantity(Integer.valueOf(fi.getString()));
	            	 }
	            	 else if("category".equals(name))
	            	 {
	            		 bean.setCategory(Long.valueOf(fi.getString()));
	            	 }
	            	 else if("upcoming_product".equals(name))
	            	 {
	            		 bean.setUpComing(fi.getString());
	            	 }
	            	 else if("new_product".equals(name))
	            	 {
	            		 bean.setIsNew(fi.getString());
	            	 }
	            	 else if("action".equals(name))
	            	 {
	            		 action = fi.getString();
	            	 }
	            	 else if("edit-productid".equals(name))
	            	 {
	            		 bean.setProductId(Long.valueOf(fi.getString()));
	            	 }
	            	 else if("newUserId".equals(name))
	            	 {
	            		 bean.setCreatedby(Long.valueOf(fi.getString()));
	            	 }
	                 String value = fi.getString();
	             }
	          }
	          
	          if("add-product".equals(action))
	          {
	        	  boolean operation =  new AddProductImpl().addProductImpl(bean);
	        	  if(operation)
	        	  {
	        		  response.sendRedirect(request.getContextPath()+"/jsp/success.jsp?msg=Product Added Successfully&url="+request.getContextPath()+"/jsp/admin.jsp");
	        		  //response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
	        	  }
	        	  else
	        	  {
	        		  out.print("unsuccess");
	        	  }
	          }
	          else if("edit-product".equals(action))
	          {
	        	  boolean operation =  new AddProductImpl().editProductImpl(bean);
	        	  if(operation)
	        	  {
	        		  response.sendRedirect(request.getContextPath()+"/jsp/success.jsp?msg=Product Updated Successfully&url="+request.getContextPath()+"/jsp/admin.jsp");
	        		  //response.sendRedirect(request.getContextPath()+"/jsp/admin.jsp");
	        	  }
	        	  else
	        	  {
	        		  out.print("unsuccess");
	        	  }
	          }
	          
	          
	          } catch(Exception ex) {
	        	 response.sendRedirect(request.getContextPath()+"/jsp/success.jsp"+"?msg=image size is to large&operation=unsuccess&url="+request.getContextPath()+"/jsp/admin.jsp");
	             System.out.println(ex);
	          }
	       }
	}
















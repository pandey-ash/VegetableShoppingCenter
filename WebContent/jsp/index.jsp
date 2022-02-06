<%@page import="java.util.Arrays"%>
<%@page import="com.VegetableShoppingCentre.helper.Helper"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/header.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/index.css">
<script type="text/javascript">
window.addEventListener( "pageshow", function ( event ) {
	  var historyTraversal = event.persisted || ( typeof window.performance != "undefined" && window.performance.navigation.type === 2 );
	  if ( historyTraversal ) {
	    // Handle page restore.
	    window.location.reload();
	  }
	});
</script>
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/script.js"></script>
<body style="background: white;">
<%@ include file="header.jsp" %> 
<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>" />
	<!-- ----------------for upcoming product------------------------------ -->
	<div class="wrapper">
		<div class="upcoming-heading-div">
			<span class="upcoming-heading">Fresh Offer<span><img src="<%= request.getContextPath()%>/images/coming.gif" style="margin-top: -12px;margin-left: 4px;">
		</div>
		<%
			List list = new Helper().getUpcomingProduct();
			for(int i=0; i<list.size(); i++)
			{
				Object object[] = (Object[]) list.get(i); 		
				
		%>
			<%
				if(i==3)
				{
				
			%>
					<div class="upcoming-product spacing last-div">
						<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/<%= object[0]%>);background-size: 100% 100%;"></div>
			
					<p style="font-size: 23px;" class="upcoming-text"><b>Product:</b> <%= object[1]%></p>
					<p style="font-size: 23px;" class="upcoming-text"><b>MRP:</b> RS <%= object[2]%>/KG</p>
					<p style="font-size: 18px;" class="upcoming-text"><b>Standard Delivery:</b> <%= object[3]%></p>
					</div>
					
			<%
					break;
				}
			%>
				<div class="upcoming-product spacing">
					<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/<%= object[0]%>);background-size: 100% 100%;"></div>
			
					<p style="font-size: 23px;" class="upcoming-text"><b>Product:</b> <%= object[1]%></p>
					<p style="font-size: 23px;" class="upcoming-text"><b>MRP:</b> RS <%= object[2]%>/KG</p>
					<p style="font-size: 18px; line-height: 24px;" class="upcoming-text"><b>Standard Delivery:</b> <%= object[3]%></p>
				</div>
				
		<%
			}		
		%>
	<div class="clr"></div>
	</div>
	<!-- ----------------for upcoming product end------------------------------ -->
	
	<!-- ----------------for new product list------------------------------ -->
 	<div class="wrapper section-spacing">
 	<div class="upcoming-heading-div" style="margin-bottom: 23px;">
			<span class="new-heading" style="font-size: 32px;">Newly Launched Offered<span><img src="<%= request.getContextPath()%>/images/new.gif" style="margin-top: -15px;">
		</div>
		<%
			List list1 = new Helper().getNewProduct();
			for(int i=0; i<list1.size(); i++)
			{
				Object object[] = (Object[]) list1.get(i); 		
				
		%>
			<%
				if(i==3)
				{
				
			%>
					<div class="upcoming-product spacing last-div">
						<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/<%= object[1]%>);background-size: 100% 100%;" onclick="cart.description('<%= object[0]%>', '<%= object[1]%>', '<%= object[2]%>', '<%= object[3]%>', '<%= object[4]%>', '<%= object[5]%>')"></div>
			
						<p style="font-size: 23px;" class="upcoming-text"><b>Product:</b> <%= object[2]%></p>
						<p style="font-size: 23px;" class="upcoming-text"><b>MRP:</b> RS <%= object[3]%>/KG</p>
						<p id="before-button<%= object[0]%>" style="font-size: 18px; line-height: 24px;" class="upcoming-text"><b>Standard Delivery:</b> <%= object[4]%></p>
						<%
						session = request.getSession(false);
						List emptyCart = (List) session.getAttribute("cartProduct");
						if(session.getAttribute("cartProduct")==null || emptyCart.isEmpty())
						{
					%>
							<input type="hidden" id="cart-presence<%= object[0]%>" value="absent">
						    <button value="install" id="<%= object[0]%>" class="install btn btn-success" onclick="cart.addToCart('<%= object[0]%>', '<%= object[5]%>')">Cart</button>

					<% 
						}
						else
						{
						List cartProduct = (List) session.getAttribute("cartProduct");
						for(int j=0; j<cartProduct.size(); j++)
						{
							List productDetail = (List) cartProduct.get(j);
							if(productDetail.get(0).equals(object[0]))
							{
						%>
								<input type="hidden" id="cart-presence<%= object[0]%>" value="present">
								<p id='cart-product<%= object[0]%>' class="added-to-cart">Added to cart</p>
						<%
								break;
							}
							if(j == (cartProduct.size()-1))
							{
							
						%>
								<input type="hidden" id="cart-presence<%= object[0]%>" value="absent">
								<button value="install" id="<%= object[0]%>" class="install btn btn-success" onclick="cart.addToCart('<%= object[0]%>', '<%= object[5]%>')">Cart</button>
						<%
								
							}}}
						%>
					</div>
					<div class="clr"></div>
					
			<%
					break;
				}
			%>
					<div class="upcoming-product spacing">
						<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/<%= object[1]%>);background-size: 100% 100%;" onclick="cart.description('<%= object[0]%>', '<%= object[1]%>', '<%= object[2]%>', '<%= object[3]%>', '<%= object[4]%>', '<%= object[5]%>')"></div>
			
						<p style="font-size: 23px;" class="upcoming-text"><b>Product:</b> <%= object[2]%></p>
						<p style="font-size: 23px;" class="upcoming-text"><b>MRP:</b> RS <%= object[3]%>/KG</p>
						<p id="before-button<%= object[0]%>" style="font-size: 18px; line-height: 24px;" class="upcoming-text"><b>Standard Delivery:</b> <%= object[4]%></p>
						
						<%
						session = request.getSession(false);
						List emptyCart = (List) session.getAttribute("cartProduct");
						if(session.getAttribute("cartProduct")==null || emptyCart.isEmpty())
						{
					%>
							<input type="hidden" id="cart-presence<%= object[0]%>" value="absent">
						    <button value="install" id="<%= object[0]%>" class="install btn btn-success" onclick="cart.addToCart('<%= object[0]%>', '<%= object[5]%>')">Cart</button>
							
					<% 
						}
						else
						{
						List cartProduct = (List) session.getAttribute("cartProduct");
						for(int j=0; j<cartProduct.size(); j++)
						{
							List productDetail = (List) cartProduct.get(j);
							if(productDetail.get(0).equals(object[0]))
							{
						%>
								<input type="hidden" id="cart-presence<%= object[0]%>" value="present">
								<p id='cart-product<%= object[0]%>' class="added-to-cart">Added to cart</p>
						<%
								break;
							}
							if(j == (cartProduct.size()-1))
							{
						%>
								<input type="hidden" id="cart-presence<%= object[0]%>" value="absent">	
								<button value="install" id="<%= object[0]%>" class="install" onclick="cart.addToCart('<%= object[0]%>', '<%= object[5]%>')">Cart</button>
						<%
							}}}
						%>
					</div>
				
		<%
			}		
		%>
	<div class="clr"></div>
	
	</div>
	<!-- ----------------for new product list end------------------------------ -->
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<%-- <div class="upcoming-product spacing">
			<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/apple.jpg);background-size: 100% 100%;"></div>
			
			<p>MRP: RS 500/KG</p>
		</div>
		<div class="upcoming-product spacing">
			<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/apple.jpg);background-size: 100% 100%;"></div>
			
			<p>MRP: RS 500/KG</p>
		</div>
		<div class="upcoming-product spacing">
			<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/apple.jpg);background-size: 100% 100%;"></div>
			
			<p>MRP: RS 500/KG</p>
		</div>
		<div class="upcoming-product spacing last-div">
			<div class="product-image" style="background: url(<%= request.getContextPath()%>/images/apple.jpg);background-size: 100% 100%;"></div>
			
			<p>MRP: RS 500/KG</p>
		</div>
		<div class="clr"></div>
	</div> --%>
	<script type="text/javascript">
	window.onload=getNoOfProduct ; 
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/header.css">
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
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="wrapper">

<div class="description">
<div class="left-div">
	<div class="left-div-common img-div" id="left-div-common" style="background: url(/VegetableShoppingCentre/images/<%= request.getParameter("path")%>);background-size: 100% 100%;"></div>
	<!-- <button class="left-div-common description-cart-button">
		Add To Cart
	</button> -->
	<%
						session = request.getSession(false);
						List emptyCart = (List) session.getAttribute("cartProduct");
						if(session.getAttribute("cartProduct")==null || emptyCart.isEmpty())
						{
					%>
						    <button value="install" id="<%= request.getParameter("id")%>" class="install left-div-common description-cart-button" onclick="cart.addToCart('<%= request.getParameter("id")%>', '<%= request.getParameter("description")%>')">Add To Cart</button>
							
					<% 
						}else
						{
						List cartProduct = (List) session.getAttribute("cartProduct");
						for(int j=0; j<cartProduct.size(); j++)
						{
							List productDetail = (List) cartProduct.get(j);
							if(productDetail.get(0).toString().equals(request.getParameter("id")))
							{
						%>
								<button id='cart-product<%= request.getParameter("id")%>' class="left-div-common description-cart-button">Added to cart</button>
						<%
								break;
							}
							if(j == (cartProduct.size()-1))
							{
						%>
								<button value="install" id="<%= request.getParameter("id")%>" class="install left-div-common description-cart-button" onclick="cart.addToCart('<%= request.getParameter("id")%>', '<%= request.getParameter("description")%>')">Add To Cart</button>
						<%
							}}}
						%>
</div>
<div id="pop-background" class="pop-background"></div>
<div class="right-div">
&nbsp;
	<p class="description-product-name"><%= request.getParameter("name")%></p>
	<p class="product-description"><%= request.getParameter("description")%></p>
	<p class="product-price">MRP: RS <%= request.getParameter("price")%>/KG</p>
	<p class="product-delivery"><%= request.getParameter("devileryBy")%></p>
</div>
</div>

</div>
<script type="text/javascript">
	window.onload=getNoOfProduct ;
	</script>
</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.VegetableShoppingCentre.dao.OrderHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/order.css">
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
<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>" />
<table>
	<tr>
		<td>ORDER-ID</td>
		<td>PRODUCT</td>
		<td>PRODUCT NAME</td>
		<td>PRODUCT QUANTITY</td>
		<td>TOTAL PRICE</td>
		<td>SHIPPING ADDRESS</td>
		<td>DATE OF PURCHASE</td>
	</tr>
	<%
		int j = 0;
		session = request.getSession();
		List list = new OrderHistory().getOrderDetail(Long.valueOf((String) session.getAttribute("userId")));
		for(int i=0; i<list.size(); i++)
		{
			j = i+1;
			Object object[] = (Object[]) list.get(i);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
			String input = object[8].toString();
			input = input.substring(0, 10); 
	%>
			<tr>
				<td><%= object[9]%></td>
				<td style="background: url(<%= request.getContextPath()%>/images/<%= object[0]%>);background-size: 100% 100%;"></td>
				<td><%= object[1]%></td>
				<td><%= object[2]%></td>
				<td><%= object[3]%></td>
				<td><%= object[4]%>, <%= object[5]%>, <%= object[6]%>, <%= object[7]%></td>
				<td><%= input%></td>
			</tr>
	<%
		}
		if(j == 0)
		{
	%>
			<tr>
				<td colspan="7">Sorry you have not placed any order.</td>
			</tr>
	<%
		}
	%>
</table>
	<script type="text/javascript">
		window.onload=getNoOfProduct ; 
	</script>
</body>
</html>
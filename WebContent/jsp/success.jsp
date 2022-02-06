<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.loading{left: 43%;
    width: 234px;
    height: 218px;
    margin: 158px 650px;}
</style>
<script type="text/javascript">
setTimeout(function() { window.location="<%= request.getParameter("url")%>";},3000);
</script>
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
</head>
<body>
<img src='/VegetableShoppingCentre/images/check.gif' class='loading' /><h1 style='color: green;margin: -127px 596px;'><%= request.getParameter("msg")%></h1>
<%
	if(request.getParameter("operation") != null)
	{
%>
	<input type="hidden" id="unsuccessfull" val="unsuccess" />
<%
	}
%>
<script type="text/javascript">
	if($("#unsuccessfull").val() == "unsuccess")
	{
		$("img").attr("src", "/VegetableShoppingCentre/images/download.png");
	}
</script>
</body>
</html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%

	session.removeAttribute("email");
	session.removeAttribute("admin");
	session.removeAttribute("cartProduct");
	session.removeAttribute("userId");
	//session.removeAttribute("");
	session.invalidate();
	response.sendRedirect(request.getContextPath()+"/jsp/success.jsp?msg=Logout successfully&url="+request.getContextPath());
	//response.sendRedirect(request.getContextPath());
%>
</body>
</html>
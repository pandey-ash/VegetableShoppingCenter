<%@page import="com.VegetableShoppingCentre.helper.Helper"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/checkout.css">
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
<script src="<%= request.getContextPath() %>/js/checkout.js"></script>
</head>
<body style="background: white;">

<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>" />
<div class="checkout-wrapper">
<div>
	<div class="checkout-float checkout-quantity quantity-heading " id="">Quantity</div>
	<div class="checkout-float checkout-price price-heading" id="">Price</div>
</div>

<!----------------------- main jsp portion uncomment this one ------------------------------>
<div>




 <%

	
	List cartList = (List) session.getAttribute("cartProduct");
	for(int i=0; i<cartList.size(); i++)
	{
		List productDetail = (List) cartList.get(i);
%>
			<div class="checkout-product-div">
				<div class="checkout-float checkout-image" id="" style="background: url(/VegetableShoppingCentre/images/<%= productDetail.get(1)%>);background-size: 100% 100%;"></div>
				<div class="checkout-float checkout-name" id=""><%= productDetail.get(3)%></div>
				<div class="checkout-float checkout-quantity" id=""><%= productDetail.get(5)%></div>
				<div class="checkout-float checkout-price" id="product-price"><%= productDetail.get(2)%></div>
				<div class="clr"></div>
				<input class="product-id" type="hidden" value="<%= productDetail.get(0)%>">
			</div>
			
<%
	}
	
%>
<input class="user-id" type="hidden" value="<%= session.getAttribute("userId")%>">
<hr>
	<div class="checkout-total-price" id="checkout-total-price">Total: 66</div>
	<button class="place-order" onclick="check.placeOrder()">Place Order</button>
	<table class="checkout-table">
		<%
		
			List list = new Helper().getUserAddress(Long.valueOf((String)session.getAttribute("userId")));
			for(int i=0; i<list.size(); i++)
			{
				Object object[] = (Object[]) list.get(i);
				if(i == 0)
				{
		%>
				<tr>
					<td>
						<input type="radio" onclick="check.hideForm()" old-address="true" name="checkout-address" value="<%= object[0]%>" checked="checked"><%= object[1]%>, &nbsp;<%= object[2]%>, &nbsp;<%= object[3]%>, &nbsp;<%= object[4]%>, &nbsp;<%= object[5]%>,<br/>Mobile No: &nbsp;<%= object[6]%>
					</td>
				</tr>
		<%
				}
				else
				{
		%>
				<tr>
					<td>
						<input type="radio" onclick="check.hideForm()" old-address="true" value="<%= object[0]%>" name="checkout-address"><%= object[1]%>, &nbsp;<%= object[2]%>, &nbsp;<%= object[3]%>, &nbsp;<%= object[4]%>, &nbsp;<%= object[5]%>,<br/>Mobile No: &nbsp;<%= object[6]%>
					</td>
				</tr>
		<%
				}
			}
		%>
			<tr>
				<td>
					<input type="radio" value="new" onclick="check.showAddressForm()" name="checkout-address">Add New Address<br/>
					<form onsubmit ="return false" id="registration-form" action="<%= request.getContextPath()%>/Controller">
					
						<!-- Address -->
						<div class="field-spacing">
							<div>
								<label>Adddress1: </label><br/>
								<textarea class="input-style reset-field" rows="3" cols="85" id="address" onclick="validate.removeErrorMsg('#address', '#address_error')" onkeypress="validate.removeErrorMsg('#address', '#address_error')"
								onblur="validate.dynamicFieldCheck('#address', '#address_error', 'validateAddress')" />
								</textarea>
							</div>
							<div id="address_error" class="error"></div>
						</div>
						<!-- Address end-->
						
						<!-- for first name -->
						<div class="field-spacing">
							<div>
								<label>Landmark: </label><br/>
								<input class="input-style reset-field" type="text" id="first_name" onclick="validate.removeErrorMsg('#first_name', '#first_name_error')" onkeypress="validate.removeErrorMsg('#first_name', '#first_name_error')" onblur="validate.dynamicFieldCheck('#first_name', '#first_name_error', 'validateName')"/>
							</div>
							<div id="first_name_error" class="error"></div>
						</div>
						<!-- for first name end -->

						<!-- pincode -->
						<div class="field-spacing">
							<div>
							<label>pincode: </label><br/>
							<input class="input-style reset-field" type="text" id="pincode" onclick="validate.removeErrorMsg('#pincode', '#pincode_error')" onkeypress="validate.removeErrorMsg('#pincode', '#pincode_error')"
							onblur="validate.dynamicFieldCheck('#pincode', '#pincode_error', 'validatePincode')"/>
							</div>
							<div id="pincode_error" class="error"></div>
						</div>
						<!-- pincode end-->
						
						<!-- state -->
						<div class="field-spacing">
							<div>
								<label>State: </label><br/>
								<select id="state" 
								onchange="check.getCity()" onblur="validate.dynamicFieldCheck('#state', '#state_error', 'validateSelect')">
									<option value="N" selected="selected">-------Select State----------</option>
								</select>
							</div>
							<div id="state_error" class="error"></div>
						</div>
						<!-- state end-->

						<!-- city -->
						<div class="field-spacing">
							<div>
								<label>City: </label><br/>
								<select id="city" 
								onblur="validate.dynamicFieldCheck('#city', '#city_error', 'validateSelect')">
									<option value="N" selected="selected">Select State first</option>
								</select>
							</div>
							<div id="city_error" class="error"></div>
						</div>
						<!-- city end-->
						
						<!-- for mobile no -->
						<div class="field-spacing">
							<div>
								<label>Biller Mobile No: </label><br/>
								<input class="input-style reset-field" type="text" id="mobile_no" onclick="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')" onkeypress="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')"
								onblur="validate.dynamicFieldCheck('#mobile_no', '#mobile_no_error', 'validateMblNo')"/>
							</div>
							<div id="mobile_no_error" class="error"></div>
						</div>
						<!-- for mobile no end -->

			</form>
				</td>
			</tr>
			
	</table>
	
	
</div>

<!----------------------- main jsp portion uncomment this one ------------------------------>


<script type="text/javascript">
	window.onload=check.getTotalPrice ;
	</script>
</body>
</html>
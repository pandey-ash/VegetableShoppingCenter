<%@page import="com.VegetableShoppingCentre.pojo.Product"%>
<%@page import="com.VegetableShoppingCentre.helper.Helper"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ashish Assignment</title>
  <!--[if lte IE 8]>

<script>
document.createElement('header'); 
document.createElement('nav'); 
document.createElement('article');
document.createElement('section'); 
document.createElement('aside'); 
document.createElement('footer');
//-->
</script>
<!-- for multi level drop down -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
 <!-- for multi level drop down end -->


<style> 
header, nav, article, section, aside, footer{ display:block; } 
</style>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/header.css">
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
  <script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/script.js"></script>
<script src="<%= request.getContextPath() %>/js/validation.js"></script>
<script type="text/javascript">
	function preventBack(){window.history.forward();}
	setTimeout("preventBack", 0);
	window.onunload = function(){null};

</script>
 </head>
<body>
<div id="main-div">
	<div class="top-header">
		<div class="wrapper">
			<div class="user-section">
			<a href="<%= request.getContextPath()%>"><img class="home-image" src="<%= request.getContextPath()%>/images/bigbasket.jpg"></a>
				<p id="login-link" class="login-link">
				<% 
					if(!(session.getAttribute("email") == null))
					{
				%>
					<p class="email-style"><%= session.getAttribute("email") %></p>
					<a class="order-style" href="<%= request.getContextPath()%>/jsp/order.jsp">Order History</a>
					<input type="hidden" id="user-id" class="user-id" value="<%= session.getAttribute("userId")%>">
					<%
						if("Y".equals(session.getAttribute("admin")))
						{
					%>
							
							<a class="admin-style" href="<%= request.getContextPath()%>/jsp/admin.jsp">Admin Panel</a>
					<% 
						}
					%>
					<p class="logout-style" onclick="cart.saveCartDetail(<%= session.getAttribute("userId")%>)">LogOut</p>
					<%-- <a href="<%= request.getContextPath() %>/jsp/logout.jsp?id=<%= session.getAttribute("userId")%>">LogOut</a> --%>
				<%
					}
					else{
				%>
				Login
				</p>
				<p id="register-link" class="login-link">New User? Register Here</p>
				<%
					}
				%>
			</div>
			
			<!-- testingggggggggggggggggggggggggg for multi level drop down -->
			
			
			
			<!-- testingggggggggggggggggggggggggg for multi level drop down enddddddd -->
			
			<!-- for multi level drop down -->
			
			<div class="dropdown dropdown-style">
    <button class="btn btn-default dropdown-toggle" style="padding: 11px 20px;font-size: 22px;" type="button" data-toggle="dropdown">Shop By Category
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
    <%
    	List category = new Helper().getCategoryDropDown();
		for(int i=0; i<category.size(); i++)
		{
		
    %>
    
      <li class="dropdown-submenu" >
        <a class="test" onclick="cart.showSubmenu('submenu<%= i%>', <%= i%>)" id="submenu<%= i%>" tabindex="-1" href="#"><%= category.get(i)%> <span class="caret"></span></a>
        <ul class="dropdown-menu ul" id="ul<%= i%>">
        <%
        	List list = new Helper().getProductDropDownImpl((String)category.get(i));
        	for(int j=0; j<list.size(); j++)
        	{
        		Product product = (Product) list.get(j);
        	
        %>
          <li><a tabindex="-1" href="<%= request.getContextPath()%>/jsp/description.jsp?id=<%= product.getPkProductId()%>&path=<%= product.getImagePath()%>&name=<%= product.getProductName()%>&price=<%= product.getPrice()%>&devileryBy=<%= product.getDevileryBy()%>&description=<%= product.getDescription()%>&cartPresence=naii"><%= product.getProductName()%></a></li>
        <%
        	}
        %>
        </ul>
      </li>
   <%
		}
   %>
    </ul>
  </div>
			
			<!-- for multi level drop down end-->
			
			
			
			<!-- cart div -->
			
			
			
			<div class="cart-dropdown">
			<p onclick="myFunction()" class="dropbtn">
				<img onclick="myFunction()" style="width: 54px;margin-top: 2px;" id="cart-img-p" src="<%= request.getContextPath()%>/images/cart2.png" class>
				<span id="cart-quantity" class="cart-quantity">0</span>
			</p>
			<div id="myDropdown" class="dropdown-content">
  			<div id="main-cart-div" style="max-height: 181px;overflow-y: scroll;">
			<%
			
				if(session.getAttribute("cartProduct") != null)
				{
					List list = (List) session.getAttribute("cartProduct");
					
					for(int i=0; i<list.size(); i++)
					{
						List productDetail = (List) list.get(i);
				
			%>
  					 	<div class="cart-div" id="cart-div" productId="<%= productDetail.get(0)%>" style="background: white;">
  					 		<%-- <input type="hidden" class="product-detail" productId="<%= productDetail.get(0)%>" quantity="1"> --%>
  							<div class="cart" onclick="cart.removeProduct('<%= productDetail.get(0)%>')"><img src="/VegetableShoppingCentre/images/cancel1.png" class="cart-cancel" id="remove-product" userId="<%= productDetail.get(0)%>"></div>
  							<div class="cart" style="margin-top: 24px;font-size: 18px;">Total Price: <span class="total-price" id="total-price<%= productDetail.get(0)%>"><%= productDetail.get(2)%></span></div>
  							<div class="cart product-quantity">
  								<img style="width: 18px;" src="<%= request.getContextPath()%>/images/subtract.png" onclick="cart.decrease('<%= productDetail.get(0)%>')">&nbsp;<span class="quantity" id="quantity<%= productDetail.get(0)%>"><%= productDetail.get(productDetail.size()-1)%></span> &nbsp;<img style="width: 18px;" src="<%= request.getContextPath()%>/images/plus.png" onclick="cart.increase('<%= productDetail.get(0)%>')">	
  							</div>
  							<div class="cart product-name"><%= productDetail.get(3)%></div>
  							<div class="cart cart-img" style="background: url(<%= request.getContextPath()%>/images/<%= productDetail.get(1)%>);background-size: 100% 100%; width: 69px;height: 74px;margin-right: 12px;"></div>
  							<div class="clr"></div>
  						</div>
  					<%
							}	
						}
					%>
						
  						</div>
  						<div class="proceed-checkout" id="proceed-checkout">
  						<% 
							if(!(session.getAttribute("email") == null) && session.getAttribute("cartProduct") != null && !((List)session.getAttribute("cartProduct")).isEmpty())
							{
						%>
  								<a href="/VegetableShoppingCentre/jsp/checkout.jsp" onclick="directToCheckOut()" class="cart-sub-part" style="float: left;padding: 8px;background: #a5cd39;margin-left: 23px;margin-top: -18px;border-radius: 10px;font-size: 19px;"><span id="cart-checkout">Proceed To CheckOut</span></a>
  						<% 
							}
							else if(session.getAttribute("cartProduct") != null )
							{
  						%>
  								<span id="login-checkout" class="cart-sub-part" style="float: left;padding: 8px;background: #a5cd39;margin-left: 23px;margin-top: -18px;border-radius: 10px;font-size: 19px;">Please login for checkout</span>
  						<%
							}
  						%>
  						<% 
							if(session.getAttribute("cartProduct") != null)
							{
						%>
  								<span id="cart-total" class="cart-sub-part" style="font-size: 18px;float: right;margin-right: 16px; margin-top: -9px;">Total</span>
  						<% 
							}
  						%>
  						</div>
  					</div>
			</div>
			
			
			
			<!-- cart div end -->
			<div class="clr"></div>
			
		</div>
	</div>
	
	<!-- div for backgroun color -->
	<div id="pop-background" class="pop-background"></div>
	<!-- div for backgroun color end-->
	<!-- login div -->
	
	<div class="login" id="login">
		<img src="<%= request.getContextPath()%>/images/cancel.png" class="login-cancel" id="cancel-img">
		<div class="loginSuccess" id="loginSuccess"></div>
		<div class="login-main-design">
			<form  id="loginForm"  onsubmit="return loginValidation.doLoginValidation()">
				<div class="field-spacing">
					<div>
						<label>email id: </label><br/>
						<input type="text" name="email" class="login-style reset-field" id="username" onclick="loginValidation.removeErrorMsg('#username', '#login_username_error')" onkeypress="loginValidation.removeErrorMsg('#usernmae', '#login_username_error')"
						onblur="loginValidation.doDyanimcLoginValidation('#username', '#login_username_error', 'validateUsername');"/>
					</div>
					<div id="login_username_error" class="error"></div>
				</div>
				<div class="field-spacing">
					<div>
						<label>password: </label><br/>
						<input type="password" name="passwd" class="login-style reset-field" id="login-password" onclick="loginValidation.removeErrorMsg('#login-password', '#login_password_error')" onkeypress="validate.removeErrorMsg('#login-password', '#login_password_error')"
						onblur="loginValidation.doDyanimcLoginValidation('#login-password', '#login_password_error', 'validatePassword')"/>
					</div>
					<div id="login_password_error" class="error"></div>
				</div>
			<!-- button -->
				<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>>">
				<input type="hidden" name="action" value="login">
				<button class="reset login-reset" type="reset">Reset</button>
				<button type="submit" class="submit">Submit</button>
			<!-- button end-->
			</form>
		</div>
	</div>
	<!-- login div end-->
	
	<!-- register div -->
	
	<div class="register" id="register">
		<img src="<%= request.getContextPath()%>/images/cancel.png" class="register-cancel" id="cancel-img">
		<div class="header"></div>
		<div class="main-design" style="margin: -34px auto;">
		<div class="registerSuccess" id="registerSuccess"></div>
			<form id="registration-form" method="post" onsubmit="return validate.doValidation()" action="Controller">
			<!-- left side of input field -->
			<div class="left">
				<!-- for first name -->
				<div class="field-spacing">
					<div>
						<label>first name: </label><br/>
						<input name="first_name" class="input-style reset-field" type="text" id="first_name" onclick="validate.removeErrorMsg('#first_name', '#first_name_error')" onkeypress="validate.removeErrorMsg('#first_name', '#first_name_error')" onblur="validate.dynamicFieldCheck('#first_name', '#first_name_error', 'validateName')"/>
					</div>
					<div id="first_name_error" class="error"></div>
				</div>
				<!-- for first name end -->

				<!-- for last name -->
				<div class="field-spacing">
					<div>
						<label>last name: </label><br/>
						<input name="last_name" class="input-style reset-field" type="text" id="last_name" onclick="validate.removeErrorMsg('#last_name', '#last_name_error')" onkeypress="validate.removeErrorMsg('#last_name', '#last_name_error')"
						onblur="validate.dynamicFieldCheck('#last_name', '#last_name_error', 'validateName')"/>
					</div>
					<div id="last_name_error" class="error"></div>
				</div>
				<!-- for last name end-->

				

				<!-- date of birth -->
				
				<!-- date of birth end-->

				<!-- for email id -->
				<div class="field-spacing">
					<div>
						<label>email id: </label><br/>
						<input name="email" class="input-style reset-field" type="text" id="email_id" onclick="validate.removeErrorMsg('#email_id', '#email_id_error')" onkeypress="validate.removeErrorMsg('#email_id', '#email_id_error')"
						onblur="validate.dynamicFieldCheck('#email_id', '#email_id_error', 'validateEmailId'); validate.checkEmail('#email_id', '#email_id_error')"/>
					</div>
					<div id="email_id_error" class="error"></div>
				</div>
				<!-- for email id end-->

				<!-- for admin drop down -->
				<div class="field-spacing">
					<div>
						<label>Is Admin?: </label><br/>
						<select id="is_admin" name="is_admin">
							<option value="N" selected>No</option>
							<option value="Y">Yes</option>
						</select>
					</div>
					<div id="state_error" class="error"></div>
				</div>
				<!-- for admin drop down -->

			<!-- gender -->
				<div class="field-spacing">
					<div>
						<label>gender: </label><br/>
						<div id="radio_div" class="radio-style" onclick="validate.removeErrorMsg('#radio_div', '#gender_error')" onkeypress="validate.removeErrorMsg('#radio_div', '#gender_error')"
						onblur="validate.dynamicFieldCheck('#radio_div', '#gender_error', 'validateGender')">
							male <input type="radio" class="uncheck" name="gender" value="M" id="male" onclick="validate.removeErrorMsg('#male', '#gender_error')" onkeypress="validate.removeErrorMsg('#male', '#gender_error')"
							onblur="validate.dynamicFieldCheck('#male', '#gender_error', 'validateGender')"/>
							female <input type="radio" class="uncheck" name="gender" value="F" id="female" onclick="validate.removeErrorMsg('#female', '#gender_error')" onkeypress="validate.removeErrorMsg('#female', '#gender_error')"/>
						</div>
					</div>
					<div id="gender_error" class="error"></div>
				</div>
				<!-- gender end-->			
				</div>
			<!-- left side of input field end-->

			<!-- right side of input field-->
			<div class="right">
			<!-- for mobile no -->
				<div class="field-spacing">
					<div>
						<label>mobile no: </label><br/>
						<input class="input-style reset-field" type="text" name="mobile_no" id="mobile_no" onclick="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')" onkeypress="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')"
						onblur="validate.dynamicFieldCheck('#mobile_no', '#mobile_no_error', 'validateMblNo')"/>
					</div>
					<div id="mobile_no_error" class="error"></div>
				</div>
				<!-- for mobile no -->
				<!-- password -->
				<div class="field-spacing">
					<div>
						<label>password: </label><br/>
						<input name="password" class="input-style reset-field" type="password" id="password" onclick="validate.removeErrorMsg('#password', '#password_error')" onkeypress="validate.removeErrorMsg('#password', '#password_error')"
						onblur="validate.dynamicFieldCheck('#password', '#password_error', 'validatePassword')"/>
						<p class="passwd-note">Note:</p>
						<p class="passwd-note">1.Password length should be of minimum 5 character</p>
						<p class="passwd-note">2.Password should began with any desire character but last 4 character should be special character('_' is not special character) followed by small case, uppercase and digit.
						</p>
					</div>
					<div id="password_error" class="error"></div>
				</div>
				<!-- password end-->

				<!-- confirm password -->
				<div class="field-spacing">
					<div>
						<label>confirm password: </label><br/>
						<input class="input-style reset-field" type="password" id="confirm_pass" onclick="validate.removeErrorMsg('#confirm_pass', '#confirm_pass_error')" onkeypress="validate.removeErrorMsg('#confirm_pass', '#confirm_pass_error')"
						onblur="validate.dynamicFieldCheck('#confirm_pass', '#confirm_pass_error', 'validateConfirmPassword')"/>
					</div>
					<div id="confirm_pass_error" class="error"></div>
				</div>
			</div>
			<!-- right side of input field-->
			<div class="clr"></div>

				<!-- button -->
					<input type="hidden" name="action" value="register">
					<button class="reset" type="reset">Reset</button>
					<button type="submit" class="submit">Submit</button>
				<!-- button end-->
			</form>
		</div>
	</div>
	<!-- register end-->
	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function preventBack(){window.history.forward();}
	setTimeout("preventBack", 0);
	window.onunload = function(){null};
</script>
<script src="<%= request.getContextPath() %>/js/jquery.js"></script>
<script src="<%= request.getContextPath() %>/js/admin.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin.css">
</head>
<body>
<input type="hidden" id="contextPath" value="<%= request.getContextPath()%>" />
<div class="main-content"> <!-- main image div -->
		<div class="header"> <!-- entire body header div -->
			<div class="wrapper"> <!-- 1200 header div -->
				<header>
					<div class="logo">
						<p>ADMIN  </p>&nbsp;<img style="margin-top: -6px;" src="<%= request.getContextPath()%>/images/admin3.png" alt="let's travel logo" />&nbsp;<p>  PANEL</p>
					</div>
					<div class="nav">
						<ul>
							<li><a href="" id="login-link" class="login-link">ADD CATEGORY</a></li>
							<li><a href="" id="register-link" class="login-link">ADD PRODUCT</a></li>
							<li><a href="" id="edit-product" class="edit-product">EDIT PRODUCT</a></li>
						</ul>
					</div>
					<div class="clr"></div>
				</header>
			</div>
		</div>
		<table id="display-product-detail">
	
	</table>
		<form action=""></form>
	</div>
	
	
	
	
	
	
	<!-- div for backgroun color -->
	<div id="pop-background" class="pop-background"></div>
	<!-- div for backgroun color end-->
	
	
	<!-- login div -->
	
	<div class="login" id="login">
		<img src="/VegetableShoppingCentre/images/cancel.png" class="login-cancel" id="cancel-img">
		<div class="loginSuccess" id="loginSuccess"></div>
		<div class="login-main-design">
			<form onsubmit="return false" id="loginForm">
				<div class="field-spacing">
					<div>
						<label>Category Name: </label><br/>
						<input type="text" class="login-style reset-field" id="username" onclick="loginValidation.removeErrorMsg('#username', '#login_username_error')" onkeypress="loginValidation.removeErrorMsg('#usernmae', '#login_username_error')"
						/>
					</div>
					<div id="login_username_error" class="error"></div>
				</div>
				
			<!-- button -->
				<button class="login-submit" type="reset">Reset</button>
				<button type="submit" class="login-submit only-submit" onclick="loginValidation.doLoginValidation()">Submit</button>
			<!-- button end-->
			</form>
		</div>
	</div>
	<!-- login div end-->
	
	<!-- register div -->
	
	<div class="register" id="register">
		<img src="/VegetableShoppingCentre/images/cancel.png" class="register-cancel" id="cancel-img">
		<div class="header"></div>
		<div class="main-design">
		<div class="registerSuccess" id="registerSuccess"></div>
			<form onsubmit ="return validate.doValidation()" method="post" enctype="multipart/form-data" id="registration-form" action="<%= request.getContextPath()%>/FileUpload">
			<!------------------------ left hand side div --------------------------->
			<div class="left">
				<!-- for first name -->
				<div class="field-spacing">
					<div>
						<label>Product Name </label><br/>
						<input name="product_name" class="input-style reset-field" type="text" id="first_name" onclick="validate.removeErrorMsg('#first_name', '#first_name_error')" onkeypress="validate.removeErrorMsg('#first_name', '#first_name_error')" onblur="validate.dynamicFieldCheck('#first_name', '#first_name_error', 'validateName')"/>
					</div>
					<div id="first_name_error" class="error"></div>
				</div>
				<!-- for first name end -->
				
				<!-- Address -->
				<div class="field-spacing">
					<div>
						<label>Product Description: </label><br/>
						<textarea name="product_desc" class="input-style reset-field" rows="3" cols="85" id="address" onclick="validate.removeErrorMsg('#address', '#address_error')" onkeypress="validate.removeErrorMsg('#address', '#address_error')"
						onblur="validate.dynamicFieldCheck('#address', '#address_error', 'validateAddress')" />
						</textarea>
					</div>
					<div id="address_error" class="error"></div>
				</div>
				<!-- Address end-->
				
				<!-- for last name -->
				 <div class="field-spacing">
					<div>
						<label>Standard Delivery Time: </label><br/>
						<input name="delievry_time" class="input-style reset-field" type="text" id="last_name" onclick="validate.removeErrorMsg('#last_name', '#last_name_error')" onkeypress="validate.removeErrorMsg('#last_name', '#last_name_error')"
						onblur="validate.dynamicFieldCheck('#last_name', '#last_name_error', 'validateName')"/>
					</div>
					<div id="last_name_error" class="error"></div>
				</div>
				<!-- for last name end-->

				<!-- for mobile no -->
				<div class="field-spacing">
					<div>
						<label>Price (per Kg): </label><br/>
						<input name="price" class="input-style reset-field" type="text" id="mobile_no" onclick="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')" onkeypress="validate.removeErrorMsg('#mobile_no', '#mobile_no_error')"
						onblur="validate.dynamicFieldCheck('#mobile_no', '#mobile_no_error', 'validateMblNo')"/>
					</div>
					<div id="mobile_no_error" class="error"></div>
				</div>
				<!-- for mobile no end -->
			</div>
			<!------------------------------ left hand side div end ---------------------------->
			
			<!------------------------------- right hand side div ---------------------------->
			<div class="right">
				<!-- for quantity no -->
				<div class="field-spacing">
					<div>
						<label>Quantity (per Kg): </label><br/>
						<input name="quantity" class="input-style reset-field" type="text" id="quantity" onclick="validate.removeErrorMsg('#quantity', '#quantity_error')" onkeypress="validate.removeErrorMsg('#quantity', '#quantity_error')"
						onblur="validate.dynamicFieldCheck('#quantity', '#quantity_error', 'validateMblNo')"/>
					</div>
					<div id="quantity_error" class="error"></div>
				</div>
				<!-- for quantity end -->
				
				<div class="field-spacing">
					<div>
						<label>Select File:: </label><br/>
						<input type="file" accept="image/*" id="file_name" name="file_name" class="upload-image" onclick="validate.removeErrorMsg('#quantity', '#quantity_error')"/>
					</div>
					<div id="file_name_error" class="error"></div>
				</div>
				
				<!-- category -->
				<div class="field-spacing">
					<div>
						<label>Category: </label><br/>
						<select name="category" id="category" onclick="validate.removeErrorMsg('#category', '#category_error')"
						onblur="validate.dynamicFieldCheck('#category', '#category_error', 'validateSelect')">
						</select>
					</div>
					<div id="category_error" class="error"></div>
				</div>
				<!-- category end-->
				
				<!-- state -->
				<div class="field-spacing">
					<div>
						<label>Upcoming Product ?: </label><br/>
						<select name="upcoming_product" id="state" onclick="validate.removeErrorMsg('#state', '#state_error')"
						onblur="validate.dynamicFieldCheck('#state', '#state_error', 'validateSelect')">
							<option value="N" selected="selected">No</option>
							<option value="Y">Yes</option>
						</select>
					</div>
					<div id="state_error" class="error"></div>
				</div>
				<!-- state end-->

				<!-- city -->
				<div class="field-spacing">
					<div>
						<label>New Product ?: </label><br/>
						<select name="new_product" id="city" onclick="validate.removeErrorMsg('#city', '#city_error')"
						onblur="validate.dynamicFieldCheck('#city', '#city_error', 'validateSelect')">
							<option value="N" selected="selected">No</option>
							<option value="Y">Yes</option>
						</select>
					</div>
					<div id="city_error" class="error"></div>
				</div>
				<!-- city end-->

				</div>
			<!--------------------------------- right hand side div end -------------------------------->
			<div class="clr"></div>
				<!-- button -->
					<input type="hidden" id="action" name="action" value="add-product">
					<input type="hidden" id="action" name="newUserId" value="<%= session.getAttribute("userId")%>">
					<input type="hidden" id="edit-productid" name="edit-productid" value="3">
					<button class="reset" type="reset">Reset</button>
					<button type="submit" class="submit">Submit</button>
				<!-- button end-->
			</form>
		</div>
	</div>
	<!-- register end-->
	<script type="text/javascript">
		window.onload= admin.getCategory;
	</script>
</body>
</html>
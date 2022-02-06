var categoryCheck = false;
var validate = new validation();
var admin = new productData()

function validation(){
	this.doValidation = doValidation;
	this.removeErrorMsg = removeErrorMsg;
	this.checkForEmptyField = checkForEmptyField;
	this.displayErrorMsg = displayErrorMsg;
	this.validateName = validateName;
	this.validateMblNo = validateMblNo;
	this.validateSelect = validateSelect;
	this.validatePincode = validatePincode;
	this.validateAddress = validateAddress;
	this.getUserChoice = getUserChoice;
	this.dynamicFieldCheck = dynamicFieldCheck;
	this.displaySuccessMsg  = displaySuccessMsg;
	this.displayRgisterMsg = displayRgisterMsg;
	this.validateFile = validateFile
}

function doValidation(){

	if(!(validate.checkForEmptyField("#first_name", "#first_name_error") && validate.validateName("#first_name", "#first_name_error"))){
		return false
	}
	else if(!(validate.checkForEmptyField("#address", "#address_error") && validate.validateAddress("#address", "#address_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#last_name", "#last_name_error") && validate.validateName("#last_name", "#last_name_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#mobile_no", "#mobile_no_error") && validate.validateMblNo("#mobile_no", "#mobile_no_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#quantity", "#quantity_error") && validate.validateMblNo("#quantity", "#quantity_error"))){
		return false;
	}
	else if(!validate.validateSelect("#city", "#city_error")){
		return false;
	}
	else if(!validate.validateFile("#file_name", "#file_name_error")){
		return false;
	}
	else if(!validate.validateSelect("#state", "#state_error")){
		return false;
	}
	else if(!validate.validateSelect("#city", "#city_error")){
		return false;
	}
	return true
}

function dynamicFieldCheck(inputObj, errorObj, functionName){
	if(!validate.checkForEmptyField(inputObj, errorObj)){
		return false;
	}
	else if($(inputObj).attr("id") == "confirm_pass"){
		if(!validate[functionName](inputObj, errorObj, $("#password").val())){
			return false
		}
	}
	else if(!validate[functionName](inputObj, errorObj)){
		return false;
	}
	validate.removeErrorMsg(inputObj, errorObj)
}

function validateFile(fname_obj, fname_error_obj)
{
	if(!($("#file_name").val()))
	{
		validate.displayErrorMsg(fname_obj, fname_error_obj, "Please provide a file");
		return false
	}
	return true;
}

function validateName(fname_obj, fname_error_obj){
	//var name = fname_obj.value;
	var name_re = /^[a-zA-Z]{2,}$/;
	if (!name_re.test($(fname_obj).val())){
		validate.displayErrorMsg(fname_obj, fname_error_obj, "Name should be alphabetic and should of minimum 2 character");
		return false;
	}
	return true;
}

function validateMblNo(mbl_no_obj, mbl_no_error_obj){
	//var mbl_no = mbl_no_obj.value;
	//var mbl_no_re = /^(\+91|0)[789]\d{9}$/;
	var mbl_no_re = /^\d{1,}$/;
	if(!mbl_no_re.test($(mbl_no_obj).val())){
		validate.displayErrorMsg(mbl_no_obj, mbl_no_error_obj, "Invalid price");
		return false;
	}
	return true;
}

function validateDob(dob_obj, dob_error_obj){
	//var dob = dob_obj.value;
	var dob_re = /^(0[1-9]|[1-2]\d|3[0-1]|\d)[\/](0[1-9]|[1-9]|1[0-2])[\/]((19|20)\d\d)$/;
	if(!dob_re.test($(dob_obj).val())){
		validate.displayErrorMsg(dob_obj, dob_error_obj, "Please enter valid date of birth (dd/mm/yyyy)");
		return false
	}
	return true;
}

function validateAddress(addr_obj, addr_error_obj){
	addr = $(addr_obj).val().replace(/\s{2,}/g,' ');
	//addr = $.trim($(addr_obj).val());
	if(!(11 <= Number(addr.length))){
		validate.displayErrorMsg(addr_obj, addr_error_obj, "Address should consist of more than 10 character");
		return false;
	}
	return true;
}

function validateSelect(select_obj, select_error_obj){
//	var select_value = select_obj.value;
	var description = $(select_obj).attr("id");
	if($(select_obj).val() == null){
		validate.displayErrorMsg(select_obj, select_error_obj, "Please select your " + description);
		return false;
	}
	return true;
}

function validatePincode(pin_obj, pin_error_obj){
//	var pin = pin_obj.value;
	var pin_re = /^[0-9]{6}$/;
	if(!pin_re.test($(pin_obj).val())){
		validate.displayErrorMsg(pin_obj, pin_error_obj, "Please enter valid pincode");
		return false;
	}
	return true
}

function checkForEmptyField(input_field, div){
		if($(input_field).val() === "") {
			validate.displayErrorMsg(input_field, div, "Required")
			return false;
		}
	return true;
}

function removeErrorMsg(obj, error_div){
//	obj.style.removeProperty("border");
	$(obj).css("border", "")
//	error_div = document.getElementById(error_div);
//	error_div.innerHTML = "";
	$(error_div).html("");
	
}

function displayErrorMsg(input_obj, div_obj, error_msg){
	$(input_obj).css("border", "3px solid red");
	$(div_obj).text(error_msg);
	$(div_obj).css("color", "red");
}

function getUserChoice(choice_obj){
	var choice = ""
	for (var i=0; i<choice_obj.length; i++){
		if(choice_obj[i].checked){
			choice = choice + choice_obj[i].value + " ";
		}
	}
	return choice;
}

function displayRgisterMsg()
{
	return true;
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	var action = $("#action").val();
	var productName = $("#first_name").val()
	var productDesc = $("#address").val()
	var delivery = $("#last_name").val()
	var price = $("#mobile_no").val()
	var category = $("#category").val()
	var upComing = $("#state").val()
	var isNew = $("#city").val()
	var quantity = $("#quantity").val()
	var productId = $("#edit-productid").val()
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": action,
				"productName": productName,
				"productDesc": productDesc,
				"delivery": delivery,
				"price": price,
				"category": category,
				"upComing": upComing,
				"isNew": isNew,
				"quantity": quantity,
				"imagePath": "mushroom.jpg",
				"productId": productId
		   }, 
		   function(data){
			   var data = data.substring(0, data.indexOf('<'));
				parse = $.parseJSON(data);
			   if(data == "true" || parse)
			   {
				   $("#registerSuccess").html("Operation Done successfully").css("color", "green");
				   $('#registration-form').find('input, textarea').not("select").val('');
					//document.getElementById("registration-form").reset();
					setTimeout(function() { window.location=window.location;},2000);
			   }
		   });
	
}

//---------------------------login part---------------------------------------------

loginValidation = new LoginValidation();

function LoginValidation(){
	this.doLoginValidation = doLoginValidation;
	this.validateMblNo = validateMblNo;
	this.validateUsername = validateUsername;
	this.removeErrorMsg = removeErrorMsg;
	this.displayErrorMsg = displayErrorMsg;
	this.checkForEmptyField = checkForEmptyField;
	this.displaySuccessMsg = displaySuccessMsg;
	this.doDyanimcLoginValidation = doDyanimcLoginValidation
}

function doLoginValidation(){
	if(!(loginValidation.checkForEmptyField("#username", "#login_username_error") && loginValidation.validateUsername("#username", "#login_username_error"))){
		return false;
	}
	admin.checkUniqueCategory($("#username").val().toLowerCase())
	setTimeout(loginValidation.displaySuccessMsg, 2000)
}

function doDyanimcLoginValidation(inputObj, divObj, functionName){
	
	if(!loginValidation.checkForEmptyField(inputObj, divObj)){
		return false;
	}
	else if(!loginValidation[functionName](inputObj, divObj)){
		return false;
	}
	loginValidation.removeErrorMsg(inputObj, divObj)
	admin.checkUniqueCategory($("#username").val().toLowerCase())
}

function checkUniqueCategory(categoryName)
{
	var path = $("#contextPath").val();
	var parse = false;
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "duplicate categoryName",
				"categoryName": categoryName
			},
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				parse = $.parseJSON(data);
				if(parse)
				{
					categoryCheck = true;
					loginValidation.displayErrorMsg("#username", "#login_username_error", "Same category already present");
					return;
				}
				categoryCheck = false;
				return
			});
}

function validateUsername(usernameObj, divObj)
{
	emailRe = /^[a-zA-Z]{2,}$/;
	mblRe = /^[789]\d{9}$/;
	if(emailRe.test($(username).val())){
		return true;
	}
	loginValidation.displayErrorMsg(usernameObj, divObj, "Invalid product name");
	return false;
}

function productData()
{
	this.getCategory = getCategory;
	this.getProductDetail = getProductDetail;
	this.getAllProduct = getAllProduct;
	this.deleteProductDetail = deleteProductDetail;
	this.displayEditRegister = displayEditRegister;
	this.checkUniqueCategory = checkUniqueCategory
}

function deleteProductDetail(productId)
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "delete product",
				"productId": productId
			},
			function(data){
				setTimeout(function() { window.location=window.location;},1000);
			});
}

function getCategory()
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "get category"
			},
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				var parse = $.parseJSON(data);
				$.each(parse, function(key, value){
					$("#category").append("<option value="+key+">"+value+"</option>")
				});
				
			});
}

function getProductDetail(productid)
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "get edit product",
				"productid": productid
			},
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				var parse = $.parseJSON(data);
				$("#first_name").val(parse[1]);
				$("#address").val(parse[2]);
				$("#last_name").val(parse[3]);
				$("#mobile_no").val(parse[4]);
				$("#quantity").val(parse[5]);
				$("#category").val(parse[6]);
				$("#state").val(parse[7]);
				$("#city").val(parse[8]);
				$("#action").val("edit-product");
				$("#edit-productid").val(parse[0]);
				admin.displayEditRegister()
			});
}

function displayEditRegister(){
	$("#display-product-detail").hide()
	$("#pop-background, #register").slideDown(1000);
	return false;
}

/*---------------------------------------------------for edit------------------------------ */
function getAllProduct()
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "get all product"
			},
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				var parse = $.parseJSON(data);
				if(parse != null && parse != undefined)
				{
					$("#display-product-detail").removeClass("table-display");
					$("#display-product-detail").addClass("table-display");
					$("#display-product-detail").append(
							"<tr>"+
							"<td>Product Name</td>"+
							"<td>Price</td>"+
							"<td>Quantity</td>"+
							"<td>Category</td>"+
							"<td>Action</td>"+
							"</tr>")
				}
				$.each(parse, function(key, value){
					$("#display-product-detail").append(
							"<tr>"+
							"<td>"+value[1]+"</td>"+
							"<td>"+value[4]+"</td>"+
							"<td>"+value[5]+"</td>"+
							"<td>"+value[6]+"</td>"+
							"<td>"+
							"<img src='/VegetableShoppingCentre/images/edit.png' onclick='admin.getProductDetail("+value[0]+")' productid='"+value[0]+"' action='edit' id='edit"+value[0]+"'/>"+
							"<img src='/VegetableShoppingCentre/images/delete.png' onclick='admin.deleteProductDetail("+value[0]+")' productid='"+value[0]+"' action='delete' id='delete"+value[0]+"'/>"+
							"</td>"+
							"</tr>"
							
					)
				});
				
			});
}
/*---------------------------------------------------for edit------------------------------ */

function displaySuccessMsg()
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	var categoryName = $("#username").val().toLowerCase();
	if(categoryCheck)
	{
		loginValidation.displayErrorMsg("#username", "#login_username_error", "Same category alredy present");
		return false;
	}
	$.post(path+"/jsp/ajax.jsp",
			{
				"action": "add category",
				"categoryName": categoryName
			},
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				var parse = $.parseJSON(data);
			});
	document.getElementById("loginSuccess").innerHTML = "Category Added successfully"
	document.getElementById("loginForm").reset();
	setTimeout(function() { window.location=window.location;},2000);
}

$(document).ready(function(){
	$(".reset").click(clear);
	$("#login-link").click(displayLogin);
	$("#register-link").click(displayRegister);
	$("#edit-product").click(displayEditRegister);
	$("#pop-background, #cancel-img").click(close);

	function clear(){
		$(".error, .reset-field,textarea").removeAttr("style").html("");
		$("#radio_div, #hobby_div").removeAttr("style");
		$("select").removeAttr("style");
	}
	
	function displayLogin(){
		$("#display-product-detail").hide()
		$("#pop-background, #login").slideDown(1000);
		return false;
	}

	function displayEditRegister()
	{
		if($("#display-product-detail").hasClass("table-display"))
		{
			return;
		}
		$("#display-product-detail").hide()
		admin.getAllProduct();
		$("#display-product-detail").slideDown(2000);
		return false;
	}
	
	function displayRegister(){
		$("#display-product-detail").hide()
		$("#pop-background, #register").slideDown(1000);
		return false;
	}

	function close(){
		$(".error, .reset-field,textarea").removeAttr("style").html("").val("");
		$("#radio_div, #hobby_div").removeAttr("style");
		$(".uncheck").prop("checked", false);
		$("select").val("N");
		$("#category").val("1");
		$("select").removeAttr("style");
		$("#pop-background, #register").slideUp();
		$("#pop-background, #register, #login").slideUp();
	}
});




//newly added




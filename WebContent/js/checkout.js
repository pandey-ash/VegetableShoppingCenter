var check = new checkOut();
var validate = new validation();

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
	this.displayRgisterMsg = displayRgisterMsg;
}

function doValidation(){

	if(!(validate.checkForEmptyField("#address", "#address_error") && validate.validateAddress("#address", "#address_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#first_name", "#first_name_error") && validate.validateName("#first_name", "#first_name_error"))){
		
		return false
	}
	else if(!(validate.checkForEmptyField("#pincode", "#pincode_error") && validate.validatePincode("#pincode", "#pincode_error"))){
		
		return false;
	}
	else if(!validate.validateSelect("#state", "#state_error")){
		
		return false;
	}
	else if(!validate.validateSelect("#city", "#city_error")){
		
		return false;
	}
	else if(!(validate.checkForEmptyField("#mobile_no", "#mobile_no_error") && validate.validateMblNo("#mobile_no", "#mobile_no_error"))){
		
		return false;
	}
	 return validate.displayRgisterMsg();
	
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

function validateName(fname_obj, fname_error_obj){
	//var name = fname_obj.value;
	var name_re = /^[a-zA-Z]{2,10}$/;
	if (!name_re.test($(fname_obj).val())){
		validate.displayErrorMsg(fname_obj, fname_error_obj, "Landmark should be alphabetic and should of minimum 2 character");
		return false;
	}
	return true;
}

function validateMblNo(mbl_no_obj, mbl_no_error_obj){
	//var mbl_no = mbl_no_obj.value;
	//var mbl_no_re = /^(\+91|0)[789]\d{9}$/;
	var mbl_no_re = /^[789]\d{9}$/;
	if(!mbl_no_re.test($(mbl_no_obj).val())){
		validate.displayErrorMsg(mbl_no_obj, mbl_no_error_obj, "Invalid Mobile No");
		return false;
	}
	return true;
}


function validateAddress(addr_obj, addr_error_obj){
	addr = $(addr_obj).val().replace(/\s\s+/g, ' ');
//	string.replace(/\s\s+/g, ' ');
//	addr = $.trim($(addr_obj).val());
	if(!(10 <= Number(addr.length))){
		validate.displayErrorMsg(addr_obj, addr_error_obj, "Address should consist of atleast 10 character");
		return false;
	}
	return true;
}

function validateSelect(select_obj, select_error_obj){
//	var select_value = select_obj.value;
	var description = $(select_obj).attr("id");
	if($(select_obj).val() === "N"){
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

function displayRgisterMsg(){
	$("#registerSuccess").html("Successfully Save Address").css("color", "green");
	return true;
	
}





/*------------validation--------------------------------*/

function checkOut()
{
	this.getTotalPrice = getTotalPrice;
	this.placeOrder = placeOrder;
	this.oldAddress = oldAddress;
	this.newAddress = newAddress;
	this.displayCorectImg = displayCorectImg;
	this.displayLoadingImg = displayLoadingImg;
	this.showAddressForm = showAddressForm;
	this.getCity = getCity;
	this.hideForm = hideForm
}

function hideForm()
{
	$("#registration-form").hide()
}

function placeOrder()
{
	if($("input[name=checkout-address]:checked").val() != "new")
	{
		
		check.oldAddress();
	}
	else
	{
		check.newAddress();
	}
}

function displayCorectImg()
{
	$("body").empty()
	$("body").append("<img src='/VegetableShoppingCentre/images/check.gif' class='loading'/><h1 style='color: green;margin: -127px 596px;'>Your order has been placed</h1>")
	setTimeout(function() { window.location="/VegetableShoppingCentre/";},5000);
}

function displayLoadingImg()
{
	$("body").empty()
	$("body").append("<img src='/VegetableShoppingCentre/images/loading.gif' class='loading'><h1 style='color: red;margin: -127px 596px;'>Loading!! Please wait</h1>")
	setTimeout(check.displayCorectImg, 4000)
}

function oldAddress()
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	var addressId = $("input[name=checkout-address]").val();
	var totalProduct = $(".checkout-product-div").length
	var totalAmt = $("#checkout-total-price").html().replace("Total: ", "");
	var productId = "";
	var quantity = "";
	var productPrice = "";
	$(".checkout-product-div").each(function() {
		productId = $(this).find( ".product-id" ).val()+","+productId;
	    quantity = $(this).find(".checkout-quantity").html()+","+quantity;
	    productPrice = $(this).find(".checkout-price").html()+","+productPrice;
	});
	$.post(path+"/jsp/ajax.jsp",
			   {
					"action": "place order",
					"addressId": addressId,
					"totalProduct": totalProduct,
					"totalAmt": totalAmt,
					"productId": productId,
					"quantity": quantity,
					"productPrice": productPrice,
			   },
			   function(data){
					check.displayLoadingImg()
			  
			   });
}

function newAddress()
{
	if(!validate.doValidation())
	{
		return false
	}
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	
	
	/*-----------------new address----------------------------*/
	
	var address1 = $("#address").val();
	var landmark = $("#first_name").val();
	var pincode = $("#pincode").val();
	var city = $("#city").val();
	var mobileNo = $("#mobile_no").val();
	
	/*-----------------end address----------------------------*/
	var totalProduct = $(".checkout-product-div").length
	var totalAmt = $("#checkout-total-price").html().replace("Total: ", "");
	var productId = "";
	var quantity = "";
	var productPrice = "";
	$(".checkout-product-div").each(function() {
		productId = $(this).find( ".product-id" ).val()+","+productId;
	    quantity = $(this).find(".checkout-quantity").html()+","+quantity;
	    productPrice = $(this).find(".checkout-price").html()+","+productPrice;
	});
	$.post(path+"/jsp/ajax.jsp",
			   {
					"action": "place order with new address",
					"totalProduct": totalProduct,
					"totalAmt": totalAmt,
					"productId": productId,
					"quantity": quantity,
					"productPrice": productPrice,
					"address1": address1,
					"landmark": landmark,
					"pincode": pincode,
					"city": city,
					"mobileNo": mobileNo
					
			   },
			   function(data){
					check.displayLoadingImg()
			  
			   });
	
}

function getCity()
{
	if($("#state").val() == "N")
	{
		$("#city").empty()
		$("#city").append("<option value='N'>--Select state first-----</option>")
	}
	else
	{
		$("#city").empty()
		var state = $("#state").val();
		$("#registration-form").show();
		var path = $("#contextPath").val();
		$.post(path+"/jsp/ajax.jsp",
				   {
						"action": "get city",
						"stateId": state
				   },
				   function(data){
					   var data = data.substring(0, data.indexOf('<'));
						parse = $.parseJSON(data);
						$.each( parse, function( key, value ) {
							$("#city").append("<option value='"+key+"'>"+value+"</option>")
							});
				  
				   });
	}
}

function showAddressForm()
{
	$("#registration-form").show();
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
			   {
					"action": "get state",
			   },
			   function(data){
				   var data = data.substring(0, data.indexOf('<'));
					parse = $.parseJSON(data);
					if($('select#state option').length>2)
					{
						return;
					}
					$.each( parse, function( key, value ) {
						$("#state").append("<option value='"+key+"'>"+value+"</option>")
						});
			  
			   });
}

function getTotalPrice()
{
	$("#registration-form").hide()
	var totalPrice = 0;
	$(".checkout-product-div").each(function() {
		totalPrice = parseInt($(this).find( ".checkout-price" ).html())+totalPrice;
	});
	$("#checkout-total-price").html("Total: "+totalPrice);
	if($("input[old-address='true']").length<1)
	{
		$("<input type='radio' value='new' name='checkout-address'>").attr("checked", true)
		check.showAddressForm()
	}
}


$(document).ready(function(){
	$(".reset").click(clear);
	$("#login-link").click(displayLogin);
	$("#register-link").click(displayRegister);
	$("#pop-background, #cancel-img").click(close);

	function clear(){
		$(".error, .reset-field,textarea").removeAttr("style").html("");
		$("#radio_div, #hobby_div").removeAttr("style");
		$("select").removeAttr("style");
	}

	function displayLogin(){
		$("#pop-background, #login").slideDown(1000);
		return false;
	}

	function displayRegister(){
		$("#pop-background, #register").slideDown(1000);
		return false;
	}

	function close(){
		$(".error, .reset-field,textarea").removeAttr("style").html("").val("");
		$("#radio_div, #hobby_div").removeAttr("style");
		$(".uncheck").prop("checked", false);
		$("select").val("no-select");
		$("select").removeAttr("style");
		$("#pop-background, #register").slideUp();
		$("#pop-background, #register, #login").slideUp();
	}
});

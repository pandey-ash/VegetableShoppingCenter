var categoryCheck = false;
var validate = new validation();

function validation(){
	this.doValidation = doValidation;
	this.removeErrorMsg = removeErrorMsg;
	this.checkForEmptyField = checkForEmptyField;
	this.displayErrorMsg = displayErrorMsg;
	this.validateName = validateName;
	this.validateMblNo = validateMblNo;
	this.validateEmailId = validateEmailId;
	this.validatePassword = validatePassword;
	this.validateConfirmPassword = validateConfirmPassword;
	this.validateGender = validateGender;
	this.dynamicFieldCheck = dynamicFieldCheck;
	this.displaySuccessMsg  = displaySuccessMsg;
	this.displayRgisterMsg = displayRgisterMsg;
	this.checkEmail = checkEmail;
	this.disappearMsg = disappearMsg;
}

function disappearMsg()
{
setTimeout(function(){$('#short-time').fadeOut();}, 3000);
}

function doValidation(){

	if(!(validate.checkForEmptyField("#first_name", "#first_name_error") && validate.validateName("#first_name", "#first_name_error"))){
		return false
	}
	else if(!(validate.checkForEmptyField("#last_name", "#last_name_error") && validate.validateName("#last_name", "#last_name_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#email_id", "#email_id_error") && validate.validateEmailId("#email_id", "#email_id_error"))){
		return false;
	}
	else if(!validate.validateGender('#female', '#gender_error')){
		return false;
	}
	else if(!(validate.checkForEmptyField("#mobile_no", "#mobile_no_error") && validate.validateMblNo("#mobile_no", "#mobile_no_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#password", "#password_error") && validate.validatePassword("#password", "#password_error"))){
		return false;
	}
	else if(!(validate.checkForEmptyField("#confirm_pass", "#confirm_pass_error") && validate.validateConfirmPassword("#confirm_pass", "#confirm_pass_error", $("#password").val()))){
		return false;
	}
	
	validate.checkEmail('#email_id', '#email_id_error')
	setTimeout(loginValidation.displaySuccessMsg, 2000)
	return categoryCheck;
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
		validate.displayErrorMsg(fname_obj, fname_error_obj, "Name should be alphabetic and should of minimum 2 character");
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

function validateEmailId(email_id_obj, email_id_error_obj){
	//var email_id = email_id_obj.value;
	var email_id_re = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if(!email_id_re.test($(email_id_obj).val())){
		validate.displayErrorMsg(email_id_obj, email_id_error_obj, "Please enter valid email id");
		return false
	}
	return true;
}


function validatePassword(pass_obj, pass_error_obj){
	var pass_re = /^[\w\W]+\W{1}[a-z]{1}[A-z]{1}\d{1}$/;
//	if (!pass_re.test($(pass_obj).val())){
//		validate.displayErrorMsg(pass_obj, pass_error_obj, "Password does not satisfy specified criteria. Try again");
//		return false;
//	}
	return true
}

function validateConfirmPassword(conf_pass_obj, conf_pass_error_obj, pass){
	if(!($(conf_pass_obj).val() === pass)){
		validate.displayErrorMsg(conf_pass_obj, conf_pass_error_obj, "Entered password and confirm password are not same");
		return false;
	}
	return true;
}

function validateGender(gender_obj, gender_error_obj){
	gender = $("input[name=gender]:checked").val();
	if(typeof gender === "string"){
		return true;
	}
validate.displayErrorMsg("#radio_div", gender_error_obj, "Please select your gender");
return false;
}

function checkForEmptyField(input_field, div){
		if($(input_field).val() === "") {
			validate.displayErrorMsg(input_field, div, "Required")
			return false;
		}
	return true;
}

function removeErrorMsg(obj, error_div)
{
	$(obj).css("border", "")
	$(error_div).html("");
	
}

function displayErrorMsg(input_obj, div_obj, error_msg){
	$(input_obj).css("border", "3px solid red");
	$(div_obj).text(error_msg);
	$(div_obj).css("color", "red");
}

function displayRgisterMsg(){
	$("#registerSuccess").html("Successfully Register").css("color", "green");
	
	//document.getElementById("registration-form").reset();
	setTimeout(function() { window.location=window.location;},10000);
	
	return true;
}

function checkEmail(inputObj, divObj)
{
	var email=$(inputObj).val();
	var parse;
	var path = $("#contextPath").val();
	path = path.replace(">", "")
	$.post(path+"/jsp/ajax.jsp", 
			{
				"action": "duplicate_email",
				"email": email
			}, 
			function(data){
				var data = data.substring(0, data.indexOf('<'));
				parse = $.parseJSON(data);
				if(parse)
				{
					categoryCheck = false;
					$(divObj).html("Email id alredy taken").css("color", "red");
					$(inputObj).css("border", "3px solid red");
					return;
				}
				categoryCheck = true;
				return;
			});
}

//---------------------------login part---------------------------------------------

loginValidation = new LoginValidation();

function LoginValidation(){
	this.doLoginValidation = doLoginValidation;
	this.validateMblNo = validateMblNo;
	this.validateEmailId = validateEmailId;
	this.validateUsername = validateUsername;
	this.validatePassword = validatePassword;
	this.removeErrorMsg = removeErrorMsg;
	this.displayErrorMsg = displayErrorMsg;
	this.checkForEmptyField = checkForEmptyField;
	this.displaySuccessMsg = displaySuccessMsg;
	this.doDyanimcLoginValidation = doDyanimcLoginValidation;
	this.checkLoginCredential = checkLoginCredential;
}


function doLoginValidation(){
	if(!(loginValidation.checkForEmptyField("#username", "#login_username_error") && loginValidation.validateUsername("#username", "#login_username_error"))){
		return false;
	}
	else if(!(loginValidation.checkForEmptyField("#login-password","#login_password_error"))){
		return false;
	}
	else if(!loginValidation.checkLoginCredential())
	{
		return false;
	}
	else if(loginValidation.displaySuccessMsg())
	{
		return true;
	}
	
	return false;
}


function checkLoginCredential()
{
	var email = $("#username").val();
	var passwd = $("#login-password").val();

	var parse;
	var path = $("#contextPath").val().replace(">", "");
	$.post(path+"/jsp/ajax.jsp", 
			{
				"action": "login",
				"email": email,
				"passwd": passwd
			}, 
			function(data){
				parse = data.substring(0, data.indexOf('<'));
				if("false" == parse)
				{
					$("#loginSuccess").html("Invalid credential! Please try again");
					return false;
				}
				window.location.reload();
			});
}


function doDyanimcLoginValidation(inputObj, divObj, functionName){
	if(!loginValidation.checkForEmptyField(inputObj, divObj)){
		return false;
	}
	else if($(inputObj).attr("id") === "login-password"){
		return true;
	}
	else if(!loginValidation[functionName](inputObj, divObj)){
		return false;
	}
	loginValidation.removeErrorMsg(inputObj, divObj)
}

function validateUsername(usernameObj, divObj){
	emailRe = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	mblRe = /^[789]\d{9}$/;
	if(emailRe.test($(username).val()) || mblRe.test($(username).val())){
		return true;
	}
	loginValidation.displayErrorMsg(usernameObj, divObj, "Invalid username");
	return false;
	
}


function displaySuccessMsg(){
	document.getElementById("loginSuccess").innerHTML = "Successfully Logged In"
	//document.getElementById("loginForm").reset();
//	setTimeout(function() { window.location=window.location;},2000);
	return true;
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
		$("#loginSuccess").html("");
		$(".error, .reset-field,textarea").removeAttr("style").html("").val("");
		$("#radio_div, #hobby_div").removeAttr("style");
		$(".uncheck").prop("checked", false);
		$("select").val("N");
		$("select").removeAttr("style");
		$("#pop-background, #register, #myDropdown").slideUp();
		$("#pop-background, #register, #login").slideUp();
	}
	
	
	
});
















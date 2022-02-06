
var quantity = "";

var cart = new cartFunction();

function cartFunction()
{
	this.addToCart = addToCart;
	this.saveCartDetail = saveCartDetail;
	this.showCartProduct = showCartProduct;
	this.showStoredProduct = showStoredProduct;
	this.removeProduct = removeProduct;
	this.description = description;
	this.increase = increase;
	this.decrease = decrease;
	this.addQuantityDeatil = addQuantityDeatil;
	this.getCartTotal = getCartTotal;
	this.showSubmenu = showSubmenu;
	
}

/*------------------------------for dropdown----------------------------------*/


function showSubmenu(menuChoice, position)
{
	$(".ul").hide();
	$("#ul"+position).show();
	    $(menuChoice).next('ul').toggle();
	    event.stopPropagation();
	    event.preventDefault();
}


/*------------------------------for dropdown----------------------------------*/

function description(id, imagePath, productName, price, devileryBy, description)
{
	var cartPresence = $("#cart-presence"+id).val()
	window.location.href="/VegetableShoppingCentre/jsp/description.jsp?id="+id+"&path="+imagePath+"&name="+productName+"&price="+price+"&devileryBy="+devileryBy+"&description="+description+"&cartPresence="+cartPresence;
}

function getNoOfProduct()
{
	$("#cart-quantity").html(($(".cart-div").length));
	cart.getCartTotal();
	if($("#register-link").length<1)
	{
		$(".cart-dropdown").addClass("cart-after-login");
	}
	else
	{
		$(".cart-dropdown").removeClass("cart-after-login");
	}
}

function saveCartDetail(productId)
{
	if ($(".cart-div").length < 1)
	{
		window.location.href="/VegetableShoppingCentre/jsp/logout.jsp";
	}
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	var productId = "";
	var quantity = "";
	var productPrice = "";
	$(".cart-div").each(function() {
	    console.log($(this).html());
		productId = $(this).find( "#remove-product" ).attr("userId")+","+productId;
	    quantity = $(this).find(".quantity").html()+","+quantity;
	    productPrice = $(this).find(".total-price").html()+","+productPrice;
	});
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": "save cart product",
				"productId": productId,
				"quantity": quantity,
				"productPrice": productPrice
		   },
		   function(data){
				window.location.href="/VegetableShoppingCentre/jsp/logout.jsp";
		  
		   });
}

/*this function provide detail from cart database*/
function showStoredProduct()
{
	if ($(".user-id").length < 1)
	{
		return;
	}
	var path = $("#contextPath").val().replace(">", "");
	var userId = $("#user-id").val()
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": "get cart data",
				"userId": userId
		   },
		   function(data){
			   var data = data.substring(0, data.indexOf('<'));
				parse = $.parseJSON(data);
				$.each( parse, function( key, value ) {
					showCartProduct(value);
					});
		   });
}

/*this function provide detail from cart database end*/
function addToCart(productId, productQantity)
{
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": "add product to cart",
				"productId": productId
		   },
		   function(data){			   	
			   	var data = data.substring(0, data.indexOf(']')+1);
				parse = $.parseJSON(data);
				$("#cart-presence"+productId).val("present");
				cart.showCartProduct(parse);
		  
		   });
	$("#"+productId).hide();
	if($("#cart-product"+productId).length<1)
	{
		if($(".left-div-common").length>1)
		{
			$("#left-div-common").after("<button id='cart-product"+productId+"' class='left-div-common description-cart-button'>Added to cart</button>");
			return;
		}
		$("#"+productId).after("<p id='cart-product"+productId+"' class='added-to-cart'>Added to cart</p>");
		return;
	}
	$("#cart-product"+productId).show();
}

function increase(productId)
{
	if($("#quantity"+productId).html() == 1)
	{
		$("#quantity"+productId).html("2")
		var totalPrice = $("#total-price"+productId).html()*2;
		$("#total-price"+productId).html(totalPrice);
		cart.getCartTotal();
	}
	cart.addQuantityDeatil(productId)
}

function decrease(productId)
{
	if($("#quantity"+productId).html() == 2)
	{
		$("#quantity"+productId).html("1")
		var totalPrice = $("#total-price"+productId).html()/2;
		$("#total-price"+productId).html(totalPrice);
		cart.getCartTotal();
	}
	cart.addQuantityDeatil(productId)
}

function addQuantityDeatil(productId)
{
	var path = $("#contextPath").val();
	var quantity = $("#quantity"+productId).html();
	var price = $("#total-price"+productId).html()
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": "add quantity detail",
				"productId": productId,
				"quantity": quantity,
				"price": price
		   },
		   function(data){
			   	var data = data.substring(0, data.indexOf('<'));
				});
}

function getCartTotal()
{
	if($(".cart-div").length>0)
	{
		var total = 0;
		$(".cart-div").each(function() {
			total = total + parseInt($(this).find( ".total-price" ).html());
		});
		$("#cart-total").html("Total: "+total);
	}
	else
	{
		$("#login-checkout").remove();
		$("#cart-total").remove();
	}
}

function showCartProduct(parse)
{
	$("#main-cart-div").append('<div class="cart-div " productId="'+parse[0]+'" style="background: white;">'+
			'<div class="cart" onclick="cart.removeProduct('+parse[0]+')"><img src="/VegetableShoppingCentre/images/cancel1.png" class="cart-cancel" id="remove-product" userId="'+parse[0]+'"></div>'+
			'<div class="cart" style="margin-top: 24px;font-size: 18px;">Total Price: <span class="total-price" id="total-price'+parse[0]+'">'+parse[2]+'</span></div>'+
				'<div class="cart product-quantity">'+
					'<img style="width: 18px;" src="/VegetableShoppingCentre/images/subtract.png" onclick="cart.decrease('+parse[0]+')">'+
					'&nbsp;<span class="quantity" id="quantity'+parse[0]+'">1</span>&nbsp;'+
					'<img style="width: 18px;" src="/VegetableShoppingCentre/images/plus.png" onclick="cart.increase('+parse[0]+')"></div>'+
				'<div class="cart product-name">'+parse[3]+'</div>'+
				'<div class="cart cart-img" style="background: url(/VegetableShoppingCentre/images/'+parse[1]+');background-size: 100% 100%; width: 69px;height: 74px;margin-right: 12px;"></div>'+
				'<div class="clr"></div></div>'
	)
	if($(".cart-div").length<2)
	{
		if($("#register-link").length>0)
		{
			$("#proceed-checkout").append('<span id="login-checkout" class="cart-sub-part" style="float: left;padding: 8px;background: #a5cd39;margin-left: 23px;margin-top: -18px;border-radius: 10px;font-size: 19px;">Please login for checkout</span>');
			$("#login-checkout").after('<span id="cart-total" class="cart-sub-part" style="font-size: 18px;float: right;margin-right: 16px; margin-top: -9px;">Total</span>');
			
		}
		else
		{
			$("#proceed-checkout").append('<a href="/VegetableShoppingCentre/jsp/checkout.jsp" onclick="directToCheckOut()" class="cart-sub-part" style="float: left;padding: 8px;background: #a5cd39;margin-left: 23px;margin-top: -18px;border-radius: 10px;font-size: 19px;"><span id="cart-checkout">Proceed To CheckOut</span></a>');
			$("#proceed-checkout").append('<span id="cart-total" class="cart-sub-part" style="font-size: 18px;float: right;margin-right: 16px; margin-top: -9px;">Total</span>');
		}
	}
	cart.getCartTotal();
	$("#cart-quantity").html(parseInt($("#cart-quantity").html())+1);
}

function removeProduct(productId)
{
	
	var path = $("#contextPath").val();
	path = path.replace('>', '');
	$.post(path+"/jsp/ajax.jsp",
		   {
				"action": "remove product",
				"productId": productId
		   },
		   function(data){
			   	var data = data.substring(0, data.indexOf('<'));
				parse = $.parseJSON(data);
				if(parse)
				{
					
					$( "div[productId='"+productId+"']" ).remove();
					$("#cart-quantity").html(($(".cart-div").length));
					$("#cart-product"+productId).hide();
					if($("#"+productId).length<1)
					{
						
						if($(".left-div-common").length>1)
						{
							
							$("#left-div-common").after("<button value='install' id='"+productId+"' class='install left-div-common description-cart-button' onclick='cart.addToCart("+productId+"')>Add to cart</button>");
							window.location=window.location
							return;
						}
						$("#before-button"+productId).after('<button value="install" id="'+productId+'" class="install" onclick="cart.addToCart('+productId+')">Cart</button>');
						window.location=window.location
						return;
					}
					else{
						$("#"+productId).show();
					}
					window.location=window.location
					//$("#before-button"+productId).after('<button value="install" id="'+productId+'" class="install" onclick="cart.addToCart('+productId+')">Cart</button>');
				}
		  
		   });
}

function directToCheckOut()
{
	window.location = window.location.href="/VegetableShoppingCentre/jsp/checkout.jsp"
}













/* ---------------for dropdown---------------------- */


function myFunction() {
	
    document.getElementById("myDropdown").classList.toggle("show");
	//$( "#myDropdown" ).toggleClass("show").slideDown(1000);
	event.stopPropagation();
    event.preventDefault();
}

$("body").click(function(){
	
	$("#myDropdown").hide();
	if(!($("#myDropdown").hasClass("show")))
	{
		return;
	}
	document.getElementById("myDropdown").classList.toggle("show");
	//$( "#myDropdown" ).toggleClass("show").slideDown(1000);
	event.stopPropagation();
    event.preventDefault();
});
// Close the dropdown if the user clicks outside of it
//window.onclick = function(event) {
//	  if (!event.target.matches('.dropdown-content')) {
//
//	    var dropdowns = document.getElementsByClassName("dropdown-content");
//	    var i;
//	    for (i = 0; i < dropdowns.length; i++) {
//	      var openDropdown = dropdowns[i];
//	      if (openDropdown.classList.contains('show')) {
//	        throw new Error("Something went badly wrong!");
//	      }
//	    }
//	  }
//	}
//function show1()
//{
//$("#myDropdown, #").click(function(){
//	$("#myDropdown").show();
//	
//});
//
//$(".pop-background").click(function(){
//	$(".dropdown-content").hide()
//	
//});
//}

$(document).ready(function(){
	
	$("#myDropdown").click(function(){
		$("#myDropdown").show();
		event.stopPropagation();
	    event.preventDefault();
		
	});
	
	$(".pop-background").click(function(){
		$(".dropdown-content").hide();
		event.stopPropagation();
	    event.preventDefault();
		
	});
	
});
/* ---------------for dropdown end---------------------- */

/* ---------------for multilevel dropdown---------------------- */



/* ---------------for multilevel dropdown---------------------- */





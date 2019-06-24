$(document).ready(function() {
	$(".load-popup").click(function() {
		
		var target = $(this).attr("id");
		
		focusTarget = "";
		if(target == "ii") {
			focusTarget = ".fname";
		} else if(target == "iii") {
			focusTarget = ".id";
		}	
		
		if(focusTarget.length > 0) {
			$(".popup-wrapper").fadeIn(400, function() {
				$(focusTarget).focus();
			});
		} else {
			$(".popup-wrapper").fadeIn();
		}
		
		
		$(".content").hide();
		$("."+target).show();
		
	});
	$(".popup-x").click(function() {
		$(".all").empty();
		$("input").val("");
		$(".popup-wrapper").fadeOut();
	});			
	
	$(".service-response p").click(function() {
		$("input").val("");
		$(".service-response").fadeOut();
	});
	
	function saveProfile() {
		var inputCheck = true;
		var fname = $(".fname").val();
		var lname = $(".lname").val();
		var email = $(".email").val();
		
		inputCheck = fname.length == 0 ? false : (lname.length== 0 ? false : (email.length == 0 ? false : true));
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		var emailCheck = emailReg.test(email);
		
		if(inputCheck) {
			if(emailCheck) {
				var currId = Math.floor(Math.random() * 9999) + 1223;
				var data = {
					id : currId,
					firstname : fname,
					lastname : lname,
					email: email
				}
				$.ajax({
					method : "POST",
					contentType : "application/json",
					url : window.location + "profilemanager/save",
					data: JSON.stringify(data),
					dataType: "json",
					success: function(result) {
						profile = result.data;
						var buildResponse = "Profile : " + profile.firstname + " " + profile.lastname + " (" + profile.email + ") added succesfully.";
						$(".service-response div").text(buildResponse);
						$(".service-response").fadeIn();
						setTimeout(function() {
							$(".service-response").fadeOut();
						}, 10000);
						$(".popup-wrapper").fadeOut();
					},
					error: function(e) {
						alert(JSON.stringify(e));
					}
				});
			} else {
				alert("Invalid Email");
			}
		} else {
			alert("Please Fill out all the fields.");
		}
	}
	
	$("#add").submit(function() {
		saveProfile();
		return false;
	});
	
	$(".save").click(function(){
		saveProfile();
	});
});
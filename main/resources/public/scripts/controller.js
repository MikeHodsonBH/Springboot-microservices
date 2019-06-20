$(document).ready(function() {
	$(".load-popup").click(function() {
		
		var target = $(this).attr("id");
		
		$(".popup-wrapper").fadeIn();
		$(".content").hide();
		$("."+target).show();
		
	});
	$(".popup-x").click(function() {
		$(".all").empty();
		$(".popup-wrapper").fadeOut();
	});			
	
	$(".save").click(function(){
		var inputCheck = true;
		var fname = $(".fname").val();
		var lname = $(".lname").val();
		var email = $(".email").val();
		
		inputCheck = fname.length == 0 ? false : (lname.length== 0 ? false : (email.length == 0 ? false : true));
		if(inputCheck) {
			var currId = Math.floor(Math.random() * 9999) + 1223;
			var data = {
				id : currId,
				firstname : fname,
				lastname : lname,
				email: email
			}
			$.ajax({
				type : "POST",
				contentType : "application/json",
				url : window.location + "profilemanager/save",
				data: JSON.stringify(data),
				dataType: "json",
				success: function(result) {
					profile = result.data;
					$(".response p").empty().text("Profile " + profile.id +": "+ profile.firstname + " " + profile.lastname + " (" + profile.email + ") added succesfully." )
				},
				error: function(e) {
					alert(JSON.stringify(e));
				}
			});
		} else {
			alert("Please Fill out all the fields.");
		}
	});
});
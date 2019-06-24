$(document).ready(function() {
	$(".view").click(function(){
		
		$(".all").empty();
		var profiles = null;
		
		$.ajax({
			type: "GET",
			url: window.location + "profilemanager/getall",
			success:function(result){
				temp = profiles = result.data;
				for(i=0; i<profiles.length; i++) {
					profile = profiles[i];
					$(".all").append("Profile " + profile.id +": "+ profile.firstname + " " + profile.lastname + ", " + profile.email + "<br>");
				}
			},
			error:function(e){
				
			}
		});
	});

	$(".add").click(function() {
		$(".response p").empty("");
	});
	
	$(".search").click(function() {
		$(".search-results").empty();
		$(".available-ids").empty();
	});
	

	function search() {
		$(".search-results").empty();
		var searchParam = $(".id").val();
		var inputCheck = searchParam.length == 0 ? false : true;
		if(inputCheck) {
			$.ajax({
				type: "POST",
				url: window.location + "profilemanager/getProfile?query="+searchParam,
				success: function(result) {
					$(".search-results").text(" :: Search Results :: ");
					for(var i=0; i<result.length; i++) {
						var profile = result[i];
						if(profile.firstname == null) {
							$(".search-results").append("<br><br>").append(" Match Not Found 😶⛔  Try using a different search phrase ↩.");
						} else {
							$(".search-results").append("<br><br>" + profile.firstname + " " + profile.lastname + " " + profile.email);
						}
					}
				},
				error: function(e) {alert(JSON.stringify(e));}
			});
		} else {
			alert("Hmmm... Looks like you're missing a search id");
		}
	}
	
	$(".results form").submit(function() {
		search();
		return false;
	});
	
	$(".search-details").click(function(e) {
		search();
	});
});
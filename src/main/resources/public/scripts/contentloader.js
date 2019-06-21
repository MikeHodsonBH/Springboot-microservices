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

	searchIds = [];
	lookupObj = null;
	$(".search").click(function() {
		$(".search-results").empty();
		$(".available-ids").empty();
		$.ajax({
			type: "GET",
			url: window.location + "profilemanager/getall",
			success:function(result){
				lookupObj = profiles = result.data;
				for(k=0; k<profiles.length; k++) {
					profile = profiles[k];
					$(".available-ids").append(profile.id + "; ");
					searchIds.push(profile.id);
				}
			},
			error:function(e){
				alert(JSON.stringify(e));
			}
		});
	});
	
	$(".add").click(function() {
		$(".response p").empty("");
	});
	
	$(".search-details").click(function() {
		$(".search-results").empty();
		var searchId = $(".id").val();
		var inputCheck = searchId.length == 0 ? false : true;
		if(inputCheck) {
			matchedRecord = null;
			for(j =0; j<lookupObj.length; j++) {
				profile = lookupObj[j];
				if(searchId === profile.id) {
					matchedRecord = profile;
				}
			}
			if(matchedRecord) {
				$(".search-results").text(":: Search Results :: ").append("<br>").append(" Id " + matchedRecord.id +": "+ matchedRecord.firstname +" "+ matchedRecord.lastname+ " (" + matchedRecord.email+")");
			} else {
				$(".search-results").text(":: Search Results :: ").append("<br>").append(" Match Not Found!!")
			}
		} else {
			alert("Hmmm... Looks like you're missing a search id");
		}
	});
});
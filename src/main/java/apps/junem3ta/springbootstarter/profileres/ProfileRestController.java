package apps.junem3ta.springbootstarter.profileres;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import apps.junem3ta.springbootstarter.profileres.Response;
import apps.junem3ta.springbootstarter.repository.ProfileRepo;
import apps.junem3ta.springbootstarter.profilemodel.Profile;

@RestController
@RequestMapping("/profilemanager")
public class ProfileRestController {	
	
	@Autowired
	ProfileRepo repo;
	
	@GetMapping(value = "/getall")
	public Response getResource() {
		List<Profile> profiles = new ArrayList<>();
		profiles = (List<Profile>) repo.findAll();
		Response response = new Response("Done", profiles);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Profile profile) {
		// Create Response Object
		repo.save(profile);
		Response response = new Response("Done", profile);
		return response;
	}
	
	public List<Profile> searchRecords(List<Profile> profiles, String queryString) {
		List<Profile> matchedProfiles = new ArrayList<>();
		Boolean matchTracker = false;
		
		for(int i = 0; i<profiles.size(); i++) {
			Profile profile = profiles.get(i);
			if(profile.getFirstname().toLowerCase().equals(queryString.toLowerCase())) {
				matchedProfiles.add(profile);
				matchTracker = true;
				continue;
			} else if(profile.getLastname().toLowerCase().equals(queryString.toLowerCase())) {
				matchedProfiles.add(profile);
				matchTracker = true;
				continue;
			} else if(profile.getEmail().toLowerCase().equals(queryString.toLowerCase())) {
				matchedProfiles.add(profile);
				matchTracker = true;
				continue;
			}
		}
		if (matchTracker) {
			return matchedProfiles;
		} else {
			List<Profile> defaultResponse = new ArrayList<Profile>();
			defaultResponse.add(new Profile());
			return defaultResponse;
		}
	}
	
	
	@RequestMapping(value = "/getProfile", method = {RequestMethod.POST, RequestMethod.GET})
	public List<Profile> getProfile(@RequestParam String query) {
		List<Profile> all = (List<Profile>) repo.findAll();
		return searchRecords(all, query);
	}

}
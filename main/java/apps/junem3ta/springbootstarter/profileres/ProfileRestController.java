package apps.junem3ta.springbootstarter.profileres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apps.junem3ta.springbootstarter.profileres.Response;
import apps.junem3ta.springbootstarter.profilemodel.Profile;

@RestController
@RequestMapping("/profilemanager")
public class ProfileRestController {	
	/* Sample Data */
	
		Profile p1 = new Profile("1209","Sheila","Vinson","sheilavinson@profilemgr.tst");
		Profile p2 = new Profile("1345","Horton","Stafford","hortonstafford@profilemgr.tst");
		Profile p3 = new Profile("5678","Mcpherson","Rocha","mcphersonrocha@profilemgr.tst");
		Profile p4 = new Profile("3745","Dixon","Bradley","dixonbradley@profilemgr.tst");
		Profile p5= new Profile("4532","Mays","Cortez","mayscortez@profilemgr.tst");
		Profile p6 = new Profile("3421","Angelita","Parsons","angelitaparsons@profilemgr.tst");
	    Profile p7 = new Profile("3452", "Neva", "Erickson", "nevaerickson@profilemgr.tst");  
	    Profile p8 = new Profile("1345", "Clara", "Hicks", "clarahicks@profilemgr.tst");
	    Profile p9 = new Profile("3541", "Huffman", "Goodman", "huffmangoodman@profilemgr.tst");
	    Profile p10 = new Profile("2455", "Adriana", "Meyers", "adrianameyers@profilemgr.tst");
	    Profile p11 = new Profile("2355", "Sonia", "Horn", "soniahorn@profilemgr.tst");
	    Profile p12 = new Profile("2163", "Adkins", "Bell", "adkinsbell@profilemgr.tst");
	    Profile p13 = new Profile("2576", "Pitts", "Forbes", "pittsforbes@profilemgr.tst");
	    Profile p14 = new Profile("1222", "Brittney", "Holden", "brittneyholden@profilemgr.tst");
	
    /* End Sample Data */
	
	List<Profile> cust = new ArrayList<Profile>();
	List<Profile> addedProfiles = new ArrayList<>(Arrays.asList());
	
	public List<Profile> addDefaultProfiles() {
		List<Profile> profilesList = Arrays.asList( p1, p2, p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);
		return profilesList;
	}
	
	@GetMapping(value = "/getall")
	public Response getResource() {
		cust.clear();
		cust.addAll(addDefaultProfiles());
		cust.addAll(addedProfiles);
		Response response = new Response("Done", cust);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Profile profile) {
		// Create Response Object
		Response response = new Response("Done", profile);
		addedProfiles.add(profile);
		return response;
	}
}
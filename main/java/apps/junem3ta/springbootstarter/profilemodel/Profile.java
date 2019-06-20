package apps.junem3ta.springbootstarter.profilemodel;

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;*/

public class Profile {
	
	private String id;
    private String firstname;
    private String lastname;
    private String email;
     
    public Profile(){}
     
    public Profile(String id, String firstname, String lastname, String email){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
     
    /* Id */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    /* First Name */
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
     
    /* Last Name */
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    /* Email */
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    /*
    
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

	 */
}




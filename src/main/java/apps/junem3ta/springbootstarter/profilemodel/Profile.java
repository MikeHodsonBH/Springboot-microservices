package apps.junem3ta.springbootstarter.profilemodel;

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
}




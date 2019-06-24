package apps.junem3ta.springbootstarter.profilemodel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	
	@Id
	private int id;
    private String email;
    private String firstname;
    private String lastname;
     
    public Profile(){}
     
    public Profile(int id, String email, String firstname, String lastname){
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
     
    /* Id */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    /* Email */
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    
}




package test;

//o user me to id,username ,pass toy
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;
    private String email;
    private String fname;
    private String lname;
    private int points;
    
    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getrole() {
		return role;
	}
	
	public void setrole(String role) {
		this.role = role;
	}
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String first_name) {
        this.fname = first_name;
    }

    public String getLname() {
        return lname;
    }
    public void setLname(String last_name) {
        this.lname = last_name;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
  
    
    
}
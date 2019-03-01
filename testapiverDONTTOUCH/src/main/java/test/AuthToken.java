package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="auth_token")
public class AuthToken {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String value;
	private Integer withdrawn;
	private String user_role;

	
	public Integer getid() {
		return id;
	}
	
	public String getvalue() {
		return value;
	}
	
	public void setvalue(String value) {
		this.value = value;
	}
	
	public String getuser_role() {
		return user_role;
	}
	
	public void setuser_role(String user_role) {
		this.user_role = user_role;
	}
	
	public Integer getwithdrawn() {
		return withdrawn;
	}
	
	public void setwithdrawn(int withdrawn) {
		this.withdrawn = withdrawn;
	}
	
}
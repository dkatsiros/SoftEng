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
	
	public Integer getid() {
		return id;
	}
	
	public String getvalue() {
		return value;
	}
	
	public void setvalue(String value) {
		this.value = value;
	}
	
	public Integer getwithdrawn() {
		return withdrawn;
	}
	
	public void setwithdrawn(int withdrawn) {
		this.withdrawn = withdrawn;
	}
	
}
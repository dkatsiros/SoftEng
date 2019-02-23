package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	//private Float MO_Price;
	private String description;
	private Integer withdrawn;
	private String category;
	private String tags;
	
	public Integer getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	/*
	public Float getMO_Price() {
		return MO_Price;
	}*/	
	
	public String getdescription() {
		return description;
	}
	
	public void setdescription(String description) {
		this.description = description;
	}
	
	public Integer getwithdrawn() {
		return withdrawn;
	}
	
	public void setwithdrawn() {
		this.withdrawn = 0;
	}
	
	public String getcategory() {
		return category;
	}
	
	public void setcategory(String category) {
		this.category = category;
	}
	
	public String gettags() {
		return tags;
	}
	
	public void settags(String tags) {
		this.tags = tags;
	}

}

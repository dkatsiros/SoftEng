package test;

import java.util.Arrays;
import java.util.List;

import test.Product;
//import test.Extra;

public class Productout {
	
	private Integer id;
	private String name;
	private String description;
	private String category;
	private List<String> tags;
	private Boolean withdrawn;
	//private Extra extraData;
	
	
	public Integer getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	
	public String getdescription() {
		return description;
	}
	
	public Boolean getwithdrawn() {
		return withdrawn;
	}
	
	public String getcategory() {
		return category;
	}
	
	public List<String> gettags() {
		return tags;
	}
	/*
	public Extra getextraData() {
		return extraData;
	}*/
	
	public Productout (Product product) {
		this.id = product.getid();
		this.description = product.getdescription();
		if (product.getwithdrawn() == 0) {
			this.withdrawn = false;
		}
		else {
			this.withdrawn = true;
		}
		this.name = product.getname();
		this.category = product.getcategory();
		this.tags = Arrays.asList(product.gettags().split("\\s*,\\s*"));
		//this.extraData = new Extra(product.getMO_Price());
		
	}

}
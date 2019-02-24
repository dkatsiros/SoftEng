package test;

import java.util.Arrays;
import java.util.List;

import test.Shop;

public class Shopout {
	
	private Integer id;
	private String name;
	private String address;
	private Double lng;
	private Double lat;
	private List<String> tags;
	private Boolean withdrawn;

	
	public Integer getid() {
		return id;
	}
	
	public String getname() {
		return name;
	}
	
	public String getaddress() {
		return address;
	}
	
	public Boolean getwithdrawn() {
		return withdrawn;
	}
	
	public Double getlng() {
		return lng;
	}
	
	public Double getlat() {
		return lat;
	}
	
	public List<String> gettags() {
		return tags;
	}
	
	public Shopout (Shop shop) {
		this.id = shop.getid();
		this.name = shop.getname();
		this.address = shop.getaddress();
		this.lng = shop.getlng();
		this.lat = shop.getlat();
		if (shop.getwithdrawn() == 0) {
			this.withdrawn = false;
		}
		else {
			this.withdrawn = true;
		}
		this.tags = Arrays.asList(shop.gettags().split("\\s*,\\s*"));

	}
	

}
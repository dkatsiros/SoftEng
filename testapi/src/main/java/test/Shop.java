package test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
	private String address;
	private Integer withdrawn;
	private Double lng;
	private Double lat;
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
	
	public String getaddress() {
		return address;
	}
	
	public void setaddress(String address) {
		this.address = address;
	}
	
	public Integer getwithdrawn() {
		return withdrawn;
	}
	
	public void setwithdrawn() {
		this.withdrawn = 0;
	}
	
	public Double getlng() {
		return lng;
	}
	
	public void setlng(Double lng) {
		this.lng = lng;
	}
	
	public Double getlat() {
		return lat;
	}
	
	public void setlat(Double lat) {
		this.lat = lat;
	}
	
	public String gettags() {
		return tags;
	}
	
	public void settags(String tags) {
		this.tags = tags;
	}

}
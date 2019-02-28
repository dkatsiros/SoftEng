package test;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Priceout {
	
	private Double price;
	private Date date;
	private String productName;
	private Integer productid;
	private List<String> productTags;
	private Integer shopid;
	private String shopName;
	private String shopAddress;
	private List<String> shopTags;
	private Double dist;
	
	public Priceout(Price price, double dist, Date date) {
		this.price = price.getprice();
		this.productName = price.getproduct().getname();
		this.productid = price.getproduct().getid();
		this.productTags = Arrays.asList(price.getproduct().gettags().split("\\s*,\\s*"));
		this.shopid = price.getshop().getid();
		this.shopName = price.getshop().getname();
		this.shopAddress = price.getshop().getaddress();
		this.shopTags = Arrays.asList(price.getshop().gettags().split("\\s*,\\s*"));
		this.dist = dist;
		this.date = date;
	}
	
	public Double getprice() {
		return price;
	}
	
	public Date getdate() {
		return date;
	}
	
	public String getproductName() {
		return productName;
	}
	
	public Integer getproductid() {
		return productid;
	}
	
	public List<String> getproducttags() {
		return this.productTags;
	}
	
	public Integer getshopid() {
		return this.shopid;
	}
	
	public String getshopName() {
		return this.shopName;
	}
	
	public String getshopAddress() {
		return this.shopAddress;
	}
	
	public List<String> getshopTags() {
		return this.shopTags;
	}
	
	public Double getdist () {
		return dist;
	}

}

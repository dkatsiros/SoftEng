package test;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Price {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer priceid;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "productid")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "shopid")
	private Shop shop;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "PST")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateFrom;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy", timezone = "PST")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateTo;
	
	private Integer thumbsup;
	private Integer thumbsdown;
	
	public Integer getpriceid() {
		return priceid;
	}
	
	public Double getprice() {
		return this.price;
	}
	
	public void setprice(Double price) {
		this.price = price;
	}
	
	public Product getproduct() {
		return this.product;
	}
	
	public void setproduct(Product product) {
		this.product = product;
	}
	
	public Shop getshop() {
		return this.shop;
	}
	
	public void setshop(Shop shop) {
		this.shop = shop;
	}
	
	public Date getdateFrom () {
		return this.dateFrom;
	}
	
	public void setdateFrom (Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public Date getdateTo () {
		return this.dateTo;
	}
	
	public void setdateTp (Date dateTo) {
		this.dateTo = dateTo;
	}
	
	public Integer getthubmsdown() {
		return this.thumbsdown;
	}
	
	public void setthumbsdown(Integer thumbsdown) {
		this.thumbsdown = thumbsdown;
	}
	
	public Integer getthubmsup() {
		return this.thumbsup;
	}
	
	public void setthumbsup(Integer thumbsup) {
		this.thumbsup = thumbsup;
	}
}

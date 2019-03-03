package test;
import java.util.ArrayList;
import java.util.List;

import test.Productout;

public class PagingProduct {
	
	private Integer start;
	private Integer count;
	private Integer total;
	public List<Productout> products = new ArrayList<>();
	
	public Integer getstart() {
		return start;
	}
	
	public Integer getcount() {
		return count;
	}
	
	public Integer gettotal() {
		return total;
	}
	
	public List<Productout> getproducts() {
		return products;
	}
	
	public PagingProduct(Integer start, Integer count, Integer total) {
		this.start = start;
		this.count = count;
		this.total = total;
	}
}
